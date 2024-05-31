package _视频._3_对象.thisdemo;

public class Student {
    /*
    * 实体类：1.必须私有成员变量，为每个成员变量都提供get、set方法
    *       2.必须提供一个无参构造器
    *   用来保存数据pojo
    * */
    private String name;
    private double score;
    /*
    * 封装设计规范：合理隐藏，合理暴露
    * 成员属性隐藏privite（避免乱赋值），成员方法暴露public
    * */


//    this 解决对象的成员变量与方法内部变量名字一样，导致访问冲突问题
//    类在设计是如果不屑构造器，java会自动生成一个无参构造器
//    一旦定义了有参构造器，java就不会帮我们自动生成无参构造器了，建议自己手动写一个无参构造器
//    无参构造器
    public Student(){
        System.out.println("无参构造器");
    }

    public Student(String name ,double score){
        System.out.println("有参构造器");
        this.name = name;
        this.score = score;
    }

    public void pass(double score){
        if(this.score>score){
            System.out.println("pass");
        }else {
            System.out.println("no pass");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
