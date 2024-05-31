package _视频._1_数组;
import org.junit.Test;

import static java.lang.Math.pow;

public class XunHuan {


    @Test
    public void test流程(){
//      switch 注意事项
//        1.表达式类型只能是byte short int char jdk5开始支持枚举，jdk7开始支持string，不支持double float long
//        2.case给出的值不允许重复，且不能是变量
//        3.正常使用switch时，不能忘记写break，否则会出现穿透现象
        int a = 10;
        double b = 0.1;
        double c = 0.2;
        double d = b+c;
        System.out.println(d);
        switch (a%4){
            case 0:
            System.out.println("echo0");
            break;
            case 1:
            System.out.println("echo1");
            break;
            case 2:
            System.out.println("echo2");
            break;
            case 3:
            System.out.println("echo3");
            break;
            default:
                System.out.println("好好好");
        }


//        利用switch穿透
        String week = "周四";
        switch (week){
            case "周一":
                System.out.println("啦啦啦");
                break;
            case "周二":
            case "周三":
            case "周四":
            case "周五":
                System.out.println("可爱呢");
                break;
            case "周六":
            case "周七":
                System.out.println("打游戏");
                break;
            default:
                System.out.println("输入星期有误！");
        }

    }


    @Test
    public void test循环(){
        for (int i = 0; i < 5; i++) {
            System.out.println("hello world");
        }
        int i = 0;
        while (i<5){
            System.out.println(i);
            i++;
        }

        //珠穆朗玛峰0进 1出 sum=0.2
        //珠穆朗玛峰1进 2出 sum=0.4
        int n = 0;//纸张折叠次数
        double sum = 0.1;//纸张折叠后厚度毫米
        while (sum<8848860){
//            sum = sum * 2;
            sum = 0.1*pow(2,n+1);
            n++;
        }
        System.out.println(n);
        System.out.println("最终纸张厚度为：" + sum);
    }




















}
