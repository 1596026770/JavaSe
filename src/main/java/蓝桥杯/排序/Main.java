package 蓝桥杯.排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        char [] chars = sc.next().toCharArray();//C A B
        Arrays.sort(arr);//数字拍好了，ABC顺序记录在chars中
        for (int i = 0; i < 3; i++) {
            //C-A 2   A-A 0     B-A 1
            System.out.print(arr[chars[i] - 'A'] + " ");
        }
    }
}
