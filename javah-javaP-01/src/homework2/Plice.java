package homework2;

public class Plice extends Person {
    public Plice() { }

    public Plice(String name) {
        super(name);
    }

    @Override
    public void eat(String name) {
        System.out.println("Plice eat : " + name);
    }
}
