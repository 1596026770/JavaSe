package _7_继承.子类构造器特点;

class F{
    public F(){
        System.out.println("父类无参构造器执行了");
    }

    public F(String name){
        System.out.println("父类有参构造器执行了");
    }
}

class Z extends F{
    public Z(){
//        super();//默认存在 调父类无参构造器
//        super(name,age);// 调父类有参构造器赋值
//        this(name,age);// 调兄弟构造器赋值

        System.out.println("子类无参构造器执行了");
    }
    public Z(String name){
        System.out.println("子类有参构造器执行了");
    }
}


public class Test {
    public static void main(String[] args) {
        //子类构造器特点：
        //子类的全部构造器，都会先调用父类的构造器，在执行自己的构造器
        Z z = new Z("echo");

    }
}
