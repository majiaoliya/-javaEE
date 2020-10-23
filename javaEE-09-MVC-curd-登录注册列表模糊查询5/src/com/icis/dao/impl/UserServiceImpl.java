package com.icis.dao.impl;

import com.icis.dao.UserService;
import com.icis.pojo.Address;
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
    public PageBean<User, Address> findPageUser(String currentPageStr, String pageSizeStr, Map<String, String[]> mp) {
        if(currentPageStr == null) currentPageStr = "1";
        if(pageSizeStr == null) pageSizeStr = "3";

        PageBean<User, Address> pageBean = new PageBean<>();
        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);
        pageBean.setCurrentPage(currentPage); //设置当前页
        pageBean.setPageSize(pageSize); //设页大小

        pageBean.setTotCount(getUserCount(mp)); //设置总记录数
        int N = pageBean.getTotCount();
        pageBean.setTotPage(N/pageSize + (N%pageSize > 0 ? 1 : 0));

        pageBean.setDataList(findPageUserLimit(currentPage, pageSize, mp));
        pageBean.setAddressList(getAddressStr()); //设置籍贯下拉框列表

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

    public Integer getUserCount(Map<String, String[]> mp) {
        StringBuilder sql = new StringBuilder("select count(id) from user where 1=1 ");

        String []usernames = null;
        String []addresses = null;
        String []sexes = null;
        if(null != mp){
            usernames = mp.get("query_username");
            addresses = mp.get("query_address");
            sexes = mp.get("query_sex");
        }
        if(null != usernames && !usernames[0].isEmpty()) {
            sql.append(" and username like '%");
            sql.append(usernames[0]);
            sql.append("%' ");
        }

        if(null != addresses && !addresses[0].isEmpty()) {
            sql.append(" and address like '%");
            sql.append(addresses[0]);
            sql.append("%' ");
        }

        if(null != sexes && !sexes[0].isEmpty()) {
//            sql.append("like '%");
            sql.append(" and gender like '%");
            sql.append(sexes[0]);
            sql.append("%' ");
        }

        System.out.println("-------begin-------getUserCount(mp)-------------");
        System.out.printf("sql: %s\n", sql);
        System.out.println("--------end--------getUserCount(mp)-------------");

        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }

    @Override
    public List<User> findPageUserLimit(Integer currentPage, Integer pageSize) {
        currentPage = Math.max(currentPage, 1);
        currentPage = (currentPage-1) * pageSize;
        String sql = "select * from user limit ? , ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), currentPage, pageSize);
    }

    @Override
    public List<User> findPageUserLimit(Integer currentPage, Integer pageSize, Map<String, String[]> mp) {
        currentPage = Math.max(currentPage, 1);
        currentPage = (currentPage-1) * pageSize;
//        String sql = "select * from user limit ? , ?";
//            SELECT * FROM USER WHERE username LIKE '%三%' LIMIT 0,3
        StringBuilder sql = new StringBuilder("select * from user where 1=1 ");
        String []usernames = null;
        String []addresses = null;
        String []sexes = null;
        if(null != mp){
            usernames = mp.get("query_username");
            addresses = mp.get("query_address");
            sexes = mp.get("query_sex");
        }
        if(null != usernames && !usernames[0].isEmpty()) {
            sql.append(" and username like '%");
            sql.append(usernames[0]);
            sql.append("%' ");
        }

        if(null != addresses && !addresses[0].isEmpty()) {
            sql.append(" and address like '%");
            sql.append(addresses[0]);
            sql.append("%' ");
        }

        if(null != sexes && !sexes[0].isEmpty()) {
//            sql.append("like '%");
            sql.append(" and gender like '%");
            sql.append(sexes[0]);
            sql.append("%' ");
        }

        sql.append(" limit ?, ? ");

        System.out.println("-----------begin------findPageLimit-----------");
        System.out.printf("sql : %s\n", sql);
        System.out.println("-----------end------findPageLimit-----------");

        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(User.class), currentPage, pageSize);
    }

    @Override
    public List<Address> getAddressStr() {
        String sql = "select * from tb_address";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Address.class));
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
