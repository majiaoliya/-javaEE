package homework2;

public class Main {
    public static void main(String[] args) {
        Person p[] = new Person[2];
        p[0] = new Student();
        p[1] = new Coder();
        p[0].work();
        p[1].work();
        p[0].die();
        p[1].die();
    }
}
