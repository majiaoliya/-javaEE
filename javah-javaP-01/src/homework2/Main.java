package homework2;

public class Main {
    public static void main(String[] args) {
        Person p[] = new Person[4];
        p[0] = new Student("张");
        p[1] = new Worker("张");
        p[2] = new Teacher("张");
        p[3] = new Plice("张");
        for(int i=0; i<4; i++)
            p[i].eat("狗屎");
    }
}
