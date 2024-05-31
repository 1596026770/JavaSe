package _视频._15collections;

import java.util.Arrays;

public class _01ParamTest {
    //可变参数
    public static void main(String[] args) {
        test();
        test(10,20,30);
        test(new int[]{10,20,30});
    }

    //一个形参列表中只能有一个可变参数
    //可变参数只能放在形参列表最后面
    public static void test(int...nums){
        //可变参数在方法内部本质是一个数组
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println("---------------");
    }
}
