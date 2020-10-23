package demo3;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Emp;
import utils.DataSourceUtils;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class Demo3 {
    public static JdbcTemplate jdbc = null;

    @Before
    public void init() throws Exception {
        jdbc = new JdbcTemplate(DataSourceUtils.getDs());
    }

    @Test
    public void updateBalanceById() {
        String sql = "UPDATE emp set salary=? where id=?";
        int cnt = jdbc.update(sql, 999, 6);
        System.out.printf("影响了 : %d\n", cnt);
    }

    @Test
    public void insertEmp() {
        Emp emp = new Emp(7, "金角大王");
        String sql = "insert into emp VALUES (?,?,?,?,?,?)";
        int cnt = jdbc.update(sql, emp.getId(), emp.getName(), emp.getGender(), emp.getSalary(), emp.getJoin_date(), emp.getDept_id());
        System.out.printf("影响了 : %d\n", cnt);
    }

    @Test
    public void deleteEmpById() {
        Emp emp = new Emp(null, "金角大王");
        String sql = "DELETE FROM emp where name=?";
        int cnt = jdbc.update(sql, emp.getName());
        System.out.printf("影响了 : %d\n", cnt);
    }

    //查询一行
    @Test
    public void selectOneRow() {
        Emp emp = new Emp(null, "金角大王");
        String sql = "select * from emp where id=?";
        Map<String, Object> mp = jdbc.queryForMap(sql, 3);
        System.out.println(mp);
    }

    //查询所有的记录 并封装为List
    @Test
    public void selectAllForList() {
        String sql = "select * from emp ";
        List<Map<String, Object>> list = jdbc.queryForList(sql);
        System.out.println(list);
    }

     //查询所有的记录 并封装为List<Emp>
    @Test
    public void selectAllForListEmp() {
        String sql = "select * from emp ";
        List<Emp> list = jdbc.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    //查询总记录数
    @Test
    public void queryForObjectTest() {
        String sql = "select count(id) from emp ";
        Object o = jdbc.queryForObject(sql, Integer.class);
        System.out.println(o);
    }
}