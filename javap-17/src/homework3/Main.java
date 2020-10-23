package homework3;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

class Mutex {
    public static Semaphore plate = new Semaphore(1),
                             apple = new Semaphore(0),
                             oringe = new Semaphore(0);
    public static String str = null;
}

class Dad implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("爸爸");
        while(true) {
            try {
                Mutex.plate.acquire();
                String name = Thread.currentThread().getName();
                Mutex.str = "苹果";
                System.out.printf("[%s 放入 %s\n", name, Mutex.str);
                Mutex.apple.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Mon implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("妈妈");
        while(true) {
            try {
                Mutex.plate.acquire();
                Mutex.str = "橘子";
                String name = Thread.currentThread().getName();
                System.out.printf("[%s 放入 %s\n", name, Mutex.str);
                Mutex.oringe.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Son implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("儿子");
        while(true) {
            try {
                Mutex.oringe.acquire();
                String name = Thread.currentThread().getName();
                System.out.printf("%s 吃掉 %s]\n\n", name, Mutex.str);
                Mutex.plate.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Dat implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("女儿");
        while(true) {
            try {
                Mutex.apple.acquire();
                String name = Thread.currentThread().getName();
                System.out.printf("%s 吃掉 %s]\n\n", name, Mutex.str);
                Mutex.plate.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    public static void main(String[] args) throws IOException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        Thread dad = new Thread(new Dad()),
               mon = new Thread(new Mon()),
               son = new Thread(new Son()),
               dat = new Thread(new Dat());
        dad.start();
        mon.start();
        son.start();
        dat.start();
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

