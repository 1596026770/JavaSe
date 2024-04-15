package _14_api._8_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        //1.创建日期对象
        Date d = new Date();
        System.out.println(d);

        long time = d.getTime();
        System.out.println(time);
        
        //2.格式化日期对象和时间毫秒值
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        String rs = sdf.format(d);
        String rs1 = sdf.format(time);
        System.out.println(rs);
        System.out.println(rs1);

        System.out.println("----------------");

        //3.把字符串时间解析为日期对象
        String dateStr = "2022-12-12 12:12:12";
        //创建简单日期格式化对象，指定时间的格式必须与被解析的时间格式一致
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf1.parse(dateStr);
        System.out.println(d2);

    }
    
    
    
    
}
