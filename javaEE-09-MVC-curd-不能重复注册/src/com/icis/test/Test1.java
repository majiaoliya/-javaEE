package com.icis.test;

import com.icis.dao.UserService;
import com.icis.dao.impl.UserServiceImpl;
import com.icis.pojo.PageBean;
import com.icis.pojo.User;
import org.junit.Test;

import java.util.List;

public class Test1 {
    @Test
    public void test() {
        UserService dao = new UserServiceImpl();
        List<User> allUsers = dao.getAllUsers();
    }
    @Test
    public void test2() {
        UserService dao = new UserServiceImpl();
        User user = new User();
        user.setUsername("abc"); user.setPassword("123456");
        boolean ok = dao.findUserByUser(user);
        System.out.printf("find : %s\n", ok ? "yes" : "no");
        user.setUsername("abc"); user.setPassword("1234586");
        ok = dao.findUserByUser(user);
        System.out.printf("find : %s\n", ok ? "yes" : "no");
    }

    @Test
    public void test3() {
        UserService dao = new UserServiceImpl();
//        User user = new User();
        User user = dao.findUserById("15");
        System.out.println(user);
    }

    @Test
    public void test4() {
        UserService dao = new UserServiceImpl();
//        User user = new User();
        User user = dao.findUserById("15");
        System.out.println(user);
    }

    @Test
    public void test5() {
        UserService dao = new UserServiceImpl();
        List<User> pageUserLimit = dao.findPageUserLimit(1, 3);
        System.out.println(pageUserLimit);
    }

    @Test
    public void test6() {
        UserService dao = new UserServiceImpl();
        PageBean<User> pageUser = dao.findPageUser("1", "3");
        System.out.println(pageUser);
    }
}
