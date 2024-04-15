package _2_方法;

public class MethodOverLoad {

    public static void main(String[] args) {

//        方法重载
//        一个类中，出现多个方法名相同，但是他们的形参列表不同(个数、类型、顺序 不关心形参名称)的这些方法叫方法重载（与修饰符无关）
        test(1);
    }

    public static void test(){
        System.out.println("test1");
    }
    public static void test(int a){
        System.out.println("test1" + "a");
    }

}
