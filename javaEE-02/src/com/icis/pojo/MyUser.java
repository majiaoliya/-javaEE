package com.icis.pojo;

public class MyUser {
    String key, val;

    public MyUser(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public MyUser() {
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
