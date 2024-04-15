package _2_1_案例;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
//        抢红包
//        有5个红包，分别有9、666、188、520、99999，随机抽取，一个红包只能抽一次，先抽哪个是随机的
        qhb();

    }
    public static void qhb(){
        int[] amount = {9,666,188,520,99999};
        int[] flag = {0,0,0,0,0};//flag[i]==0表示红包还没有被抽走
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        while (flag[0]==0 ||flag[1]==0 ||flag[2]==0 ||flag[3]==0 ||flag[4]==0 ||flag[0]==0 ){
            switch (r.nextInt(5)){
                case 0:
                    if(flag[0]==0) {
                        System.out.print("请按任意键完成抽奖：");
                        sc.nextLine();
                        System.out.println("恭喜你，你抽中了：9");
                        flag[0] = 1;
                        break;}
                    else {
                        break;
                    }
                case 1:
                    if(flag[1]==0) {
                        System.out.print("请按任意键完成抽奖：");
                        sc.nextLine();
                        System.out.println("恭喜你，你抽中了：666");
                        flag[1] = 1;
                        break;}
                    else {
                        break;
                    }
                case 2:
                    if(flag[2]==0) {
                        System.out.print("请按任意键完成抽奖：");
                        sc.nextLine();
                        System.out.println("恭喜你，你抽中了：188");
                        flag[2] = 1;
                        break;}
                    else {
                        break;
                    }
                case 3:
                    if(flag[3]==0) {
                        System.out.print("请按任意键完成抽奖：");
                        sc.nextLine();
                        System.out.println("恭喜你，你抽中了：520");
                        flag[3] = 1;
                        break;}
                    else {
                        break;
                    }
                case 4:
                    if(flag[4]==0) {
                        System.out.print("请按任意键完成抽奖：");
                        sc.nextLine();
                        System.out.println("恭喜你，你抽中了：99999");
                        flag[4] = 1;
                        break;}
                    else {
                        break;
                    }
                default:
                    System.out.println("活动结束。。。。");
                    break;

            }
        }
        System.out.println("活动结束。。。。");
    }

}
