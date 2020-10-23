package com.icis.demo;
//
//public class Student {
//    private String name, pw;
//
//    public Student() {
//    }
//
//    public Student(String name, String pw) {
//        this.name = name;
//        this.pw = pw;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPw() {
//        return pw;
//    }
//
//    public void setPw(String pw) {
//        this.pw = pw;
//    }
//}
import java.util.Random;
public class Student {
    public String name;
    public int age;

    public Student(String name) { this.name = name; }
    public Student(String name, int arr[]) {
        this.name = name;
        Random rand = new Random();
        this.age = arr[rand.nextInt(arr[0]-1)+1];
    }

    @Override
    public String toString() {
        return "[名字:" + name + " 年龄:" + age + "]";
    }
}
