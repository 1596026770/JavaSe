package _6_static.单例;

public class B {
//    懒汉式单例
    //模糊
    //用代码块完成
    private static B b;

    private B(){

    }

    public static B getObject(){
        if(b == null){
            b = new B();
        }
        return b;
    }


}
