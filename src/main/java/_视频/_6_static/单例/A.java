package _视频._6_static.单例;

public class A {
//    饿汉式单例
    //2.定义一个类变量（只会执行一次）记住类的一个对象
    private static A a = new A();

    //1.必须私有类的构造器
    private A(){

    }

    //3.定义一个类方法(只会执行一次)返回类对象
    //不能私有返回对象，要给别人调用，返回同一个对象
    public static A getObject(){
        return a;
    }





}
