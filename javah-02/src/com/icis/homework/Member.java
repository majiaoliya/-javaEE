package com.icis.homework;

import java.util.ArrayList;

public class Member extends User {
    public Member() {
    }

    public Member(String userName, int money) {
        super(userName, money);
    }
    public void receiveRed(ArrayList<Integer> list) {
        Integer in = list.get(0);
        list.remove(0);
        this.setMoney(this.getMoney()+in);
    }

}
