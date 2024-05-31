package _视频._9_抽象类.模板方法;

public class Test {
    //目标：清楚抽象类的应用场景之一，经常用来设计模板方法设计模式

    public static void main(String[] args) {
        People people = new Student();
        people.write();
        Teacher teacher = new Teacher();
        teacher.write();
    }
}
