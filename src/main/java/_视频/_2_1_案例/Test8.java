package _视频._2_1_案例;
import org.junit.Test;

public class Test8 {
    public static void main(String[] args) {
//        乘法表、下三角
        chengfa();
    }
    public static void chengfa(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                if(j!=i){
                    System.out.print(i + "x" + j + "=" + i*j + "\t");
                }else {
                    System.out.println(i + "x" + j + "=" + i*j );
                }
            }
        }
    }

    @Test
    public void test(){

        /*
                输出     num      行号n     空格数
                *       1          1        3            num = 2n-1
               ***      3          2        2             空格数=4-行号n
              *****     5          3        1
             *******    7          4        0
        * */
        int n=5;//行号
        for (int i = 1; i <= n; i++) {
//            控制空格数
            for (int j = 1; j <= n- i; j++) {
                System.out.print(" ");
            }
//            控制星星数
            for (int j = 1; j <= 2*i-1; j++) {

                System.out.print(j % 2 == 0?" ":"*");
            }
            System.out.println();
        }

    }

}
