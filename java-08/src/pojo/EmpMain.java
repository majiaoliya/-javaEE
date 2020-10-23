package pojo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-08\\src\\pojo\\test.txt"));
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(100, 17, "张"));

        Scanner cin = new Scanner(System.in);
        for(int i=0; i<4; i++) {
            list.add(new Employee(cin.nextInt(), cin.nextInt(), cin.next()));
        }
        System.out.println(list);
        add_age_2(list);
        System.out.println(list);
    }
    public static void add_age_2(List<Employee> list) {
        for(int i=0; i<list.size(); i++) {
            Employee p = list.get(i);
            p.age += 2;
        }
    }

    public static List<Employee> add_age_2_return_60(List<Employee> list) {
        List<Employee> ret = new ArrayList<>();
        for(Employee it : list) {
            it.age += 2;
            if(it.age >= 60) ret.add(it);
        }
        return ret;
    }
}
