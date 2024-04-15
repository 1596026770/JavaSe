package _6_static.单例;

public class Test {

    public static void main(String[] args) {
        //单例模式的写法
//    A a1 = new A();//报错 构造器被私有了
        A a1 = A.getObject();
        A a2 = A.getObject();
        System.out.println(a1);
        System.out.println(a2);//a1 a1地址相同


        System.out.println("----------------");
        B b1 = B.getObject();
        B b2 = B.getObject();
        System.out.println(b1);
        System.out.println(b2);


    }




}
