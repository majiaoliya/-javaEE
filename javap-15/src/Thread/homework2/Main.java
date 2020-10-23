package Thread.homework2;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Sex {
    boy, girl
}

class Emp implements Comparable<Emp> {
    public String name, age, dozhang;
    public Sex sex;

    public Emp() { }

    public Emp(String name, String age, String dozhang, Sex sex) {
        this.name = name;
        this.age = age;
        this.dozhang = dozhang;
        this.sex = sex;
    }

    public Emp(String name, String age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex=" + (sex== Sex.boy ? "男" : "女") +
                '}';
    }

    @Override
    public int compareTo(Emp o) {
        int x = Integer.parseInt(this.age);
        int y = Integer.parseInt(o.age);
        return x < y ? -1 : 1;
    }
}

public class Main {
    public static final boolean debug = true;
    public static String INPATH = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javap-15\\src\\Thread\\employees.txt",
            OUTPATH = "C:\\Users\\majiao\\Desktop\\out.txt";
    public static StreamTokenizer tok;
    public static BufferedReader cin;
    public static PrintWriter cout;

    public static long start_time = 0, out_time = 0;
    public static int n, m, K, Q, MAXN = (int)1e5+7, INF = 0x3f3f3f3f;
    public static byte buf[] = new byte[MAXN];

    public static void main(String[] args) throws IOException, InterruptedException {
        main_init();
        if(debug) { start_time = System.currentTimeMillis(); }
        if(false) { System.setOut(new PrintStream(OUTPATH)); }
        class Thread1 extends Thread {
            public void run() {
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new InputStreamReader(new FileInputStream(INPATH), "gbk"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Map<String, List<Emp>> mp = new HashMap<>();
                n =2;
                while(n -->0) {
                    String s = null;
                    try {
                        s = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    List<Emp> list = new ArrayList<>();
                    mp.put(s, list);
                    for (int i = 0; i < 3; i++) {
                        String str = null;
                        try {
                            str = in.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (str == null || str.length() == 0) break;
                        String[] split = str.split(",");
    //                cout.printf("[%s]\n", str);
                        Sex sex = split[2].equals("男") ? Sex.boy : Sex.girl;
                        Emp emp = new Emp(split[0], split[1], split[3], sex);
                        list.add(emp);
                    }
                    list.sort(Emp::compareTo);
                    cout.println(list);
                }
            }
        }
        Thread th = new Thread1();
        th.start();
        Thread.sleep(1000);

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

