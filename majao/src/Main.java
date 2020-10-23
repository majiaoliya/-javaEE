
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static final boolean debug = true;
    public static String INPATH = "C:\\Users\\majiao\\Desktop\\P2052_9.in",
            OUTPATH = "C:\\Users\\majiao\\Desktop\\out.txt";
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0, ans = 0;
    public static int n, m, K, Q, MAXN = (int)1e6+7, INF = 0x3f3f3f3f;

    static List<Edge> G[] = new ArrayList[MAXN];

    static class Edge {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    public static int dfs(int u, int fa) {
        int chls = 0, edchls = 0;
        for (Edge ed : G[u]) {
            int v = ed.v, w = ed.w;
            if(v == fa) continue ;
            edchls = dfs(v, u);
            chls += edchls;
            ans += (w*1l* abs(edchls-(n-edchls)));
        }
        return chls + 1;
    }
    public static void main(String[] args) throws IOException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        n = read_int();
        int u, v, w;
        for(int i=1; i<=n+1; i++) G[i] = new ArrayList<>();
        for(int i=1; i<n; i++) {
            u = read_int(); v = read_int(); w = read_int();
            G[u].add(new Edge(v, w));
            G[v].add(new Edge(u, w));
        }
        dfs(1, 1);
        cout.printf("%d\n", ans);








        if(debug) {
            out_time = System.currentTimeMillis();
            cout.printf("run time : %d ms\n", out_time-start_time);
        }
        cout.flush();
    }

    public static void show(List<Object> list, Object... obj) {
        cout.printf("%s : ", obj.length>0 ? obj[0] : "");
        for(Object x : list) {
            cout.printf("[%s] ", x);
        }
        cout.printf("\n");
    }

    public static void show(Map<Object, Object> mp, Object... obj) {
        cout.printf("%s : ", obj.length>0 ? obj[0] : "");
        Set<Map.Entry<Object, Object>> entries = mp.entrySet();
        for (Map.Entry<Object, Object> en : entries) {
            cout.printf("[%s,%s] ", en.getKey(), en.getValue());
        }
        cout.printf("\n");
    }

    public static<T> void forarr(T arr[], int ...args) {
        int lef = 0, rig = arr.length - 1;
        if(args.length > 0) { lef = args[0]; rig = args[1]; }
        cout.printf(" : ");
        for( ; lef<=rig; lef++) {
            cout.printf("[%s] ", args[lef]);
        }
        cout.printf("\n");
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


    class Pair implements Comparable<Pair>{
        int fst, sec;
        public Pair() { }
        public Pair(int fst, int sec) {
            this.fst = fst;
            this.sec = sec;
        }
        @Override
        public int compareTo(Pair o) {
            return fst - o.fst == 0 ? sec - o.sec : fst - o.fst;
        }
    }
}

