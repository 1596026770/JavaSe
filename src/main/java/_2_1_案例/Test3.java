package _2_1_案例;

public class Test3 {
    public static void main(String[] args) {
//        评委打分：评委打0~100的整数，最后得分为：去掉最高最低分，取平均分
        int[] a = {85,72,96,35,55};
        soure(a);
    }

    public static double soure(int[] a){
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length-1; j>i ; j--) {
//                System.out.println();
                if (a[i] > a[j]) {
                    int tem = a[i];
                    a[i] = a[j];
                    a[j] = tem;
                }
            }
            System.out.print(a[i] + " ");
            System.out.println();
            sum += a[i];
        }
        sum = sum - a[0] - a[a.length-1];
        sum /= a.length-2;
        System.out.println("选手最终得分为：" + sum);
        return sum;
    }
}
