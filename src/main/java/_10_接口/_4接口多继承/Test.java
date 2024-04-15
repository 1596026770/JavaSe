package _10_接口._4接口多继承;

public class Test {
    public static void main(String[] args) {
        //接口多继承
        /*
        * 使用接口的注意事项：
        * 1.一个接口继承多个接口，如果多个接口中存在方法签名冲突（包括返回类型、方法名），则不支持多继承
        * 2.一个类实现多个接口，如果多个接口中存在方法签名冲突，则不支持多实现
        * 3.一个类继承了父类，又同时实现了接口，父类和接口中有同名的默认方法，实现类会优先调用父类的
        * 4.一个类实现了多个接口，多个接口中存在同名的默认方法（default修饰），可以不冲突，这个类重写该方法即可。
        * */
    }
}

interface A{
    void test1();
}
interface B{
    void test2();
}
interface C{
    void test3();
}
interface D extends A,B,C{

}

class E implements D{


    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }

    @Override
    public void test3() {

    }
}