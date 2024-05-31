package _视频._7_继承.test2Modifer;

public class Demo {
    public static void main(String[] args) {
        Fu f = new Fu();
        //同一包下不同类，不能访问private
        f.method();
        f.protectedMethod();
        f.publicMethod();
    }
}
