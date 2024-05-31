package 无锡实习.thirdwork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Work21 {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("请输入开始日期：（格式为:yyyy-MM-dd HH:mm:ss）");
        String start = scan.nextLine();
        System.out.println("请输入结束日期：（格式为:yyyy-MM-dd HH:mm:ss）");
        String end = scan.nextLine();

        Date date1 = format.parse(start);
        Date date2 = format.parse(end);
        long time = date2.getTime() - date1.getTime();
        long day = time / (24*60*60*1000);//转天
        System.out.println(Math.abs(day));

    }
}
