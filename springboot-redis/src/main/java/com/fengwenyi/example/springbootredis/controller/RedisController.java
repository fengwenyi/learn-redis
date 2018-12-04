package com.fengwenyi.example.springbootredis.controller;

import com.fengwenyi.example.springbootredis.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author Wenyi Feng
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate redisTemplate;

    //@PostConstruct
    public void init() {
        byte[] key = SerializationUtils.serialize("k1");
        byte[] value = SerializationUtils.serialize("v1");
        redisTemplate.opsForValue().set(key, value);
        byte[] rs = (byte[]) redisTemplate.opsForValue().get(key);
        System.out.println(SerializationUtils.deserialize(rs));
    }

    @RequestMapping("/set")
    public void set() {
        String key = "key";
        String value = "value";
        redisService.set(key, value);
    }

    @RequestMapping("/get")
    public Object get() {
        String key = "key";
        String value = redisService.get(key);
        return value;
    }

}
