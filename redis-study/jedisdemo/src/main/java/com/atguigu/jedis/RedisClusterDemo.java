package com.atguigu.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @author liaohongwei
 * @date 2021/4/25 15:46
 * @Description:
 */
public class RedisClusterDemo {
    public static void main(String[] args) {

        HostAndPort host = new HostAndPort("172.16.5.128", 6379);
        JedisCluster jedisCluster = new JedisCluster(host);
        jedisCluster.set("test0425", "fall0425");

        String res = jedisCluster.get("test0425");
        jedisCluster.close();
        System.out.println(res);
    }
}
