package bytestream;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static final boolean debug = false;
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

        if(false) {
            String gx = "广西工学院";
            FileOutputStream fos = new FileOutputStream(Main.INPATH);
            OutputStreamWriter os = new OutputStreamWriter(fos, "utf-8");
            try {
                os.write(gx);
                os.close();
                InputStreamReader is = new InputStreamReader(new FileInputStream(Main.INPATH));
                char buf[] = new char[1024];
                int len = 0;
                StringBuffer sb = new StringBuffer();
                while(-1 != (len=is.read(buf))) {
                    sb.append(buf, 0, len);
                }
                cout.println(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(false) {
            InputStreamReader is = new InputStreamReader(new FileInputStream(Main.INPATH), "utf-8");
            BufferedReader bf = new BufferedReader(is);
            int cnt = 0;
            String str = null;
            while((str=bf.readLine()) != null) {
                cout.println(str);
                cnt ++;
            }
            cout.println(cnt);
        } else {
            InputStreamReader is = new InputStreamReader(new FileInputStream(Main.INPATH), "utf-8");
            BufferedReader bf = new BufferedReader(is);
            int cnt = 0;
            String str = null;
            class Node implements Comparable<Node> {
                int cmp;
                StringBuilder sb;

                public Node(int cmp, StringBuilder sb) {
                    this.cmp = cmp;
                    this.sb = sb;
                }

                @Override
                public int compareTo(Node o) { return cmp < o.cmp ? -1 : 1; }
            }
            ArrayList<Node> list = new ArrayList<>();
            while((str=bf.readLine()) != null) {
//                cout.println(str);
                int id = 0;
                char[] buf = str.toCharArray();
                int i;
                for(i=0; i<buf.length && buf[i]!='.'; i++)
                    id = id * 10 + (buf[i] - '0');
                i ++;
                StringBuilder sb = new StringBuilder();
                while(i < buf.length) sb.append(buf[i++]);
                list.add(new Node(id, sb));
                cnt ++;
            }
            list.sort(Node::compareTo);
            for (Node no : list) {
                cout.println(no.sb.toString());
            }
        }

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
