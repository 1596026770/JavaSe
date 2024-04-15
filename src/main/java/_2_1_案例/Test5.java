package _2_1_案例;

public class Test5 {
    public static void main(String[] args) {
//        拷贝数组  与直接赋值数组不同，直接赋值赋地址
        int[] arr = {11,22,33};
        int[] arr1 = copy(arr);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    public static int[] copy(int[] num){
        int[] num1 = new int[num.length];
        for (int i = 0; i <num1.length ; i++) {
            num1[i] = num[i];
        }
        return num1;
    }
}
