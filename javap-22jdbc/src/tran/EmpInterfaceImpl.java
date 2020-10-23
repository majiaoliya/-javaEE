package tran;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Executors;

public class EmpInterfaceImpl implements EmpInterface {

    @Test
    public void test() throws SQLException {
        EmpInterface emp = new EmpInterfaceImpl();
        emp.transferMoney(1, 2, 1000.);
        System.out.println("test ok");
    }

    @Override
    public void transferMoney(Integer fromID, Integer toID, Double money) throws SQLException {
        Connection conn = JDBCUtils.getConn();
        try {
            conn.setAutoCommit(false); //开启事务

            String sql = "UPDATE emp SET salary = salary-? WHERE id=?",
                    sql2 = "UPDATE emp SET salary = salary+? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, money.toString());
            ps.setString(2, fromID.toString());

            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, money.toString());
            ps2.setString(2, toID.toString());

            int x = ps.executeUpdate();
            int y = ps2.executeUpdate();
            conn.commit();
            if(x == y && x == 1)
                System.out.printf("finish %s\n", money.toString());
            else
                System.out.printf("error %s\n", money.toString());
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        }
    }
}
