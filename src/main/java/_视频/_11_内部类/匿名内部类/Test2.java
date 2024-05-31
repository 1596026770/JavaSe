package _视频._11_内部类.匿名内部类;

public class Test2 {
    public static void main(String[] args) {
        //匿名内部类使用场景
//        Swimming s1 = new Swimming(){
//            @Override
//            public void swim() {
//                System.out.println("狗游泳");
//            }
//        };
//        go(s1);

        go(new Swimming(){
            @Override
            public void swim() {
                System.out.println("狗游泳");
            }
        });
    }

    //设计一个方法，可以接受swimming接口的一切实现类对象来参加游泳比赛
    public static void go(Swimming s){
        System.out.println("开始----------------");
        s.swim();
    }

}

//猫和狗都要参加游泳

interface Swimming{
    void swim();
}


