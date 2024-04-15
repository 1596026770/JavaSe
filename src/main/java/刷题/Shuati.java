package 刷题;

import org.junit.Test;

import java.io.*;
import java.lang.Math;
import java.util.*;

public class Shuati {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

    }


    @Test
    public void test01() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int res = 1;

//    for(int i = 0;i<b;i++){
//        res *= a;
//    }
        res = (int) Math.pow(a, b);
        if (res <= Math.pow(10, 9)) {
            System.out.println(res);
        } else
            System.out.println(-1);
    }

    @Test
    public void test_打狼(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int type = scanner.nextInt();
        scanner.nextLine();
        int[] t = new int[n];
        int[] q = new int[n];
        int count = 0;
        int num = 0;

        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q[i] = scanner.nextInt();
        }

        for(int i=0;i < n;i++){
            if(t[i]==1&&q[i]==1){
                count++;
                num = m + n - count;
            }
        }
        if(count > m)
            System.out.println(num);
        else System.out.println(n);
    }

    @Test
    public void test_系统判断() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

//        SCP2021RPplusplus\nchenzheAKIOI\n1plus1equalto2\n
//        int flag = str.indexOf("\n");
        if(str.indexOf("\\n") != -1 && str.indexOf("\\r\\n")!=15 ){
            System.out.println("linux");
        }
        if(str.indexOf("\\r\\n")!=-1){
            System.out.println("windows");
        }
        if(str.indexOf("\\r") != -1 && str.indexOf("\\r\\n")!=15 ){
            System.out.println("mac");
        }

    }

    @Test
    public void test计数(){
        /*请统计某个给定范围 [L,R] 的所有整数中，数字 2 出现的次数。
比如给定范围 2,22，数字 2 在数 2 中出现了 1 次，在数 12 中出现 1 次，在数 20 中出现 1 次，
在数 21 中出现 1 次，在数 22 中出现 2 次，所以数字 2 在该范围内一共出现了 6 次。
         */
        //l r
        Scanner sc = new Scanner(System.in);
        int l =sc.nextInt();
        int r =sc.nextInt();
        String str = "";
        int count = 0;
        for (int i = l; i <= r; i++) {
            str = ""+i;//2011
//            System.out.println(str);
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='2'){
                    count++;
                }
//                System.out.println(j);
            }
        }
        System.out.println(count);

    }

    @Test
    public void test_仓库(){
//    long n=2021041820210418L;
    int n = 90;
    int count=0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; i++) {
                for (int k = 1; k < n; i++) {
                    if(i*j*k==n){
//                        System.out.println(i +"*" + j + "*" + k );
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }


    @Test
    public void tongxin() throws IOException {
        /*
        * 题目描述:
    最近有 n 个不爽的事，每句话都有一个正整数刺痛值（心理承受力极差）。爱与愁大神想知道连续 m 个刺痛值的和的最小值是多少，
        但是由于业务繁忙，爱与愁大神只好请你编个程序告诉他。

输入格式:
第一行有两个用空格隔开的整数，分别代表 n 和 m。
第 2 到第 (n+1) 行，每行一个整数，第(i+1) 行的整数 ai 代表第 i 件事的刺痛值ai。

输出格式:
输出一行一个整数，表示连续 m 个刺痛值的和的最小值是多少。

输入输出样例:
输入 #1
    8 3
    1       0
    4       1
    7       2
    3       3
    1       4
    2       5
    4       6
    3       7

输出 #1
6
*/
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num.add(sc.nextInt());
        }
        int min = 1000;
        for (int i = 0; i <= n-m; i++) {//0-5
            int sum =0;
            for (int j = i; j < i + m; j++) {//0-2
                sum +=num.get(j);

            }
            if(sum < min){
                min = sum;
            }
        }

        System.out.println(min);

    }




    @Test
    public void danzhu(){
        //30分
                /*
        题目描述:
    MedalPluS 和他的小伙伴 NOIRP 发掘了一个骨灰级别的游戏——超级弹珠。
游戏的内容是：在一个 n×n 的矩阵里，有若干个敌人，你的弹珠可以摧毁敌人，但只能攻击你所在的行、列里的所有敌人，然后你就可以获得他们的分数之和，
现在请你选择一个你的位置，使得能击杀的敌人最多，注意，你不能和敌人在一个地方。

输入格式:
输入有两行，第一行一个正整数 n，接下来 n 行，每行 n 列，如果有敌人则为一个正整数，否则为 0。

输出格式:
输出共一行，最多分数，如果连你的容身之地都没有，请输出“Bad Game!”
输入输出样例:
输入 #1
    4
    1 1 1 0
    1 1 1 1
    1 1 1 1
    0 1 1 1

    %4==0 =1 2 3判断列
n=4 0 1 2 3    /4==0 判断行
    4 5 6 7    /4==1

    0 1 2 3
    1 1 1 0 0
    1 1 1 1 1
    1 0 1 1 2
    0 1 1 1 3
已知 索引9 矩阵阶数n=4
求  行数：9/4==2
    列数：9%4==1
    同行同列的和

输出 #1
6
*/
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        int count = 0;
        ArrayList<Rc> rcs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==0){//获取行列
                    Rc rc = new Rc();
                    rc.r = i;
                    rc.c = j;
                    rcs.add(rc);
                    count++;
                }

            }
        }
        sc.close();


        int max = 0;
        if(count==0){
            System.out.println("Bad Game!");
            return;
        }else {
            for (int i = 0; i < rcs.size(); i++) {//找0中的
                int sum = 0;
                for (int j = 0; j < n; j++) {//行
                    for (int k = 0; k < n; k++) {//列
                        if(j == rcs.get(i).r ){//行相加
                            sum += arr[j][k];
                        }
                        if(k == rcs.get(i).c){//列相加
                            sum += arr[j][k];
                        }
                        if(sum > max){
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }


    @Test
    public void 数组拆分(){
        /*
        * 数组拆分

给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
返回该 最大总和 。
示例 1：
    输入：nums = [1,4,3,2]
    输出：4
    解释：所有可能的分法（忽略元素顺序）为：
    1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
    2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
    3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
    所以最大总和为 4

示例 2：
    输入：nums = [6,2,6,5,1,2]
    输出：9
    解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
        * */
        int[] nums = {6,2,6,5,1,2};
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        System.out.println(sum);
    }

    @Test
    public void 星期(){
        long n = (long) Math.pow(6,22);//20，22太长计算错误
        System.out.println(n);
        //6
        System.out.println(n % 7);//1



    }

    @Test
    public void 纯净数(){
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = "" + i;
            if(str.contains("2")){
                count++;
            }
        }
        System.out.println(n - count);
    }


    @Test
    public void 因数平方和(){
        //结果有误
        int n = sc.nextInt();

        long sum = 0L;
        for (int i = 1; i <= n; i++) {
            sum += 因数平方sum(i);
        }

        int yushu = (int)(sum%(Math.pow(10,9)+7));
        System.out.println(yushu);
        sc.close();
    }

    public static int 因数平方sum(int n){
        ArrayList<Integer> yinshu = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                yinshu.add(i);
            }
        }
        for (int i = 0; i < yinshu.size(); i++) {
            sum += Math.pow(yinshu.get(i),2);
        }
        return sum;
    }

    @Test
    public void 最长子串(){
        /*
无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
提示：
- 0 <= s.length <= 5 * 104
- s 由英文字母、数字、符号和空格组成
        * */


        String str = "pwwkew";
        String s = "";
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                    s = str.substring(i, j + 1);
                    set.add(s);


            }
        }
       for (String l:set){
           System.out.println(l);
       }

//        System.out.println(set);

    }











}


//danzhu 的行列对象
class Rc {
    public int r;
    public int c;
}