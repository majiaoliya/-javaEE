package tran;

import java.sql.SQLException;

public interface EmpInterface {
    void transferMoney(Integer fromID, Integer toID, Double money) throws SQLException;
}
