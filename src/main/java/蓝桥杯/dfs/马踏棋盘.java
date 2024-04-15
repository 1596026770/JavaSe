package 蓝桥杯.dfs;

import java.util.ArrayList;

public class 马踏棋盘 {
    static boolean flag = false;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int n = 6;//棋盘大小
    static int sx = 0;//开始的横纵坐标     左上(0,0)
    static int sy = 0;
    static int[][] v = new int[n][n];//状态
    static int[][] ans = new int[n][n];//记录结果

    public static void main(String[] args) {
        v[sx][sy]=1;
        ans[sx][sy]=0;
        dfs(0,sx,sy);

    }

    /**
     *
     * @param step  第几步
     * @param x     当前x坐标
     * @param y     当前y坐标
     */
        public static void dfs(int step,int x,int y){
            if(flag) return;
            if(step >= n*n-1){
                flag = true;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%3d",ans[i][j]);
                    }
                    System.out.println();
                }
                return;
            }
            flag = false;

            for (int i = 0; i < 8; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                if(a<0 || a>=n || b<0 || b>=n) continue;
                if(v[a][b] !=0) continue;


                v[a][b] = 1;
                ans[a][b] = step+1;
                dfs(step+1,a,b);
                v[a][b] = 0;
                ans[a][b] = 0;
            }
            return;
        }

}
