package com.atguigu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author liaohongwei
 * @date 2021/4/23 09:59
 * @Description: jedis工具的测试连接
 */
public class JedisDemo {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("172.16.5.59", 6379);
        String res = jedis.ping();
        System.out.println(res);
    }

    @Test
    public void test() {
        //创建jedis对象
        Jedis jedis = new Jedis("172.16.5.59", 6379);
        Set<String> keys = jedis.keys("*");
        for (String key: keys) {
            System.out.println(key);
        }
    }
}
