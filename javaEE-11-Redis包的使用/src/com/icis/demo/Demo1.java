package com.icis.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icis.pojo.Product;
import com.icis.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.PortUnreachableException;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;

public class Demo1 {
    JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDs());
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    ObjectMapper mp = new ObjectMapper();

    @Test
    public void addProduct() {
        String sql = "INSERT INTO tb_product VALUES(null, ?, ?, ?)";
        Product pro = new Product("a", 100, "2020-10-7");
        int ret = jdbc.update(sql, pro.getProName(), pro.getProPrice(), pro.getProDate());
        System.out.println(ret);
    }

    //添加数据到Redis缓存
    @Test
    public void queryProduct2() throws JsonProcessingException { //通过起别名封装
        String sql = "SELECT p_name proName, p_price proPrice, p_date proDate FROM tb_product";
        List<Product> list = jdbc.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

        String list_json = mp.writeValueAsString(list); //先转成json
        System.out.println(list_json);
        jedis.set("pros", list_json); //设置到Redis缓存里
        System.out.println(list);
    }



    @Test
    public void getPros() throws IOException {
        String list_json = jedis.get("pros");
        List<Product> list = mp.readValue(list_json, new TypeReference<List<Product>>() { });
        System.out.println(list);
    }

    @Test
    public void queryProduct() { //通过重写rowMapper的方式封装
        String sql = "SELECT * FROM tb_product";
        List<Product> list = jdbc.query(sql, ((resultSet, idx) -> {
            Product pro = new Product();
            pro.setProName(resultSet.getString("p_name"));
            pro.setProPrice(resultSet.getInt("p_price"));
            Date date = resultSet.getDate("p_date");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = sdf.format(resultSet.getDate("p_date"));
            pro.setProDate(date_str);
            return pro;
        }));

        System.out.println(list);
    }


}
