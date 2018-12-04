package com.fengwenyi.example.springbootredis.controller;

import com.fengwenyi.example.springbootredis.bean.User;
import com.fengwenyi.example.springbootredis.redis.ByteRedisService;
import com.fengwenyi.example.springbootredis.redis.RedisService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wenyi Feng
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/redis")
public class ByteRedisController {

    @Autowired
    private ByteRedisService redisService;

    @RequestMapping("/string")
    public Object string() {
        String key = "BYTE_KEY_STRING";
        String value = "value";
        redisService.set(SerializationUtils.serialize(key),
                SerializationUtils.serialize(value));
        byte[] rs = redisService.get(SerializationUtils.serialize(key));
        return SerializationUtils.deserialize(rs);
    }

    @RequestMapping("/list")
    public Object list() {
        String key = "BYTE_KEY_LIST";
        List<String> value = Arrays.asList("h", "a", "b");
        redisService.set(SerializationUtils.serialize(key),
                SerializationUtils.serialize(value));
        byte[] rs = redisService.get(SerializationUtils.serialize(key));
        return SerializationUtils.deserialize(rs);
    }

    @RequestMapping("/obj")
    public Object obj() {
        String key = "BYTE_KEY_OBJ";
        User value = new User();
        value.setName("Zhangsan");
        value.setAge(20);
        redisService.set(SerializationUtils.serialize(key),
                SerializationUtils.serialize(value));
        byte[] rs = redisService.get(SerializationUtils.serialize(key));
        return SerializationUtils.deserialize(rs);
    }

}
