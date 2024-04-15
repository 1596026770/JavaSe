package 蓝桥杯;

import java.io.IOException;
import java.lang.Math;
import java.util.*;

import org.junit.Test;


public class Main {
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        /**
         题目描述
         给出一串正整数数列以及一个正整数C，要求计算出所有满足
         A−B=C 的数对的个数（不同位置的数字一样的数对算不同的数对）。

         输入格式输入共两行。
         第一行，两个正整数N,C。
         第二行，
         N 个正整数，作为要求处理的那串数。
         输出格式
         一行，表示该串正整数中包含的满足A−B=C 的数对的个数。

         输入输出样例
         输入 #1复制
         4 1
         1 1 2 3
         输出 #1复制
         3

         */
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();

        int n = sc.nextInt();

        int c = sc.nextInt();

        int [] arr = new  int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            //1 1 2 3
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);//统计各个数出现的次数
            // 1:2 2:1 3:1
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int b = arr[i] - c;
            res += map.getOrDefault(b,0); //统计满足条件的次数,map.getOrDefault(b,0)判断是否满足条件，若满足返回出现次数，即几个结果
        }

        System.out.println(res);


    }

    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        while (n>0){
            System.out.print(n+ " ");
            n/=2;
        }

    }

    /**
     Hel2oword1
     */
    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        char[] c= scanner.next().toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if(c[i] >= '1' && c[i] <= '9'){
                int k = c[i] - '0';//0Ascii为48
                for (int j = 0; j < k-1; j++) {
                    str.append(c[i-1]);
                }
            }else {
                str.append(c[i]);
            }
        }
        System.out.println(str);

    }

    /**
     输入一行字符串，统计其中数字的个数
     */
    @Test
    public void StringTest(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0';
            if(index >= 0 && index <= 9){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     输入一个字符串，输出该字符串是否回文。回文是指顺读和倒读都一样的字符串。
     */
    @Test
    public void 回文串(){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int left = 0,right = s1.length()-1;
        boolean flag =true;
        while (left < right){
            if(s1.charAt(left) != s1.charAt(right)){
                flag = false;
                break;
            }
            left++;
            right--;
        }

        if (flag == true) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    /**
     给定一行句子，每个词之间用空格隔开，要么是全小写英文单词，要么是全大写英文单词，要么是自然数。
     要求将这些单词倒序输出。而且对于每个单词，如果是小写词，应当转为大写；如果是大写词，应当转为小写；如果是自然数，应该倒转输出。

     举一个例子：
     we choose TO go 2 the 123 moon
     程序应当输出：
     MOON 321 THE 2 GO to CHOOSE WE
     */
    @Test 
    public void 反转变换(){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String [] strings = s1.split(" ");
        //判断大小写或数字
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].charAt(0) >= 48 && strings[i].charAt(0) <= 48+10-1){
                //反转
                StringBuilder num = new StringBuilder(strings[i]);
                strings[i] = num.reverse().toString();
            } else if (strings[i].charAt(0) >= 65 && strings[i].charAt(0) <= 65+26-1) {
                //大写    转小写
                strings[i] = strings[i].toLowerCase();
            } else if (strings[i].charAt(0) >= 97 && strings[i].charAt(0) <= 97 +26-1) {
                //小写    转大写
                strings[i] = strings[i].toUpperCase();
            }
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[strings.length-1 - i]+ " ");
        }
    }

    @Test
    public void char类型转换大小写(){
        char a = 'a';
        String b = "asda";
        System.out.println(a ^=32);
    }

    @Test
    public void 模拟(){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count=0;
        for (int i = 1; i <= n-1; i++) {
            if (Math.pow(i,2)%n < n/2.0) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void 数字(){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0l;
        for (long i = 1; i <= n; i++) {
            String s = "" + i;
            if (s.contains("2") ||s.contains("0") ||s.contains("1") ||s.contains("9")) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    @Test
    public void 前缀和(){
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int [] arr = new int[n];
        long [] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }
    }

    /**
     给定n 个整数a1,a2 ...an 求它们两两相乘再相加的和，即S=a1*a2+a1*a3+a1+a4+...+a1*an +a2*a3+...+a2*an+...+an-1*an
     输入格式
     输入的第一行包含一个整数n 。
     第二行包含n 个整数

     输出格式
     输出一个整数S，表示所求的和。请使用合适的数据类型进行运算。

     输入输出样例
     输入 #1复制
     4
     1 3 6 9
     输出 #1复制
     117
     */
    @Test
    public void 两两相乘再相加(){
        int n = scan.nextInt();
        int[] arr = new int[n+1];
        long [] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
            sum[i] = sum[i-1] + arr[i];
        }

        long res = 0l;
        for (int i = 1; i <= n; i++) {
            res += arr[i]*(sum[n] - sum[i]);
        }
        System.out.println(res);
        scan.close();
    }

    /**
     5 2
     1
     2
     3
     4
     5

     */
    @Test
    public void K倍序列(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] f = new int[k];
        f[0] = 1;//有一个初始k倍区间    在此基础上再找
        long sum = 0l, res = 0;
        for (int i = 0; i < n; i++) {
            sum += scan.nextLong();
            res += f[(int)(sum%k)];//假设k=2 f大小为2    f[0]: f[1]
            f[(int)(sum%k)]++;//f[0]++  f[1]++
        }
        System.out.println(res);
        scan.close();
    }


    @Test
    public void 乘法逆元() {//13-1 * 10 %13      120%13   3
        long inv[] = new long[3000005], n = 10, p = 13;
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = (p - p / i) * inv[(int) p % i] % p;
            System.out.println(i + "mod13的乘法逆元为："+ inv[i]);
        }

    }

    /**
     a：底数 n：指数 p：取余
     */
    public static int 快速幂(int a,int n, int p){
        if(a==1 || n==0)    return 1;
        a %= p;
        int c = 快速幂(a,n/2,p);
        if(n%2==1)  return c * c%p * a%p;//奇
        else return c * c%p;//偶

    }

    /**
     a：底数 n：指数 p：取余
     */
    public static int quickmi(int a,int n,int p){//3 6 1e9+7
        int res = 1;//连乘器
        //6
        //3^6 -> 9^3 -> res=9 81^3/2  = 81^1 ->  res= 9 * 81 = 3^2 * 3^4  81*81^0
        //3^5 -> res= 3 9^2 -> 9*9^1 -> res= 3 * 9*9 = 3 * 3^4  81*81^0
        while (n>0){
            if(n%2==1)   res = res * a%p;//位权为1即为奇才
            a *=a%p;
            n >>= 1;//右移并赋值
        }
        return res;
    }
    @Test
    public void quickly(){
        System.out.println(快速幂(20, 22, 7));
//        System.out.println(quickmi(3, 5, 43));

    }

    /**
     蓝桥 13B 山
     */
    @Test
    public void 山(){
        int count=0;
        for (long i = 2022L; i < 2022222022; i++) {
            String s = i +"";
            if(huiwen(s) && bujian(s)){
                System.out.println(s);
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     蓝桥 13B 山
     判断是否回文
     */
    public static boolean huiwen(String s){
        int left =0,right = s.length()-1;
        while (left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     蓝桥 13B 山
     判断是否单调不减
     */
    public static boolean bujian(String s){
        for (int i = 1; i < (s.length()+1) / 2; i++) {
            if(s.charAt(i-1)>s.charAt(i))
                return false;
        }
        return true;
    }

    /**
     蓝桥 13 C A 排列字母
     */
    @Test
    public void 排列字母(){
        char[] charArray = "WHERETHEREISAWILLTHEREISAWAY".toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] );
        }

    }

    /**
     蓝桥 13 B C
     */
    @Test
    public void 字符统计(){
        char[] chars = scan.nextLine().toCharArray();
        int [] n = new int[26];
        //ADADLA
        for (int i = 0; i < chars.length; i++) {
            n[(chars[i]-'A')]++;
        }
        int max = n[0];
        for (int i = 0; i < n.length; i++) {
            if(max < n[i]){
                max = n[i];
            }
        }
        for (int i = 0; i < n.length; i++) {
            if(n[i] == max){
                System.out.print((char)(i+'A'));
            }
        }
    }

    /**
     蓝桥 13  B D
     */
    @Test
    public void 最少刷题数(){
        int n = scan.nextInt();
        int[] stnum = new int[n];
        ArrayList<Integer> stnew = new ArrayList<>();
        int[] x = new int[n];
        int max = stnum[0];
        for (int i = 0; i < n; i++) {
            stnum[i] = scan.nextInt();
            stnew.add(stnum[i]);
            if(max < stnum[i]){
                max = stnum[i];
            }
        }
        //还要刷x[]题使得     刷完x题后刷题数：stnum[i] + x[i]
        //实现一个方法查找大于刷题量x 的人数 和不超过x的人数
        for (int i = 0; i < stnum.length; i++) {
            //number = x[i]+stnum[i]
            //gt(number,stnum)<=lt(number,stnum)成立
            //求x[i]
            //5
            //12 10 15 20 6
            for (int j = 0; j < max; j++) {
                int gt = gt(x[i]+stnum[i],stnew,i);
                int lt = lt(x[i]+stnum[i],stnew,i);
                if(gt > lt){
                    x[i]++;
                }else break;
            }
            System.out.print(x[i]+" ");
        }

    }

    /**
     *
     * @param x     当前刷题数
     * @param list  刷题数list
     * @param index 当前刷题人索引
     * @return
     */
    public static int gt(int x,ArrayList list,int index){
        int count = 0;
        int tem = (int)list.get(index);
        list.remove(index);
        for (int i = 0; i < list.size(); i++) {
            if(x < (int)list.get(i)){
                count++;
            }
        }
        list.add(index,tem);
        return count;
    }
    /**
     *
     * @param x     当前刷题数
     * @param list  刷题数list
     * @param index 当前刷题人索引
     * @return
     */
    public static int lt(int x,ArrayList list,int index){
        int count = 0;
        int tem = (int)list.get(index);
        list.remove(index);
        for (int i = 0; i < list.size(); i++) {
            if(x > (int)list.get(i)){
                count++;
            }
        }
        list.add(index,tem);
        return count;
    }

    /**
    蓝桥  求和 3585
     */
    @Test
    public void 求和(){
        long x = scan.nextLong();
        long k = scan.nextLong();
        long n = scan.nextLong();
        long b = scan.nextLong();
        long mod = 20130919l;

        long res = 0l;
        for (long i = 0; i <= n; i++) {
            res += fx(gx(i,k,b),x,mod)%mod;
        }
        System.out.println(res%mod);
    }
    /**
     蓝桥  求和 3585
     */
    public static long fx(long n , long x,long mod){
        long res = 0;
        for (long i = 1; i <= n; i++) {
            res += (long) (Math.pow(i,x) * Math.pow(x,i)) %mod;
        }
        return res %mod;
    }
    /**
     蓝桥  求和 3585
     */
    public static long gx(long n,long k,long b){
        return k*n+b;
    }

    /**
     蓝桥 13 B E
     */
    @Test
    public void 求阶乘(){
        long k = scan.nextLong();
        long left=1l,right = Long.MAX_VALUE-1;
        while (left < right){
            //找使得check(middle)==k 的middle值  一直逼近k值
            long middle = (left+right)/2;
            if(checkMod5(middle) < k){
                left = middle + 1;
            }else {
                right = middle ;
            }
        }
        if(checkMod5(left) != k){
            System.out.println(-1);
        }else {
            System.out.println(right);
        }
    }

    /**
     n包含有几个5，即阶乘后有0的个数
     * @param n
     * @return
     */
    public static long checkMod5(long n){
        long res =0l;
        while (n>0){
            //25    24
            res += n/5;//5  4
            n /= 5;//5  4
        }
        return res;
    }

    /**
     洛谷 P8667
     */
    @Test
    public void 递增三元组(){
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            c[i] = scan.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int[] B = new int[n];//比bi大的c有多少个   //        int[] A = new int[n];//比ai大的b有多少个
        for (int i = 0; i < n; i++) {
            int left = 0,right = n-1;
            while (left < right){
                int mid = (left + right)/2;
                if(c[mid] > b[i]){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            if(c[left] > b[i]){
                B[i] = n- left;//比ai大的b有多少个 n-1(尾) - left(当前) +1 = n - left
            }
        }
        long [] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + B[i-1];
        }
        long ans = 0l;
        //求比bi大的c
        for (int i = 0; i < n; i++) {
            int left = 0,right = n-1;
            while (left < right){
                int mid = (left + right)/2;
                if(b[mid] > a[i]){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            if(b[left] > a[i]){
                //A[i] = n- left;//比ai大的b有多少个 n-1(尾) - left(当前) +1 = n - left
                ans += sum[n] - sum[left];
            }
            //ans += A[i] * B[i];
        }
        System.out.println(ans);

    }



    @Test
    public void 丢失数字(){
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int left =0,right = nums.length;
        //0 1 3
        //0 1 2 3
        //i == nums[i]
        Arrays.sort(nums);
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > mid) right = mid;
            else left = mid +1;
        }
        System.out.println(left);
    }

    @Test
    public void ceshi(){
        int a=2,b=2;
        int left = -100,right = 100;
        while (left <= right){
            int mid = left + (right - left)/2;
            if( a*mid+b >  0 ) right = mid -1;
            else if(a*mid+b <  0) left = mid +1 ;
            else if(a*mid+b == 0) right = mid -1;
        }
        System.out.println(left);
    }

    @Test
    public void 一元三次方程(){
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        double d = scan.nextDouble();

        for(int i = -100;i<=100;i++){
            double left = i,right = i+1;
            if(hsf(left,a,b,c,d)==0){
                System.out.printf("%.2f ",(double)i);
            }else if(hsf(left,a,b,c,d) * hsf(right,a,b,c,d) <0){
                while (right - left >= 1e-3){
                    double mid = left +(right-left)/2;
                    if(hsf(mid,a,b,c,d)*hsf(left,a,b,c,d) <0) right = mid;
                    else left = mid;
                }
                System.out.printf("%.2f ",left);
            }
        }
    }
    public static double hsf(double x,double a,double b,double c,double d){
        return a*x*x*x + b*x*x + c*x + d;
    }

    @Test
    public void erfenLeft(){
        //左边找
        //大于等于k的第一个索引
        //结束条件：left > right 即 left = right +1
        //返回left 即为
        //             0 1 2 3 4 5 6 7 8 9  10 11 12
        int [] nums = {1,2,3,5,6,8,8,8,9,11,15,15,16};
        int target = 7;
        int left =0,right = nums.length-1;//12
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target)left = mid +1;
            else right = mid -1;
        }
//        if(right < 0 || nums[left]!= target) System.out.println(-1);
        System.out.println("大于等于k的第一个索引："+left);
        System.out.println("小于k的最后一个索引："+right);
    }

    @Test
    public void erfenRight(){
        //右边找   输入右
        //小于等于k的最后一个索引
        //若输入变左 成为 大于k的第一个索引
        //             0 1 2 3 4 5 6 7 8 9  10 11 12
        int [] nums = {1,2,3,5,6,8,8,8,9,11,15,15,15};
        int target = 9;
        int left =0,right = nums.length-1;//12
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target)left = mid +1;
            else left = mid +1;
        }
//        if(right < 0 || nums[left]!= target) System.out.println(-1);
        System.out.println(left);
    }

    @Test
    public void erfenTest(){
        //左边找
        //大于等于k的第一个索引
        //变成：小于k的最后一个索引
        //             0 1 2 3 4 5 6 7 8 9  10 11 12
        int [] nums = {1,2,3,5,6,8,8,8,9,11,15,15,15,15,15,16};
//        int [] nums = {1,2,3,5,6,8,9,11,15,16};
        int target = 15;
        int left =0,right = nums.length-1;//12
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target)left = mid +1;
            else {
                System.out.println(mid);
                break;
            }

        }
//        if(right < 0 || nums[left]!= target) System.out.println(-1);
        System.out.println(left);
        System.out.println(right);
    }

    /**
     自己整理了一下不知道为什么有些不能通过
     4
     1 2 3 4
     1 3 4 5
     1 3 4 6
     */
    @Test
    public void 三元组(){
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            c[i] = scan.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
//        int[] B = new int[n];//记录每个比ai大的b的数目
        int[] C = new int[n];//记录每个比bi大的c的数目
        //注意sum[]化为long否则会溢出
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            int start = 0, end = n-1;
            while (start <= end){
                int zhong = start + (end - start)/2;
                if(c[zhong] > b[i]) end = zhong -1;
                else if (c[zhong] < b[i]) start = zhong + 1;
                else if (c[zhong] == b[i]) {
                    start = zhong + 1;
                }
            }

            if(end< 0 || c[end]!=b[i]){
                //没找到
            }
            //left即为大于ai的第一个索引，数组b中大于ai的个数为：[left，n-1] n-1 - left +1 = n - left
            C[i] = n - start;

        }
        for (int i = 1; i <= n; i++) {
            //不能放在一个for循环中是因为要先让C[i]跑完求前缀和
            sum[i] = sum[i - 1] + C[i-1];
        }

        long res = 0l;
        for (int i = 0; i < n; i++) {
            int left = 0,right = n-1;
            //输出left即为大于k的第一个索引
            while (left <= right){
                int mid = left + (right - left)/2;
                if(b[mid] > a[i]) right = mid -1;
                else if (b[mid] < a[i]) left = mid + 1;
                else if (b[mid] == a[i]) {
                    left = mid + 1;
                }
            }
            if(right< 0 || b[right]!=a[i]){
                //没找到
            }
            //left即为大于ai的第一个索引，数组b中大于ai的个数为：[left，n-1] n-1 - left +1 = n - left
//            B[i] = n - left;//没用到B[i]

            //判断b[i]是否大于a[i] left已知为大于ai的最小索引，若大于累加求和
            if(b[left]> a[i]){
                //1 2 3 4
                //1 3 4 5
                //1 3 4 6
                //为什么是这样的结果：
                //以a0开始向后找，找到B[0] = n - left =3 ,然后取回首个大于ai的索引即left = 1,
                // 在找C[left]即比b[left]大的c的个数为2，找完找C[left+1]一直到C[n-1]，然后累加即为a0对应的递增三元组个数 即 2 + 1 + 1 =4个
                //以此类推到an-1并累加即为所有递增三元组个数。为了方便把C[left]一直到C[n-1]累加计算，使用前缀和sum[n-1] - sum[left-1]
                //此处用的原作者的sum[n+1]否则会索引为-1
                res += sum[n] - sum[left];
            }
        }
            System.out.println(res);
    }

    /**
     以bi为切入点，c中大于bi的首个索引*a中小于等于bi的最后一个索引即为答案
     4
     1 2 3 4
     1 3 4 5
     1 3 4 6
     */
    @Test
    public void 三元组优化(){
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            c[i] = scan.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        long ans =0l;
        for (int i = 0; i < n; i++) {
            int left = 0,right = n-1;
            int start = 0,end = n-1;
            //c中大于bi的第一个索引，即cleft到cn-1全是满足条件的
            while (left <= right){
                int mid = left + (right - left)/2;
                if(c[mid] > b[i]) right = mid -1;
                else if (c[mid] < b[i]) left = mid + 1;
                else if (c[mid] == b[i]) left = mid + 1;

            }
            //left
            //a中小于bi的最后一个索引，即a0到aend全是满足条件的
            while (start <= end){
                int mid = start + (end - start)/2;
                if(a[mid] > b[i]) end = mid -1;
                else if (a[mid] < b[i]) start = mid + 1;
                else if (a[mid] == b[i]) end = mid - 1;
            }
            //end
//            System.out.println("c中大于b"+i+"的第一个索引:"+left);
//            System.out.println("a中小于b"+i+"的最后一个索引:"+end);

            if(left >=0 && left <n && end >=0 && end <n){
                //注意化为long否则会溢出
                ans += (long)(n-left) * (long)(end +1);
            }
//            ans += (long) ((n-left) * (end +1));

//            System.out.println("结果ans为：" + ans);
//            System.out.println();
        }
        System.out.println(ans);
    }

    @Test
    public void 浮点二分测试(){
        //                  0   1    2    3    4    5     6    7    8   9   10   11   12   13
        double [] nums = {1.25,2.36,3.45,5.75,6.25,8.11,8.11,8.11,8.22,9.0,11.1,15.2,15.2,16.3};
        double left =0,right = 1e9;
        double taregt = 8843.15;
        //答案与标准答案误差不超过0.01 即小于等于0.01可以退出循环
        while (right - left >= 1e-2){//开区间
            double mid = left + (right - left)/2;
            if(mid > taregt) right = mid -1 ;//能满足切k段，再在满足的区间中缩小找
            else if(mid < taregt) left = mid +1;
            else left = mid + 1 ;
        }
        System.out.println("left:" + left);
        System.out.println("right:"+ right);

    }

    /**
     洛谷 P1577
     */
    @Test
    public void 切绳子(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        double [] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextDouble();
        }
        double left =0,right = 1e9;
        //答案与标准答案误差不超过0.01 即小于等于0.01可以退出循环
        while (right - left > 1e-2){//开区间
            double mid = left + (right - left)/2;
            if(checkShengzi(nums,mid)>=k) left = mid ;//能满足切k段，再在满足的区间中缩小找
//            else if(checkShengzi(nums,mid)<k) right = mid -1;
            else right = mid ;
        }
        System.out.printf("%.2f",left);

    }

    /**
     * 切绳子
     * @param nums 数组
     * @param length    假设每段长度  length越大越难满足条件
     * @return      最多可以切几段
     */
    public static int checkShengzi(double[] nums, double length){
        //nums[] = 8.02 7.43 4.57 5.39  length = 2.00
        //sum = 8.02/2 + 7.43/2 + 4.57/2 + 5.39/2 =11 最多可以切11段
        //         4        3       2       2
        int sum =0;//最多可以切几段
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]/length;
        }
        return sum;
    }

    /**
     * 算法书上题
     * 从1-n输出蛇形填数 n*n
     列   1   2  3  4
  行 1     1  2  3  4    9/n==行
     2    12 13 14  5    9%n==列
     3    11 16 15  6
     4    10  9  8  7

     将初值定为1，判断下一个目标的值是否为0并且坐标不超过最大值n，如果满足令下一个位置的值为total+1,坐标对应向下一个位置移动单位1
     */
    @Test
    public void 蛇形填数(){
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        int total = arr[0][0] = 1;
        int x=0,y=0;//x:向下纵坐标    y:向右横坐标
        while (total < n*n) {
            //向右
            while (y+1 < n && arr[x][y+1]==0 ){//最后一个位置由当前while填
                arr[x][y+1] = total+1;
                total++;
                y++;
            }
            //向下
            while (x+1 < n && arr[x+1][y]==0){
                arr[x+1][y] = total+1;
                total++;
                x++;
            }
            //向左
            while (y-1 >= 0 && arr[x][y-1]==0){//注意是y-1 >= 0（有等于号）
                arr[x][y-1] = total+1;
                total++;
                y--;
            }
            //向上
            while (x-1 >= 0 && arr[x-1][y]==0){
                arr[x-1][y] = total+1;
                total++;
                x--;
            }
//            break;
        }


        for (int i = 0; i < n; i++) {//7
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.println();
        }

    }

    @Test
    public void abc(){
        int count = 0;
        for (int i = 1; i <= 2020; i++) {
           String s = i + "";
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='2') count++;
            }
        }
        System.out.println(count);
    }





    /**
     ```````````````````````````````````````````````````````````````````````````````````````````````````````````````````
     */
    @Test
    public void  testLanQiao() {
        //大于target的第一个索引
        int [] nums = {1,2,3,5,6,8,8,9,11,15,15,16};
        int target = 11;
        int left =0,right = nums.length-1;//11
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target) right = mid;
            else left = mid +1;
        }
//        if(right < 0 || nums[left]!= target) System.out.println(-1);
        System.out.println(left);
    }
}
