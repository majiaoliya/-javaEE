package test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class TestCode {
    @Test
    public void testPath() throws IOException {
        Path path = Paths.get("D:/ubuntu/majiao_path.jpg");
        FileInputStream fis = new FileInputStream("C:\\Users\\majiao\\Desktop\\timg.jpg");
        System.out.printf("path:[%s]\n", path);
        System.out.printf("fa  :[%s]\n", path.getParent());
        Files.copy(fis, path);
    }
}
