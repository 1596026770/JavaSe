package _11_内部类;

public class Test {
    //了解内部类
    public static void main(String[] args) {
        //创建内部类对象 先创建外部类.new 内部类
        Outer.Inner inner = new Outer().new Inner();
         inner.test();
    }
}
