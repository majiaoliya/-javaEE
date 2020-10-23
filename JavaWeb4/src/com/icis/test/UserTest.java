package com.icis.test;

import com.icis.dao.UserDao;
import com.icis.pojo.User;
import org.junit.Test;

public class UserTest {
    @Test
    public void getUser(){
        User user=new User();
        user.setUsername("");
        user.setPassword("123456");
        UserDao userDao=new UserDao();
        User user1 = userDao.getUserByNameAndPwd(user);
        System.out.println(user1);

    }
}
