package com.ilovesshan.user.util;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value), timeout, TimeUnit.SECONDS);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(value));
    }

    public <T> T get(String key, Class<T> clazz) {
        return JSON.parseObject(redisTemplate.opsForValue().get(key), clazz);
    }

    public void remove(String key) {
        redisTemplate.delete(key);
    }

    public Set<String> keys() {
        return redisTemplate.keys(null);
    }

    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }
}