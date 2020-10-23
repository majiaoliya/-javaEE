package test;

import icis.dao.UserDao;
import icis.pojo.User;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test1() {
        UserDao dao = new UserDao();
        List<User> list = dao.getAllUsers();
        for (User u : list) {
            System.out.println(u);
        }
    }
}
