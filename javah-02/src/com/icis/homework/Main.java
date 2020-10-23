package com.icis.homework;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager ma = new Manager("群主", 100);
        ArrayList<Integer> list = ma.sendMoney(100, 7);
        System.out.println(list);
        ma.show();
        Member a[] = new Member[4];
        for(int i=0; i<4; i++) a[i] = new Member("张"+i, 0);
        for(int i=0; i<4; i++)
            a[i].receiveRed(list);
        for (Member mb : a) {
            mb.show();
        }
    }
}
