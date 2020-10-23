package tran;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    static Properties pro = null;
    static {
        try {
            pro = new Properties();
            InputStream ins = JDBCUtils.class.getResourceAsStream("../db.properties");
            pro.load(ins);
            Class.forName(pro.getProperty("driver"));
            String url = pro.getProperty("url");
            System.out.println(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"), pro.getProperty("pw"));
    }
    @Test
    public void doit() throws SQLException {
        Connection conn = getConn();
    }
}
