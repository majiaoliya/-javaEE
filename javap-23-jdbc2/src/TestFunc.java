import org.junit.Test;

import java.io.PrintStream;
import java.sql.*;

public class TestFunc {
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
}
