package com.li.shopsystem.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis操作工具类
 * @author Li
 */
@Component
public final class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 设置String型的KV键值对及过期时间
     * @author Li
     */
    public void stringsetex(int time, String key, String value){
        redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
    }

    /**
     * 取String型的K的值
     * @author Li
     */
    public String stringget(String key){
        try{
        return (String) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
