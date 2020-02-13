package com.xr.bos.util;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisTemplateUtil {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public void setString(String key,Object value){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
        redisTemplate.expire(key,24, TimeUnit.HOURS);

    }

    public Object getString(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void setList(String key, List<?> value){
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        /*redisTemplate.expire(key,60, TimeUnit.HOURS);*/
        listOperations.leftPush(key, value);


    }
    public Object getList(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public void setSet(String key, Set<?> value) {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        setOperations.add(key, value);
    }
    public Object getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 操作hash对象类型的set/get
     */
    public void setHash(String key, Map<String, ?> value) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key, value);
    }
    public Object getHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 根据Key键删除数据（针对String、Hash、List、Set等类型）
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
