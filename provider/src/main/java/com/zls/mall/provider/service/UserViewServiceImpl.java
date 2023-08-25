package com.zls.mall.provider.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.zls.api.common.CommonPage;
import com.zls.mall.api.model.UmsLogType;
import com.zls.mall.api.model.UmsLogTypeExample;
import com.zls.mall.api.model.UmsUserView;
import com.zls.mall.api.service.IUserViewService;
import com.zls.mall.provider.mapper.UmsLogTypeMapper;
import com.zls.mall.provider.mapper.redis.mapper.RedisUtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service(
        version = "1.0.0",
        interfaceName = "com.zls.mall.api.service.IUserViewService",
        interfaceClass = IUserViewService.class
)
@Transactional
public class UserViewServiceImpl implements IUserViewService {

    @Autowired
    private RedisUtilMapper redisUtilMapper;

    @Autowired
    private UmsLogTypeMapper umsLogTypeMapper;



    @Override
    public CommonPage listUv(String start, String end, String type) {

        List uvList = forDate(start, end, type);
        return CommonPage.restPage(uvList);
    }

    private List<UmsUserView> forDate(String start, String end, String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<UmsUserView> umsUserViews = new ArrayList<>();

        try {
            Date d1 = simpleDateFormat.parse(start);
            Date d2 = simpleDateFormat.parse(end);

            Date tmp = d1;
            Calendar dd = Calendar.getInstance();
            dd.setTime(d1);

            //遍历日期区间的每一天，得到redis数据
            while (tmp.getTime() <= d2.getTime()){
                tmp = dd.getTime();
                Set<Object> s = redisUtilMapper.getAllKeys(simpleDateFormat.format(tmp) + "_" + type);

                s.forEach(o->{
                    int count = Integer.parseInt(redisUtilMapper.get(o.toString()).toString());
                    umsUserViews.add(new UmsUserView(o.toString().substring(0, 10), count));
                });
                dd.add(Calendar.DAY_OF_MONTH, 1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return umsUserViews;
    }

    @Override
    public CommonPage listTypeUV() throws Exception {
        UmsLogTypeExample example = new UmsLogTypeExample();
        example.createCriteria().andFlagEqualTo(1);
        List<UmsLogType> list = umsLogTypeMapper.selectByExample(example);
        return CommonPage.restPage(list);
    }
}
