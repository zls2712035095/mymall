package com.zls;

import com.zls.api.common.GsonUtil;
import com.zls.mall.api.model.UmsLog;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumerBase;
import org.apache.flink.streaming.connectors.redis.RedisSink;
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

public class UVReceiver {
    public static void main(String[] args) throws Exception {

        String topic = "malluv";
        String host = "192.168.27.159";
        //String host = "master";
        int port = 9092;
        int database_id = 1;
        final StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        environment.enableCheckpointing(TimeUnit.MINUTES.toMillis(1));
        environment.setParallelism(5);

        CheckpointConfig checkpointConfig = environment.getCheckpointConfig();
        //数据的处理结果与摄入是没有数据的丢失与重复
        checkpointConfig.setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        //一旦数据被cancel后 会自动保留checkpoinst数据 以便恢复
        checkpointConfig.enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host +":"+ port);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "app_uv_stat");

        //从指定的topic中指定group进行消费
        FlinkKafkaConsumerBase<String> kafkaConsumerBase = new FlinkKafkaConsumer<String>(topic, new SimpleStringSchema(), properties).setStartFromGroupOffsets();

        //输出
        FlinkJedisPoolConfig config = new FlinkJedisPoolConfig.Builder().setDatabase(database_id).setHost(host).build();
        //"20783","2021-01-06","2021-01-06","37","192.168.1.199","查询订单","{'pageNum':['1']&&'pageSize':['10']}","GET","/order/list","80","17"
        environment.addSource(kafkaConsumerBase).map(string->{
            System.out.println("["+string+"]");
            StringBuffer stringBuffer = new StringBuffer();
            try {
                List<String> list = Arrays.asList(string.split(","));
                stringBuffer.append("{");
                Field[] fs = UmsLog.class.getDeclaredFields();
                for (int i = 0; i < list.size(); i ++){
                    stringBuffer.append(fs[i].getName() + ":"+list.get(i)+",");
                }
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
                stringBuffer.append("}");
                //{id:"54",createBy:"system",createTime:"2020-02-05 18:05:15.0",delFlag:"0",
// updateBy:"system",updateTime:"2020-02-05",costTime:"23",ip:"127.0.0.1",ipInfo:"",
// name:"品牌列表",
// requestParam:"{""pageNum"":[""1""]&&""pageSize"":[""100""]}",requestType:"GET",requestUrl:"/brand/list",
// userid:"3",logType:"5"}
            }catch (Exception e){
                e.printStackTrace();
            }

            UmsLog u = null;
            u = GsonUtil.fromJson(stringBuffer.toString(), UmsLog.class);

            return u;
        }).keyBy("updateTime", "logType").map(new RichMapFunction<UmsLog, Tuple2<String, Long>>() {
            //存储当前key对应的userId集合
            private MapState<String, Boolean> userIdState;
            //当前key对应的uv值
            private ValueState<Long> uvState;

            @Override
            public Tuple2<String, Long> map(UmsLog umsLog) throws Exception {

                if(uvState.value() == null){
                    uvState.update(0l);
                }

                //userIds是否不包含当前访问的userId,说明该用户今天未访问该页面
                if(!userIdState.contains(umsLog.getUserid().toString())){
                    userIdState.put(umsLog.getUserid().toString(), null);
                    uvState.update(uvState.value() + 1);
                }
                //生成Redis key format: 日期_logType
                String redisKey = umsLog.getUpdateTime() + "_" + umsLog.getLogType();
                System.out.println(redisKey+"  ::::  "+uvState.value());
                System.out.println("由"+umsLog.getUserid()+"号用户，在"+umsLog.getUpdateTime()+
                        "时间操作了地址【"+umsLog.getRequestUrl()+"】1次！"+"；数据库的序号是："+umsLog.getId());
                System.out.println("【"+umsLog.getRequestUrl()+"】，共操作了"+uvState.value()+"次！");
                return Tuple2.of(redisKey, uvState.value());
            }

            @Override
            public void open(Configuration parameters) throws Exception {
                super.open(parameters);
                //从状态中要回复userIdState
                userIdState = getRuntimeContext().getMapState(new MapStateDescriptor<String, Boolean>(
                        "userIdState",
                        TypeInformation.of(new TypeHint<String>() {}),
                        TypeInformation.of(new TypeHint<Boolean>() {})
                ));

                //从状态中恢复uvState
                uvState = getRuntimeContext().getState(new ValueStateDescriptor<Long>(
                        "uvState",
                        TypeInformation.of(new TypeHint<Long>() {})
                ));

            }
        }).addSink(new RedisSink<>(config, new RedisSetSinkMapper()));
        environment.execute();
    }

    private static class RedisSetSinkMapper implements RedisMapper<Tuple2<String, Long>>{

        @Override
        public RedisCommandDescription getCommandDescription() {
            return new RedisCommandDescription(RedisCommand.SET);
        }

        @Override
        public String getKeyFromData(Tuple2<String, Long> stringLongTuple2) {
            return stringLongTuple2.f0;
        }

        @Override
        public String getValueFromData(Tuple2<String, Long> stringLongTuple2) {
            return stringLongTuple2.f1.toString();
        }
    }
}