package homework2;

import java.util.Scanner;

/**
 2.实现    查找数组中是否有对应的元素
     1. 使用Scanner输入一个的数字
     2. 数组可以使用静态初始化
     3. 在数组中查找元素  如果有就返回对应的位置 没有就提示没有找到
 */

public class Test2 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Scanner cin = new Scanner(System.in);
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == cin.nextInt()) {
                System.out.println(i);
                return ;
            }
        }
        System.out.println("have not ");
    }
}
