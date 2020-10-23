import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class dataPg {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date_str = sdf.format(date);
        System.out.println(date_str);

        date = sdf.parse("2020-08-20 10:15:11");
        System.out.println(date);
        Object obj;
        Properties pro = System.getProperties();
        System.out.println(pro);
        Integer src[] = { 0, 1, 2, 3, 4, 5, 6, 7 };
        Integer des[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
//        System.arraycopy(src, 0, des, 0, 8);
        copy_arr(src, 3, des, 3, 3);
//        src[3] = 5;
        for(int i=0; i<des.length; i++)
            System.out.printf("%d ", src[i]);
        System.out.println();
        for(int i=0; i<des.length; i++)
            System.out.printf("%d ", des[i]);
    }

    public static<T> void copy_arr(T[] src, int src_pos,
                                     T[] dst, int dst_pos, int len) {
        src_pos += (len - 1);
        dst_pos += (len - 1);
        for( ; len-- > 0; src_pos--, dst_pos--)
            dst[dst_pos] = src[src_pos];
    }
}
