package _6_static;

public class Student {
    //有无public修饰的成员变量用法、特点
    //类变量
    static String name;
    //实例变量（对象的变量）
    int age;
    double score;
    //类变量的应用场景  计数
    public static int number;


    public Student(){
//        Student.number++;
        //注意：在同一个类中，访问自己的类的变量，才可以省略类名不写
        number++;
    }


    public static void printHelloWorld(){
        System.out.println("Hello World");
        System.out.println("Hello World");
    }

    public void printPass(){
        System.out.println(score > 60?"pass":"no pass");
    }




}
