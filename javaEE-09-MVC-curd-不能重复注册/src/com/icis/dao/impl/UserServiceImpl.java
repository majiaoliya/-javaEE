package com.icis.dao.impl;

import com.icis.dao.UserService;
import com.icis.pojo.PageBean;
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

    @Override
    public PageBean<User> findPageUser(String currentPageStr, String pageSizeStr) {
        if(currentPageStr == null) currentPageStr = "1";
        if(pageSizeStr == null) pageSizeStr = "3";

        PageBean<User> pageBean = new PageBean<>();
        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        pageBean.setTotCount(getUserCount());
        int N = pageBean.getTotCount();
        pageBean.setTotPage(N/pageSize + (N%pageSize > 0 ? 1 : 0));

        pageBean.setDataList(findPageUserLimit(currentPage, pageSize));

        return pageBean;
    }

    @Override
    public Integer deleteUserByIds(String[] ids) {
        if(null == ids) return 0;
        int ret = 0;
        for(int i=0; i<ids.length; i++)
            if(null != ids[i]) {
                ret += deleteUserById(ids[i]);
            }
        return ret;
    }

    @Override
    public Integer getUserCount() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findPageUserLimit(Integer currentPage, Integer pageSize) {
        currentPage = Math.max(currentPage, 1);
        currentPage = (currentPage-1) * pageSize;
        String sql = "select * from user limit ? , ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), currentPage, pageSize);
    }

    @Override
    public Integer registerUserByUserMap(Map<String, String[]> mp) {
        int ret = 0;
        String[] passwords = mp.get("password");
        String[] usernames = mp.get("username");
        if(usernames == null || passwords == null || passwords.length<=0 || usernames.length<=0) return ret;

        User user = new User(usernames[0], passwords[0]);

        String sql = "SELECT id FROM register WHERE username=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), usernames[0]);
        if(list.size() > 0) return ret;

        sql = "INSERT INTO register (username, PASSWORD) VALUES(?, ?)";
        ret = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return ret;
    }

    @Override
    public boolean findRegUserByUser(User user) {
        String sql = "SELECT \n" +
                "  * \n" +
                "FROM\n" +
                "  register \n" +
                "WHERE username = ? \n" +
                "  AND PASSWORD = ? ;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, user.getUsername(), user.getPassword());
        return !list.isEmpty();
    }
}
