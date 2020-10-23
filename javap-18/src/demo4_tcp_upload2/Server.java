package demo4_tcp_upload2;


import javax.naming.Name;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RecvFileTask implements Callable<Object> {
    Socket client = null;
    public static int cnt = 0;
    public static Object lock = new Object();
    public static String root_path = "C:\\Users\\majiao\\Desktop\\";
    public static String pre_path = "C:\\Users\\majiao\\Desktop\\copy_";

    public RecvFileTask(Socket client) { this.client = client; }

    //作用严格读满区间 [lef, rig)
    public static void read_fill(InputStream in, byte by[], int lef, int rig) throws IOException {
        int need = rig - lef;
        int len = 0;
        while(need > 0) {
            len=in.read(by, 0, need);
            need -= len;
        }
    }

    @Override
    public Object call() throws Exception {

        OutputStream os = client.getOutputStream();
        BufferedOutputStream sock_out = new BufferedOutputStream(os);
        File file = new File(root_path);
        String[] list = file.list();
        sock_out.write(list.length);
        for(int i=0; i<list.length; i++) {
            byte[] bytes = list[i].getBytes();
            sock_out.write(bytes.length);
            sock_out.write(bytes);
        }
        sock_out.flush();

        synchronized (lock) {
            cnt ++;
        }
        InputStream in = client.getInputStream();
        int name_len = in.read();
        byte name_bytes[] = new byte[1024], buf[] = new byte[4096<<2];
//        in.read(name_bytes, 0, name_len);
        read_fill(in, name_bytes,0, name_len);
        String name = new String(name_bytes, 0, name_len);

        System.out.printf("name_len:%d\nname:[%s]\n", name_len, name);

        int len = -1, file_len = 0;
        StringBuilder path = new StringBuilder(pre_path);
        path.append(cnt).append(name);
        BufferedOutputStream file_out = new BufferedOutputStream(new FileOutputStream(path.toString()));
        while(-1 != (len=in.read(buf))) {
            file_out.write(buf, 0, len);
            file_len += len;
        }
        file_out.flush();
        file_out.close();
        System.out.printf("%s 接收文件:%s [%d byte]\n", Thread.currentThread().getName(), path, file_len);
        System.out.flush();
        client.close();
        return null;
    }
}

public class Server {
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

        ServerSocket server = new ServerSocket(8899);
        String pre_path = "C:\\Users\\majiao\\Desktop\\copy_";
        boolean flag = true;
        int cnt = 0;
        ExecutorService pool = Executors.newFixedThreadPool(64);
        RecvFileTask recv_task = null;
        while(flag) {
            Socket client = server.accept();
            cout.printf("accept a client : \n");
            cout.flush();
            recv_task = new RecvFileTask(client);
            pool.submit(recv_task);
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

