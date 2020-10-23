package com.icis.pt;

public class Teacher extends Person {
    private double salary;

    public Teacher() { }

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public void teach() {
        System.out.println("name:" + super.getName());
        System.out.println("age:" + super.getAge());
        System.out.println("salary:" + salary);
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(double salary) {
        this.salary = salary;
    }
}
