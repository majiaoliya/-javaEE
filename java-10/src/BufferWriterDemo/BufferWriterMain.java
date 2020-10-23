package BufferWriterDemo;

import java.io.*;

public class BufferWriterMain {
    public static void main(String[] args) throws IOException {
        String path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\BufferWriterDemo\\test";
        BufferedWriter cout = new BufferedWriter(new FileWriter(path));
        cout.newLine(); cout.newLine(); cout.newLine();
        cout.write("eat shit");
        cout.flush();
        cout.close();

        BufferedReader cin = new BufferedReader(new FileReader(path));
        String str = null;
        while(null != (str=cin.readLine())) {
            System.out.println("[" + str + "]");
        }
        cin.close();
    }
}
