package com.icis.pt;

public class Coder extends Person {

    private double salary;

    public Coder(String name, int age) {
        super(name, age);
    }

    public void code() {
        System.out.println(super.getName() + " 写代码\n");
        System.out.println("age:" + super.getAge());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Coder(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public Coder() {
    }
}
