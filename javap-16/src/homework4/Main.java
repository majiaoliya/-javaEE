package homework4;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyTh {
//    public static Object m1 = new Object(), m2 = new Object();
    public static Semaphore m1 = new Semaphore(1),
                             m2 = new Semaphore(0);
}

class ThA implements Runnable {
    public static int x = 1, y = 99;
    public static boolean flag = true;
    @Override
    public void run() {
        while(true) {
            try {
//                MyTh.m1.wait();
                MyTh.m1.acquire();
                if (x < 100) {
                    System.out.printf("A:%d\n", x);
                    x += 2;
                } else break;
                Thread.sleep(1000);
                MyTh.m2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThB implements Runnable {
//    public static int x = 1, y = 99;
    @Override
    public void run() {
        while(true) {
            try {
                MyTh.m2.acquire();
                if(ThA.y >= 0) {
                    System.out.printf("B:%d\n", ThA.y);
                    ThA.y -= 2;
                } else break;
                Thread.sleep(1000);
                MyTh.m1.release();
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

    public static void main(String[] args) throws IOException, InterruptedException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

//        MyTh.m2.acquire();
        Thread th[] = new Thread[2];
        ThA a = null;
        ThB b = null;
        th[0] = new Thread((a=new ThA()));
        th[1] = new Thread((b=new ThB()));
        th[0].start(); th[1].start();



//        th[0].start(); th[1].start();
//        Thread.sleep(9999);

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

