package _8_多态.Final;

public class FinalTest {
    //常量：static final修饰的变量，建议名称全部大写，多个单词下划线连接
    //final 修饰static必须赋初值
    public static final String SCHOOL_NAME = "hx";
    public static void main(String[] args) {
//        3.final修饰变量,仅能赋值一次
        /*
            变量：
            一.局部变量

            二.成员变量
                1.静态成员变量
                2.实例成员变量

            */
    }

}

//  1.final修饰类，类不能被继承
final class A {}
//class B extends A {}

//  2.final修饰方法，方法不能被重写
class C {
    public final void test(){

    }
}
class D extends C {
//    @Override
//    public void test(){
//
//    }
}