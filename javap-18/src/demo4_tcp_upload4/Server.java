package demo4_tcp_upload4;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CMD {
    public static final int ERR = -1,
                              LS = (1 << 0), //列出目录返回给客户端
                              RECV_FILE = (1 << 1), //接收文件
                              EXIT = (1 << 2); //退出线程
}

class RecvFileTask implements Callable<Object> {
    Socket client = null;
    public static int cnt = 0;
    public static Object lock = new Object();
    public static String root_path = "C:\\Users\\majiao\\Desktop\\";
    public static String pre_path = "C:\\Users\\majiao\\Desktop\\copy_";

    public RecvFileTask(Socket client) { this.client = client; }

    //作用严格读满区间 [lef, rig)
    public static void read_fill(InputStream in, byte by[], long lef, long rig) throws IOException {
        int need = (int) (rig - lef);
        int len = 0;
        while(need > 0) {
            len=in.read(by, 0, need);
            need -= len;
        }
    }

    public int read_cmd(DataInputStream sock_in) {
        try {
            System.out.printf("server尝试接收命令: \n");
            System.out.flush();
            int ret = sock_in.readInt();
//            int ret = real_recv_int(client.getInputStream());
            System.out.printf("server接收到命令: [ %d ]\n", ret);
            System.out.flush();
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CMD.ERR;
    }

    void list_file(DataOutputStream sock_out) throws IOException {

        File file = new File(root_path);

        String[] list = file.list();
        sock_out.writeInt(list.length);
//        real_write_int(sock_out, list.length);

        for(int i=0; i<list.length; i++) {
            byte[] bytes = list[i].getBytes();
            sock_out.writeInt(bytes.length);
//            real_write_int(sock_out, bytes.length);
            sock_out.write(bytes);
        }
        sock_out.flush();
    }

    void recv_file(DataInputStream sock_in) throws IOException {
        synchronized (lock) {
            cnt ++;
        }
        int name_len = sock_in.readInt();
//        int name_len = real_recv_int(in);
        byte name_bytes[] = new byte[1024], buf[] = new byte[4096<<2];
//        in.read(name_bytes, 0, name_len);
        read_fill(sock_in, name_bytes,0, name_len);
        String name = new String(name_bytes, 0, name_len);

        System.out.printf("文件名长度:%d\n文件名:[%s]\n", name_len, name);

        long file_len = sock_in.readLong();
        System.out.printf("文件长度:[%d]\n", file_len);

        int rev_file_len = 0;
        StringBuilder path = new StringBuilder(pre_path);
        path.append(cnt).append(name);
        FileOutputStream fos = new FileOutputStream(path.toString());
        BufferedOutputStream file_out = new BufferedOutputStream(fos);
        byte[] pbuf = new byte[1024<<2];
        while(file_len > 0) {
            long L = 0, R = Math.min(file_len, 1024L<<2);
            read_fill(sock_in, pbuf, L, R);
            int get_len = (int) (R - L);
            if(get_len <= 0) continue;
            file_out.write(pbuf, 0, get_len);
            rev_file_len += get_len;
            file_len -= get_len;
//            System.out.printf("[pack len: %d not read: %d]\n", get_len, file_len);
//            System.out.flush();
        }
        file_out.flush();
        file_out.close();
        fos.close();
        System.out.printf("%s 接收文件:%s [%d byte]\n", Thread.currentThread().getName(), path, rev_file_len);
        System.out.flush();
    }

    @Override
    public Object call() throws Exception {
        int cmd = CMD.ERR;
        DataInputStream sock_in = new DataInputStream(client.getInputStream());
        DataOutputStream sock_out = new DataOutputStream(client.getOutputStream());
        while(CMD.ERR != (cmd=read_cmd(sock_in))) {
            System.out.flush();
            if(CMD.LS == cmd)
                list_file(sock_out);
            else if(CMD.RECV_FILE == cmd)
                recv_file(sock_in);
            else break;
        }

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
            cout.printf("accept a client : %s\n", client.getInetAddress().getHostAddress());
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

    public static void show_int(int ans) {
        for(int i=31; i>=0; i--) {
            System.out.printf("%d", (ans>>>i)&1);
        }
        System.out.println();
        System.out.flush();
    }

}

