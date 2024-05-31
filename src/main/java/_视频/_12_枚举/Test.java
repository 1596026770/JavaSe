package _视频._12_枚举;

public class Test {
    public static void main(String[] args) {
        //枚举
        A a1 = A.X;
        System.out.println(a1);

        //枚举类的构造器的私有的，不能对外创建对象
//        A a = new A();//报错

        //枚举类的第一行都是常量，记住的是枚举类的对象
        A a2 = A.Y;

        //枚举类提供一些额外API
        A[] as = A.values();//拿到全部对象
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }
        System.out.println("--------------");
        A a3 = A.valueOf("Z");
        System.out.println(a3);
        System.out.println(a3.name());
        System.out.println(a3.ordinal());//拿索引


        System.out.println("-----------------");

        B y = B.Y;
        y.go();

    }
}
