package _14_api._2_objects;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "echo";
//        System.out.println(s1.equals(s2));//s1不呢为空，不然会空指针异常
        System.out.println(Objects.equals(s1, s2));//更安全

        //2.isNull
        System.out.println(Objects.isNull(s1));
        System.out.println(Objects.isNull(s2));

        System.out.println(Objects.nonNull(s1));
        System.out.println(Objects.nonNull(s2));


    }
}
