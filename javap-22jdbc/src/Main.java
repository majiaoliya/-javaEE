



import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

public class Main {
    public static final boolean debug = true;
    public static String INPATH = "C:\\Users\\majiao\\Desktop\\test.txt",
            OUTPATH = "C:\\Users\\majiao\\Desktop\\out.txt";
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0;
    public static int n, m, K, Q, MAXN = (int)1e5+7, INF = 0x3f3f3f3f,
            pre[] = new int[MAXN], sum[] = new int[MAXN], POS = 50000;
    public static byte buf[] = new byte[MAXN];

    public static int fa(int x) { return pre[x]==x ? x : (pre[x]=fa(pre[x])); }

    public static void union_xy(int x, int y) {
        x = fa(x); y = fa(y);
        if(x != y) {
            sum[x] += sum[y];
            pre[y] = x;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        @Override
        public int compareTo(Edge o) { return w - o.w; }
    }
    static Edge a[] = new Edge[MAXN];

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/db3";
        Connection conn = DriverManager.getConnection(url, "root", "root");
//        String sql = "SELECT * FROM emp";
        String sql = "SELECT name, join_date as fuck, dept_id as fuck2 FROM emp";
        PreparedStatement st = conn.prepareStatement(sql);
//        st.setString(1, "join_date");
//        st.setString(2, "dept_id");
        ResultSet rs = st.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        while(rs.next()) {
            for(int i=1; i<=col; i++)
                cout.printf("[%s:%s] ", rs.getMetaData().getColumnName(i), null==rs.getString(i) ? "fuck" : rs.getString(i));
            cout.printf("\n");
        }
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

}
