package 无锡实习.thirdwork;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Work25{
    public static void main(String[] args) {
        ScoreInfo info1= new ScoreInfo ("1001","张三",80);
        ScoreInfo info2= new ScoreInfo ("1002","李四",55);
        ScoreInfo info3= new ScoreInfo ("1003","王五",65);
        ScoreInfo info4= new ScoreInfo ("1004","赵六",92);
        List<ScoreInfo> list = new ArrayList<>();
        list.add(info1); // 可初始化4个对象，都放入list下。
        list.add(info2);
        list.add(info3);
        list.add(info4);
        Collections.sort(list,(o1, o2) -> o2.getScore() - o1.getScore());
//        list.sort((o1, o2) -> o2.getScore() - o1.getScore());
        for (ScoreInfo stu : list){
            System.out.println("学号："+stu.getStu_id()+",姓名："+stu.getStu_name()+",成绩："+stu.getScore());
        }

    }
}

class ScoreInfo{
    //String stu_id, String stu_name, Integer score三个属性，均为私有属性，score用于存放成绩，分别给属性赋予get/set方法。
    private String stu_id;
    private String stu_name;
    private Integer score;

    public ScoreInfo(String stu_id, String stu_name, Integer score) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.score = score;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
