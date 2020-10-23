package com.icis.dao;

import com.icis.pojo.PageBean;
import com.icis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean findUserByUser(User user);


    List<User> getAllUsers();

    int insertUserByUser(User user);

    User findUserById(String id);

    int updateUserByUser(User user);

    int deleteUserById(String id);

    User getUserById(String id);

    PageBean<User> findPageUser(String currentPage, String pageSize);

    Integer getUserCount();

    List<User> findPageUserLimit(Integer currentPage, Integer pageSize);

    Integer deleteUserByIds(String[] ids);

    Integer registerUserByUserMap(Map<String, String[]> mp);

    boolean findRegUserByUser(User user);
}
