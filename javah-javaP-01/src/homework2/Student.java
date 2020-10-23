package homework2;

public class Student extends Person {
    public Student() { }

    public Student(String name) {
        super(name);
    }

    @Override
    public void eat(String name) {
        System.out.println("student eat : " + name);
    }
}
