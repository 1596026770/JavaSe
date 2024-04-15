package _2_1_案例;


public class Test4 {
    public static void main(String[] args) {
        System.out.println(jiami(9876));
//        System.out.println(split(1234));
    }


    public static String jiami(int number){
//        1.拆分为一个个数字
        int [] numbers = split(number);
//        2.加密
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ((numbers[i] + 5) %10);
        }
//        3.反转
        reverse(numbers);

//        4.将加密的数字拼接返回
        String data = "" ;
        for (int i = 0; i < numbers.length; i++) {
            data += numbers[i];
        }

        return data;
    }

    public static void reverse(int[] numbers) {
        for (int i = 0,j = numbers.length-1; i < j; i++,j--) {
                int tem = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tem;

        }
    }

    public static int[] split(int str) {
        int[] num = new int[4];
        num[0] = str/1000;
        num[1] = str/100%10;
        num[2] = str/10%10;
        num[3] = str%10;

        return num;
    }
}
