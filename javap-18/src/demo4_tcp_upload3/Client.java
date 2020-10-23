package demo4_tcp_upload3;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Socket;

public class Client {
    public static final boolean debug = true;
    public static String INPATH = "C:\\Users\\majiao\\Desktop\\timg.jpg",
            OUTPATH = "C:\\Users\\majiao\\Desktop\\out.txt";
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0;
    public static int n, m, K, Q, MAXN = (int)1e5+7, INF = 0x3f3f3f3f;
    public static String ip = "127.0.0.1"; //server ip
    public static byte buf[] = new byte[MAXN];

    //作用严格读满区间 [lef, rig)
    public static void read_fill(InputStream in, byte by[], int lef, int rig) throws IOException {
        int need = rig - lef;
        int len = 0;
        while(need > 0) {
            len=in.read(by, 0, need);
            need -= len;
        }
    }

    //列出文件目录
    public static void list_file(BufferedInputStream sock_in) throws IOException {
        int sz = sock_in.read();
        for(int i=1; i<=sz; i++) {
            int len = sock_in.read();
            byte bytes[] = new byte[len];
            read_fill(sock_in, bytes, 0, len);
            String s = new String(bytes, 0, len);
            cout.printf("%d:[%s]\n", i, s);
            cout.flush();
        }
    }

    public static void send_file(String file_name, OutputStream out) throws IOException {
        File file = new File(file_name);
        BufferedInputStream filein = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream sock_out = new BufferedOutputStream(out);
        int len = -1;
        int name_len = file.getName().length();
        sock_out.write(name_len);
        sock_out.write(file.getName().getBytes());
        sock_out.flush();
        while(-1 != (len=filein.read(buf))) {
            sock_out.write(buf, 0, len);
            cout.printf("写出文件:[%s] [%d]\n", file.toString(), len);
            cout.flush();
        }
        sock_out.flush();
        filein.close();
    }

    public static void main(String[] args) throws IOException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        Socket sock = new Socket(ip, 8899);

        InputStream is = sock.getInputStream();
        BufferedInputStream sock_in = new BufferedInputStream(is);
        OutputStream out = sock.getOutputStream();

        list_file(sock_in);
        send_file(INPATH, out);

        sock.close();

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

