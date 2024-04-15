package _7_继承;

public class Test {
    public static void main(String[] args) {
        //继承注意事项：
        /*
        * 1.java是单继承的，一个类只能有一个父类（一个人只能有一个baba），不支持多继承，但支持嵌套继承（子 父 爷）
        * 2.Object类是java所有类的超类
        * */
        B b = new B();
        b.i = 10;
        b.print1();
        b.print3();
    }
}
