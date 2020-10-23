package homework1;

public class Child extends Fa {

    public void play() {
        System.out.println("play and die");
    }

    public Child() {
    }

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(String str) {
        System.out.println("eat and die");
    }
}
