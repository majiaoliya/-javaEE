package FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("C:\\Users\\majiao\\Desktop\\test");
//        System.setIn(fis);
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int x, cnt = 0, p = 0;
            while(n-- > 0) {
                x = scan.nextInt();
                cnt = 0;
                if(p ++ > 0) System.out.print(" ");
                if(1 == (x&1)) {
                    System.out.print(x);
                    continue;
                } else {
                    int tmp = x;
                    while(tmp > 0) {
                        cnt ++;
                        tmp >>>= 1;
                    }
                    if(cnt == 1) {
                        System.out.print(x);
                        continue;
                    }
                    int id = cnt - 1, ans = 0;
                    for(int i=0; i<cnt; i++, id--) {
                        if(1 == (x>>>i&1)) {
                            ans |= (1 << id);
                        }
                    }
                    System.out.print(ans);
                }
            }
            System.out.println();
        }
    }
}
