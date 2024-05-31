package _视频._14_api._8_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 案例 {

    public static void main(String[] args) throws ParseException {
        //完成秒杀案例

        //1.把开始时间，结束时间，小贾下单时间，小皮下单时间拿到
        String start = "2023年11月11日 0:0:0";
        String end = "2023年11月11日 0:10:0";
        String xj = "2023年11月11日 0:01:08";
        String xp = "2023年11月11日 0:10:57";

        //2.创建简单日期格式化对象，指定时间的格式必须与被解析的时间格式一致
        //解析为日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date startDt = sdf.parse(start);
        Date endDt = sdf.parse(end);
        Date xjDt = sdf.parse(xj);
        Date xpDt = sdf.parse(xp);
        System.out.println(startDt);


        //3.判断小皮、小贾是否秒杀成功
        //把日期对象转为时间毫秒值
        long startDtTime = startDt.getTime();
        long endDtTime = endDt.getTime();
        long xjDtTime = xjDt.getTime();
        long xpDtTime = xpDt.getTime();
        System.out.println(startDtTime);
        System.out.println(endDtTime);

//        if (miaosha(xjDtTime)) {
//            System.out.println("小贾秒杀成功");
//        }else {
//            System.out.println("小贾秒杀失败");
//        }
//
//        if (miaosha(xpDtTime)) {
//            System.out.println("小皮秒杀成功");
//        }else {
//            System.out.println("小皮秒杀失败");
//        }
        if(xjDtTime >=  startDtTime && xjDtTime <= endDtTime) {
            System.out.println("小贾秒杀成功");
        }else {
            System.out.println("小贾秒杀失败");
        }

        if(xpDtTime >=  startDtTime && xpDtTime <= endDtTime) {
            System.out.println("小皮秒杀成功");
        }else {
            System.out.println("小皮秒杀失败");
        }


    }

    public  static boolean miaosha(long time){
        long startDtTime = 1699632000000L;
        long endDtTime = 1699632600000L;
        if(time >=  startDtTime && time <= endDtTime) {
//            System.out.println("秒杀成功");
            return true;
        }else {
//            System.out.println("秒杀失败");
            return false;
        }
    }



}

