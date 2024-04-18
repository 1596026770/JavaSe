package _无锡实习.secondwork;

import java.util.Calendar;
import java.util.Scanner;

public class Work13 {
    /**
     * 日历
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请输入一个年份：");
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
//        获取当前时间，并设置对应年份
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);

        for (int i = 0; i < 12; i++) {
            //设置月份
            calendar.set(Calendar.MONTH,i);
            calendar.set(Calendar.DATE,1);
            System.out.println(year+"年"+(i+1)+"月");
            System.out.println("星期日 星期一 星期二 星期三 星期四 星期五 星期六");
            //获取1号属于星期几start和当月最大日期maxDay
            int startWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int maxDay = calendar.getActualMaximum(Calendar.DATE);  //获得当前月的最大日期数
//            输出每月日期，在输出时，要考虑周1到周日为一行，每到周一需要换行显示，先看看1号属于周几，如1号为周三，则周一周二为空格显示：
            //输出空格
            for(int j = 1;j < startWeek;j++){
                System.out.print("\t");
            }
            for(int j = 1;j <= maxDay;j++){
                System.out.print(j+"\t"); 	   //输出日期数字
                if((startWeek + j - 1) % 7 == 0){   //判断是否换行
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
