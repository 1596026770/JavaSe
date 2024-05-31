package _视频._7_继承.test3_override;

public class Test {
    //方法重写

    public static void main(String[] args) {
        //子类掉父类成员变量/成员方法  super.变量名
        /*方法重写注意事项：
            1.使用Override注解
            2.子类重写父类方法，访问权限必须大于或等于父类该方法的权限public > protected > 缺省
            3.返回值必须一样或更小
            4.私有方法、静态方法不能重写
        * */
        /*方法重写：
         * 1.重写方法要与原方法的方法名、形参列表相同
         * 2.重写后遵循就近原则
         * 3.重写原因：觉得父类的方法不好用
         * */
        A a = new A();
        a.print1();
        a.print2(1,2);

        B b = new B();
        b.print1();
        b.print2(1,2);


        System.out.println("--------------");
        Student s = new Student("echo",18);
        System.out.println(s.toString());


    }
}
