package homework2;

import com.sun.javafx.iio.ios.IosDescriptor;

import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

/**
 4. 定义一个数组  静态初始化
     1.使用Scanner 类 提示输入一个数  插入到数组的第一位
     2.使用Scanner 类 提示输入一个数  插入到数组的最后
     3.使用Scanner 类 提示输入一个数  插入到数组第3个位置(可选)
 */

public class Test4 {
    public static final int MAXN = (int)2e5+7;
    public static int lef = (int)1e5+7, rig = (int)1e5+6;
    public static int arr[] = new int[MAXN];

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\majiao\\Desktop\\test.txt");
        System.setIn(fis);
        /**
         测试数据
         1 1
         2 2
         1 2
         2 1
         4 7
         -1
         */
        Scanner cin = new Scanner(System.in);
        int cmd, x, cas = 0;
        while(~(cmd = cin.nextInt()) != 0) {
            if(cmd == 1) {
                x = cin.nextInt();
                push_front(x);
            } else if(cmd == 2) {
                x = cin.nextInt();
                push_back(x);
            } else {
                x = cin.nextInt();
                int fst, sec;
                if(rig - lef + 1 <= 2)
                    push_back(x);
                else {
                    fst = pop_front();
                    sec = pop_front();
                    push_front(x);
                    push_front(fst);
                    push_front(sec);
                }
            }
            System.out.print((++cas) + " th: ");
            for(int i=lef; i<=rig; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void push_back(int x) {
        arr[++rig] = x;
    }

    public static void push_front(int x) {
        arr[--lef] = x;
    }

    public static int pop_front() {
        return arr[lef++];
    }
}
