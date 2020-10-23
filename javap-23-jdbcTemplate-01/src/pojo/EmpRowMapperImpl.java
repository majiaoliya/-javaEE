package pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapperImpl implements RowMapper<Emp> {
    @Override
    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp emp = new Emp();
        emp.id = resultSet.getInt(1);
        emp.name = resultSet.getString(2);
        return emp;
    }
}
