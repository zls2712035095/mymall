package com.zls.mall.provider.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;


@Configuration
public class RedisCacheConfig {
    //Redis缓存Key生成器 就是让key形成唯一值，方便调用 默认是simpleKeyGenerator生成器
    /*
    Spring提供的缓存Key生成器 有时会出现重复，重复后，调用的值就会错误
    所以我们需要自己自定义 cache key 的生成方式
    我一般是这样用的 类名+方法名+参数列表的类型+参数值 再做 哈希散列 作为唯一key

     */
    @Bean("keyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                sb.append("&");
                for (Object obj : params) {
                    if (obj != null){
                        sb.append(obj.getClass().getName());
                        sb.append("&");
                        sb.append(JSON.toJSONString(obj));//fastjson
                        sb.append("&");
                    }
                }

                return DigestUtils. sha256Hex(sb.toString());// commons-codec 加密 不能反向
            }
        };
    }
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//字符串的
        //速度优于GenericJacksonRedisSerializer
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);//对象的
        //  解决查询缓存转换异常的问题


        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(20))//失效时间 亲测 成功 可以过期 用redis_cli看效果
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))//键是字符串
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))//值是对象
                .disableCachingNullValues();
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
    }
}
