package com.icis.dao.impl;

import com.icis.dao.UserService;
import com.icis.pojo.User;
import com.icis.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

//创建实体类  用于实现对user表的操作
public class UserServiceImpl implements UserService {
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

    public boolean findUserByUser(User user) {
        String sql = "SELECT \n" +
                "  * \n" +
                "FROM\n" +
                "  USER \n" +
                "WHERE username = ? \n" +
                "  AND PASSWORD = ? ;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, user.getUsername(), user.getPassword());
        return !list.isEmpty();
    }

    public int addUserToDB(User user) {
        String sql = "INSERT INTO USER(\n" +
                "  username,\n" +
                "  PASSWORD,\n" +
                "  gender,\n" +
                "  birthday,\n" +
                "  tel,\n" +
                "  email\n" +
                ") \n" +
                "VALUES\n" +
                "  (\n" +
                "  ?,\n" +
                "  ?,\n" +
                "  ?,\n" +
                "  ?,\n" +
                "  ?,\n" +
                "  ?\n" +
                "  ) ;\n";
        int status = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getGender(),
                user.getBirthday(),
                user.getTel(),
                user.getEmail()
        );
        System.out.printf("register [status=%d] :%s\n", status, user);
        return status;
    }
    
    public List<User> getAllUsers() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public int insertUserByUser(User user) {
        String sql = "INSERT INTO USER(username, password, gender, qq, email, sex) VALUES(?, ?, ?, ?, ?, ?)";
        int ret = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getUsername(),
                user.getGender(),
                user.getQq(),
                user.getEmail(),
                user.getSex());
        return ret;
    }

    @Override
    public User findUserById(String id) {
        User user = new User();
        String sql = "select * from user where id=?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUserByUser(User user) {
        if(user == null) return 0;
        String sql = "UPDATE USER \n" +
                "SET\n" +
                "  gender = ?,\n" +
                "  age = ?,\n" +
                "  address = ?,\n" +
                "  email = ?,\n" +
                "  qq = ? \n" +
                "WHERE id = ? ;\n" +
                "\n";
        int ret = jdbcTemplate.update(sql,
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getEmail(),
                user.getQq(),
                user.getId());
        return ret;
    }

    @Override
    public int deleteUserById(String id) {
        String sql = "DELETE FROM USER WHERE id=?;";
        int ret = jdbcTemplate.update(sql, id);
        return ret;
    }

    @Override
    public User getUserById(String id) {
        String sql = "select * from user where id='?'";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }
}
