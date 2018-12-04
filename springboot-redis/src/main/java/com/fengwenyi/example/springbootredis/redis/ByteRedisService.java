package com.fengwenyi.example.springbootredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wenyi Feng
 * @since 2018-12-04
 */
@Service
public class ByteRedisService {

    @Resource
    private RedisTemplate<byte[], byte[]> redisTemplate;

    public void set(byte[] key, byte[] value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public byte[] get(byte[] key) {
        return redisTemplate.opsForValue().get(key);
    }

}
