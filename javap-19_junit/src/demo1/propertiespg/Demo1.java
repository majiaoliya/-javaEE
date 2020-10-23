package demo1.propertiespg;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

public class Demo1 {

    @Before
    public void before() {
        System.out.println("show me before");
    }

    @Test
    public void func() {
        System.out.println(" test");
    }
    @Before
    public void before2() {
        System.out.println("show me before2");
    }

    @Test
    public void class_test() throws ClassNotFoundException {
        Node no = new Node(999, 777);
        Class<Node> cls = (Class<Node>) no.getClass(),
                    cls2 = Node.class;
        Class<?> cls3 = Class.forName("demo1.propertiespg.Node");
        System.out.println(cls == cls2);
        URL url = cls3.getResource("");//返回字节码路径
        URL model_path = cls3.getResource("/"); //返回当前模块路径
        System.out.println(url);
    }

    //反射获取构造方法
    @Test
    public void getConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Node> nodeClass = Node.class;
        Constructor<Node> constructor = nodeClass.getConstructor(int.class, int.class);
        constructor.setAccessible(true); //暴力反射，可使用private构造函数

        Node node = constructor.newInstance(789, 987);
        System.out.printf("%d %d\n", node.lef, node.rig);
        
        //获得一组被public修饰的构造方法
        Constructor<?>[] constructors = nodeClass.getConstructors();

        //获得所有构造方法
        Constructor<?>[] declaredConstructors = nodeClass.getDeclaredConstructors();


        //获得私有方法
        Method setLef = nodeClass.getDeclaredMethod("setLef", int.class);
        System.out.printf("setLef私有: %s\n", setLef.toString());
        setLef.invoke(node, 0x3f3f3f3f);
        System.out.printf("lef : %d\n", node.lef);
    }
    
    //反射获得字段
    @Test
    public void getFieldTest() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Node> nodeClass = Node.class;
        Field shit = nodeClass.getDeclaredField("shit");
        shit.setAccessible(true);
        Constructor<Node> declaredConstructor = nodeClass.getDeclaredConstructor(int.class, int.class);
        declaredConstructor.setAccessible(true);
        Node node = declaredConstructor.newInstance(0x3f3f3f3f, 0x7f7f7f7f);
        shit.set(node, 0x3f3f3f3f);
        System.out.println(node.getShit());
    }


    //练习properties类
    @Test
    public void propertiesTest() {
        Properties pro = new Properties();
        String key = "name", val = "tom";
        pro.setProperty(key, val);
        System.out.println(pro);
    }

    //把对象存储到文件
    @Test
    public void storeTest() throws IOException {
        Properties pro = new Properties();
        String key = "name", val = "tom";
        pro.setProperty(key, val);
        File file = new File("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javap-19_junit\\src\\demo1\\propertiespg\\db.properties");
        FileOutputStream out = null;
        pro.store((out=new FileOutputStream(file)), "this is my pro");
        out.close();
        System.out.println(pro);
    }
}

class Node {
    int lef, rig;
    private int shit;

    public int getLef() {
        return lef;
    }

    public void setLef(int lef) {
        this.lef = lef;
    }

    public int getRig() {
        return rig;
    }

    public void setRig(int rig) {
        this.rig = rig;
    }

    public Node() {
        System.out.println("node 无参构造");
    }

    public int getShit() {
        return shit;
    }

    public Node(int lef, int rig) {
        this.lef = lef;
        this.rig = rig;
    }
}