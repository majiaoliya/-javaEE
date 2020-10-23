package demo4;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class VideoPlay { //普通单例模式
    private static VideoPlay ins = new VideoPlay();
    private VideoPlay() { }
    public synchronized static VideoPlay getIns() {
        return VideoPlay.ins;
    }
}

class VideoPlay2 { //双重锁 JDK1.5写法
    /**
     使用 volatile 关键字 每次都从主储存取值(每次都能取到最新的值)
     如果不加 volatile 关键字 jvm会对其进行指令重排
      new VideoPlay2() 过程为
             理论过程 ：1.分配内存  2.初始化 3.返回内存地址
             实际底层回进行重排过程 ：1.分配内存  2.返回地址  3. 初始化
     由于重排，
     线程 A 执行1.分配内存 2.返回地址(还未初始化)
     线程 B 发现ins不为空（还未初始化)， 就直接拿来用 ，所以造成了不安全
     */
    private volatile static VideoPlay2 ins;
    public static VideoPlay2 getIns() {
        if(ins == null) {
            synchronized (VideoPlay2.class) {
                if(ins == null) ins = new VideoPlay2();
            }
        }
        return ins;
    }
}

class VideoPlay3 { //双重锁 使用静态内部类实现
    private static class Helper {
        private static VideoPlay3 ins = new VideoPlay3();
    }
    private VideoPlay3() { }
    public static final VideoPlay3 getIns() {
        return Helper.ins;
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

