package FileReaderDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyMain {
    public static void main(String[] args) throws IOException {
        String path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\FileReaderDemo\\FileCopyMain.java";
        String out_path = path + "_out", in_path = path;
        FileWriter cout = new FileWriter(out_path, false);
        FileReader cin = new FileReader(in_path);

        char buf[] = new char[1024];
        int cnt = -1;
        while(-1 != (cnt=cin.read(buf)))
            cout.write(buf, 0, cnt);

        cout.close();
        cin.close();
    }
}