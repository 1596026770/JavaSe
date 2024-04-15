package 蓝桥杯._code洛谷;

import java.util.*;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

public class Main {
    static Scanner scan = new Scanner(System.in);
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
     P1706
     */
    @Test
    public void 全排列问题(){
        int n =scan.nextInt();
        int [] v = new int[n+1];//v[i] = 1表示选过了  0表示还没选过
        int[] ans = new int[n+1];
        dfs(1,n,v,ans);

    }

    /**
     P1706
     x表示当前枚举到哪个位置
     */
    public static void dfs(int x,int n, int[] v,int[] ans){
//        x表示当前枚举到哪个位置  n   表示对n全排列
        if(x > n){
            for (int i = 1; i <= n; i++) {
                System.out.printf("%5d",ans[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
           if(v[i] == 0 ) {
               v[i] = 1;
               ans[x] = i;
               dfs(x+1,n,v,ans);
               v[i] =0;
               //移出最末尾的值
               ans[x] = 0;
           }
        }
    }

    /**
     P3623
     */
    @Test
    public void 枚举排列(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        int [] v = new int[n+1];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(n,k,v,ans);
    }
    /**
     P3623
     */
    public static void dfs(int n,int k,int[] v,ArrayList<Integer> ans){
        if(k == ans.size()){
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i)+ " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if(v[i] == 1) continue;
            ans.add(i);
            v[i] = 1;
            dfs(n,k,v,ans);
            v[i] =0;
            //移出最末尾的值
            ans.remove(ans.size() -1);
        }
    }

    /**
     P1157
     */
    @Test
    public void 组合的输出(){
        int n = scan.nextInt();
        int r = scan.nextInt();
        int[] ans = new int[r+1];//从第一个位置开始放
        combination(1,1,n,r,ans);
    }
    /**
     * @param x     当前位置
     * @param start     开始枚举位置
     */
    public static void combination(int x, int start, int n, int r, int[] ans){

        if(x > r){//说明装满了
            for (int i = 1; i <= r; i++) {
                System.out.printf("%3d",ans[i]);
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {//判断选第i个数
            ans[x] = i;
            combination(x+1,i+1,n,r,ans);//从i+1开始选，一定比i大
            ans[x] = 0;
        }
    }

    /**
     * P1036
     */
    @Test
    public  void 选数(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> sumlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[] ans = new int[k];//k
        int count = 0;
        dfs(0,0,arr,k,ans,sumlist);
        for (int i = 0; i < sumlist.size(); i++) {
//            System.out.print(sumlist.get(i) + " ");
            if(prime(sumlist.get(i))) count++;
        }
        System.out.println(count);
    }

    /**
     * P1036
     * 注意：开数组的时候要按要求给大小，不能给过大，用多少给多少，原因：结束条件是ans.length 或者可以把n传进来
     * @param x     当前第几个位置 0开始
     * @param start 开始位置
     * @param arr   存放题目所给数字
     * @param k     选取k个数
     * @param ans   存放选取的数字
     * @param sumlist   将选取数字求和放入list
     */
    public static void dfs(int x, int start, int[] arr, int k,int[] ans,ArrayList<Integer> sumlist){
        if(x + arr.length - start  < k)  return;//剪枝
        if(x >= k){
            int sum = 0;
            for (int i = 0; i < ans.length; i++) {
//                System.out.printf("%3d",ans[i]);
                sum += ans[i];
            }
//            System.out.println();
            //可以直接在这判断是否为素数，然后定义一个全局变量count ++,然后输入,可以少开一个sumlist节省空间
            sumlist.add(sum);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            ans[x] = arr[i];
            dfs(x+1,i+1,arr,k,ans,sumlist);
            ans[x] = 0;
        }
    }

    public static boolean prime(int n){
        if(n<=1)   return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n %i ==0){//5%2 =2 10%2==0
                return false;
            }
        }
        return true;
    }

    /**
     P2089
     */
    @Test
    public void 烤鸡(){
        int n = scan.nextInt();
        int[] ans = new int[10];
//        List<int[]> res = new ArrayList<>();//存放方案数，最多3^10种 10个位置 每个位置最多三种
        int[][] res = new int[59055][10];
        if(n<10 || n >30) {
            System.out.println(0);
            return;
        } else dfsChicken(1,0,n,ans,res);
        System.out.println(count);

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     P2089
     */
    public static void dfsChicken(int x,int sum,int n,int[] ans,int[][] res){
        if(sum > n || sum + (10-(x-1))*3 < n) return;
        if(x > 10){
            if (sum == n) {
                for (int i = 0; i < 10; i++) {
//                    System.out.print(ans[i] + " ");
                    res[count][i] = ans[i];
                    //因为题目输出要求，先输出方案数count，再输出方案，在dfs中不能输出，所以用ans存每一种配料的质量，再将所有方案放入res中
                }
//                System.out.println();
                count++;

            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            ans[x-1] = i;
            sum +=i;
            dfsChicken(x+1,sum,n,ans,res);
            ans[x-1] = 0;
            sum -=i;
        }
    }

    /**
     P1088  数据样例2 栈溢出
     */
    @Test
    public void 火星人(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] v = new int[n+1];
        int[] ans = new int[n+1];
        int[] mars = new int[n+1];
        for (int i = 1; i <= n; i++) {
            mars[i] = scan.nextInt();
        }
        dfs(1,n,m,v,mars,ans);
    }

    /**
     * 火星人
     * @param x     当前位置
     * @param n     对n全排列
     * @param m     加上的一个数
     * @param v     各个数的状态选没选 0:没选 1:选了
     * @param mars  火星人给出的初始数字
     * @param ans   存放结果数组
     */
    public static void dfs(int x,int n,int m, int[] v,int [] mars,int[] ans){
        if(flag)  return;
        if(x > n){  // x表示当前枚举到哪个位置
            count++;
            if (count == m + 1) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(ans[i]+ " ");
                }
//                System.out.println();
                flag = true;
            }
            return;//不管找没找到，当x>n进来count++后都应该结束，即上面if要结束else也应当结束
        }
        for (int i = 1; i <= n; i++) {
            if(count == 0)  i = mars[x];//从火星人给的数字往后遍历
            if(v[i] == 0 ) {
                v[i] = 1;
                ans[x] = i;
                dfs(x+1,n,m,v,mars,ans);
                v[i] =0;//恢复现场
                ans[x] = 0;
            }
        }

    }

    /**
     P1149
     */
    @Test
    public void 火柴棒(){
        int n = scan.nextInt();
//        int[] hcb = {6,2,5,5,4,5,6,3,7,6};//10个数所需要的火柴棒：6 2 5 5 4 5 6 3 7 6
        int[] hcb = new int[1000];//10个数所需要的火柴棒：6 2 5 5 4 5 6 3 7 6
        hcb[0]=hcb[6]=hcb[9]=6;
        hcb[2]=hcb[3]=hcb[5]=5;
        hcb[1]=2;hcb[4]=4;hcb[7]=3;hcb[8]=7;
        for (int i = 10; i < 1000; i++) {//将计算结果放到数组中可以直接过10000的数据，如果用compute函数过不了10000最后一个测试会超时
            hcb[i] = hcb[i%10] + hcb[i/10];
        }
        int[] arr = new int[3];
        int sum=4;//当前所用火柴棒
        dfs(0,n,sum,hcb,arr);
        System.out.println(count);
    }

    /**
     *
     * @param x     当前位置0开始
     * @param n     火柴棒数
     * @param sum   当前所用火柴棒数
     * @param hcb   0~9数字所用火柴棒数
     * @param arr   存结果数组
     */
    public static void dfs(int x,int n,int sum,int[] hcb,int[] arr){
        if(sum > n || (x==3 && sum != n)) return;//剪枝
        if(x >= 3 ){
            if (arr[0] + arr[1] == arr[2] && sum==n) {//A + B = C
//                System.out.print(arr[0]+" "+arr[1]+" "+arr[2]);
//                System.out.println();
                count++;
            }
            return;
        }
        for (int i = 0; i < 1000; i++) {//计算20根火柴棒能组成的最大数设为最值
            if(sum + hcb[i] <= n){
                arr[x] = i;
                dfs(x+1,n,sum +hcb[i],hcb,arr);//如果用compute计算每个数所用火柴棒数：sum= sum+compute(i,hcb)
                arr[x] =0;
            }
        }
    }

    /**
     计算一个数需要用多少火柴棒
     * @param n     数
     * @param hcb   火柴棒数组
     * @return
     */
    public static int compute(int n,int[] hcb){
        if(n>=0 && n<=9){
            return hcb[n];
        }
        int sum=0;
        while (n > 0){
            sum +=hcb[n%10];
            n /=10;
        }
        return sum;
    }

    /**
     PERKET     P2036
     */
    @Test
    public void PERKET(){
        int n = scan.nextInt();
        int[][] sb = new int[n][2];
        int[] v = new int[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            sb[i][0] = scan.nextInt();
            sb[i][1] = scan.nextInt();
            arr[i][0]=1;
        }
        dfs(0,n,sb,v,arr);
        System.out.println(min);
    }

    public static void dfs(int x,int n,int[][] sb,int[] v,int[][] arr){
        flag =false;
        if(x >= n ){
            int s=1,b=0;
            for (int i = 0; i < n; i++) {
                if (v[i] ==1) {//只乘加选的
                    flag = true;
                    s*=arr[i][0];
                    b+=arr[i][1];
//                    System.out.print("选了");
//                    System.out.print(i +" ");
                }
            }
//            System.out.println();
            if(flag)
                min =  Math.min(min,Math.abs(s-b));
            return;
        }
        //不需要遍历，x就在增加   不要与排列弄混
        //选
        arr[x][0]=sb[x][0];
        arr[x][1]=sb[x][1];
        v[x] = 1;//改变当前位置的状态，是x，不是i，i是因为判断数选没选，现在判断当前位置选没选
        dfs(x+1,n,sb,v,arr);

        //不选
        arr[x][0]=1;
        arr[x][1]=0;
        v[x]=0;
        dfs(x+1,n,sb,v,arr);

    }

    /**
     P1135  不能通过所有数据
     */
    @Test
    public void 奇怪的电梯(){
        int n = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int[] v = new int[n+1];
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }
        dfs(a,n,a,b,v,arr);
        if(min == (int)1e9)
            System.out.println(-1);
        else System.out.println(min);
    }

    /**
     *
     * @param x     当前位置
     * @param a     起点位置
     * @param b     终点位置
     * @param arr   电梯数组
     */
    public static void dfs(int x,int n,int a,int b,int[] v,int[] arr){
//        if(flag) return;
//        flag = false;
        if(x<=0 || x>n) return;
        if(count > min) return;
        if(x == b){
//            System.out.println(count);
//            flag = true;
            min = Math.min(min,count);
            return;
        }
        //上
        if (x+arr[x] <= n && v[x+arr[x]]==0) {//找没走过的走
            x+=arr[x];
            v[x]=1;
            count++;
            dfs(x,n,a,b,v,arr);
            v[x]=0;
        }

        //下
        if (x-arr[x] >0 && v[x-arr[x]]==0) {
            x-=arr[x];
            v[x]=1;
            count++;
            dfs(x,n,a,b,v,arr);
            v[x]=0;
        }

    }

    /**
     P1683
     */
    @Test
    public void 入门(){
        int w = scan.nextInt();
        int h = scan.nextInt();
        int[][] v = new int[h][w];
        char[][] arr = new char[h+1][w+1];//h行w列
        for (int i = 0; i < h; i++) {
            char[] chars = scan.next().toCharArray();
            scan.nextLine();//吸回车
            for (int j = 0; j < chars.length; j++) {//最后有个回车
                arr[i][j] = chars[j];
                if(chars[j] == '@'){
                    mapx =i;mapy=j;
                }
            }
        }
//        dfs(1,mapx,mapy,w,h,arr,v);
        dfs入门优化(mapx,mapy,arr,v);
        System.out.println(count+1);//count初值为0，@算第一步没加
    }


    public static void dfs(int step,int x, int y ,int w,int h,char[][] arr,int[][] v) {
        //x,y当前横纵坐标     x向下 y向右（x行y列）
        if(x>=h || x<0 || y<0 || y>=w)  return;
        //上
        if (x - 1 >= 0 && arr[x - 1][y] == '.' && v[x - 1][y] == 0) {//没走过
            v[x - 1][y] = 1;
            count++;
            dfs(step + 1, x - 1, y, w, h, arr, v);
        }

        //下
        if (x + 1 < h && arr[x + 1][y] == '.' && v[x + 1][y] == 0) {//没走过
            v[x + 1][y]=1;
            count++;
            dfs(step + 1, x + 1, y, w, h, arr, v);
        }
        //左
        if (y - 1 >= 0 && arr[x][y - 1] == '.' && v[x][y - 1] == 0) {//没走过
            v[x][y - 1]=1;
            count++;
            dfs(step + 1, x ,y-1, w, h, arr, v);
        }
            //右
        if (y + 1 < w && arr[x][y + 1] == '.' && v[x][y + 1] == 0) {//没走过
            v[x][y + 1]=1;
            count++;
            dfs(step + 1, x ,y+1, w, h, arr, v);
        }
    }

    /**
     P1683
     */
    public static void dfs入门优化(int x,int y,char[][] arr,int[][] v){//h行w列
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];//当前坐标 + 向量坐标     x行y列
            int b = y + dy[i];

            if(a<0 || a>=arr.length-1 || b<0 || b>arr[i].length-1 ) continue;//不能return
            if(arr[a][b] != '.')    continue;//只走点
            if(v[a][b] != 0)    continue;//只走点 且 没走过

            v[a][b]=1;
            count++;
            dfs入门优化(a,b,arr,v);
        }
    }

    /**
     P1596  两个数据栈爆了
     */
    @Test
    public void Lake(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] g = new char[n+10][m+10];
        int[][] v = new int[n+10][m+10];
        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        for (int i = 0; i < n; i++) {
            g[i] = scan.next().toCharArray();//因为\n被下一行吸取了，所以不会溢出
            scan.nextLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(g[i][j]+" ");
                if(g[i][j] == 'W' && v[i][j]==0){
                    v[i][j] = 1;//注意最开始的那个状态要更改
                    dfs(i,j,n,m,dx,dy,g,v);
                    count++;
                }
            }
//            System.out.println();
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y ,int n,int m,int[] dx ,int[] dy,char[][] g,int[][] v){//最好不要用length，传入参数进来
        for (int i = 0; i < 8; i++) {
            int a = x + dx[i],b = y + dy[i];
            if(a<0 || a>= n || b<0 || b>=m) continue;
            if(g[a][b] !='W')   continue;
            if(v[a][b] != 0)    continue;

            v[a][b] = 1;
            dfs(a,b,n,m,dx,dy,g,v);
        }
    }

    /**
     P1025
     */
    @Test
    public void 数的划分(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[k+1];
        dfs(1,n,k,1,0,arr);
        System.out.println(count);
    }

    public static void dfs(int x,int n,int k,int start,int sum,int[] arr){
        if(sum > n) return;
        //x当前位置     sum:和
        if(x > k){//x==k时为最后一个，如果等于k return; arr[k]还没赋值
            if (sum == n) {
                for (int i = 1; i <= k; i++) {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
                count++;
            }
            return;
    }                                              //前面的和   后面的数*最少从x的位置i枚举 <= n
        for (int i = start;(k-x+1)*i <= n-sum; i++) {//只用枚举到 sum + (k-x)*i <= n 此处会有x==k的情况，所以使x=k+1 让前面的if提前return掉
            arr[x] = i;
            dfs(x+1,n,k,i,sum+i,arr);//从i开始,如果从1开始肯定会有与上面相同的
            arr[x]=0;
        }
    }

    /**
     有问题
     P1019
     */
    @Test
    public void 单词接龙(){
        int n = scan.nextInt();
        String[] words = new String[n];
        int[] v = new int[n];//使用次数 0 1 2
        int[][] g = new int[n][n];//g[i]单词能否接到g[j]单词后面，存的是重合长度

        for (int i = 0; i < n; i++) {
            words[i] = scan.next();
            scan.nextLine();
            System.out.print(words[i] + " ");
        }
        char start = scan.next().charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String a = words[i],b = words[j];//substring()左闭右开
                for (int k = 1; k < Math.min(a.length(), b.length()); k++) {//从1开始，不能包含 min:
                    if(a.substring(a.length() - k).equals(b.substring(0, k))){//a单词的尾与b单词的头相等  b接a后面
                        g[i][j] = k;
                        break;//找最长即重叠最少
                    }
                }
//                System.out.print(g[i][j]+" ");
            }
//            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if(words[i].charAt(0) == start){
//                v[i]++;
                dfs(words[i],i,n,words,v,g);
            }
        }
        System.out.println(max);

    }

    /**
     *
     * @param ans   龙
     * @param x     当前访问到哪个单词
     * @param words
     * @param v
     */
    public static void dfs(String ans,int x,int n,String[] words,int[] v,int[][] g){
        //g[i][j]   j单词接i单词后 重叠的长度
        max = Math.max(max,ans.length());
        if(ans.length()==max) System.out.println(ans);
        v[x]++;
        for (int i = 0; i < n; i++) {
           if(g[x][i]>0 && v[x]<2){
               dfs(ans + words[x].substring(g[x][i]),i,n,words,v,g);
           }
        }
        v[x]--;
    }

    /**
     P1746
     */
    @Test
    public void 离开山中的路(){
        int n = scan.nextInt();
        int[] startend = new int[4];
        int[][] g = new int[n+1][n+1];
        int[][] status = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(status[i],-1);
            String s = scan.next();
            scan.nextLine();
            for (int j = 0; j < s.length(); j++) {
                g[i][j+1] = s.charAt(j)-'0';
            }
        }
        for (int i = 0; i < 4; i++) {
            startend[i] = scan.nextInt();
        }
        bfs(startend[0],startend[1],startend,g,status);
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

                if(a<=0 || a>=g.length || b<=0 || b>=g.length) continue;
                if(g[a][b] != 0)continue;
                if(status[a][b] >= 0)continue;//原点也不能走  大于等于0不能走

                queue.add(new int[]{a,b});
                status[a][b] = status[x][y] + 1;
//                System.out.println(a+","+b+"的边为:"+status[a][b]);
//                System.out.println("对头元素："+queue.peek()[0] +" "+queue.peek()[1]);

                if(a == startend[2] && b == startend[3]){
                    System.out.println(status[a][b]);
                    return;
                }
            }
        }
    }

    /**
     P1443
     */
    @Test
    public void 马的遍历(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        int startx = scan.nextInt();
        int starty = scan.nextInt();
        bfs(startx,starty,n,m);
    }

    public static void bfs(int x,int y,int n,int m){
        int[][] status = new int[n+1][m+1];
        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < status.length; i++) {
            Arrays.fill(status[i],-1);
        }
        status[x][y] = 0;
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 8; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<=0 || a>n || b<=0 || b>m)continue;
                if(status[a][b]>=0)continue;
                queue.add(new int[]{a,b});
                status[a][b] = status[x][y] + 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(status[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     P1332
     */
    @Test
    public void 血色先锋队(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        bfs1332(n,m);
    }

    public static void bfs1332(int n,int m){
        int u = scan.nextInt();//感染源
        int v = scan.nextInt();//领主
        int[][] uxy = new int[u+1][2];
        int[][] vxy = new int[v+1][2];
        int[][] stutus = new int[n+1][m+1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(stutus[i],-1);
        }
        for (int i = 1; i <= u; i++) {
            uxy[i][0] = scan.nextInt();
            uxy[i][1] = scan.nextInt();
            queue.add(uxy[i]);//入队列
            stutus[uxy[i][0]][uxy[i][1]] = 0;
        }

        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<=0 || a>n || b<=0 || b>m)continue;
                if(stutus[a][b] >= 0)continue;

                queue.add(new int[]{a,b});
                stutus[a][b] = stutus[x][y] + 1;
            }
        }
        for (int i = 1; i <= v; i++) {
            vxy[i][0] = scan.nextInt();
            vxy[i][1] = scan.nextInt();
            System.out.println(stutus[vxy[i][0]][vxy[i][1]]);
        }
    }

    /**
     P1162
     */
    @Test
    public void 填涂色块(){
        int n = scan.nextInt();
        int[][] g = new int[n+2][n+2];//一圈全部包围需要n+2
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = scan.nextInt();
            }
        }
        bfs1162(0,0,n,g);//从边界开始

    }

    public static void bfs1162(int x ,int y,int n,int[][] g){
        int[][] status = new int[n+2][n+2];
        Queue<int[]> queue = new LinkedList<>();
        status[x][y] = 1;//外面的状态置为1
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<0 || a>n+1 || b<0 || b>n+1)continue;
                if(g[a][b] !=0)continue;
                if(status[a][b] !=0)continue;
                //改变外面的0状态
                status[a][b] = 1;
                queue.add(new int[]{a,b});

            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(g[i][j]==0 && status[i][j]==0){
                    g[i][j] = 2;
                }
                    System.out.print(g[i][j]+ " ");
            }
            System.out.println();
        }
    }

    /**
     P2895
     踩坑点： 1.数组初始化要在最开始，不然上一行向下拓展的焦土会被初始化覆盖
            2.bfs中判断贝茜是否安全跑出焦土时，用dist[x][y]+1而非ab，此时ab还未赋值
     */
    @Test
    public void 流星雨(){
        int m = scan.nextInt();
        int[][] g = new int[310][310];//t时刻地图状态 记录当前坐标在t时刻前为安全的
        int[][] dist = new int[310][310];//贝茜走(x,y)的时刻
        //流星及焦土全部计算好了
        for (int i = 0; i < g.length; i++) {//如果在下面循环中初始化，可能会把流星下一行的焦土覆盖为max
            Arrays.fill(dist[i],-1);
            Arrays.fill(g[i],1010);
        }
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int t = scan.nextInt();
            g[x][y] = Math.min(t,g[x][y]);//更新流星
            for (int j = 0; j < 4; j++) {
                int a = x + dx[j];//流星拓展范围
                int b = y + dy[j];
                if(a<0 || a>301 || b<0 || b>301)continue;//301焦土也能覆盖
                g[a][b] = Math.min(t,g[a][b]);//更新焦土    当相同位置落入多个流星或者焦土覆盖到时，取最早的时间
            }
        }
        bfs2895(g,dist);
    }

    public static void bfs2895(int[][] g,int[][] dist){
        Queue<int[]> queue = new LinkedList<>();
        dist[0][0] = 0;
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<0 || b<0)continue;
                if(dist[x][y] + 1 >= g[a][b])continue;//只是当前路没跑出来，其他路可能能跑出来 注意加一！！！这里时xy dist[a][b]还没赋值
                if(dist[a][b]>=0)continue;

                dist[a][b] = dist[x][y] + 1;
                queue.add(new int[]{a,b});

                if(g[a][b] >= 1010){//流星提前判断完了
                    System.out.println(dist[a][b]);
                    return;
                }

            }
        }
        System.out.println(-1);

    }

    /**
     P1747
     */
    @Test
    public void 好奇怪的游戏(){
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        bfs1714(x1,y1);
        bfs1714(x2,y2);
    }

    public static void bfs1714(int x,int y){
        int[][] dist = new int[22][22];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-2,-1,1,2,2,1,-1,-2,2,2,-2,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1,2,-2,2,-2};
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i],-1);
        }

        dist[x][y] = 0;
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 12; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<1 || a>20 || b<1 || b>20)continue;
                if(dist[a][b] > 0)continue;

                dist[a][b] = dist[x][y] +1;
                queue.add(new int[]{a,b});

                if(a==1 && b==1){
                    System.out.println(dist[a][b]);
                    return;
                }
            }
        }

    }

    /**
     P2385
     */
    @Test
    public void 莲花池(){
        int m = scan.nextInt();
        int n = scan.nextInt();
        int m1 = scan.nextInt();
        int m2 = scan.nextInt();
        bfs2385(m,n,m1,m2);

    }

    public static void bfs2385(int m,int n,int m1,int m2){
        int[][] g = new int[m+5][n+5];
        int[][] dist = new int[m+5][n+5];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {m1,m1,-m1,-m1,m2,m2,-m2,-m2};
        int[] dy = {m2,-m2,m2,-m2,m1,-m1,m1,-m1};
        for (int i = 1; i <= m; i++) {
            Arrays.fill(dist[i],-1);
            for (int j = 1; j <= n; j++) {
                g[i][j] = scan.nextInt();
                if (g[i][j] == 3) {
                    dist[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 8; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<=0 || a>m || b<=0 || b>n)continue;
                if(g[a][b]!=1 && g[a][b]!=4)continue;
                if(dist[a][b]>=0)continue;

                dist[a][b] = dist[x][y] + 1;
                queue.add(new int[]{a,b});

                if(g[a][b] == 4){
                    System.out.println(dist[a][b]);
                    return;
                }

            }
        }

    }

    /**
     P1506
     避坑点：   1.注意输入scan.next()后吸回车
              2.字符数组char[]的默认值为：空格
     */
    @Test
    public void 拯救oibh总部(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] g = new char[n+2][m+2];
        for (int i = 0; i < g.length; i++) {
            Arrays.fill(g[i],'0');
        }
        for (int i = 1; i <= n; i++) {
            char[] chars = scan.next().toCharArray();
            scan.nextLine();
            for (int j = 0; j < chars.length; j++) {
                g[i][j+1] = chars[j];
            }
        }
        bfs1506(n,m,g);
        System.out.println(count);
    }

    public static void bfs1506(int n,int m,char[][]g){
        int[][] status = new int[n+2][m+2];
        Queue<int[]> queue = new LinkedList<>();

        status[0][0] = 1;
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<0 || a>n+1 || b<0 || b>m+1)continue;
                if(g[a][b]!='0')continue;
                if(status[a][b]!=0)continue;

                status[a][b] = 1;
                queue.add(new int[]{a,b});
            }
        }

        for (int i = 0; i <= n+1; i++) {
            for (int j = 0; j <= m+1; j++) {
                if(g[i][j]=='0' && status[i][j]==0){
                    count++;
                }
//                System.out.print(status[i][j]+" ");
//                System.out.print(g[i][j]+" ");
            }
//            System.out.println();
        }
    }

    /**
     P3395
     坑点：路障数组g[]要开到2000不能开到1010
            单独判断n为1的情况
     */
    @Test
    public void 路障(){
        int[][] g = new int[2000][2000];
        int[][] dist = new int[1010][1010];

        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            for (int k = 1; k < g.length; k++) {//重置位置应在输入每一组组数据后
                Arrays.fill(g[k],2010);
                // Arrays.fill(dist[k],-1);
            }
            for (int k = 1; k <= 1000; k++) {//重置位置应在输入每一组组数据后
                // Arrays.fill(g[k],1010);
                Arrays.fill(dist[k],-1);
            }
            int n = scan.nextInt();
            for (int j = 1; j <= 2 * n - 2; j++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                g[x][y] = Math.min(j,g[x][y]);
            }
            if(n==1){
                System.out.println("Yes");
            }else {
                bfs3395(n,g,dist);
            }
        }

    }
    public static void bfs3395(int n,int[][] g,int[][] dist){
        Queue<int[]> queue = new LinkedList<>();

        dist[1][1]=0;
        queue.add(new int[]{1,1});

        while (!queue.isEmpty()){//重置
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<1 || a>n || b<1 || b>n)continue;
                if(dist[x][y]+1 > g[a][b])continue;
                if(dist[a][b]>=0)continue;

                dist[a][b] = dist[x][y] +1;
                queue.add(new int[]{a,b});

                if(a==n && b==n){
                    System.out.println("Yes");
                    return;
                }
            }
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(g[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println("No");
    }

    /**
     P2658
     注意：内存处于临界边缘    尽量减少变量使用
     */
    @Test
    public void 汽车拉力比赛(){
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] hight = new int[m+2][n+2];//海拔
        int[][] signpost = new int[m+2][n+2];//路标
        int[][] status = new int[m+2][n+2];//路标是否访问过
        int signum = 0;//路标总数
        int left =0,right=(int)1e9;//从0开始  right=1e9减少
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                hight[i][j] = scan.nextInt();
//                if(right < hight[i][j]){
//                    right = Math.max(right,hight[i][j]);
//                }
//                System.out.print(hight[i][j]+" ");
            }
//            System.out.println();
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                signpost[i][j] = scan.nextInt();
//                System.out.print(signpost[i][j]+" ");
                if(signpost[i][j]==1){
                    if(signum==0){//取第一个路标的坐标
                        mapx=i;
                        mapy=j;
                    }
                    signum++;
                }
            }
//            System.out.println();
        }
        scan.close();

//        bfs2658(m,n,hight,signpost,status,signum,queue,21);
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(status[i][j]+" ");
//            }
//            System.out.println();
//        }

        while (left+1<right){//大于target的首个索引
            int mid = left + (right-left)/2;
            queue.clear();//清空队列及状态
            for (int i = 1; i < status.length; i++) {
                Arrays.fill(status[i],0);
            }
            if(bfs2658(m,n,hight,signpost,status,signum,queue,mid)){//mid越大越容易满足条件
                right = mid;
            }else {
                left = mid;
            }
        }
//        while (left<=right){//内存在溢出边界     测试点7过不去
//            int mid = left + (right-left)/2;
//            queue.clear();//清空队列及状态
//            for (int i = 1; i < status.length; i++) {
//                Arrays.fill(status[i],0);
//            }
//            if(bfs2658(m,n,hight,signpost,status,signum,queue,mid)){//mid越大越容易满足条件
//                right = mid-1;
//            }else {
//                left = mid+1;
//            }
//        }//left
        System.out.println(right);

    }

    public static boolean bfs2658(int m,int n,int[][] hight,int[][] signpost,int[][] status,int signum,Queue<int[]> queue,int mid){
        count = 1;//已访问路标数
//        int mid=0;//期望值
        queue.add(new int[]{mapx,mapy});
        status[mapx][mapy]=1;
        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
//            System.out.println("x:"+x+"y:"+y);
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<1 || a>m || b<1 || b>n)continue;
                if(status[a][b]==1)continue;
                if(Math.abs(hight[a][b]-hight[x][y])>mid)continue;

                status[a][b]=1;
                queue.add(new int[]{a,b});
                if (signpost[a][b]==1) {
                    count++;
                    if(count==signum){
                        return true;
                    }
                }


            }
        }
        return false;
    }

    /**
     P4554
     */
    @Test
    public void 小明的游戏(){
        int startx = 0,starty = 0;
        int endx = 0,endy = 0;
        while (true){
            int n = scan.nextInt();
            int m = scan.nextInt();
            if(n==0 && m==0) break;
            char[][] g = new char[n+1][m+1];
            int[][] dist = new int[n+1][m+1];
            for (int i = 0; i < dist.length; i++) {
                Arrays.fill(dist[i],-1);
            }
            for (int i = 0; i < n; i++) {
                char[] chars = scan.next().toCharArray();
                scan.nextLine();
                for (int j = 0; j < m; j++) {
                    g[i][j] = chars[j];
//                    System.out.print(g[i][j]+" ");
                }
//                System.out.println();
            }
            startx = scan.nextInt();
            starty = scan.nextInt();
            endx = scan.nextInt();
            endy = scan.nextInt();
            int[] se = {startx,starty,endx,endy};
            bfs4554(n,m,g,dist,se);
            n = 500;m=500;
//            System.out.println(startx +" "+starty+" "+endx+" "+endy);
        }
        scan.close();
    }

    public static void bfs4554(int n,int m,char[][] g,int[][] dist,int[] se){
        Deque<int[]> queue = new LinkedList<>();
        dist[se[0]][se[1]] = 0;
        queue.add(new int[]{se[0],se[1]});

        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            char ch = g[x][y];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<0 || a>=n || b<0 || b>m)continue;
                if(dist[a][b]>=0)continue;

                if(g[a][b]!= ch){
                    dist[a][b] = dist[x][y]+1;
                    queue.addLast(new int[]{a,b});

                }else{
                    dist[a][b]=dist[x][y];
                    queue.addFirst(new int[]{a,b});
                }
                if(a==se[2] && b==se[3]){
                    System.out.println(dist[a][b]);
//                    return;
                }
            }
        }
        queue.clear();//重置
    }

    /**
     P1379
     注意：map如果添加已存在的key,后添加的会覆盖先添加的
     双向广搜全部ac
     单向直接空间溢出
     */
    @Test
    public void 八数码难题(){
        String start = scan.nextLine();
        scan.close();
        bfs1379(start);
//        bfs1379("283104765");
    }

    public static void bfs1379(String start){
        String end = "123804765";
        if(start.equals(end)){
            System.out.println(0);
            return;
        }
//        String end = "123456780";
        Queue<String> queue = new LinkedList<>();
        HashMap<String,Integer> dist = new HashMap<>();
        HashMap<String,Integer> map = new HashMap<>();//存每个状态的标记1/2

        dist.put(start,0);
        dist.put(end,0);
        map.put(start,1);
        map.put(end,2);
        queue.add(start);
        queue.add(end);

        while (!queue.isEmpty()){
            StringBuilder s = new StringBuilder(queue.peek());//当前字符串
            int n = dist.get(queue.peek());//当前步数
//            System.out.println(s);
//            if(queue.peek().equals(end)){
//                System.out.println(dist.get(queue.peek()));
//                return;
//            }
            int step = map.get(queue.peek());

            queue.poll();

            int zero = s.indexOf("0");//返回0所在的索引
            int x = zero/3,y = zero%3;

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

//                StringBuilder s1 = new StringBuilder(queue.peek());
                if(a<0 || a>=3 || b<0 || b>=3)continue;

                int tem = a*3 + b;//当前位置与0换位置
                int temnum = s.charAt(tem)-'0';

                s.replace(tem,tem+1,"0");
                s.replace(zero,zero+1, temnum+"");


                //判断是否走过
                if(!dist.containsKey(s.toString())) {
                    dist.put(s.toString(), n + 1);
                    map.put(s.toString(),step);
                    queue.add(s.toString());
                }

                if(step + map.get(s.toString())==3){
                    int res1 = dist.get(s.toString());//交换后
                    s.replace(tem,tem+1,temnum+"");
                    s.replace(zero,zero+1,"0");
                    int res2 = dist.get(s.toString());
                    System.out.println(res1 + res2+1);
                    return;
                }

                s.replace(tem,tem+1,temnum+"");
                s.replace(zero,zero+1,"0");

            }
        }

    }

    /**
     P1035
     */
    @Test
    public void 级数求和(){
        int k = scan.nextInt();
//        Sn1035(1);
        System.out.println(Sn1035(k));

    }

    public static int Sn1035(int k){
        double sum =0;
        int i = 1;
        while (sum <= k){
            sum += Math.pow(i,-1);
            if(sum > k)
                return i;
            i++;
        }
        return i;
    }

    /**
     P1046
     */
    @Test
    public void 陶陶摘苹果(){
        int[] arr = new int[10];
        int count=0;
        for (int i = 0; i < 10; i++) {
            arr[i] = scan.nextInt();
        }
        int hight = scan.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= hight + 30){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     P1047
     */
    @Test
    public void 校门外的树(){
        int l = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[l+1];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            Arrays.fill(arr,start,end+1,1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void 铺地毯(){
        int n = scan.nextInt();
//        int[][] arr = new int[10010][10010];
//        int a,b,x,y;
        int[] a = new int[10010];
        int[] b = new int[10010];
        int[] x = new int[10010];
        int[] y = new int[10010];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();

        for (int i = 0; i < n; i++) {
            if(x1>=a[i] && y1>=b[i] && x1<a[i]+x[i] && y1<b[i]+y[i]){
                ans = i+1;
            }
        }
        System.out.println(ans);

    }

    @Test
    public void 三连击(){
        //i j k 为3 个 3位数
        int[] num = new int[10];//存0-9用没用过0 没有 1 用了
        for (int i = 123; i <= 333; i++) {
            int sum = 0;
            Arrays.fill(num,0);
            num[i%10]++;
            num[i/10%10]++;
            num[i/100]++;
            int j = i*2;
            num[j%10]++;
            num[j/10%10]++;
            num[j/100]++;
            int k = i*3;
            num[k%10]++;
            num[k/10%10]++;
            num[k/100]++;

            if(quan1(num)){
                System.out.println(i+" "+j+" "+k);
            }
        }
    }

    public static boolean quan1(int[] num){
        for (int l = 1; l < num.length; l++) {
            if(num[l]!=1){
                return false;
            }
        }
        return true;
    }

    /**
     P1012
     3
     1 10 100
     正确结果：大到小：110100
     如果不用compareTo  100101
        显然：110100 > 100101
     */
    @Test
    public void 拼数(){
        int n = scan.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scan.next();
//            System.out.println(str[i]);
        }
//        Arrays.sort(str);
        Arrays.sort(str,(o1, o2) -> (o1+o2).compareTo(o2+o1));
        for (int i = n-1; i >= 0; i--) {
            System.out.print(str[i]);
        }
    }

    @Test
    public void 计算器的改良(){
        String str = scan.nextLine();
        int index = str.indexOf("=");
        String left = str.substring(0,index);
        String right = str.substring(index+1,str.length());
        System.out.println(left + " " + right);

    }
















    /**
     P1192
     */
    @Test
    public void 台阶问题(){
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] dp = new int[100000+10];

        if(n<=1 || k==1){
            System.out.println(1);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j >= i-k; j--) {
                if (j>=0) {
                    dp[i]=(dp[i]+dp[j])%100003;
                }
            }
//                dp[i]=dp[i-1]+dp[i-2];
        }

        System.out.println(dp[n]%100003);
    }

    /**
     P1216
     */
    @Test
    public void 数字三角形(){
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scan.nextInt();
//                System.out.print(arr[i][j]+" ");
            }
//            System.out.println();
        }
//        dp[0] = arr[0][0];
//        for (int i = 1; i < n; i++) {
//            int max = 0;
//            int x = 0;//当前列
//            max = Math.max(arr[i][x],arr[i][x+1]);
//            dp[i] = dp[i-1] + Math.max(arr[i][x],arr[i][x+1]);//max
//        }
        int res = dfs1216(0,0,n,arr);
        System.out.println(res);
    }

    public static int dfs1216(int x, int y,int n,int[][] arr){
        if(x>=n || y>=n) return 0;
        //                          要走的                                              当前的
        else return Math.max(dfs1216(x+1,y,n,arr),dfs1216(x+1,y+1,n,arr)) + arr[x][y];
    }


    /**
     2的次方数  位运算判断
     */
    @Test
    public void pow2(){
        //位运算：(n&(n-1))==0 true为2的次方
        //  32 -> 100000 & 011111 <-31
        //             000000
        int inf = (int)1e3;
        for (int i = 1; i < inf; i++) {
            int num = i&(i-1);
            if(num==0){
                System.out.println(i+ " "+num);
//                System.out.println(i+"是2的"+count+"次方数");
                count++;
            }
        }
    }



//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!````````Problem````````!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     有问题！！！
     P1037
     */
    @Test
    public void 产生数() {
        String sn = scan.next();
        int k = scan.next().charAt(0) - '0';
        scan.nextLine();//吸回车
        int[] arr = new int[sn.length()];
        int[][] map = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                map[i][j] = scan.nextInt();
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
            if(i<k-1) scan.nextLine();//吸回车
        }
        for (int i = 0; i < sn.length(); i++) {
            arr[i] = sn.charAt(i) - '0';
        }
        if(k == 0){
            System.out.println(1);
            return;
        }
        dfs(0,arr,sn,map);
//        System.out.println("k:"+ k);
        System.out.println(count/k);
    }

    /**
     *
     * @param x     当前位置
     * @param arr     输入的数
     * @param map     变换规则
     */
    public static void dfs(int x,int[] arr,String sn,int[][] map){
        if(x == sn.length()){
            for (int i = 0; i < sn.length(); i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            count++;
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if(arr[x] == map[i][0]){
                arr[x] = map[i][1];
                dfs(x+1,arr,sn,map);
                arr[x] = map[i][0];
            }else dfs(x+1,arr,sn,map);;
        }
    }

}
