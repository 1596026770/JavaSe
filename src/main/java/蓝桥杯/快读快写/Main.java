package 蓝桥杯.快读快写;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main{
    static int count = 0;//烤鸡   P2089
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        String line=br.readLine();

        String[] s = line.split(" ");
        String sn = s[0];
        int[] arr = new int[sn.length()];
        int k = s[1].charAt(0) - '0';
        int[][] map = new int[k][2];
        for (int i = 0; i < k; i++) {
            s = br.readLine().split(" ");
            map[i][0] = s[0].charAt(0)- '0';
            map[i][1] = s[1].charAt(0)- '0';
//            out.print(map[i][0] + " ");
//            out.println(map[i][1] + " ");
        }
        for (int i = 0; i < sn.length(); i++) {
            arr[i] = sn.charAt(i) - '0';
        }
        if(k == 0){
            out.println(1);
            return;
        }
        dfs(0,arr,sn,map);
//        System.out.println("k:"+ k);
        out.println(count/2);
        out.flush();
    }

    public static void dfs(int x,int[] arr,String sn,int[][] map){
        if(x == sn.length()){
            for (int i = 0; i < sn.length(); i++) {
//                System.out.print(arr[i] + " ");
            }
//            System.out.println();
            count++;
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if(arr[x] == map[i][0]){
                arr[x] = map[i][1];
                dfs(x+1,arr,sn,map);
                arr[x] = map[i][0];
            }else dfs(x+1,arr,sn,map);
        }
    }
}