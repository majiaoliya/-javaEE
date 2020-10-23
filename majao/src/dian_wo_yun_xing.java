import java.io.*;

public class dian_wo_yun_xing {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\a.txt"));
        BufferedReader br=new BufferedReader(new FileReader(("D:\\a.txt")));
        bw.write("我是大傻逼");
        bw.close();
        System.out.println(br.readLine());
        br.close();
    }
}
