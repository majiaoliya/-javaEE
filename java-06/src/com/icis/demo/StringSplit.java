package com.icis.demo;

import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {

        String str = null;

        if(false) {
            Scanner cin = new Scanner(System.in);
            str = cin.nextLine();
            System.out.println(str);
        }

        str = "广西科技大学";
        System.out.println(str.equals("广西工学院"));
        System.out.println(str.contains("科技"));
        str = new String("广西工学院");
        System.out.println(str.substring(2, 5));

        str = "1,2,3,4,5";
        //split
        String[] arr = str.split(",");
        System.out.println("按逗号分隔 {1,2,3,4,5} 后");
        for(int i=0; i<arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }
        System.out.println();
        int array[] = { 1, 2, 3, 4, 5 };
        System.out.println(arrToString(array));

        //去掉前后空格
        str = "   space   ";
        System.out.println("去空格前:" + "[" + str + "]\n" + "去空格后:" + "[" + str.trim() + "]");

        //子串替换
        str = "A C M 选手退役了 [也要] 写算法题";
        System.out.println(str + "\n" + str.replace("也要", "就不要"));

        //遍历字符串
        foreach_str("上海自来水来自海上");

        System.out.println();
        str = "ABCabcd12345";
        int ret[] = countStr(str);
        System.out.printf("\n%s: 大写: %d  小写: %d  字母: %d\n", str, ret[2], ret[1], ret[0]);
        System.out.println("转大写:" + str.toUpperCase());
        System.out.println("转小写:" + str.toLowerCase());

        //首字母大写
        str = "acmer_oier_acmer_oier";
        char ch = str.charAt(0);
        ch = (char)((ch >= 'a' && ch <= 'z') ? (ch - 'a' + 'A') : ch);
        System.out.println(ch + str.substring(1));

        //字符串反转
        str = "123456";
        System.out.printf("反转%s后为%s\n", str, StringSplit.reverse(str));

        Shit shit = new Shit("blue shit\n");
        shit = StringSplit.pushShit(shit, "yellow shit");
        System.out.println(shit.name);
    }

    public static String arrToString(int arr[]) {
        String s = "";
        s += "[";
        for(int i=0; i<arr.length; i++) {
            s += ( (i>0 ? "," : "") + arr[i]);
        }
        return (s+"]");
    }

    public static void foreach_str(String str) {
        for(int i=0; i<str.length(); i++ )
            System.out.printf("str[%d]=%c, ", i, str.charAt(i));
    }

    //练习：统计字符串中大写、小写及数字字符个数
    public static int[] countStr(String str) {
        int ret[] = new int[4];
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') ret[0] ++;
            else if(ch >= 'a' && ch <= 'z') ret[1] ++;
            else if(ch >= 'A' && ch <= 'Z') ret[2] ++;
        }
        return ret;
    }

    public static String reverse(String s) {
        char data[] = s.toCharArray();
        int lef = 0, rig = s.length() - 1;
        for( ; lef < rig; lef ++, rig --) {
            data[lef] ^= data[rig];
            data[rig] ^= data[lef];
            data[lef] ^= data[rig];
        }
        return new String(data);
    }

    //类名做参数和返回值
    public static Shit pushShit(Shit shit, String shit_name) {
        shit.name = shit_name;
        return shit;
    }
}

class Shit {
    public String name;
    public Shit() { }
    public Shit(String name) { this.name = name; }
}
