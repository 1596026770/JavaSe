package _视频._6_static.block;

public class Student {
    static int num = 80;
    static  String name;
    //静态代码块 只会执行一次
    //静态代码块 完成类变量的初始化赋值
    static {
        System.out.println("静态代码块执行了");
        name = "echo";

    }
    //实例代码块 每次创建实例都会执行
    //和构造器一样完成对象的初始化，对实例变量进行赋值  在构造器前执行
    {
        System.out.println("实例代码块执行了");
        System.out.println(this);
    }
    public Student(){
        System.out.println("无参构造器执行了");
    }
    public Student(String name){
        System.out.println("有参构造器执行了");
    }
}
