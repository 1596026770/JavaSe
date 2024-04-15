package 蓝桥杯.dfs;

import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static int n =scan.nextInt();
    static int k =scan.nextInt();
    static int [] v = new int[n+1];//v[i] = 1表示选过了  0表示还没选过
    static int[] ans = new int[n+1];

    public static void main(String[] args) {
        dfs(1);
    }
    public static void dfs(int x){
//        x表示当前枚举到哪个位置  n   表示对n全排列
        if(x > k){
            for (int i = 1; i <= k; i++) {
                System.out.printf("%5d",ans[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(v[i] == 0 ) {
                v[i] = 1;
                ans[x] = i;
                dfs(x+1);
                v[i] =0;
                //移出最末尾的值
                ans[x] = 0;
            }
        }
    }
}
