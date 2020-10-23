package homework;

public class Student extends Human {

    @Override
    public void eat() {
        System.out.println(this.getName() + " eat 肉");
    }
}
