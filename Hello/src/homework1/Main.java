package homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("input x : ");
        if(false) {
            int num = cin.nextInt();
            sec(num);
            String name = cin.next();
        }
        for_test1();
    }

    public static void for_test1() {
        if(false) {
            int i;
            for(i=1; i<=5; i++) System.out.println(i);
            for(i=5; i>=1; i--) System.out.println(i);
        } else if(true) {
            int i = 0, ans = 0;
            if(true) {
                for( ; i<=100; i+=2) ans += i;
            } else if(true) {
                for( ; i<=100; i++)
                    ans += ((i&1)==0) ? i : 0;
            }
        } else if(true) {

        }
    }

    public static void sec(int x) {
        if(x < 0 || x > 100) {
            System.out.println("error");
            return ;
        }
        x /= 10;
        switch(x) {
            case 9 :
                System.out.println("优秀");
                break;
            case 10 :
                System.out.println("优秀");
                break;
            case 8 :
                System.out.println("好");
                break;
            case 7 :
                System.out.println("良好");
                break;
            case 6 :
                System.out.println("及格");
                break;
            default :
                System.out.println("不及格");
                break;
        }
    }

    public static void three(int x) {
        x /= 3;

    }

    public static void fst(int x) {
        switch(x) {
            case 1 :
                System.out.println("星期一");
                break;
            case 2 :
                System.out.println("星期而");
                break;
            case 3 :
                System.out.println("星期三");
                break;
            case 4 :
                System.out.println("星期四");
                break;
            case 5 :
                System.out.println("星期伍");
                break;
            case 6 :
                System.out.println("星期刘");
                break;
            case 0 :
                System.out.println("星期日");
                break;
            default:
                System.out.println("error");
        }
    }
}
