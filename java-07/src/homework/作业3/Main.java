package homework.作业3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("192.168.10.114");
        str.append('.');
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '.') {
                list.add(sum);
                sum = 0;
            } else
                sum = sum * 10 + (ch - '0');
        }
        System.out.println(list);
    }
}
