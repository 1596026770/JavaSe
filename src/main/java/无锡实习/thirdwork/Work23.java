package 无锡实习.thirdwork;


public class Work23 implements Runnable {
    public static void main(String[] args) {
        Work23 work1 = new Work23();
//        Work23 work2 = new Work23();
        Thread thread1 = new Thread(work1);
//        Thread thread2 = new Thread(work2);
        thread1.start();
//        thread2.start();
    }

    @Override
    public void run() {
        System.out.println("开始倒计时：");
//        System.out.println(10); // 倒计时初始值为10，然后陷入沉睡
        for(int i = 0;i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //获取当前线程名称
            System.out.println(Thread.currentThread().getName()+" "+(10-i));  //因为i从1开始，每沉睡一次，输出：10-i
        }
        System.out.println("倒计时结束");

    }
}
