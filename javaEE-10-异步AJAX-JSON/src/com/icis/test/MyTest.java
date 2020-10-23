package com.icis.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icis.pojo.User;
import com.icis.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

class Node {
    String name, pwd;

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date date;

    public Node() { }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Node(String name, String pwd, Date date) {
        this.name = name;
        this.pwd = pwd;
        this.date = date;
    }

    public Node(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

public class MyTest {
    ObjectMapper mp = new ObjectMapper();
    @Test
    public void fun1() throws JsonProcessingException {
        Node no = new Node("无名", "password");
        String s = mp.writeValueAsString(no);
        System.out.println(s);
    }

    @Test
    public void fun2() throws JsonProcessingException {
        List<Node> list = new ArrayList<>();
        for(int i=0; i<5; i++)
            list.add(new Node("name"+i, 97+i+""));
        String s = mp.writeValueAsString(list);
        System.out.println(s);
    }

    @Test
    public void fun4() throws IOException {
        Node no = new Node("无名", "password");
        String s = mp.writeValueAsString(no);
        System.out.println(s);
        Node ot = mp.readValue(s, Node.class);
        System.out.printf("ot : %s %s\n", ot.getName(), ot.getPwd());
    }

    @Test
    public void fun5() throws IOException {
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new BeanPropertyRowMapper<>(User.class), 19);
        String s = mp.writeValueAsString(user);
        System.out.println(user);
        System.out.println(s);
        User user1 = mp.readValue(s, User.class);
        System.out.println(user1);
    }


    @Test
    public void fun6() throws IOException {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        String list_str = mp.writeValueAsString(list);
        System.out.println(list_str);

        User user = jdbcTemplate.queryForObject("select * from user where id=?", new BeanPropertyRowMapper<>(User.class), 19);
        String user_str = mp.writeValueAsString(user);
        Map map = mp.readValue(user_str, Map.class);
        System.out.println(map);


        List list1 = mp.readValue(list_str, List.class);
        System.out.println(list1);

        User user1 = mp.readValue(user_str, User.class);
        System.out.println(user1);
    }

    public static class Pro {
        String pName;
        double pPrice;
        boolean sale;

        public Pro() { }

        public Pro(String pName, double pPrice, boolean sale) {
            this.pName = pName;
            this.pPrice = pPrice;
            this.sale = sale;
        }

        public String getpName() {
            return pName;
        }

        public void setpName(String pName) {
            this.pName = pName;
        }

        public double getpPrice() {
            return pPrice;
        }

        public void setpPrice(double pPrice) {
            this.pPrice = pPrice;
        }

        public boolean isSale() {
            return sale;
        }

        public void setSale(boolean sale) {
            this.sale = sale;
        }
    }

    @Test
    public void homework2() throws IOException {
        String str = "{\"pName\":\"红米Max\",\"pPrice\":2888.88,\"sale\":false}";
        Pro pro = mp.readValue(str, Pro.class);
        System.out.printf("%s %f %s\n", pro.pName, pro.pPrice, pro.sale ? "true" : "false");
    }

    @Test
    public void homework3() throws IOException {
        String str = "[\n" +
                "\t  {\"pName\":\"华为mate10\",\"pPrice\":20.0,\"sale\":true},\n" +
                "\t  {\"pName\":\"华为mate11\",\"pPrice\":20.0,\"sale\":true},\n" +
                "\t  {\"pName\":\"华为mate12\",\"pPrice\":20.0,\"sale\":true},\n" +
                "\t  {\"pName\":\"华为mate13\",\"pPrice\":20.0,\"sale\":true}\n" +
                "\t ]";
        List<Pro> pro = mp.readValue(str, new TypeReference<List<Pro> >(){});
        for (Pro p : pro) {
            System.out.println(p.pName + " " + p.pPrice + " " + p.sale);
        }
    }

    @Test
    public void homework4() throws IOException {
        String str = "{\"animalAge\":\"24\",\"animalName\":\"金毛1号\",\"animalHobby\":\"啃骨头\"}";
        Map pro = mp.readValue(str, new TypeReference<Map>(){});
        System.out.println(pro);
    }


    JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDs());
    @Test
    public void fun3() {
        System.out.println(jdbcTemplate);
    }
}
