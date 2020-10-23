package homework2;

public class Student implements Person {
    @Override
    public void die() {
        System.out.println("die at 40 year");
    }

    @Override
    public void work() {
        System.out.println("study ");
    }
}
