package 蓝桥杯.队列;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 约瑟夫
 n 个人围成一圈，从第一个人开始报数,数到m 的人出列，再由下一个人重新从
 1 开始报数，数到m 的人再出圈，依次类推，直到所有的人都出圈，请输出依次出圈人的编号。

 注意：本题和《深入浅出-基础篇》上例题的表述稍有不同。书上表述是给出淘汰n−1 名小朋友，而该题是全部出圈。

 输入格式
 输入两个整数
 n,m。

 输出格式
 输出一行
 n 个整数，按顺序输出每个出圈人的编号。

 输入输出样例
 输入 #1复制
 10 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        //1 2 3 4 5 6 7 8 9 10
        //2 3 4 5 6 7 8 9 10 1
        //3 4 5 6 7 8 9 10 1 2
        //4 5 6 7 8 9 10 1
        //5 6 7 8 9 10 1 4
        int res = 0;//数到第几个数
        while (queue.size() > 1){
            int x = queue.poll();
            res++;
            if(res == m){
                //被淘汰的人
                res = 0;//重置数数
                System.out.print(x + " ");
            }else {
                queue.add(x);
            }
        }
        System.out.println("最后剩余人为：第" + queue.peek() + "号");
    }
}
