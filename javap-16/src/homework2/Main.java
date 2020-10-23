package homework2;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Win implements Runnable {
    public static int cnt = 100;
    public int sum = 0;
    public static Object obj = new Object();
    public static final boolean FST = false;
    public static final boolean SEC = false;
    public static Lock lock = new ReentrantLock();

    public synchronized boolean func() {
        if(cnt > 0) {
            sum ++; cnt --;
            System.out.printf("%s sell %d\n",
                    Thread.currentThread().getName(), (100-cnt));
        } else {
            System.out.println("sell off\n");
            return false;
        }
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void run() {
        if(FST) {
            while(true) {
                synchronized (Win.obj) {
                    if(cnt > 0) {
                        sum ++; cnt --;
                        System.out.printf("%s sell %d\n",
                                Thread.currentThread().getName(), (100-cnt));
                    } else {
                        System.out.println("sell off\n");
                        break;
                    }
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if(Win.SEC) {
            while(true) {
                try {
                    lock.lock();
                    if(cnt > 0) {
                        sum ++; cnt --;
                        System.out.printf("%s sell %d\n",
                                Thread.currentThread().getName(), (100-cnt));
                    } else {
                        System.out.println("sell off\n");
                        break;
                    }
                    Thread.sleep(16);
//                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        } else {
            while(this.func());
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

//        if(!Win.FST && !Win.SEC) {
            Win win[] = new Win[4];
            for(int i=0; i<4; i++) {
                win[i] = new Win();
                Thread th = new Thread(win[i]);
                th.start();
            }
            Thread.sleep(4096);
            for(int i=0; i<4; i++)
                cout.printf("win[%d] = %d\n", i, win[i].sum);
//        } else {

//        }
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

