package homework1;

public class Test4 {

    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        Test4.method1();
        Test4.method2();
    }

    public static void method1() {
        int a = -5;
        int b = -- a, c = 30;
        System.out.println("method1 : " + a + " " + b);
    }

    public static void method2() {
        int a = 0;
        while(a <= 5) {
            for(int b=1; b<=5; b++)
                System.out.print(b + " ");
            a ++;
            System.out.println();
        }
    }

}
