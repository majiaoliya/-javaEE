package homework;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;

public class Main {
    public static DataSource src = null;
    static {
        src = new ComboPooledDataSource();
    }

    @Test
    public void func1() throws SQLException {
        Connection conn = src.getConnection();

        String sql = "INSERT INTO dept values(null,?,null)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "yy部门");
        int cnt = ps.executeUpdate();
        System.out.printf("影响了 : %d 条\n", cnt);
        conn.close();
    }

    @Test
    public void func2() throws SQLException {
        Connection conn = src.getConnection();

        String sql = "DELETE FROM dept WHERE name=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "yy部门");
        int cnt = ps.executeUpdate();
        System.out.printf("影响了 : %d 条\n", cnt);
        conn.close();
    }
    @Test
    public void func3() throws SQLException {
        Connection conn = src.getConnection();

        String sql = "UPDATE dept SET name=? WHERE name=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        String s[] = { "zz部门", "yy部门" };
        for(int i=1; i<=s.length; i++)
            ps.setString(i, s[i-1]);
        int cnt = ps.executeUpdate();
        System.out.printf("影响了 : %d 条\n", cnt);
        conn.close();
    }
    @Test
    public void func4() throws SQLException {
        Connection conn = src.getConnection();

        String sql = query();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int col = metaData.getColumnCount();
        String col_name[] = new String[col+1];
        for(int i=1; i<=col; i++) {
            col_name[i] = metaData.getColumnName(i);
            System.out.printf("[%s]   ", col_name[i]);
        }
        System.out.println();
        while(rs.next()) {
            for (int i=1; i<=col; i++)
                System.out.printf("[%s]  ", rs.getString(i));
            System.out.println();
        }
        conn.close();
    }
    static String query(int...id) {
        if(id.length <= 0) return "SELECT * FROM dept";
        StringBuilder sb = new StringBuilder("SELECT * FROM dept WHERE ");
        for(int i=0; i<id.length; i++) {
            if(i > 0) sb.append(" OR ");
            sb.append(" id= ");
            sb.append(id[i]);
        }
        return sb.toString();
    }

    @Test
    public void func5() throws SQLException {
        Connection conn = src.getConnection();

        String sql = "SELECT id FROM dept WHERE name=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "zz部门");
        ResultSet rs = ps.executeQuery();
        int dept_id = -1;
        if(rs.next()) { dept_id = rs.getInt(1); }
        rs.close();
        if(-1 != dept_id) {
            String sql2 = "insert into emp VALUE (NULL , ?, ?, NULL , ?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, "xxx");
            ps2.setDouble(2, 789.7);
            ps2.setInt(3, dept_id);
            System.out.println(ps2);
            int cnt = ps2.executeUpdate();
            System.out.printf("更新了 : %d 条\n", cnt);
        }
        conn.close();
    }


    @Test
    public void func6() throws SQLException {
        String sql = "\n" +
                "SELECT\n" +
                "  t1.id as 编号,\n" +
                "  t1.`name`,\n" +
                "  t1.`salary`,\n" +
                "  t1.`in_time`,\n" +
                "  IFNULL(t2.`name`, '没有部门')\n" +
                "FROM\n" +
                "  emp AS t1 LEFT JOIN dept AS t2\n" +
                "ON \n" +
                "  t1.`dept_id` = t2.`id`;";
        Connection conn = src.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        for(int i=1; i<=col; i++)
            System.out.printf("[%s]  ", rs.getMetaData().getColumnName(i));
        System.out.println();
        while(rs.next()) {
            for(int i=1; i<=col; i++)
                System.out.printf("%s  ", rs.getString(i));
            System.out.println();
        }
    }
}
