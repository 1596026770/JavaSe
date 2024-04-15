package _7_继承.test2Modifer;

public class Fu {
    //权限修饰符
    //        private < 缺省 < protected(保护) < public
//        本类    同一包下其他类   任意包下子类    任意包下任意类
    private void privateMethod(){
        System.out.println("private");
    }

    void method(){
        System.out.println("缺省");
    }

    protected void protectedMethod(){
        System.out.println("protected");
    }
    public void publicMethod(){
        System.out.println("public");
    }

    public void test(){
        privateMethod();
        method();
        protectedMethod();
        publicMethod();
    }

}
