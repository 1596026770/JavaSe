package 无锡实习.thirdwork;

public class Work24 {
    public void print(){
        System.out.println("这是一个父类print方法");
    }
    public void spPrint(){
        System.out.println("这是一个父类spPrint方法");
    }

}

class SubClass extends Work24{
    public void say(){
        System.out.println("这是类中不带参数的say方法");
    }
    public void say(int id){
        System.out.println("这是类中带一个参数的say方法，参数类型为int："+id);
    }
    public void say(String name){
        System.out.println("这是类中带一个参数的say方法，参数类型为String："+name);
    }
    public void say(int id,String name){
        System.out.println("这是类中带两个参数的say方法。");
    }

}

class DemoTest{
    public static void main(String[] args) {
        SubClass sub = new SubClass();
        sub.print(); //获取子类print方法，父类方法倍子类重写
        sub.spPrint();//获取父类中spPrint方法
        sub.say();
        sub.say(1);
        sub.say("张三");
        sub.say(1, "张三");

    }
}
