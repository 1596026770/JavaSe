package _视频._17Stream.黄埔班考试真题P151.Time;




import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
    //高考开始时间
    private LocalDateTime startTime;

    public TimeTask(){
        String s = "2024-06-07 09:00:00";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        startTime = LocalDateTime.parse(s, dtf);
//        System.out.println(startTime);


    }
    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, startTime);
        long day = duration.toDays();
        long hour = duration.toHours() - day * 24;
        long min = duration.toMinutes() - day * 24 *60 - hour * 60;
        long seconds = duration.getSeconds() - day * 24 *60 *60 - hour * 60 *60 - min * 60 ;

//        System.out.println("现在时间是:" +now);

        System.out.println(startTime.getYear() + "年高考倒计时");
        System.out.println(startTime.getYear() + "年高考时间: " + startTime.getYear() + "年" + startTime.getMonthValue() + "月" +
                startTime.getDayOfMonth() + "日"+ "\t" +startTime.getDayOfWeek());
        System.out.println("现在距" + startTime.getYear() + "年高考还有");
        System.out.println(day + " 天" + hour + " 时" + min + " 分" + seconds + " 秒");
    }
}
