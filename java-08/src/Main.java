import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<32; i++) list.add(i);
        for(int i=0; i<32; i++) {
            if((i&1) == 1) {
                int pos = i - (i>>1);
                list.remove(pos);
            }
        }
        System.out.println(list);

        String str[] = { "张", "李", "鸡", "是" };
        List<String> list_str = new ArrayList<>();
        for(String s : str) list_str.add(s);
        System.out.println(list_str);
        for(String s : list_str) {
            System.out.println(s.startsWith("张") ? s : "");
        }
    }
}
