package _14_api._9_jdk8_time;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        //传统时间类（Date SimpleDateFormat Calendar）存在如下问题：
        //1.设计不合理 使用不方便被淘汰
        Date d = new Date();
        System.out.println(d.getYear() + 1900);

        //2.都是可变对象，修改后会丢失最开始的时间信息

        //3.线程不安全

        //4.不能精确到纳秒，只能精确到毫秒
        //秒 毫秒 微妙 纳秒 10^3















    }
}
