package com.liujie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testOpsFor(){
        ValueOperations ops = redisTemplate.opsForValue();
        HashOperations hash = redisTemplate.opsForHash();
        ListOperations opsForList = redisTemplate.opsForList();
        SetOperations opsForSet = redisTemplate.opsForSet();
        ZSetOperations opsForZSet = redisTemplate.opsForZSet();
    }

    @Test
    public void testOpsFor1(){
        //绑定key
        BoundValueOperations boundValueOps = redisTemplate.boundValueOps("key");
        BoundHashOperations hash = redisTemplate.boundHashOps("key");
        BoundListOperations opsForList = redisTemplate.boundListOps("key" );
        BoundSetOperations opsForSet = redisTemplate.boundSetOps("key");
        BoundZSetOperations opsForZSet = redisTemplate.boundZSetOps("key");

    }

}
