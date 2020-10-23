package homework1;

public abstract class Fa {

    protected String name;
    protected int age;

    public Fa() { }

    @Override
    public String toString() {
        return "Fa{" +
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

    public Fa(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat(String str);
}
