package _10_接口;

public class Test {
    public static void main(String[] args) {
        //认识接口
        //成员变量（常量）
        //成员方法（抽象方法）不能写方法体
        //接口不能创建对象（抽象），接口是用来被类实现（implements）的，实现接口的类称为实现类
        //一个类可以实现多个接口，实现多个接口必须重写完全部接口的全部抽象方法，否则要被定义为抽象类
        System.out.println(A.SCHOOL_NAME);

        D d = new D();
        d.testb1();
        d.testb2();






    }
}
