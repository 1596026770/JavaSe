package _视频._9_抽象类.abstract1;

public class Test {

    public static void main(String[] args) {
        //抽象类好处；更好地支持多态（子类必须重写父类的抽象方法）
        Animal dog = new Dog();
        dog.setName("小可爱");
        dog.cry();
        Animal cat = new Cat();
        cat.setName("大可爱");
        cat.cry();
    }
}
