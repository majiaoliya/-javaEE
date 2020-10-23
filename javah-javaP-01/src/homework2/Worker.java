package homework2;

public class Worker extends Person {
    public Worker() { }

    public Worker(String name) {
        super(name);
    }

    @Override
    public void eat(String name) {
        System.out.println("worker eat : " + name);
    }
}
