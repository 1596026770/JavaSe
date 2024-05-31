package _视频._9_抽象类.模板方法;

public abstract class People {
    /*模板方法设计模式
    1.定义一个模板方法
    * */
    //模板方法建议用final修饰，防止被重写
    public final void write(){
        System.out.println("\t\t\t\t《作文题目》");
//        2.子类重写正文
        System.out.println(zhengwen());
        System.out.println("\t\t结尾");
    }
    //3.设计一个抽象方法写正文，具体实现交给子类
    public abstract String zhengwen();
}
