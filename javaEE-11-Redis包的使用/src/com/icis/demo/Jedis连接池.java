package com.icis.demo;

import com.icis.utils.JedisUtil;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class Jedis连接池 {
    JedisPool pool = null;
    JedisPoolConfig config;

    @Before
    public void init() {
        config = new JedisPoolConfig();
        config.setMaxWaitMillis(10000);
        pool = new JedisPool(config, "127.0.0.1", 6379);
    }

    @Test
    public void test1() {
        Jedis jedis = pool.getResource();
        String pros = jedis.get("pros");
        System.out.println(pros);

    }

    @Test
    public void test2() {
        Jedis jedis = JedisUtil.getJedis();
//        String pros = jedis.get("pros");
//        System.out.println(pros);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }
}
