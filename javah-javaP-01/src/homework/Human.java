package homework;

public abstract class Human {
    private String name;
    private int age;

    public abstract void eat();

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human() {

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
