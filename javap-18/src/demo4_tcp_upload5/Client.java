package demo4_tcp_upload5;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static final boolean debug = false;
    public static String INPATH = "C:\\Users\\majiao\\Desktop\\timg.jpg",
            OUTPATH = "C:\\Users\\majiao\\Desktop\\out.txt",
            pre_path = "C:\\Users\\majiao\\Desktop\\down\\";
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0;
    public static int n, m, K, Q, MAXN = (int)1e5+7, INF = 0x3f3f3f3f;
    public static String ip = "127.0.0.1"; //server ip
    public static byte buf[] = new byte[MAXN];

    public static class CMD {
        public static final int ERR = -1,
                LS = (1 << 0), //列出目录返回给客户端
                SEND_FILE = (1 << 1), //向服务器发送文件
                RECV_FILE = (1 << 3), //从服务器接收文件
                EXIT = (1 << 2); //退出线程
    }

    //作用严格读满区间 [lef, rig)
    public static void read_fill(InputStream in, byte by[], long lef, long rig) throws IOException {
        int need = (int) (rig - lef);
        int len = 0;
        while(need > 0) {
            len=in.read(by, 0, need);
            need -= len;
        }
    }

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
    public static void list_file(DataInputStream sock_in) throws IOException {
        int sz = sock_in.readInt();
//        int sz = real_recv_int(sock_in);
        cout.printf("sz:%d\n", sz);

        for(int i=1; i<=sz; i++) {
            int len = sock_in.readInt();
            byte bytes[] = new byte[len];
            read_fill(sock_in, bytes, 0, len);
            String s = new String(bytes, 0, len);
            cout.printf("%d:[%s]\n", i, s);
            cout.flush();
        }
    }

    public static void recv_file(DataInputStream sock_in) throws IOException {
        System.out.printf("try read int\n");

        int name_len = sock_in.readInt();
        byte name_bytes[] = new byte[1024], buf[] = new byte[4096<<2];

        read_fill(sock_in, name_bytes,0, name_len);

        String name = new String(name_bytes, 0, name_len);
        System.out.printf("文件名长度:%d\n文件名:[%s]\n", name_len, name);

        long file_len = sock_in.readLong();
        System.out.printf("文件长度:[%d]\n", file_len);

        int rev_file_len = 0;
        StringBuilder path = new StringBuilder(pre_path);
        path.append(name);
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

    public static void download(String name, DataInputStream sock_in, DataOutputStream sock_out) throws IOException {
        int length = name.length();
        cout.printf("try down :[%s]\n", name);
        cout.flush();
        sock_out.writeInt(length);
        sock_out.write(name.getBytes());
        sock_out.flush();

        System.out.printf("开始recv_file:\n");
        System.out.flush();
        recv_file(sock_in);
    }

    public static void send_file(String file_name, DataOutputStream sock_out) throws IOException {
        cout.printf("尝试发送:[%s]\n", file_name);
        cout.flush();
        File file = new File(file_name);
        BufferedInputStream filein = new BufferedInputStream(new FileInputStream(file));
        int len = -1;
        int name_len = file.getName().length();

        sock_out.writeInt(name_len);                                    //发送文件名长度
//        real_write_int(sock_out, name_len);
        sock_out.write(file.getName().getBytes());                   //发送文件名

        long file_len = file.length();
        sock_out.writeLong(file_len);

        sock_out.flush();
        while(-1 != (len=filein.read(buf))) {
            sock_out.write(buf, 0, len);
            cout.printf("写出文件:[%s] [%d]\n", file.toString(), len);
            cout.flush();
        }
        sock_out.flush();
        filein.close();
    }

    public static void send_cmd(DataOutputStream sock_out, int cmd) throws IOException {
        cout.printf("发送命令 [ %d ]\n", cmd);
        cout.flush();
        sock_out.writeInt(cmd); sock_out.flush();
    }

    public static void main(String[] args) throws IOException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }

        Socket sock = new Socket(ip, 8899);

        InputStream is = sock.getInputStream();
        DataInputStream sock_in = new DataInputStream(is);
        DataOutputStream sock_out = new DataOutputStream(sock.getOutputStream());

        int cmd = 0;
        Scanner scan = new Scanner(System.in);
        while(0 != (cmd=scan.nextInt())) {
            if(cmd == 3) cmd = CMD.RECV_FILE;
            send_cmd(sock_out, cmd);
            if(CMD.LS == cmd)
                list_file(sock_in);
            else if(CMD.SEND_FILE == cmd) {
                cout.printf("输入要上传的文件名:");
                cout.flush();
                String p_file_name = scan.next();
                send_file(p_file_name, sock_out);
            } else if(CMD.RECV_FILE == cmd) {
                cout.printf("输入要下载的文件名:");
                cout.flush();
                scan.nextLine();
                String file_name = scan.nextLine();
                download(file_name, sock_in, sock_out);
            }
        }

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

