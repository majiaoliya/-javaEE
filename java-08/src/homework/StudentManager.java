package homework;

import pojo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 学成管理系统程序入口  System.extit(0) 退出jvm
public class StudentManager {

    public static void main(String[] args) {
        //定义一个键盘输入类对象
        Scanner scanner=new Scanner(System.in);
        // 创建学生集合  存储学生
        ArrayList<Student> list =new ArrayList<>();
        
        while(true){
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            String choice = scanner.next();
            Scanner cin = scanner;
            //switch 判断选择
            switch (choice){
                case "1":
                    System.out.println("查看...");
                    if(list.isEmpty()) {
                        System.out.println("空列表, 无学生");
                        break;
                    }
                    for(int i=0; i<list.size(); i++)
                        System.out.println(list.get(i));
                    break;
                case "2":
                    System.out.println("添加...");
                    add_stu(cin, list);
                    break;
                case "3":
                    System.out.println("删除...");
                    del_stu(cin, list);
                    break;
                case "4":
                    System.out.println("修改...");
                    upd_stu(cin, list);
                    break;
                case "5":
                    System.out.println("欢迎下次光临!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("操作符输入有误,请重新输入!");
                    break;
            }
        }


    }

    private static boolean upd_stu(Scanner cin, List<Student> list) {
        System.out.println("输入id: ");
        Student stu = new Student(cin.next(), "", "");
        for(Student s : list) {
            if(s.equals(stu)) {
                System.out.println("输入age:");
                s.setAge(cin.next());
                System.out.println("输入name: ");
                s.setName(cin.next());
                System.out.println("修改完成:" + s);
                return true;
            }
        }
        System.out.println("没有学生 : " + stu.getId());
        return false;
    }

    public static boolean add_stu(Scanner cin, List<Student> list) {
        System.out.println("依次输入 id, name, age : ");
        Student stu = new Student(cin.next(), cin.next(), cin.next());
        for(Student s : list)
            if(s.equals(stu)) {
                System.out.println("失败 : 已经存在stu " + s);
                return false;
            }
        return list.add(stu);
    }

    public static boolean del_stu(Scanner cin, List<Student> list) {
        System.out.println("输入要删除的学生id: ");
        Student stu = new Student(cin.next(), "", "");
        int idx = -1;
        for(int i=0; i<list.size(); i++)
            if(list.get(i).equals(stu)) { idx = i; break; }
        if(-1 == idx) {
            System.out.println("删除失败 : 没有这个学生 ");
            return false;
        }
        list.remove(idx);
        System.out.println("删除成功");
        return true;
    }
}
