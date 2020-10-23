package demo;


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

        File file = new File("C:\\Users\\majiao\\Desktop\\java高级-day10");
        class MyFileFilterImpl implements FileFilter {
            @Override
            public boolean accept(File file) {
                char[] ch = file.getName().toCharArray();
                boolean flag = file.isFile() || true;
                int n = ch.length - 1;
                return flag;
            }
        }

        File[] files = file.listFiles(new MyFileFilterImpl());
//        tmp[0] = (file.getName().length()+1)/2;
        for(File f : files)
            cout.printf("[%s %c]\n", f.getName(), f.getName().charAt('\u0000'));

        cout.printf("----------------------\n");
        StringBuilder pre = new StringBuilder();
        dfs(file, 0, 0);

        if(debug) {
            out_time = System.currentTimeMillis();
            cout.printf("run time : %d ms\n", out_time-start_time);
        }
        cout.flush();
    }
    public static int cnt[] = new int[1024], /*第i层的剩余未打印节点个数*/
                        mid[] = new int[1024]; /*第i层的中间位置*/
    public static void dfs(File file, int fa_len, int level) {
        print_line(cnt, level);
        cout.printf("%s [%d]\n", file.getName(), level);
        if(level > 0) {
            mid[level] = mid[level-1] + (fa_len+1)/2;
            mid[level] = Math.max(mid[level], 3);
        }
        if(file.isFile()) return ;
        File[] chls = file.listFiles();
        cnt[level] = chls.length;
        for(File chl : chls)
            dfs(chl, chl.getName().length(), level+1);
        cnt[level] = 0;
    }

    public static void print_line(int tmp[], int M) {
        int j = 0;
        for(int i=0; i<M; i++) {
            while(j++<mid[i]) {
                cout.print(' ');
            }
            if(cnt[i] > 1) cout.print('|');
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



