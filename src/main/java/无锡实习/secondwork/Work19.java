package 无锡实习.secondwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Work19 {
    public static void main(String[] args) {
        // 创建并启动线程
        MyThread t1 = new MyThread("大象");
        MyThread t2 = new MyThread("兔子");
        MyThread t3 = new MyThread("狮子");
        MyThread t4 = new MyThread("乌龟");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


        // 等待所有线程执行完毕
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static class MyThread extends Thread {
        public static int distance = 10;//领先选手一共跑了多少米
        public static int n = 1;//名次
        private String name;  //线程名字
        private static final Object lock = new Object(); // 用于同步的锁对象
        List<String> names = new ArrayList<>();  //存放选手名字

        public MyThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 0; i <= 100; i += 10) {
                synchronized (lock) {
                    if (distance < 100) {
                        try {
                            // 模拟跑步速度，等待随机时间
                            Thread.sleep(new Random().nextInt(3) * 1000);
                            // 更新领先选手的距离
                            distance = i + 10;
                            // 播报领先选手
                            System.out.println(name + "跑了" + distance + "米，暂时领先");
                        } catch (Exception e) {//InterruptedException
                            e.printStackTrace();
                        }
                    } else {
                        // 检查当前线程是否已在前三名中
                        if (n <= 3 && !names.contains(name)) {
                            try {
                                // 模拟到达终点的时间差
                                Thread.sleep(1000);
                                names.add(name);
                                System.out.println(name + "跑完了100米，取得第" + n + "名");
                                n++;
                            } catch (Exception e) {//InterruptedException
                                e.printStackTrace();
                            }
                        }
                        break; // 跑出循环
                    }

                }

            }
        }
    }

}
