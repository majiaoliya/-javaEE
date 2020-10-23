package c3p0_test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

public class Main {
//    @Test
//    public void test1() throws SQLException {
//        DataSource src = new ComboPooledDataSource();
//        Connection conn = src.getConnection();

//    }
    public static void main(String[] args) throws SQLException {
        DataSource src = new ComboPooledDataSource();
        Connection conn = src.getConnection();
        System.out.println(conn);
        Consumer<Main> fuck = Main::fuck;
        fuck.accept(new Main());
    }
    void fuck() {
        System.out.println("fucking");
    }
}
