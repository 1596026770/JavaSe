package _3_对象.thisdemo;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setScore(300);
        s1.pass(250);
        Student s2 = new Student("张三",60);

        System.out.println(s2.getName());
        System.out.println(s2.getScore());
    }
}
