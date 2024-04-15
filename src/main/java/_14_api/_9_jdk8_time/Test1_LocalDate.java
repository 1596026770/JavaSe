package _14_api._9_jdk8_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Test1_LocalDate {
    public static void main(String[] args) {

        //0.获取本地时间对象
        LocalDate ld  = LocalDate.now();//年月日
        System.out.println(ld);

        //1.获取日期对象信息
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        int dayOfWeek = ld.getDayOfWeek().getValue();
        int dayOfYear = ld.getDayOfYear();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dayOfWeek);
        System.out.println("hello git");
        System.out.println("master test");
        System.out.println("hot-fix test");
        System.out.println("pull test");

    }
}
