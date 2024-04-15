package 刷题;

import java.util.Scanner;

/*public class Main{
    public static void main(String[] args) {
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
}*/

//······················模板·································
//import java.util.Scanner;
//导包


//public class Main{
//    public static void main(String[] args) {
//
//    }
//}



public class Main{
    public static void main(String[] args) {
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
}
