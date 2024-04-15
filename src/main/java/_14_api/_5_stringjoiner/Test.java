package _14_api._5_stringjoiner;

import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {
        //间隔符
//        StringJoiner s = new StringJoiner(",");
        StringJoiner s = new StringJoiner(", ","[","]");//间隔符，开始符，结束符
        s.add("java1");
        s.add("java2");
        s.add("java3");
        System.out.println(s);

        System.out.println(shuzu(new int[]{11, 22, 33}));
    }


    public static String shuzu(int[] arr){
        if(arr == null){
            return null;
        }
        StringJoiner s = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < arr.length; i++) {
            s.add("" + arr[i]);
        }
        return s.toString();
    }
}
