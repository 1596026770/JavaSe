package _2_方法;
import org.junit.Test;

public class Method {

    public static void main(String[] args) {

//        方法注意事项：
//        1.一个方法不能定义在另一个方法里

//        int res = sum(10,20);
//        System.out.println(res);
//        System.out.println(sum_n(100));
//        jiou(12);

//        基本类型值传递   引用类型 数组开辟堆内存，传地址
//        int [] arrs = {10,20,30};
//        change(arrs);
//        System.out.println("Main：" + arrs[1]);

//        int [] arr = {11,22,33,44,55};
//        arrOne(arr);
//        int s = ',';
//        System.out.println(s);

        int[]arr1 = {1,2,3};
        int[]arr2 = {1,2,3};
        System.out.println(same_arr(arr1, arr2));

    }
    public static int sum(int a, int b){
        int c= a + b;
        return c;
    }
    public static int sum_n(int n){
        int sum=0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void jiou(int n){
        if(n%2==0){
            System.out.println("偶数");
        }
        else
            System.out.println("奇数");
    }

    public static void change(int[] arrs){
        System.out.println("方法内1："+arrs[1]);
        arrs[1] = 200;
        System.out.println("方法内2："+arrs[1]);
    }


    public static void arrOne(int [] arr){
//        注意空指针异常
        if(arr == null){
            System.out.println(arr);
            return;
        }
        System.out.print("[");
        for (int i =0;i<arr.length;i++) {

            if (i!= arr.length-1) {
                System.out.print(arr[i] + ",");
            }
            else {
                System.out.print(arr[i] );
            }

        }
        System.out.print("]");
    }

    public static boolean same_arr(int[] arr1,int[] arr2){
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1 == null || arr2 == null)
            return false;

        if (arr1.length!=arr2.length){
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

    @Test
    public void testOne(){

    }


}






