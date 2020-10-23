package homework2;

import java.util.Random;

/**
 3. 使用Random 类实现生成不同的 8个  6-26之间的随机数 并存入到数组中
     1.对数组获得元素的大值和最小值 平均值
 */

public class Test3 {
    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
        int arr[] = new int[8];
        for(int i=0; i<8; i++) {
            arr[i] = rand.nextInt((26-6));
            arr[i] += 6;
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        final int INF = 0x7f7f7f7f;
        int tmax = -INF, tmin = INF, sum = 0;
        for(int i=0; i<arr.length; i++) {
            tmax = Math.max(tmax, arr[i]);
            tmin = Math.min(tmin, arr[i]);
            sum += arr[i];
        }

        System.out.println("max:" + tmax + " min:" + tmin + " avg:" + sum*1./arr.length);
    }
}
