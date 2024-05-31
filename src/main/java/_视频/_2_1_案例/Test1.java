package _视频._2_1_案例;

public class Test1 {
    public static void main(String[] args) {

//        飞机票
        double price;//原价
        int month;
        boolean flag;//舱位类型 false：头等舱   true：经济舱
        System.out.println(youhuiprice(1000, 11, false));

    }

    public static double youhuiprice(double price,int month,boolean flag){

        if(month >= 5 && month <= 10){
            if(flag==false){
                price *=0.9;
                System.out.println("当前优惠价格为：" + price);
            }else {
                price *=0.85;
                System.out.println("当前优惠价格为：" + price);
            }
        } else if ((month > 0 && month <= 4 )||(month >= 11 && month <= 12)) {
            if(flag==false){
                price *=0.7;
                System.out.println("当前优惠价格为：" + price);
            }else {
                price *=0.65;
                System.out.println("当前优惠价格为：" + price);
            }
        }else {
            System.out.println("你输入的月份有误，请重新输入！");
        }
        return price;
    }

}
