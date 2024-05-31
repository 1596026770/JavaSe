package _视频._3_对象;

public class Student {
//    定义对象的属性和方法
//    调用：   实列.属性名/方法名
    String name ;
    double china;
    double math;


    public void sumSorce(){
        System.out.println(name + "的总成绩为：" + (china + math));
    }
        public void avgSorce(){
        System.out.println(name + "的平均成绩为：" + (china + math)/2);
    }

}

class Car{
    String name;
    int price;
    int color;
}
