package _视频._6_static.block;

public class Test {
    public static void main(String[] args) {
        //认识两种代码块，了解他们的特点和作用
        //静态代码块 完成类变量的初始化赋值
        //实例代码块
        System.out.println(Student.num);

        Student s1 = new Student();
        Student s2 = new Student("echo");


    }
}
