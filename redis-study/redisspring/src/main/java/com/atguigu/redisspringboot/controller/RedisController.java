package com.atguigu.redisspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author liaohongwei
 * @date 2021/4/23 11:33
 * @Description:
 */
@RestController
@RequestMapping("/redisTest")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String testRedis() {
        redisTemplate.opsForValue().set("name", "lucy");
        String res = (String)redisTemplate.opsForValue().get("name");
        return res;
    }

    @GetMapping("/testLock")
    public void testLock() {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", "111");
        if(lock) {
            Object num = redisTemplate.opsForValue().get("num");
            System.out.println(num);
            if(num == null) {
                return;
            }
            int resNum = Integer.parseInt((String) num);
            redisTemplate.opsForValue().set("num", resNum + 1);
            redisTemplate.delete("lock");
        } else {
            try {
                TimeUnit.SECONDS.sleep(1);
                testLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
