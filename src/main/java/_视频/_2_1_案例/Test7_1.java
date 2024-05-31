package _视频._2_1_案例;

import static java.lang.Math.sqrt;

public class Test7_1 {

    public static void main(String[] args) {
        System.out.println(prime(101, 200));
    }

    public static int prime(int start,int stop){
        int sum = 0;

        OUT://设置外部循环终止标签
        for (int i = start; i <= stop; i++) {
            for (int j = 2; j <= sqrt(i); j++) {
                //                判断是否是素数
                if(i%j==0){
                    //                    不是素数
                    continue OUT;//终止外部循环
                }
            }

            System.out.println(i + "是素数");
            sum++;

        }
        return sum;
    }
}
