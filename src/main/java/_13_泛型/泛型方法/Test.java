package _13_泛型.泛型方法;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //泛型方法定义和使用
        test("java");
        Dog dog = test(new Dog());
        System.out.println(dog);


        //汽车比赛

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new BaoMa());
        cars.add(new BenChi());
        go(cars);

        ArrayList<BaoMa> baoMas = new ArrayList<>();
        baoMas.add(new BaoMa());
        baoMas.add(new BaoMa());
        go(baoMas);


        ArrayList<BenChi> benChis = new ArrayList<>();
        benChis.add(new BenChi());
        benChis.add(new BenChi());
        go(benChis);

        //不能让狗参加比赛 排除
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
//        go(dogs);
    }

    //泛型方法  没有<Car>报错
 /*   public static <T extends Car> void go(ArrayList<T> cars){

    }*/

    //？通配符，再使用泛型时可以代表一切类型       ? extends Car (上限)技术    ? super Car (下限) 只能是Car的父类
    public static  void go(ArrayList<? extends Car> cars){

    }


    //泛型方法      第二个T是返回值
    public static <T> T test(T t){
        return t;
    }
}
