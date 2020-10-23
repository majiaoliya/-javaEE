package 练习;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 , 8 };
        if(false) {
            reverse(arr);
            for(int i=0; i<arr.length; i++)
                System.out.print(arr[i] + ", ");
        }
        System.out.println(fib(99999));
//        System.out.println(fib());
    }

    public static int mymax(int x, int y) {
        return (x > y ? x : y);
    }

    public static boolean check(int x) {
      int tmp = x, sum = 0;
      while(tmp > 0) {
            int p = tmp % 10;
            sum += p * p * p;
            tmp /= 10;
        }
        return sum == x;
    }

    public static void update_arr(int arr[]) {
        for(int i=0; i<arr.length; i++)
            arr[i] = i;
    }
    
    public static void reverse(int arr[]) {
        int lef = 0, rig = arr.length - 1;
        for( ; lef < rig; lef ++, rig --)
            swap(arr, lef, rig);
    }

    public static void swap(int arr[], int lef, int rig) {
        arr[lef] ^= arr[rig];
        arr[rig] ^= arr[lef];
        arr[lef] ^= arr[rig];
    }

    public static BigInteger fib(int n) {
        BigInteger lst = new BigInteger("1"), llst = new BigInteger("1");
        BigInteger now = new BigInteger("0");
        if(n == 1 || n == 2) return lst;
        for(int i=3; i<=n; i++) {
            now = lst.add(llst);
            llst = lst;
            lst = now;
        }
        return now;
    }
}
