package homework5;


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

        class Car implements Comparable<Car> {
            public String name, color;
            public Car(String name, String color) {
                this.name = name;
                this.color = color;
            }

            @Override
            public int compareTo(Car o) {
                int x = name.compareTo(o.name),
                        y = color.compareTo(o.color);
                return x==0 ? y : x;
            }
        }
        Map<Car, String> mp = new TreeMap<>();
        n = 8;
        for(int i=0; i<n; i++) {
            mp.put(new Car("car:"+i, "color:"+i), (i*100)+"");
        }
        Set<Car> keys = mp.keySet();
        for (Car c : keys) {
            cout.printf("%s %s %s\n", c.name, c.color, mp.get(c));
        }
        Set<Map.Entry<Car, String>> entries = mp.entrySet();
        for(Map.Entry<Car, String> en : entries)
            cout.printf("[%s %s %s]\n", en.getKey().name, en.getKey().color, en.getValue());


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

