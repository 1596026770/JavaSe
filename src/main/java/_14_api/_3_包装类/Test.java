package _14_api._3_包装类;

public class Test {
    public static void main(String[] args) {
        Integer a1 = Integer.valueOf(12);
        System.out.println(a1);

        //自动装箱：自动把基本类型数据转换成对象
        Integer a2 = 12;
        //自动拆箱：自动把包装类型的对象转换为基本数据类型
        int a3 = a2;

        System.out.println("-------------------------");

        //1.把基本类型的数据转为字符串
        Integer a4 = 23;
        String s1 = Integer.toString(a4);//"23"
        System.out.println(s1 + 1);//拼接"231"

        String s2 = a4 + "";
        System.out.println(s2 + 1);

        //2.把字符串类型的数值转换成对应的基本类型
        String ageStr = "29";
//        int ageI = Integer.parseInt(ageStr);
        int ageI = Integer.valueOf(ageStr);
        System.out.println(ageI + 1);

        String scoreStr = "29.5";
//        double score = Double.parseDouble(scoreStr);
        double score = Double.valueOf(scoreStr);
        System.out.println(score + 0.5);


    }
}
