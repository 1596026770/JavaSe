package _视频._14_api._6_math_runtime_system;

import java.io.IOException;

public class RunTime {
    public static void main(String[] args) throws IOException, InterruptedException {
        //RunTime
        //系统运行时间，单例
        //1.返回与当前java应用程序关联的运行时对象
        Runtime r = Runtime.getRuntime();

        //2.终止当前运行的java虚拟机 该参数用作状态码，非零表示异常终止
//        r.exit(0);

        //3.获取虚拟机能够使用的处理器数
        System.out.println(r.availableProcessors());

        //4.返回java虚拟机中内存总量
        System.out.println(r.totalMemory()/1024.0/1024.0 +"MB");

        //5.返回java虚拟机中可用内存
        System.out.println(r.freeMemory()/1024.0/1024.0 + "MB");

        //6.启动某个程序，并返回代表该程序的对象 返回一个Process对象
        Process p = r.exec("D:\\LearnApp\\Snipaste\\Snipaste.exe");
        Thread.sleep(5000);
        p.destroy();

    }
}
