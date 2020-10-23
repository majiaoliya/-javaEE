package com.icis.pojo;

import java.util.List;

public class User {
    public String user_name, user_pw;
    List<GoodsItem> list;

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_pw='" + user_pw + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public User() { }

    public User(String user_name, String user_pw) {
        this.user_name = user_name;
        this.user_pw = user_pw;
    }
}
