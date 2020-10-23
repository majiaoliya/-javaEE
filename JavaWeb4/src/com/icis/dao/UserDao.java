package com.icis.dao;

import com.icis.pojo.User;
import com.icis.utils.JdbcUtils;
import com.mchange.v2.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//创建实体类  用于实现对user表的操作
public class UserDao {
    //创建一个JdbcTemplate
    //创建一个数据源对象
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDs());

    //定义方法   查询根据用户名和密码查询用户
    public User getUserByNameAndPwd(User user){
        String sql="select * from user where username=? and password=?";
        //1.执行查询
        User dbUser = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        return dbUser;
    }



}
