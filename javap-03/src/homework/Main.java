package homework;

public class Main {
    public static void main(String[] args) {
        Swim sw[] = new Swim[2];
        sw[0] = new TinyStudent();
        sw[1] = new MidStudent();
        getSwim(sw[0]);
        getSwim(sw[1]);
        System.out.println("-----------");

        sw[0] = new Swim() {
            @Override
            public void swimming() {
                System.out.println();
            }
        };

    }

    private static void getSwim(Swim swim) {
        swim.swimming();
    }
}
