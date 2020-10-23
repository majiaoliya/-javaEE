package utils;


import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import pojo.*;

public class DataSourceUtils {
    public static Properties pro = new Properties();
    public static DataSource src = null;
    static {
        ClassLoader classloader = DataSourceUtils.class.getClassLoader();
        try {
            pro.load(classloader.getResourceAsStream("druid.properties"));
            src = getDs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDs() throws Exception {
        return DruidDataSourceFactory.createDataSource(pro);
    }

    public static Connection getConn() throws SQLException {
        Connection conn = src.getConnection();
        return conn;
    }

    public static void main(String[] args) throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(getDs());
//        tmp.update("INSERT INTO emp VALUES(null, '好的', '男', 978.9, null, 1)");
//        String sql = "UPDATE emp SET NAME='李四' WHERE id=7";
//        String sql = "DELETE FROM emp WHERE name = '李四'";
//        tmp.update(sql);

        Map<String, Object> mp = tmp.queryForMap("select * from emp where id=1");
        System.out.println(mp);
    }

    @Test
    public void test1() throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(getDs());
        List<Map<String, Object>> list = tmp.queryForList("select * from emp");
//        System.out.println(list);
        List<Emp> ans = new ArrayList<>();
        parse(list, ans);
        System.out.println(ans);
    }

    public static void parse(List<Map<String, Object>> src, List<Emp> dst) throws IllegalAccessException {
        Class<Emp> empClass = Emp.class;
        Field[] fields = empClass.getDeclaredFields();
        for (Map<String, Object> mp : src) {
            Emp emp = new Emp();
            for (Field f : fields) {
                f.set(emp, mp.get(f.getName()));
            }
            dst.add(emp);
        }
    }

    @Test
    public void test2() throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(getDs());
        List<Emp> list = tmp.query("select * from emp", new BeanPropertyRowMapper<Emp>(Emp.class));
        System.out.println(list);
    }

    @Test
    public void test3() throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(getDs());
        List<Emp> list = tmp.query("select * from emp", new EmpRowMapperImpl());
        System.out.println(list);
    }

    @Test
    public void test4() throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(getDs());
        List<Emp> list = tmp.query("select * from emp", new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Emp(resultSet.getInt(1), resultSet.getString(2));
            }
        });
        System.out.println(list);
    }

    @Test
    //返回聚合函数执行结果
    public void test5() throws Exception {
        JdbcTemplate tmp = new JdbcTemplate(getDs());
        String sql = "select count(id) from emp"; //count(id)计数
        Object obj = tmp.queryForObject(sql, Integer.class);
        System.out.println(obj);
    } 
}

class Dept {
    Integer id;
    String NAME;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}


