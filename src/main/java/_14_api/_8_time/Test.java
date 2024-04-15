package _14_api._8_time;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        //2.拿到时间毫秒值
        long time = d.getTime();
        System.out.println(time);

        //3.把时间毫秒值转为日期对象    2s后的时间是多少
        time += 2 *1000;
        Date d2 = new Date(time);
        System.out.println(d2);

        //4.日期对象的时间用setTime修改
        Date d3 = new Date();
        d3.setTime(time);
        System.out.println(d3);
    }
}
