package _视频._17Stream.黄埔班考试真题P151;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class JavaTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.找出从开始日期到目标日期的全部日期
        //2022-2-3为休息日
        //上2休1
        LocalDate startDate = LocalDate.of(2022,2,3);

        System.out.println("请输入查询年份-月份(必须为2022年2月之后的月份)");
        //2023-5
        String currentDate = scanner.nextLine() + "-01";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(currentDate);

        //2.拿到该月份的最后一天
        //月份+1 日期-1
        endDate = endDate.plusMonths(1).minusDays(1);
//        System.out.println(endDate);

        //3.从起始日子一直拿到截至日期的全部日期，方便标记哪些休息
        List<Day> days = new ArrayList<>();
        ChronoUnit.DAYS.between(startDate,endDate);//两个日期相差天数

        for (int i = 1; i <= endDate.getDayOfMonth(); i++) {
            String day = "";
            if (i < 10) {
                day = "" + 0 + i;
            } else {
                day = "" + i;
            }
            String s = currentDate.split("-")[0] + "-" + currentDate.split("-")[1] + "-" + day;
            LocalDate now = LocalDate.parse(s);

            long mod = ChronoUnit.DAYS.between(startDate, now);//两个日期相差天数

            LocalDateTime dateTime = LocalDateTime.now();

            LocalDateTime with = dateTime.withYear(now.getYear()).withMonth(now.getMonthValue()).withDayOfMonth(now.getDayOfMonth());

//            System.out.println(with);
            DayOfWeek dayOfWeek = with.getDayOfWeek();
            int value = dayOfWeek.getValue();


            if (value == 6 || value == 7) {
                if (mod % 3 == 0) {
                    System.out.println(now + "(休息&星期"+value+")" + "\t");

                } else {
                System.out.print(now + "(星期"+value+")"+"\t");
//                    System.out.print(now + "\t");
                }
            }else {
                if (mod % 3 == 0) {
                    System.out.println(now + "休息" + "\t");

                } else {
//                System.out.print(now + "(星期"+value+")"+"\t");
                    System.out.print(now + "\t");
                }
            }
        }



        //输出该月份休息的日期

    }
class Day{
        private LocalDate date;
        private boolean flag;//是否休息

    public Day() {
    }

    public Day(LocalDate date, boolean flag) {
        this.date = date;
        this.flag = flag;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
}
