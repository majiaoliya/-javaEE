package homework2;

public class Teacher extends Person {
    public Teacher() { }

    public Teacher(String name) {
        super(name);
    }

    @Override
    public void eat(String name) {
        System.out.println("teacher eat : " + name);
    }
}
