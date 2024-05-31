package _视频._11_内部类.匿名内部类;

public class Test {
    public static void main(String[] args) {
        //认识匿名内部类，掌握其作用
//        Animal a = new Cat();
//        a.cry();

        //1.把这个匿名内部类编译成一个子类，然后立即创建一个子类对象出来
        Animal a = new Animal(){
            @Override
            public void cry() {
                System.out.println("喵喵喵");
            }
        };//注意分号
        a.cry();
    }
}

//class Cat extends Animal{
//    @Override
//    public void cry() {
//        System.out.println("喵喵喵");
//    }
//}



abstract class Animal{
    public abstract void cry();
}







