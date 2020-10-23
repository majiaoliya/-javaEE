package homework.main1;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Semaphore;

class Mutex {
    public static Semaphore m1 = new Semaphore(1),
                             m2 = new Semaphore(0);
}

class ThA implements Runnable {
    int now = 0;
    @Override
    public void run() {
        while(true) {
            try {
                Mutex.m1.acquire();
                if(now >= 52) break;
                System.out.printf("[%s:%d%d]\n", Thread.currentThread().getName(), ++now, ++now);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Mutex.m2.release();
            }
        }
    }
}

class ThB implements Runnable {
    int now = 'A';
    @Override
    public void run() {
        while(true) {
            try {
                Mutex.m2.acquire();
                if(now > 'Z') break;
                System.out.printf("[%s:%c]\n", Thread.currentThread().getName(), now++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Mutex.m1.release();
            }
        }
    }
}

public class Main2 {
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

        Thread A = new Thread(new ThA()),
               B = new Thread(new ThB());
        A.start(); B.start();

        if(debug) {
            out_time = System.currentTimeMillis();
//            cout.printf("run time : %d ms\n", out_time-start_time);
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

    public static int read_int() {
        String tmp_next_str = next_str();
        return null==tmp_next_str ? -1 : Integer.parseInt(tmp_next_str);
    }
    public static long read_long() { return Long.parseLong(next_str()); }
    public static double read_double() { return Double.parseDouble(next_str()); }
    public static BigInteger read_big() { return new BigInteger(next_str()); }
    public static BigDecimal read_dec() { return new BigDecimal(next_str()); }

}

