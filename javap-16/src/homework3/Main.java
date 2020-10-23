package homework3;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class User implements Runnable {
    String name;
    public int sleep_time;
    public static Lock lock = new ReentrantLock();

    public User(String name, int sleep_time) {
        this.name = name;
        this.sleep_time = sleep_time;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(this.sleep_time);
            System.out.printf("%s close\n", this.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

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

    public static void main(String[] args) throws IOException, InterruptedException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        User user[] = new User[10];
        Thread th[] = new Thread[10];
        Random rand = new Random();
        for(int i=0; i<user.length; i++) {
            user[i] = new User("name"+i, 5000);
            th[i] = new Thread(user[i]);
        }
        for(int i=0; i<th.length; i++) th[i].start();
        Thread.sleep(9999);

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

    public static int read_int() {
        String tmp_next_str = next_str();
        return null==tmp_next_str ? -1 : Integer.parseInt(tmp_next_str);
    }
    public static long read_long() { return Long.parseLong(next_str()); }
    public static double read_double() { return Double.parseDouble(next_str()); }
    public static BigInteger read_big() { return new BigInteger(next_str()); }
    public static BigDecimal read_dec() { return new BigDecimal(next_str()); }

}

