package homework2;

import java.util.Scanner;

/**
 1.实现一个冒泡排序算法
     1 使用Scanner 输入数组大小
     2.初始化数组  赋值为  23-45之间的随机数
     3.对数组进行排序(冒泡排序) 并输出排序后数组元素
 */

public class Test1 {

    public static void main(String[] args) {
        int n = 0, arr[];
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        arr = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = cin.nextInt();
        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if(false) { //冒泡
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=(n-i); j++) {
                    if(arr[j] > arr[j+1])
                        swap(arr, j, j+1);
                }
            }
        }
        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
