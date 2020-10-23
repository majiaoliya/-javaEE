package com.icis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {
    public static JedisPoolConfig config = null;
    public static JedisPool pool = null;

    static {
        InputStream in = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
            config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
            config.setMinIdle(Integer.parseInt(pro.getProperty("maxIdle")));
            Integer port = Integer.parseInt(pro.getProperty("port"));
            pool = new JedisPool(config, pro.getProperty("host"), port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        Jedis ret = pool.getResource();
        return ret;
    }
    //6379
}
