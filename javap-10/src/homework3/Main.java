package homework3;


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
    public static byte buf[] = new byte[MAXN];

    public static void main(String[] args) throws IOException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        if(false) {
            Integer a[] = { 1, 3, 5, 7, 9, 11 },
                    b[] = { 2, 3, 4, 7, 10, 11};
        }

        //类似归并，复杂度 O(nlogn)
        Integer a[] = { 1, 3, 5, 7, 9, 11 },
                b[] = { 2, 3, 5, 6, 10, 11, 3, 19, 20, 21, 22, 23, 18};
//        Arrays.sort(a); Arrays.sort(b);

        TreeSet<Integer> lef = new TreeSet<>(),
                            rig = new TreeSet<>();
        for(int x : a) lef.add(x);
        for(int x : b) rig.add(x);
        lef.add(INF); rig.add(INF);
        Iterator<Integer> l = lef.iterator(),
                          r = rig.iterator();
        boolean ok = false;
        int x = l.next(), y = r.next();
        do {
            if(x == y) {
                ok = true;
                cout.printf("<%d>  ", x);
                if(!l.hasNext() || !r.hasNext()) continue;
                x = l.next();
            } else if(x < y && l.hasNext()) {
                x = l.next();
            } else if(r.hasNext()) {
                y = r.next();
            }
        } while(l.hasNext() && r.hasNext());
        if(!ok) {
            for (int val : rig) lef.add(val);
            for (int val : lef) {
                cout.printf("[%d] ", val);
            }
        }

        cout.println(ok ? "yes" : "no");
        if(debug) {
            out_time = System.currentTimeMillis();
            cout.printf("run time : %d ms\n", out_time-start_time);
        }
        cout.flush();
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

