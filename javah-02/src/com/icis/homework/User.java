package com.icis.homework;

public class User {
    private String userName;
    private int money;

    public void show() {
        System.out.println(userName + " money: " + money);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", money=" + money +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User() {
    }

    public User(String userName, int money) {
        this.userName = userName;
        this.money = money;
    }
}
