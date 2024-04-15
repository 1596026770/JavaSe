package _1_数组;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class Arr {

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,50,60,23};
//        System.out.println(maxarr(arr));

        System.out.println(cunzai(arr,23));
    }


    @Test
    public void fanzhuanarr_test(){
        int[] arr = {1,2,3,4,5,6,50,60,23};
//        1 2 3 4 5 6 50 60 23
//        0  1 2 3 4 5 6 7   8
//        i                  j
        for (int i = 0 , j = arr.length-1; i < j ; i++, j--){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

        }
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    @Test
    public void suijipaixu_Test(){
        int [] arr = new int[8];
//        输入排序的id
        Scanner scanner  = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i+1) + "个排序id：");
            int code = scanner.nextInt();
            arr[i] = code;
        }
//        打乱顺序
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

/*    返回数组*/
    public static void getarr(int[] arr){
        System.out.print("[");
        for (int i=0;i <= arr.length-1;i++){
            if (i == arr.length-1)
                System.out.print(arr[i] );
            else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }

   /* 返回最大值*/
    public static int maxarr(int[] arr){
        int num = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (num<arr[i]){
                num=arr[i];
            }
        }
        return num;
    }

   /* 返回某个数是否存在数组中*/
    public static boolean cunzai(int[] arr, int num){
            for (int i = 0; i < arr.length; i++) {
                if (num == arr[i]) {
                    System.out.println("该数在此数组中");
                    return true;
                }
            }
            return false;
        }




}