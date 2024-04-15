package 蓝桥杯._codeAC;
import java.util.*;

import javafx.util.Pair;
import org.junit.Test;
public class Main {
    Scanner scan = new Scanner(System.in);
    static int count = 0;
    static boolean flag = false;
    static int min = (int)1e9;
    static int max = 0;
    static int[] dx = {-1,0,1,0};//向量坐标
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        scan.close();
    }

    /**
     821
     */
    @Test
    public void 跳台阶(){
        int n = scan.nextInt();//棋盘大小
        System.out.println(fx(n));
    }
    public static int fx(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return fx(n-1) + fx(n-2);
    }

    /**
     1114
     */
    @Test
    public void 棋盘问题(){
        while (!scan.hasNext("-1")) {
            count = 0;
            int n = scan.nextInt();
            int k = scan.nextInt();
            char[][] g = new char[n][n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = scan.next().toCharArray();
                scan.nextLine();
            }
            dfs(0,n,k,g,v,0);
            System.out.println(count);
        }

    }

    /**
     1114   棋盘问题
     * @param x     当前行
     * @param n     棋盘大小
     * @param k     摆放总棋子数
     * @param g     地图
     * @param v     状态
     * @param num   当前所下棋子数
     */
    public static void dfs(int x ,int n,int k,char[][] g,int[] v,int num){
        if(num == k){
            count++;
            return;
        }
        if(x>=n) return;

        for (int i=0;i<n;i++) {//i  当前列
            if(v[i]==0 && g[x][i]=='#'){//状态用i列判断
                v[i]=1;
                dfs(x+1,n,k,g,v,num+1);
                v[i]=0;
            }
        }
        dfs(x+1,n,k,g,v,num);//下一行访问
    }

    /**
     5 5
     0 1 0 0 0
     0 1 0 1 0
     0 0 0 0 0
     0 1 1 1 0
     0 0 0 1 0

     8
     从左上到右下的最小移动次数
     */
    @Test
    public void 走迷宫(){
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] g = new int[n+1][m+1];
        int[][] dist = new int[n+1][m+1];//存每个点到起点的距离
        int[][] pair = new int[n+1][m+1];//存坐标
        Queue<int[]> queue = new LinkedList<>();
//        Pair<Integer, Integer> pair = new Pair<>(1,1);

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i],-1);//初始化数组距离为-1
            for (int j = 1; j <= m; j++) {
                g[i][j] = scan.nextInt();
            }
        }

        bfs(1,1,n,g,dist,pair,queue);

    }

    public static void bfs(int x,int y,int n,int[][] g,int[][] dist,int[][] pair,Queue<int[]> queue){
        //x,y当前坐标
        queue.add(new int[]{x,y});
        dist[x][y] = 0;//距离即步数  开始在起点还没走
        while (!queue.isEmpty()){//判断是否不为空
            x = queue.peek()[0];
            y = queue.peek()[1];//获取队头当前坐标
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int a = x +dx[i];
                int b = y +dy[i];
                if(a<=0 || a>n || b<=0 || b>n)continue;
                if(g[a][b] !=0) continue;//可走
                if(dist[a][b]>=0) continue;//到过了 初始全为-1

                queue.add(new int[]{a,b});
                dist[a][b] = dist[x][y]+1;
//                System.out.println(a+","+b+"的边为:"+dist[a][b]);
//                System.out.println("对头元素："+queue.peek()[0] +" "+queue.peek()[1]);

                if(a==n && b==dist[0].length-1){
                    System.out.println(dist[a][b]);
                    return;
                }

            }
        }
    }

}
