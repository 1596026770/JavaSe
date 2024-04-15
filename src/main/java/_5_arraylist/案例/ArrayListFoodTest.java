package _5_arraylist.案例;

public class ArrayListFoodTest {
    public static void main(String[] args) {
//        ArrayList<Food> foods = new ArrayList<>();
//        foods.add(new Food("小龙虾",200,"麻辣"));
        /*
        * 1.设计一个菜品类
        * 2.设计一个菜品操作类FoodService,上架、浏览
        * */
        FoodService foodService = new FoodService();


        foodService.start();

    }
}
