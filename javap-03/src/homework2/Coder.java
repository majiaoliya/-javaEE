package homework2;

public class Coder implements Person {

    @Override
    public void die() {
        System.out.println("die at 35");
    }

    @Override
    public void work() {
        System.out.println("work 10 years");
    }
}
