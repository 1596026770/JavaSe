package _视频._14_api._6_math_runtime_system;

public class MathTest {
    public static void main(String[] args) {
        //Math

        //1.绝对值
        System.out.println(Math.abs(-12));

        //2.向上取整
        System.out.println(Math.ceil(12.5));//13
        System.out.println(Math.ceil(-12.5));//-12

        //3.向下取整
        System.out.println(Math.floor(22.8));//22
        System.out.println(Math.floor(-22.8));//-23

        //4.四舍五入
        System.out.println(Math.round(4.6));

        //5.最大、最小值    两个数
        System.out.println(Math.max(10,21));
        System.out.println(Math.min(10,21));

        //6.m的n次方
        System.out.println(Math.pow(2, 3));

        //7.随机数[0.0 , 1.0)
        System.out.println(Math.random());
    }
}
