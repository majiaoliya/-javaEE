package ListWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\ListWriter\\test";
        List<String> list = new ArrayList<>();
        for(int i=0; i<4; i++) list.add("str" + i);
        writeToFile(list, path);
        list = readFromFile(path);
        for(String str : list)
            System.out.println('[' + str + "]");
    }

    public static void writeToFile(List<String> list, String path) {
        BufferedWriter cout = null;
        try {
            cout = new BufferedWriter(new FileWriter(path));
            for(String str : list) {
                cout.write(str);
                cout.newLine();
            }
            cout.flush();
            cout.close();
        } catch (Exception e) {
            e.printStackTrace();
            if(null != cout) {
                try {
                    cout.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static List<String> readFromFile(String path) {
        List<String> ret = new ArrayList<>();
        BufferedReader cin = null;
        try {
            cin = new BufferedReader(new FileReader(path));
            String str = null;
            while(null != (str=cin.readLine()))
                ret.add(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
