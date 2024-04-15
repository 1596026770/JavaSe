package _14_api._6_math_runtime_system;

public class SystemTest {
    public static void main(String[] args) {
        //1.终止当前运行的java虚拟机
        //该参数用作状态码，非零表示异常终止
//        System.exit(0);

        //2.currentTimeMillis()
        //获取当前系统时间，返回值为long类型，从1970-1-1 0:0:0开始到现在的毫秒值
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        for (int i = 1; i <= 100000; i++) {
            System.out.println("输入次数："+ i);
        }

        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime-startTime)/1000.0 +"s");
    }
}
