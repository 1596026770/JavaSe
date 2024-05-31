package _视频._17Stream.黄埔班考试真题P151.Time;

import java.util.Timer;

public class Start {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimeTask(),0,1000);
    }
}
