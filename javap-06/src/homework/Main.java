package homework;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static final boolean debug = true;
    public static String INPATH = "C:\\Users\\majiao\\Desktop\\test.txt",
                          OUTPATH = "C:\\Users\\majiao\\Desktop\\out.txt";
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0;
    public static int n, m, K, Q, MAXN = (int)1e5+7, INF = 0x3f3f3f3f;
//    public static byte buf[] = new byte[MAXN];

    public static void main(String[] args) throws IOException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        String nums[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
                          "Q", "K" },
                sufs[] = { "♠", "♥", "♦", "♣" };

        ArrayList<Poker> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++)
            for(String suf : sufs) {
                list.add(new Poker((i), (nums[i]+suf)));
            }
        list.add(new Poker(INF, "大王"));
        list.add(new Poker((INF-1), "小王"));

//        Collections.shuffle(list);
        knuth_shuffle(list); // 时间复杂度O(N) 的 knuth 洗牌算法
//        th_shuffle(list); //vue老师王欢上课时讲的算法 复杂度 O(N log N)
        ArrayList<Poker> user[] = new ArrayList[4];
        int now = 0;
        for(int i=0; i<4; i++) {
            user[i] = new ArrayList<>();
            int len = 17;
            while(len-- > 0 && now < list.size())
                user[i].add(list.get(now++));
        }

//        class StringCmp implements Comparator<String> {
//            @Override
//            public int compare(String x, String y) {
//                if('A' == y.charAt(0) && x.charAt(0) == 'A')
//                    return x.charAt(1) < y.charAt(1) ? -1 : 1;
//                else if(x.charAt(0) == 'A') return -1;
//                return x.length() > y.length() ? 1 : x.compareTo(y);
//            }
//        }

//        StringCmp mycmp = new StringCmp();
        for(ArrayList<Poker> s : user) {
//            s.sort(StringCmp::compareTo);
            Collections.sort(s, Poker::compareTo);
            System.out.println(s);
        }

        if(debug) {
            out_time = System.currentTimeMillis();
            cout.printf("run time : %d ms\n", out_time-start_time);
        }
        cout.flush();
    }

    // 时间复杂度 O(N)
    public static void knuth_shuffle(ArrayList<Poker> list) {
        int n = list.size() - 1;
        Random rand = new Random();
        for( ; n > 0; n --) {
            int pos = rand.nextInt(n+1);
            //swap(list[n], list[pos])
            Poker tmp = list.get(pos);
            list.set(pos, list.get(n));
            list.set(n, tmp);
        }
    }

    // vue老师王欢上课时讲的做法
    // 时间复杂度 O(N log N)
    public static void th_shuffle(ArrayList<Poker> list) {
        class Node implements Comparable<Object> {
            int cmp;
            Poker val;
            public Node(int _cmp, Poker _val) {
                this.cmp = _cmp;
                this.val = _val;
            }
            @Override
            public int compareTo(Object o) {
                Node no = (Node) o;
                return cmp < no.cmp ? 1 : -1;
            }
        }
        List<Node> tmp = new ArrayList<>();
        Random rand = new Random();
        for(Poker p : list) {
            Node no = new Node(rand.nextInt(INF), p);
            tmp.add(no);
        }
        tmp.sort(Node::compareTo);
        int i = 0;
        for(Node no : tmp)
            list.set(i ++, no.val);
    }

    public static void main_init() {
        try {
            if (debug) {
                cin = new BufferedReader(new InputStreamReader(
                        new FileInputStream(INPATH)));
            } else {
                cin = new BufferedReader(new InputStreamReader(System.in));
            }
            cout = new PrintWriter(new OutputStreamWriter(System.out));
//            cout = new PrintWriter(OUTPATH);
            tok = new StreamTokenizer(cin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String next_str() {
        try {
            tok.nextToken();
            if (tok.ttype == StreamTokenizer.TT_EOF)
                return null;
            else if (tok.ttype == StreamTokenizer.TT_NUMBER) {
                return String.valueOf((int)tok.nval);
            } else if (tok.ttype == StreamTokenizer.TT_WORD) {
                return tok.sval;
            } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int read_int() { return Integer.parseInt(next_str()); }
    public static long read_long() { return Long.parseLong(next_str()); }
    public static double read_double() { return Double.parseDouble(next_str()); }
    public static BigInteger read_big() { return new BigInteger(next_str()); }
    public static BigDecimal read_dec() { return new BigDecimal(next_str()); }

}



class Poker implements Comparable<Poker> {
    public int cmp;
    public String val;
    public Poker() { }
    public Poker(int cmp, String val) {
        this.cmp = cmp;
        this.val = val;
    }
    @Override
    public int compareTo(Poker o) {
        if(this.cmp == o.cmp) return this.val.compareTo(o.val);
        return this.cmp < o.cmp ? -1 : 1;
    }
    @Override
    public String toString() { return val; }
}
