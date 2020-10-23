package com.icis.demo;

import java.util.Random;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("");
        for(int i='a'; i<='z'; i++) str.append((char)i);
        System.out.println(str + " cap:" + str.capacity());
        for(int i=0; i<100; i++) {
            if((i&1) == 0)
                str.append(i);
        }
        System.out.println(str);
//        str = new StringBuilder("{");
        str.setLength(0);
        str.append('{');
        for(int i=0, flag=0; i<50; i++) {
            if((i&1) == 0) {
                if(flag++ != 0) str.append(',');
                str.append(i);
            }
        }
        str.append('}');
        System.out.println(str);
        int arr[] = to_int_arr(str);
        for(int i=1; i<=arr[0]; i++)
            System.out.printf("[%d] ", arr[i]);
//        StringBuilderTest.Student stu1 = new StringBuilderTest.Student("张三", arr);
        Student stu1 = new Student("张三", arr),
                stu2 = new Student("伍再元", arr),
                stu3 = new Student("XIANXIAN", arr);
        System.out.println(stu1.toString() + "\n" + stu2.toString() + "\n" + stu3.toString() + "\n");
    }

    public static int[] to_int_arr(StringBuilder s) {
        int N = s.capacity();
        int []arr = new int[N];
        int tmp = 0, n = s.length(), sz = 0;
        for(int i=1; i<n; i++) {
            char ch = s.charAt(i);
            if(ch== ',' || ch=='}') {
                arr[++sz] = tmp;
                tmp = 0;
                arr[0] ++;
            } else {
                if(ch >= '0' && ch <= '9') tmp = tmp*10 + (s.charAt(i)-'0');
            }
        }
        return arr;
    }
/**
    class Student {
        public String name;
        public int age;

        public Student(String name) { this.name = name; }
        public Student(String name, int arr[]) {
            this.name = name;
            Random rand = new Random(System.currentTimeMillis());
            this.age = arr[rand.nextInt(arr.length)];
        }

        @Override
        public String toString() {
            return "[名字:" + name + " 年龄:" + age + "]";
        }
    }
 */
}

