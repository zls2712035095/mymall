package com.zls.mall.provider.mapper.redis.mapper;


import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Set;

@Repository
public class RedisUtilMapper {
    @Autowired
    private RedisTemplate<String, Object> redisTemplateS;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public Object get(String key){
        return key == null? null: redisTemplateS.opsForValue().get(key);
    }

    public Set<Object> getAllKeys(Serializable pattern){
        Set<Object> s = redisTemplate.keys(pattern);
        return s;
    }
}
