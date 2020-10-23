package demo5;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

        StringBuilder src = new StringBuilder("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javap-13");
        StringBuilder dst = new StringBuilder("C:\\Users\\majiao\\Desktop\\copy_path");
        File src_file = new File(src.toString());
        File dst_file = new File(dst.toString());
        if(!dst_file.exists()) dst_file.mkdirs();
//        copy_file(src_file, dst, src_file.getName());
        dfs(src_file, dst_file);

        if(debug) {
            out_time = System.currentTimeMillis();
            cout.printf("run time : %d ms\n", out_time-start_time);
        }
        cout.flush();
    }

    public static void dfs(File src, File dst) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder(dst.getAbsolutePath());
        sb.append("\\");
        sb.append(src.getName());
        File now = new File(sb.toString());
        if(src.isFile()) {
            try {
                now.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            cout.printf("copy:%s\n", sb);
            copy_file(src, now);
            return ;
        }
        File[] chls = src.listFiles();

        cout.printf("mkdir:%s\n", now);
        now.mkdirs();
        for(File chl : chls)
            dfs(chl, now);
    }

    private static void copy_file(File src, File dst) {
        if(!dst.exists()) {
            try {
                dst.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst));
        ) {
            int len = 0;
            while((len=in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.flush();
//            cout.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

