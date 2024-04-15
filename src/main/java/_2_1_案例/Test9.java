package _2_1_案例;

import java.util.Random;
import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        /*
         * 双色球
         * 投注6个红色球（1-33）和一个蓝色球（1-16）
         * 一等奖   6+1（红蓝个数）   1000w
         * 二等奖   6+0（红蓝个数）   500w
         * 三等奖   5+1（红蓝个数）   3000
         * 四等奖   5+0（红蓝个数）   200
         *         4+1（红蓝个数）
         * 五等奖   4+0（红蓝个数）   10
         *         3+1（红蓝个数）
         *         2+1（红蓝个数）
         * 六等奖   1+1（红蓝个数）   5
         *         0+1（红蓝个数）
         *
         * */

        jiangli();
    }

//    用户输入的号码
        public static int[] inputssq(){
            int[] number = new int[7];
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < number.length-1; i++) {
                System.out.println("请输入第" + (i+1) + "个红球的号码：");
                int flag = sc.nextInt();
//                判断输入是否合法，并不重复
                if (flag >= 1 && flag <= 33 && !exist(number, flag)) {
                    number[i] = flag;
                } else {
                    while (true) {
                        System.out.println("你输入的号码有误，请重新输入第" + (i+1) + "个红球的号码：");
                        flag = sc.nextInt();
                        if (flag >= 1 && flag <= 33 && !exist(number, flag)) {
                            number[i] = flag;
                            break;
                        }
                    }
                }
            }
            System.out.println("请输入蓝球的号码：");
            int brue = sc.nextInt();
            if (brue >= 1 && brue <= 16) {
                number[6] = brue;
            } else {
                while (true) {
                    System.out.println("你输入的号码有误，请重新输入蓝球的号码：");
                    brue = sc.nextInt();
                    if (brue >= 1 && brue <= 16) {
                        number[6] = brue;
                        break;
                    }
                }
            }
            System.out.print("用户抽取号码为：");
            for (int i = 0; i <= 6; i++) {
                System.out.print(number[i]+" ");
            }
            return number;
        }

//        判断一个数是否存在于一个数组中
    public static boolean exist(int[] number, int num) {
        for (int i = 0; i < number.length; i++) {
            if(number[i]==0){
                break;
            }
            if(number[i]==num){
                return true;
            }
        }
        return false;
    }

    //        中奖号码
        public static int[] zhongjianghao(){
            Random red = new Random();
            int[] zhongjiaohao = new int[7];
            System.out.print("中奖号码为：");
            for (int i = 0; i < zhongjiaohao.length; i++) {
                while (true) {
                    int num = red.nextInt(33)+1;
                    if (i!=zhongjiaohao.length-1 && !exist(zhongjiaohao, num)) {
                        zhongjiaohao[i] = num;
                        break;
                    }else if(i==zhongjiaohao.length-1){
                        zhongjiaohao[i] = red.nextInt(16)+1;
                        break;
                    }
                }
                System.out.print(zhongjiaohao[i]+" ");
            }
            System.out.println();
            return zhongjiaohao;
        }

//        判断是否中奖
        public static void jiangli(){
            //输入
            int [] shuru = inputssq();
            int [] zj = zhongjianghao();
            int[] user = new int[6];
            int[] zhongjiang = new int[6];
            int sum_red = 0;
            int sum_blue = 0;
//            拿到用户抽取及中奖的红球号码，判断是否中奖
            /*
            * 可以直接嵌套for循环，减少使用两个数组取各个红球号码
            * */
            for (int i = 0; i < user.length; i++) {
                user[i] = shuru[i];
                zhongjiang[i] = zj[i];
            }
//            判断蓝球是否中奖
            if(shuru[6]==zj[6]){
                sum_blue++;
            }
            for (int i = 0; i < user.length; i++) {
                if (exist(zhongjiang,user[i])) {
                    sum_red++;
                }
            }
            System.out.println("中红球个数为："+ sum_red +","+"中蓝球个数为："+ sum_blue);

            if(sum_red==6 && sum_blue==1){
                System.out.println("恭喜你获得一等奖:1000w!");
            } else if (sum_red==6 && sum_blue==0) {
                System.out.println("恭喜你获得二等奖:500w!");
            }else if (sum_red==5 && sum_blue==1) {
                System.out.println("恭喜你获得三等奖:3000!");
            }else if ((sum_red==5 && sum_blue==0) || (sum_red==4 && sum_blue==1)) {
                System.out.println("恭喜你获得四等奖:200!");
            }else if ((sum_red==4 && sum_blue==0) || (sum_red==3 && sum_blue==1) || (sum_red==2 && sum_blue==1)) {
                System.out.println("恭喜你获得五等奖:10!");
            }else if ((sum_red==1 && sum_blue==1) || (sum_red==0 && sum_blue==1)) {
                System.out.println("恭喜你获得六等奖:5!");
            }else {
                System.out.println("很遗憾你没中奖");
            }

        }
}