package _14_api._7_bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        //掌握BigDecimal,解决小数运算失真的问题
        double a = 0.1;
        double b = 0.3;
        double c = a + b;
        System.out.println(c);
        System.out.println("------------------");


        //1.把他们变成字符串封装成BigDecimal对象来运算
//        BigDecimal a1 = new BigDecimal(Double.toString(a));
//        BigDecimal b1 = new BigDecimal(Double.toString(b));
        //推荐使用以下方式，把小数转为字符串再得到BigDecimal对象来使用
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);

        BigDecimal c1 = a1.add(b1);//+
        System.out.println(c1);
        BigDecimal c2 = a1.subtract(b1);//-
        System.out.println(c2);
        BigDecimal c3 = a1.multiply(b1);//*
        System.out.println(c3);
//        BigDecimal c4 = a1.divide(b1);// /
//        System.out.println(c4);

        //1/3不能精确
        BigDecimal c5 = a1.divide(b1,2,BigDecimal.ROUND_HALF_UP);//a1/b1 保留两位 四舍五入
        System.out.println(c5);

        //转回double类型
        double c6 = c5.doubleValue();
        System.out.println(c6);

    }
}
