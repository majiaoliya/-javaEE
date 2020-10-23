package demo4_mytest注解;

import demo1.Anno;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Animal> animalClass = Animal.class;
        Method[] declaredMethods = animalClass.getDeclaredMethods();
        for(Method me : declaredMethods) {
            me.setAccessible(true);
            boolean hav = me.isAnnotationPresent(MyTest.class);
            if(hav) {
                Animal animal = animalClass.newInstance();
                me.invoke(animal);
            }
        }
    }

    @Test
    public void classLoderTest() {
        Class<Animal> animalClass = Animal.class;
        ClassLoader classLoader = animalClass.getClassLoader();
        System.out.println(classLoader.getResource(""));
        //父的父加载器是用c/c++写的
        ClassLoader par_parent = classLoader.getParent().getParent();
        System.out.println(par_parent);
    }
}

class Animal {
    @MyTest
    public void eat() {
        System.out.println("show eat");
    }

    @MyTest
    public void eat2() {
        System.out.println("show 2");
    }

    @MyTest
    public void eat3() {
        System.out.println("show eat3");
    }
}
