package test;

import com.icis.dao.ProvDao;
import com.icis.dao.impl.ProvDaoImpl;
import com.icis.pojo.Prov;
import com.icis.utils.JedisUtil;
import jdk.internal.dynalink.linker.LinkerServices;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test1 {
    Jedis jedis = null;
    @Before
    public void initJedis() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @Test
    public void test1() {
        System.out.printf("jedis : %s\n", jedis);
    }
    @Test
    public void test2set_string() {
        jedis.set("username", "伍再园");
    }
    @Test
    public void test2get_string() {
        String username = jedis.get("username");
        System.out.println(username);
    }
    @Test
    public void test2hash() {
        jedis.hset("myMap", "伍再园", "爱吃屎");
        String hget = jedis.hget("myMap", "伍再园");
        System.out.println(hget);
    }

    @Test
    public void test2list() {
        List<String> list = new ArrayList<String>();
        list.add("哈哈哈"); list.add("哈哈哈1"); list.add("哈哈哈2");

        jedis.rpush("myList", "伍再园");
        jedis.rpush("myList", "伍再园2");
        jedis.rpush("myList", "伍再园3");

        jedis.rpop("myList");

        jedis.rpush("myList", list.toArray(new String[list.size()]));
        System.out.println(jedis.lrange("myList", 0, -1));
    }

    @Test
    public void test2hgetall() {
        Map<String, String> myMap = jedis.hgetAll("myMap");
        System.out.println(myMap);
    }
    
    @Test
    public void test2keys() {
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }

    @Test
    public void ExpireTest() { //过期时间设置
        jedis.expire("myList", 2);
    }

    @After
    public void closeJedis() {
        jedis.close();
    }

    @Test
    public void test3() {
        ProvDao dao = new ProvDaoImpl();
        List<Prov> allProv = dao.getAllProv();
        System.out.println(allProv);
    }

    @Test
    public void test4() {
        jedis = JedisUtil.getJedis();
        String prov_list = jedis.get("prov_list");
        System.out.println(prov_list);
    }
}
