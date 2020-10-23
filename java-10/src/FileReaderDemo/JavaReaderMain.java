package FileReaderDemo;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaReaderMain {
    public static void main(String[] args) throws IOException {
        String path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\FileReaderDemo\\test";
        FileWriter cout = new FileWriter(path, false);
        int p = (int)1e9+7;
        cout.write("汉字");
        cout.close();
        FileReader cin = new FileReader(path);
        int ret = -1;
        while((ret=cin.read()) != -1)
            System.out.println((char)ret);
        cin.close();
    }
}
