import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date_str = sdf.format(d);
        System.out.println(date_str);

        d.setTime(100000);
        String time = "1988年9月07日 10时41分12秒";
        sdf = sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        d = sdf.parse(time);
        System.out.println(d);


        Calendar c = Calendar.getInstance();
        d = c.getTime();
        System.out.println(d);
//        c.setTime(d);
//        int pint = c.get(19987428);
        c.add(c.DAY_OF_YEAR, -1);
        System.out.println(c);
    }
}
