package _14_api._8_time;

import java.util.Calendar;
import java.util.Date;


public class CalendarTest {
    public static void main(String[] args) {
        //日历
        //1.得到系统此刻时间对应的日历对象     抽象类
        Calendar now = Calendar.getInstance();
        System.out.println(now);//所有信息：当前时间的 年月日时分秒 第几天周

        //2.获取日历中的某个信息
        int year = now.get(Calendar.YEAR);
        System.out.println(year);

        //3.拿到日历中记录的日期对象
        Date d = now.getTime();
        System.out.println(d);

        //4.获取时间毫秒值
        long timeInMillis = now.getTimeInMillis();
        System.out.println(timeInMillis);

        //5.修改日历中的某个信息
        //第一个参数为修改信息的类型，第二个为值
        now.set(Calendar.YEAR,2021);
        now.set(Calendar.MONTH,9);//10月 0开始
        System.out.println(now);
        System.out.println(now.get(Calendar.DAY_OF_YEAR));//一年中的第多少天

        //6.为某个信息增加或减少指定的值
        now.add(Calendar.DAY_OF_YEAR,100);
        now.add(Calendar.DAY_OF_YEAR,-10);
//        System.out.println(now.get(Calendar.DAY_OF_YEAR));
        System.out.println(now);

    }
}
