package com.icis;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            list.add(new Student(i));
        }
        list.sort(Student::cmp);
        for (Student s : list) {
            System.out.println(s);
        }
    }
}

class Student implements Comparable<Object> {
    public int val;

    public Student(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public int cmp(Object o) {
        Student stu = (Student) o;
        return this.val > stu.val ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "val=" + val +
                '}';
    }
}
