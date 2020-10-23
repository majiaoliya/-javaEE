package homework;

public class StudentSmok extends Student implements Smoke {

    @Override
    public void smoking() {
        System.out.println(this.getName() + "抽烟");
    }
}
