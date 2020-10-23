package com.icis.homework;

import java.util.ArrayList;

public class Manager extends User {

    public ArrayList<Integer> sendMoney(int n, int m) {
        ArrayList<Integer> ret = new ArrayList<>();
        int leftMoney = super.getMoney();
        if(n > leftMoney) {
            System.out.println("用户money不足");
            return ret;
        }
        super.setMoney(leftMoney - n);
        if(n % m == 0)
            for(int i=0; i<m; i++) ret.add((n/m));
        else {
            for(int i=0; i<m-1; i++)
                ret.add((n/m));
            ret.add(n%m);
        }
        return ret;
    }

    public Manager() { }

    public Manager(String userName, int money) {
        super(userName, money);
    }
}
