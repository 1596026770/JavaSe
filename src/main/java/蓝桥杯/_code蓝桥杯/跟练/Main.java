package 蓝桥杯._code蓝桥杯.跟练;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    /**
     暴力过不了
     */
    @Test
    public void 子串简写own(){
        int k = scan.nextInt();
        String string = scan.next();
        int count = 0;
        char c1 = scan.next().charAt(0);
        char c2 = scan.next().charAt(0);
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+k; j <= string.length(); j++) {
                String newstr = string.substring(i,j);
                if(newstr.startsWith(c1+"") && newstr.endsWith(c2+"")){
                    count++;
                    System.out.println(newstr);
                }
            }
        }
        System.out.println(count);
    }

    @Test
    public void 子串简写(){
        int k = scan.nextInt();
        String string = scan.next();
        long count = 0;
        char c1 = scan.next().charAt(0);
        char c2 = scan.next().charAt(0);
        int[] startnum = new int[string.length()];
        if(string.charAt(0)==c1){
            startnum[0]=1;
        }
//        System.out.print(startnum[0]+" ");
        for (int i = 1; i < string.length(); i++) {
            if(string.charAt(i)==c1){
                startnum[i] = startnum[i-1] + 1;
            }else startnum[i] = startnum[i-1];
//            System.out.print(startnum[i]+" ");
            if(i>=k-1 && string.charAt(i)==c2){
                count += startnum[i-k+1];
            }
        }
        System.out.println(count);
    }

    /**
     先判断特殊情况，j==0 和 j==oldchars.length-1的情况,避免溢出
     */
    @Test
    public void 翻转(){
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            char[] newchars = scan.next().toCharArray();
            char[] oldchars = scan.next().toCharArray();
            int count = 0;
            for (int j = 0; j < oldchars.length; j++) {
                if(oldchars[j]!=newchars[j]){
                    if(j==0 || j==oldchars.length-1){
                        count=-1;
                        break;
                    }else{
                        if(oldchars[j-1]==oldchars[j+1] && oldchars[j]!=oldchars[j-1]){
                            oldchars[j]=newchars[j];
                            count++;
                        }else {
                            count=-1;
                            break;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    @Test
    public void 填充(){
        char[] chars = scan.next().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i]=='?'){
                count++;
                i++;
            }else {
                if(chars[i]==chars[i+1] || chars[i+1]=='?'){
                    count++;
                    i++;
                }
            }
        }
        System.out.println(count);
    }

    @Test
    public void 数位排序(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i+1;
            arr[i][1] = sumbit(i+1);
//            System.out.print(arr[i]+" ");
        }
        //      如果[1]相等返回[0]较小的值            不相等返回
        Arrays.sort(arr,(o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);
        //12        3       4
        //3 12      相等
        //12 4      不相等
        System.out.println("原数字");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-3d",arr[i][0]);
        }
        System.out.println();
        System.out.println("现数字");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-3d",arr[i][1]);
        }
        System.out.println();

        System.out.println(arr[m-1][0]);
    }

    /**
     各个数位之和
     */
    public static int sumbit(int n){
        int sum = 0;
        while (n>0){
            sum += n%10;
            n /=10;
        }
        return sum;
    }

    @Test
    public void 求和(){
        int n = scan.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n];
        long res = 0;
        sum[0] = arr[0];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            if(i>0){
                sum[i] = sum[i-1] + arr[i];
            }
        }

        for (int i = 0; i < n-1; i++) {
            res += (long)arr[i]*(sum[n-1] - sum[i]);
        }
        System.out.println(res);

    }

    @Test
    public void 不同子串(){
        String str = scan.next();
        //1011110011
        //aaab
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String s = str.substring(i,j+1);
                set.add(s);
            }
        }
        System.out.println(set.size());
    }

    @Test
    public void 门牌制作(){
        int n = 2022;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String str = i + "";
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='2'){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    @Test
    public void 寻找2020(){
//        System.out.println((byte)'A'+" "+(byte)'L');
    }





    @Test
    public void Test1(){
        Scanner scan = new Scanner(System.in);
        char[] chars = scan.next().toCharArray();
//        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                char temp;
                if(chars[i]<chars[j]){
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
    }








}
