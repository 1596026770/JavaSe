package _无锡实习;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class _4_12 {
    public static void main(String[] args) {

    }

    @Test
    public void Test1(){
        System.out.println("Hello word");
    }

    @Test
    public void Test2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("欢迎使用计算机");
        while (true) {
            System.out.println("请输入第一个数字：");
            double a = scan.nextDouble();
            System.out.println("请输入运算符号：");
            char abc = scan.next().charAt(0);
            System.out.println("请输入第二个数字：");
            double b = scan.nextDouble();

            switch (abc){
                case '+':
                    System.out.println(a+"+"+b+"="+(a+b));
                    break;
                case '-':
                    System.out.println(a+"-"+b+"="+(a-b));
                    break;
                case '*':
                    System.out.println(a+"*"+b+"="+a*b);
                    break;
                case '/':
                    System.out.println(a+"/"+b+"="+a/b);
                    break;
                default:
                    System.out.println("你输入的操作有误！");
            }
            System.out.println("是否继续Y/N:");
            char flag = scan.next().charAt(0);

            if(flag=='N'||flag=='n'){
                return;
            } else if (flag=='Y'||flag=='y') {

            }else {
                System.out.println("你输入有误！");
            }
        }


    }

    @Test
    public void Test3(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-2d\t",i,j,i*j);
            }
            System.out.println();
        }
    }

    @Test
    public void Test4(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = 0l;
        for (int i = 1; i <= n; i++) {
            if(i<n){
                sum+=i;
                System.out.print(i+"+");
            }else {
                sum+=i;
                System.out.println(i+"="+sum);
            }


        }
    }

    @Test
    public void Test5(){
        Random random = new Random();
        int[] arr = new int[7];
//        int redRandom = random.nextInt(33) + 1;
        int blueRandom = random.nextInt(16) + 1;
        HashSet<Integer> set = new HashSet<>();
        while (set.size()!=6){
            set.add(random.nextInt(33) + 1);
        }
        int index = 0;
        System.out.println("双色球开奖结果：");
        System.out.print("红色球:");
        for(Integer item : set){
            arr[index] = item;
            System.out.print(arr[index]+" ");
            index++;
        }
        arr[6] = blueRandom;
        System.out.println();
        System.out.println("蓝色球:"+arr[6]);

    }


    @Test
    public void Test6(){
        Cat cat = new Cat("小猫咪：");
        Dog dog = new Dog("小狗：");
        cat.shout();
        dog.shout();
    }

    public class Animal{
        private String name;

        public Animal() {
        }

        public void shout(){
            System.out.println("动物的叫声");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Animal(String name) {
            this.name = name;
        }
    }

    public class Dog extends Animal{

        public Dog() {
        }

        public Dog(String name) {
            super(name);
        }

        @Override
        public void shout() {
            System.out.println(super.getName()+"汪汪汪。。。");
        }
    }

    public class Cat extends Animal{

        public Cat() {
        }

        public Cat(String name) {
            super(name);
        }

        @Override
        public void shout() {
            System.out.println(super.getName()+"喵喵喵。。。");
        }
    }

    @Test
    public void Test7(){
        Wine[] wines = new Wine[2];
        WLY wly = new WLY();
        MTJ mtj = new MTJ();
        wines[0] = wly;
        wines[1] = mtj;
        for (int i = 0; i < wines.length; i++) {
            System.out.println(wines[i].toString() + "--" + wines[i].drink());
        }


    }

    public class Wine{
        private String name;

        public Wine() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String drink(){
            return "酒的味道是：" + getName();
        }

        @Override
        public String toString() {
            return "Wine:" + getName();
        }
    }
    public class WLY extends Wine{
        public WLY() {
            super.setName("五粮液");
        }


    }
    public class MTJ extends Wine{
        public MTJ() {
            super.setName("贵州茅台");
        }

        @Override
        public String drink() {
            return "我喝的是："+getName();
        }

        @Override
        public String toString() {
            return "酒名:"+getName();
        }
    }

    @Test
    public void Test8(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你想听的音乐：");
        System.out.println("1-钢琴  2-小提琴  3-架子鼓");
        int input = scan.nextInt();
        _4_12 sound = new _4_12();
        switch (input){
            case 1:
                sound.play(new Piano());
                break;
            case 2 :
                sound.play(new Violin());
                break;
            case 3 :
                sound.play(new Drum());
                break;
            default:System.out.println("没有该场演奏会");

        }
    }

    public interface Sound{
        //开始声音
        public void makeSound();
        //提高声音
        public void RaiseSound();
        //降低声音
        public void decreaseSound();
        //停止声音
        public void stopSound();

    }
    public class Piano implements Sound{

        @Override
        public void makeSound() {
            System.out.println("开始钢琴演奏");
        }

        @Override
        public void RaiseSound() {
            System.out.println("钢琴高声演奏");
        }

        @Override
        public void decreaseSound() {
            System.out.println("钢琴低声演奏");
        }

        @Override
        public void stopSound() {
            System.out.println("停止钢琴演奏");
        }
    }
    public class Drum implements Sound{

        @Override
        public void makeSound() {
            System.out.println("开始架子鼓演奏");
        }

        @Override
        public void RaiseSound() {
            System.out.println("架子鼓高声演奏");
        }

        @Override
        public void decreaseSound() {
            System.out.println("架子鼓低声演奏");
        }

        @Override
        public void stopSound() {
            System.out.println("停止架子鼓演奏");
        }
    }
    public class Violin implements Sound{

        @Override
        public void makeSound() {
            System.out.println("开始小提琴演奏");
        }

        @Override
        public void RaiseSound() {
            System.out.println("小提琴高声演奏");
        }

        @Override
        public void decreaseSound() {
            System.out.println("小提琴低声演奏");
        }

        @Override
        public void stopSound() {
            System.out.println("停止小提琴演奏");
        }
    }
    public void play(Sound sound){
        sound.makeSound();
        sound.RaiseSound();
        sound.decreaseSound();
        sound.stopSound();
    }

    @Test
    public void Test9(){
        Feeder feeder = new Feeder("邦尼");
        feeder.speak();
        Cat1 cat = new Cat1("kitty");
        cat.shout();
        Food food = new Fish("小鱼");
        feeder.feed(cat,food);

        Fish fish = new Fish("lucy");
        Food food1 = new Cat1("大橘");
        fish.shout();
        feeder.feed(fish,food1);

    }
    public class Animal1{
        private String name;

        public void shout(){
            System.out.println("动物的叫声");
        }
        public void eat(Food food){
            System.out.println(name+"吃"+food.getName());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Animal1(String name) {
            this.name = name;
        }

        public Animal1() {
        }
    }
    public interface Food{
        String getName();
    }

    public class Cat1 extends Animal1 implements Food{
        public Cat1(String name) {
            super(name);
        }
        public Cat1() {
        }
        @Override
        public void shout() {
            System.out.println("小猫"+super.getName() +"喵喵喵。。。");
        }

        @Override
        public void eat(Food food) {
            System.out.println("小猫"+super.getName()+"吃"+food.getName());
        }
    }
    public class Fish extends Animal1 implements Food{
        public Fish(String name) {
            super(name);
        }

        @Override
        public void shout() {
            System.out.println("小鱼"+super.getName() +"布鲁布鲁。。。");
        }

        @Override
        public void eat(Food food) {
            System.out.println("小鱼"+super.getName() +"吃"+food.getName());
        }
    }
    public class Feeder{
        private String name;

        public Feeder(String name) {
            this.name = name;
        }

        public void speak(){
            System.out.println("欢迎来到动物园");
            System.out.println("我是饲养员"+getName());
            System.out.println("我正在给动物们喂食物");
        }
        public void feed(Animal1 a, Food food) { a.eat(food);  }
        public Feeder() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void Test10(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请选择要计算的形状：");
        System.out.println("1-长方形 2-圆形");
        switch (scan.nextInt()){
            case 1:
                Rectangle rectangle = new Rectangle();
                System.out.println("请输入长度：");
                rectangle.length = scan.nextInt();
                System.out.println("请输入宽度：");
                rectangle.width = scan.nextInt();
                System.out.println("长方形的面积为："+ rectangle.getArea());
                break;
            case 2:
                Circle circle = new Circle();
                System.out.println("请输入半径：");
                circle.radius = scan.nextInt();
                System.out.println("圆的面积为："+circle.getArea());
                break;
            default:
                System.out.println("你输入有误！");
        }
    }
    public interface Shape{
        double getArea();
    }
    public class Rectangle implements Shape{
        double length = 0;
        double width = 0;
        @Override
        public double getArea() {
            return length * width;
        }
    }
    public class Circle implements Shape{
        double radius = 0;
        final double PI = 3.14;
        @Override
        public double getArea() {
            return PI*radius*radius;
        }
    }
    public void getArea(Shape shape){
        shape.getArea();
    }
}
