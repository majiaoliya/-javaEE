package ArrayListDemo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add(" 五再远 ");
        list.add(" 不 ");
        list.add(" 喜欢 ");
        list.add(" eat ");
        list.add(" shit");
        list.remove(" 不 ");
        list.add(1, " 很 ");
        System.out.println(list);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
