package _14_api._4_stringbuilder;

public class Test2 {
    public static void main(String[] args) {
        //StringBuilder的好处，与String的区别
        //StringBuilder线程不安全，StringBuffer线程安全

        //需求：拼接100w次abc
        //String看性能 很慢
        String rs = "";
//        for (int i = 1; i <= 1000000; i++) {
//            rs += "abc";
//        }
        System.out.println(rs);

        //使用StringBuilder 效率高
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= 1000000; i++) {
            s.append("abc");
        }
        System.out.println(s);



    }
}
