package homework2;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> list = new ArrayList<Student>();
        list = inputStu(4);
        String out_path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\homework2\\mydir\\data";
        int cnt = Main.writeToFile(list, out_path);
        System.out.println("output cnt:" + cnt);
        list = Main.readFromFile(2, out_path);
        for(Student stu : list)
            System.out.println(stu);
    }

    public static int writeToFile(List<Student> list, String path) throws IOException {
        BufferedWriter cout = new BufferedWriter(new FileWriter(path));
        int i = 0;
        for( ; i<list.size(); i++) {
            Student stu = list.get(i);
            cout.write(stu.toString());
            cout.newLine();
        }
        cout.flush();
        cout.close();
        return i;
    }

    public static List<Student> inputStu(int n) throws FileNotFoundException {
        if(true) {
            FileInputStream fis = new FileInputStream("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\homework2\\test");
            System.setIn(fis);
        }
        Scanner cin = new Scanner(System.in);
        List<Student> ret = new ArrayList<>();
        for(int i=0; i<n; i++) {
            System.out.printf("请输入第 %d 个学生[id,name,age, address]\n", i);
            Student stu = new Student();
            ret.add(stu);
            stu.setId(cin.next());
            stu.setName(cin.next());
            stu.setAge(cin.next());
            stu.setAddress(cin.next());
            System.out.println(stu.toString());
        }
        return ret;
    }

    public static List<Student> readFromFile(int n, String path) throws IOException {
        List<Student> list = new ArrayList<>();
        BufferedReader cin = new BufferedReader(new FileReader(path));
        String str = null;
        while(n-->0 && null!=(str=cin.readLine())) {
            String s[] = str.split(" ");
            Student stu = new Student();
            stu.setId(s[0]); stu.setName(s[1]); stu.setAge(s[2]); stu.setAddress(s[3]);
            list.add(stu);
        }
        cin.close();
        return list;
    }
}
