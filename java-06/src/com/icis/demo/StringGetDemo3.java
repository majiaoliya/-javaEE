package com.icis.demo;

public class StringGetDemo3 {
    public static void main(String[] args) {
        String str = "0123456789";
        System.out.println(str.substring(2, 4));
        String s1 = "hello";
        String s2 = "world";
        s1.toCharArray();
        String tmp = "1,2,3,4,5";
        String[] arr = tmp.split(",");
        for(int i=0; i<arr.length; i++)
            System.out.println(arr[i]);
    }
}
