package homework.作业4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int N = 4;
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        String s[] = { "思", "张", "鸡" };
        for(int i=0; i<s.length; i++)
            for(int j=0; j<N; j++) list.add(new Student(s[i]+j, 17));
        System.out.println(list);
        ArrayList<String> p = new ArrayList<>();
        list = search_stu_by_pre(list, "思");
        System.out.println(list);
    }

    public static List<Student> search_stu_by_pre(List<Student> list, String pre_str) {
        List<Student> ret = new ArrayList<>();
        for(Student iter : list) {
//            if(iter.name.startsWith(pre_str)) ret.add(iter);
            if(-1 != iter.name.indexOf(pre_str)) ret.add(iter);
        }
        return ret;
    }
}
