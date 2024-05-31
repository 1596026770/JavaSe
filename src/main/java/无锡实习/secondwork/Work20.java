package 无锡实习.secondwork;

public class Work20 {
    public static void main(String[] args) {
        // 创建四个售票窗口的线程
        TicketThread t1 = new TicketThread("窗口1");
        TicketThread t2 = new TicketThread("窗口2");
        TicketThread t3 = new TicketThread("窗口3");
        TicketThread t4 = new TicketThread("窗口4");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    public static class TicketThread extends Thread {
        private String name;
        private static int ticket = 10;
        // 使用静态变量作为锁
        private static final Object lock = new Object();

        public TicketThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (ticket > 0) {
                        // 售票
                        System.out.println(name + "卖出了第" + ticket + "张票");
                        ticket--;
                    } else {
                        // 票已售完
                        System.out.println(name + "：票已售完");
                        break; // 跳出循环
                    }
                }

                // 线程休眠1秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
