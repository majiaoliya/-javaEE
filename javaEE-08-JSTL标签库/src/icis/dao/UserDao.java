package icis.dao;

import icis.pojo.User;
import icis.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

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

    public boolean findUserByUser(User user) {
        String sql = "SELECT \n" +
                "  * \n" +
                "FROM\n" +
                "  USER \n" +
                "WHERE username = '?' \n" +
                "  AND PASSWORD = '?' ;";
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


}
