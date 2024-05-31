package _视频._12_枚举.应用场景;

public class Test {
    public static void main(String[] args) {
        //枚举可直接创建单例，且线程安全
        //掌握枚举的应用场景，做信息标志和分类
        //枚举做信息标志，避免别人随便写入switch
//        check(1);
//        check(Constant.BOY);

        check(Constant2.BOY);
    }



    public static void check(Constant2 sex){
        switch (sex){
            case BOY:
                System.out.println("男");
                break;
            case GIRL:
                System.out.println("女");
                break;
        }
    }

/*    public static void check(int sex){
        switch (sex){
            case Constant.BOY:
                System.out.println("男");
                break;
            case Constant.GIRL:
                System.out.println("女");
                break;
        }
    }*/
}
