package _视频._5_arraylist.案例;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodService {
//    1.定义一个菜品集合，负责存储菜品信息
    private ArrayList<Food> foodList = new ArrayList<>();
//    foodList = [];

//    2.开发功能，上架菜品
    public void addFood(){
        Food food = new Food();
        //录入菜品
        Scanner sc = new Scanner(System.in);



        System.out.println("请你输入菜品名称：");
        String name = sc.nextLine();
        food.setName(name);

        System.out.println("请你输入菜品价格：");
        double price = sc.nextDouble();
        food.setPrice(price);

        System.out.println("请你输入菜品信息：");
        String info = sc.next();
        food.setInfo(info);

        /*
        * BUG:将输入菜品信息放在菜品价格之后，不会给输入的机会
        *       但是放在菜品价格之前可以输入
        * */




        foodList.add(food);
        System.out.println("你成功上架菜品"+ food.getName() );
    }

    //展示菜品
    public void findAll(){
        if(foodList.size()==0){
            System.out.println("暂时没有菜品，请先上架！");
            return;
        }

        for (int i = 0; i < foodList.size(); i++) {
            System.out.println("菜品名称：" + foodList.get(i).getName());
            System.out.println("菜品价格：" + foodList.get(i).getPrice());
            System.out.println("菜品信息：" + foodList.get(i).getInfo());
            System.out.println();
        }

    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----菜品系统----");
            System.out.println("1.菜品上架");
            System.out.println("2.菜品展示");
            System.out.println("0.退出系统");
            System.out.println("请选择操作：");
            String flag = sc.nextLine();
            switch (flag){
                case "1":
                    addFood();
                    break;
                case "2":
                    findAll();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("你输入的操作有误，请重新输入！");
            }
        }

    }
}
