package homework2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 5.  定义一个数组  静态初始化
     1.使用Scanner 类 提示输入一个数的索引,实现删除这个数字  并输出删除后的数组
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\majiao\\Desktop\\test.txt");
//        System.setIn(fis);

        int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7 };
        int sz = 8;
        Scanner cin = new Scanner(System.in);
        if(false) { //模拟移动
            int idx = cin.nextInt();
            if(idx >= 0 && idx <= arr.length) {
                int pos = idx + 1;
                for( ; pos<sz; pos++) arr[pos-1] = arr[pos];
            }
            sz --;
            for(int i=0; i<sz; i++)
                System.out.print(arr[i] + " ");
        } else { //标记访问
            boolean vis[] = new boolean[sz];
            int idx = cin.nextInt();
            if(idx >= 0 && idx <= sz) vis[idx] = true;
            for(int i=0; i<sz; i++)
                if(!vis[i]) System.out.print(arr[i] + " ");
        }
    }
}
