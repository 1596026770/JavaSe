package _6_static;

public class StudentTest {
    public static void main(String[] args) {
        //单例static
        //有无static修饰的成员变量用法、特点
        /*  类方法、实例方法注意事项
        1.类方法可以直接访问类变量，不可以直接访问实例变量
        2.实例方法中可以出现this关键字，类方法中不行
        * */

        //1.类变量的用法  被所有对象共享（仅一个）主键
        // 应用：工具类       工具类没有创建对象的需求，建议将工具类的构造器（无参）私有,不让别人实例对象
        //类方法同理
        //类名.变量名（推荐）
        Student.name = "凌霜华";
        Student s1 = new Student();
        s1.name = "张三";//不推荐
        s1.age = 18;
        s1.score = 75;

        Student s2 = new Student();
        s2.age = 16;
        s2.score = 55;

        //2.实例变量（对象的变量）的用法，属于每个对象的变量
        //对象.实例变量
        System.out.println(Student.name);//张三

        System.out.println(Student.number);

        //类方法调用
        Student.printHelloWorld();

        s1.printPass();

        //调用类方法     工具类
        MyUtil.yzm(4);








    }
}
