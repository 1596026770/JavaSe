package _视频._10_接口._3jdk8新增方法;

public interface A {
    /*新增方法体，便于维护拓展项目，避免写完方法签名后，（以前的项目）必须实现方法
    * 1.默认方法：必须使用default修饰，默认会被public修饰
    * 实例方法：对象的方法，必须使用实现类的对象来访问
    * */
    default void test(){
        System.out.println("=======默认方法=======");
    }

    /*
    * 2.私有方法：必须使用private修饰 jdk9以后才支持
    * */
//    private void test2(){}

    /*
    * 3.静态方法：必须使用static修饰，默认会被public修饰
    * */
    static void test3(){
        System.out.println("=====静态方法=======");
    }
    static void test4(){}
}
