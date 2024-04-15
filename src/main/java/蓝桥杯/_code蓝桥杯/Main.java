package 蓝桥杯._code蓝桥杯;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

import java.util.*;

public class Main {
    Scanner scan = new Scanner(System.in);
    static int count = 0;//烤鸡   P2089
    static boolean flag = false;//火星人结束条件  P1088
    static int min = (int)1e9;//PERKET     P   1149     要给尽量大
    static int max = 0;
    static int mapx = 0;//入门   初始坐标：x向下,y向右
    static int mapy = 0;
    static int[] dx = {-1,0,1,0};//向量坐标
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        scan.close();
    }

    /**
     3510
     二分可以优化for循环（当前可以全部通过）
     */
    @Test
    public void 冶炼金属(){
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        ArrayList<Integer> vmax = new ArrayList<>();
        ArrayList<Integer> vmin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
        }
        int left = 1,right = (int)1e9;
        int start = 1,end = (int)1e9;
        for (int i=0;i<n;i++) {
            while (left <= right){
                int mid = left +(right-left)/2;
                if(a[i]/mid > b[i]){//满足条件
                    left = mid +1;
                }else if(a[i]/mid < b[i]) right = mid -1;
                else left = mid +1;
            }
            while (start <= end){
                int zhong = start +(end-start)/2;
                if(a[i]/(b[i]+1) > zhong){//判断v是否能满足所有条件（每条记录都满足）
                    start = zhong +1;
                }else if(a[i]/(b[i]+1) < zhong) end = zhong -1;
                else end = zhong -1;
            }
            vmax.add(right);
            vmin.add(start+1);
            left = 1;right = (int)1e9;//重置
            start = 1;end = (int)1e9;
        }
        Collections.sort(vmax);
        Collections.sort(vmin);
        int max = vmax.get(0);
        int min = vmin.get(vmin.size()-1);
        System.out.println(min + " " + max);
    }

    /**
     3505 冶炼金属
     Math.min 、max 判断
     */
    @Test
    public void yelian() {
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
        }
        int max = a[0] / b[0];
        int min = 0;
        for (int i = 0; i < n; i++) {
            max = Math.min(max, a[i] / b[i]);
            min = Math.max(min,(a[i] / (b[i]+1))+1);
        }
        System.out.println(min + " " + max);
        scan.close();
    }

    /**
     594    蛇形填数
     此蛇形填数中间对角线的值为:行号（从1开始）^2+(行号-1)^2  如第4行第四列的值为：4*4+3*3=25
     */
    @Test
    public void 蛇形填数(){
        int n = 39;//定义一个n*n大小的数组  需要定义大一点，最好翻倍，否则不会向右向下跑一次，最低要定义到2*n-1
        int[][] arr = new int[n][n];
        int total = arr[0][0] = 1;
        int x=0,y=0;//x纵向向下为正   y横向
        while (total < n*n){
            //向右向下只执行一次     加全部小于n 减全部大于等于0
            //向右 y++
            while (y+1 < n && arr[x][y+1]==0){
                arr[x][y+1] = total+1;
                total++;
                y++;
                break;//每次只执行一次
            }
            //向左下   x++ y--
            while (x+1 < n && y -1 >= 0  && arr[x+1][y-1]==0){
                arr[x+1][y-1] = total+1;
                total++;
                x++;
                y--;
            }
            //向下    x++
            while (x+1 < n && arr[x+1][y]==0){
                arr[x+1][y] = total+1;
                total++;
                x++;
                break;//每次只执行一次
            }
            //向右上   x-- y++
            while (x-1 >= 0 && y +1 < n  && arr[x-1][y+1]==0){
                arr[x-1][y+1] = total+1;
                total++;
                x--;
                y++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%5d",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("第20行20列" + arr[19][19]);
    }

    /**
     14届    B   A
     快速幂
     */
    @Test
    public void 阶乘求和(){
        long res = 0l;
        for (int i = 1; i < 300; i++) {
            res += jiecheng(i)%(long) 1e9;
        }
        System.out.println(res%(long) 1e9);
    }

    /**
     * 快速幂
     * @param a     底数
     * @param n     指数
     * @param p     modp
     * @return
     */
    public static long quickPow(int a, int n , long p){
        if(a == 0)  return 0;
        if(a==1 || n == 0)  return 1;
        a %=p;
        long c = quickPow(a,n/2,p);
        if(n%2==1) return c * c%p *a%p;//奇
        else return c * c%p;//偶
    }

    /**
     * 快速幂  不递归版
     * @param a     底数
     * @param n     指数
     * @param p     mod
     * @return
     */
    public static long quicklyPow(int a , int n , long p){
        if(a == 0)  return 0;
        if(a==1 || n == 0)  return 1;
        long res = 1;//连乘器
        while (n > 0){
            if (n%2==1) {//n为奇,即权位为1
                res *= a%p;
            }
            a *=a;//底数倍增
            n >>=1;//指数除2
        }
        return res%p;
    }

    /**
     * 求阶乘  取9位
     * @param n
     * @return
     */
    public static long jiecheng(int n){
        if(n == 1 || n == 0)    return 1;
        return n*jiecheng(n-1)%(long) 1e9;
    }

    /**
     14     B   B
     */
    @Test
    public void 幸运数字(){
        int count = 0;
        int n = 1;
        while (count < 2023){//不能等于，count为目标值时已经得到结果，如果等于还会进入下一次循环，以5测试
            if(shahade(n,2) && shahade(n,8) && shahade(n,10) && shahade(n,16)){
//                System.out.printf("%8d",n);
                count++;
//                if(count%10==0) System.out.println();
                if(count==2023) System.out.println(n);
            }
            n++;
        }
    }

    /**
     * 判断数字n在mod进制下是否为沙哈得数
     * @param n
     * @param mod
     * @return
     */
    public static boolean shahade(int n , int mod){//      八进制 125 %8
        int oldn = n;//记录此数字                                5 7 1 0
        int ans = 0;                                  //125/8 = 15 1 0
        while (n > 0){//125                                     二进制125 %2 =1
            ans +=n%mod;//5  取出在mod进制下的各个位数               1 0 1 1 1 1 1 0
            n /=mod;                                            //125/2 = 62 31 15 7 3 1 0
        }
        return oldn%ans==0;
    }

    /**
     14     B   C
     */
    @Test
    public void 数组分割(){
        int t = scan.nextInt();
        int[] arr = new int[1000];
        int[] sum = new int[1000];
        int mod = (int) 1e9+7;
        for (int i = 0; i < t; i++) {//数据组数
            int count = 0;
            int n = scan.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
                sum[0] = arr[0];
                if (j>0) {
                    sum[j] = sum[j-1]%mod + arr[j]%mod;
                }
            }
            for (int j = 0; j < n; j++) {
                if(sum[j]%2==0 && (sum[n-1] - sum[j])%2==0) count++;
            }
            System.out.println(count);
        }
    }

    /**
     只会暴力，此题需要会优先队列
     */
    @Test
    public  void 整数删除(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> num = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            num.add(scan.nextInt());
            min = Math.min(min,num.get(i));
//            queue.add(scan.nextInt());
        }
        for (int j = 1;j<=k;j++) {
            for (int i = 0; i < num.size(); i++) {
                if(num.get(i) == min){
                    if (i >=1 && i< num.size()-1) {
                        num.set(i-1,num.get(i-1)+min);
                        num.set(i+1,num.get(i+1)+min);
                        num.remove(i);
                        break;
                    } else if (i == 0) {
                        num.set(i+1,num.get(i+1)+min);
                        num.remove(i);
                        break;
                    } else if (i == num.size() - 1) {
                        num.set(i-1,num.get(i-1)+min);
                        num.remove(i);
                        break;
                    }
                }
            }
            min = (int)1e9;
            for (int i = 0; i < num.size(); i++) {
                min = Math.min(min,num.get(i));
            }
        }

        for (int i = 0; i < num.size(); i++) {
            System.out.print(num.get(i)+ " ");
        }
    }

    @Test
    public void 走迷宫(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] startend = new int[4];
        int[][] g = new int[n+1][m+1];
        int[][] status = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(status[i],-1);
            for (int j = 1; j <= m; j++) {
                g[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < 4; i++) {
            startend[i] = scan.nextInt();
        }
        bfs(startend[0],startend[1],startend,g,status);
        if(!flag)System.out.println(-1);
    }

    public static void bfs(int x,int y,int[] startend,int[][] g,int[][] status){
        Queue<int[]> queue = new LinkedList<>();
        status[x][y] = 0;
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<=0 || a>=g.length || b<=0 || b>=g[0].length) continue;
                if(g[a][b] != 1)continue;
                if(status[a][b] >= 0)continue;//原点也不能走  大于等于0不能走

                queue.add(new int[]{a,b});
                status[a][b] = status[x][y] + 1;
//                System.out.println(a+","+b+"的边为:"+status[a][b]);
//                System.out.println("对头元素："+queue.peek()[0] +" "+queue.peek()[1]);

                if(a == startend[2] && b == startend[3]){
                    System.out.println(status[a][b]);
                    flag =true;
                    return;
                }
            }
        }
    }


    @Test
    public void 奇偶排序(){
        int n = scan.nextInt();
        int[] num = new int[n];
        ArrayList<Integer> ji = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
            if(num[i]%2!=0){
                ji.add(num[i]);
            }else ou.add(num[i]);
        }
        Collections.sort(ji,((o1, o2) -> o1-o2));
        Collections.sort(ou,((o1, o2) -> o1-o2));
        for (int i = 0; i < ou.size(); i++) {
            ji.add(ou.get(i));
        }
        for (int i = 0; i < ji.size(); i++) {
            System.out.print(ji.get(i)+" ");
        }
    }

    /**
     Integer.toBinaryString转二进制串
     */
    @Test
    public void 霓虹(){
        //二进制异或
//        int[] light = {0b1110111,0b0010010,0b1011101,0b1011011,0b01111010,
//                        0b1101011,0b1101111,0b1010010,0b1111111,0b1111011};
//        String start = scan.nextLine();
//        String end = scan.nextLine();
//        int sum=0;
//        for (int i = 0; i < start.length(); i++) {
//            String binaryString = Integer.toBinaryString(light[start.charAt(i) - '0'] ^ light[end.charAt(i) - '0']);
//            for (int j = 0; j < binaryString.length(); j++) {
//                if(binaryString.charAt(j)=='1'){
//                    sum++;
//                }
//            }
//        }
//        System.out.println(sum);

        String[] light = {"1110111","0010010","1011101","1011011","01111010",
                          "1101011","1101111","1010010","1111111","1111011"};
        String start = scan.nextLine();
        String end = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < start.length(); i++) {
            for (int j = 0; j < 7; j++) {
                if(light[(start.charAt(i)-'0')].charAt(j)!=light[(end.charAt(i)-'0')].charAt(j))sum++;
            }
        }
        System.out.println(sum);
    }

    /**

5
2 4 4 6 8

     */
    @Test
    public void 可结合的元素对(){
        int n = scan.nextInt();
        int[] arr = new int[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 1; i < n; i++) {
//            for (int j = i+1; j <= n; j++) {
//                if(lowbit(arr[i]+arr[j])==(arr[i]+arr[j])){
//                    count++;
//                    System.out.println(i+" "+j);
//                }
//            }
//        }
//        System.out.println(count);


        for (int i = 1; i <= n; i++) {
            //2^32 10^9
            //找数组中 满足 ai + aj = 2^k 的ai,aj的对数
            //            aj = 2^k - ai
            //先把ai加到map中去 在map中找是否存在aj使得ai + aj = 2^k，若存在count++
            //因为ai aj 都是arr[]中的元素   所以找A+B=C的个数AB对  即为在arr[]找B=C-A出现的次数

            for (int j = 1; j < 32; j++) {
            count += map.getOrDefault((1 << j)- arr[i],0);
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);//更新arr[i]出现的次数
        }

        for (Map.Entry<Integer,Integer> empty : map.entrySet()) {
            System.out.println(empty.getKey()+" "+ empty.getValue());
        }

        System.out.println(count);



//        System.out.println(lowbit(10));
        scan.close();
    }

    public static long lowbit(long x){//判断x最小位上1的数字
        int quan=0;
        while (x>0){
            if(x%2==0){//偶数
                x/=2;
                quan++;
            }else return (long) Math.pow(2,quan);
        }
        return (long) Math.pow(2,quan);
    }


    @Test
    public void 二进制王国(){
      int n = scan.nextInt();
//      String[] liststr = new String[n];
//        for (int i = 0; i < n; i++) {
//            String str = scan.next();
//            liststr[i] = str;
//        }
//        Arrays.sort(liststr);
//        for (int i = 0; i < liststr.length; i++) {
//            System.out.print(liststr[i]);
//        }

        ArrayList<String> list = new ArrayList<>();
//        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = scan.next();
            list.add(str);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
//            stringBuilder.append(list.get(i));
            System.out.print(list.get(i)+"");
        }

        scan.close();
    }

    @Test
    public void djwcb(){
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int p = scan.nextInt();
//            int ans = quickPow(x,p,10);
            int ans = pow(x,p,10)%10;
            System.out.println(ans);
        }
    }

    public static int quickPow(int x ,int p ,int mod){
        if(x ==0)return 0;
        if(x==1 || p==0) return 1;
        x = x%mod;
        int c= quickPow(x,p/2,mod);
        if(p%2==1)return c * c%mod * x%mod;
        else return c * c%mod;
    }
    public static int pow(int a,int n,int p){
        if(a == 0)  return 0;
        if(a==1 || n == 0)  return 1;
        int res = 1;//连乘器
        while (n > 0){
            if (n%2==1) {//n为奇,即权位为1
                res *= a%p;
            }
            a *=a%p;//底数倍增
            n >>=1;//指数除2
        }
        return res%p;
    }





    @Test
    public void test(){
        System.out.println("递归"+ quickPow(2,31,(long)1e6));
        System.out.println("不递归"+ quicklyPow(2,31,(long)1e6));
    }


}
