import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main <T> {
    public T[] ts;
    public static void main(String[] args) {
        Main<Integer> main = new Main<>();
        main.ts = new Integer[1024];
        List<String> list = new LinkedList<>();
        list.set(0, "shit");
        list.sort(String::compareTo);
        Set<Integer> seta = new TreeSet<>();
        seta.add(8);
    }

}

