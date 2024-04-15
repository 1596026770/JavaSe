package _2_1_案例;
import static java.lang.Math.*;
public class Test7_2 {
    public static void main(String[] args) {
    prime_num(101,200);
    }

    public static int prime_num(int start,int stop){
        int sum = 0;
        for (int i = start; i <= stop; i++) {
            if (prime(i)) {
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }
    public static boolean prime(int number){
        if(number<2)
            return false;
        else {
//        注意加==sqrt()的值
            for (int i = 2; i <= sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            System.out.println(number + "是素数");
            return true;
        }
    }
}
