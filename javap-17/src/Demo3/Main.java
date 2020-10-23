package Demo3;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Stu {
    public String name;
    int age;

    public Stu() { }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class SetNameRun implements Runnable {
    Stu stu = null;
    public static int cnt;

    public SetNameRun(Stu stu) {
        this.stu = stu;
    }

    @Override
    public void run() {

        while(true) {
            synchronized (stu) {
                if(stu.name != null) {
                    try {
                        stu.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if((cnt & 1) == 0) stu.name = "偶数";
                else stu.name = "奇数";
                stu.age = cnt;
                System.out.printf("%s  %s : %d\n", Thread.currentThread().getName(), stu.name, cnt);
                cnt ++;
                stu.notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class GetNameRun implements Runnable {
    Stu stu = null;

    public GetNameRun(Stu stu) {
        this.stu = stu;
    }

    @Override
    public void run() {
        while(true)
            synchronized (stu) {
                if(stu.name == null) {
                    try {
                        stu.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("%s : %s %d\n", Thread.currentThread().getName(), stu.name, stu.age);
                stu.name = null;
                stu.notify();
                try {
                    Thread.sleep(100);
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

        Stu stu = new Stu();

        SetNameRun set = new SetNameRun(stu);
        GetNameRun get = new GetNameRun(stu);
        Thread A = new Thread(set),
               B = new Thread(get);
        A.setName("生产"); B.setName("消费");
        A.start(); B.start();

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

