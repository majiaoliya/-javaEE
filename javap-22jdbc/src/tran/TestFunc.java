package tran;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.*;
import java.util.Properties;

public class TestFunc {

    static Properties pro = null;
    static {
        pro = new Properties();
        InputStream ins = TestFunc.class.getResourceAsStream("db.properties");
        try {
            pro.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db3";
        Connection conn = DriverManager.getConnection(url, "root", "root");
//        String sql = "SELECT * FROM emp";
        String sql = "SELECT name, join_date as fuck, dept_id as fuck2 FROM emp";
        PreparedStatement st = conn.prepareStatement(sql);
//        st.setString(1, "join_date");
//        st.setString(2, "dept_id");
        ResultSet rs = st.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        PrintStream cout = System.out;
        while(rs.next()) {
            for(int i=1; i<=col; i++)
                cout.printf("[%s:%s] ", rs.getMetaData().getColumnName(i), null==rs.getString(i) ? "fuck" : rs.getString(i));
            cout.printf("\n");
        }
    }
    @Test
    public void doit() throws SQLException {
        Connection conn = JDBCUtils.getConn();
        String sql = "SELECT name, join_date, dept_id FROM emp";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        PrintStream cout = System.out;
        while(rs.next()) {
            for (int i = 1; i <= col; i++)
                cout.printf("[%s:%s] ", rs.getMetaData().getColumnName(i), null == rs.getString(i) ? "fuck" : rs.getString(i));
            cout.printf("\n");
        }
        rs.close();
    }

    @Test
    public void jdbc事务() throws SQLException {
        Connection conn = JDBCUtils.getConn();

    }
}
