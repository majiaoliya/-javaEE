package demo3解析注解;

import org.junit.Test;

import java.lang.reflect.Method;
import java.net.URL;

public class Demo {
    @Test
    @MyClass(className = "String", methonName = "toString")
    public void init() throws NoSuchMethodException {
        Class<Demo> demoClass = Demo.class;
        Method init = demoClass.getDeclaredMethod("init");
        System.out.println(init);
        MyClass annotation = init.getAnnotation(MyClass.class);
        System.out.println(annotation.className());
        System.out.println(annotation.methonName());
        URL resource = demoClass.getResource("");
        System.out.printf("url:%s\n", resource);
    }
}
