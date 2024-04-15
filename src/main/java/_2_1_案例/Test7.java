package _2_1_案例;

import static java.lang.Math.*;

public class Test7 {
    public static void main(String[] args) {
//        找素数判断101-200之间有多少个素数，并输出素数个数
        System.out.println(prime(101, 200));
    }
    public static int prime(int start,int stop){
        int sum = 0;

        for (int i = start; i <= stop; i++) {
            boolean flag = true;
                for (int j = 2; j <= sqrt(i); j++) {
    //                判断是否是素数
                    if(i%j==0){
    //                    不是素数
                        flag = false;
                        break;
                    }
                }
            if (flag==true) {
                System.out.println(i + "是素数");
                sum++;
            }

        }
        return sum;
    }
}
