package FileIO;

import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter out = null;
        try {
//            FileWriter out = new FileWriter("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-09\\src\\FileIO\\test");
            out = new FileWriter("C:\\Users\\majiao\\Desktop\\test");
//            out.write(97);
//            out.write(1000);
//            out.flush();
//            out.close();
            ArrayList<FileWriterDemo.Student> list = new ArrayList<Student>();
            for(int i=0; i<4; i++) {
                FileWriterDemo.Student stu = new FileWriterDemo.Student();
                stu.name = i + "张";
                stu.age = i + "";
                stu.addr = i + "addr";
                list.add(stu);
                out.write("{"+stu.name + "," + stu.age + "," + stu.addr + "}");
                out.write("\n");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            out.close();
        }
    }

    static class Student {
        String name, age, addr;
        public Student() { }
    }
}
