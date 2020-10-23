package homework;


public class TeacherSmok extends Teacher implements Smoke {
    @Override
    public void eat() {
        System.out.println(this.getName() + "eat shit");
    }

    @Override
    public void smoking() {
        System.out.println(this.getName() + " 抽烟");
    }
}
