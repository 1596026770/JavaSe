package _视频._3_对象;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        //    调用：   实列.属性名/方法名
        s1.name = "张三";
        s1.china = 100;
        s1.math = 60;

        s1.sumSorce();
        s1.avgSorce();
//        类与对象的注意事项：
//        1.类名用英文单词，首字母大写，驼峰，且要有意义
//        2.类中定义的变量也称为成员变量（对象的属性），类中定义的方法也称为成员方法（对象的行为）
//        3.成员方法本身存在默认值，不用赋初始值
//        4.一个代码文件中，可以有多个class类，但只能用一个public
//              且public修饰的类必须为代码文件名
//        5.对象与对象之间的数据不会相互影响，但多个变量指向一个对象会有影响
        /*
        Student s2 = s1;
        s2.name="李四";
        System.out.println(s1.name);//输出结果为李四，地址传递 ！多个变量指向一个对象会有影响！
*/
//        6.如果某个对象没有一个变量引用它，则该对象无法被操作，该对象为垃圾对象
       /* s1 = null;
        System.out.println(s1.name);*/
    }
}
