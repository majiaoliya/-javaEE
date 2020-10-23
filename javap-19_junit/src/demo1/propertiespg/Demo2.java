package demo1.propertiespg;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

public class Demo2 {
    @Test
    public void infoTest() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Properties pro = new Properties();
        FileInputStream in = new FileInputStream("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javap-19_junit\\src\\demo1\\propertiespg\\info.properties");

        pro.load(in);
        Class<?> className = Class.forName((String) pro.get("className"));
        Object o = className.newInstance();
        Field[] fields = className.getDeclaredFields();
        for(Field f : fields) {
            String val = pro.getProperty(f.getName());
            f.setAccessible(true);
            f.set(o, val);
        }
        System.out.println(o);
    }
}
class Dog {
    String name, age, color;

    public Dog() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Dog(String name, String age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}


class Person {
    private String name;
    private String gender;
    private String age;
    public Person() {
        super();
    }
    public Person(String name, String gender, int age) {
        super();
        this.name = name;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
    }
}