package _视频._10_接口._2案例;

import java.util.ArrayList;

public class StudentOperatorImpl2 implements StudentOperator{
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        int maleNum = 0;
        int famaleNum = 0;
        System.out.println("---------全班全部学生信息---------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("学生姓名：" + s.getName() + " 学生性别："+s.getSex() +" 学生成绩："+s.getScore());
            if(s.getSex()=="男"){
                maleNum++;
            } else if (s.getSex()=="女") {
                famaleNum++;
            }
        }
        System.out.println("男生一共"+ maleNum +"人，女生一共"+ famaleNum +"人");
        System.out.println("--------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        System.out.println("----------全部学生平均成绩------------");
        double sum = 0;
        double min = students.get(0).getScore();
        double max = students.get(0).getScore();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            sum += s.getScore();
            if(min > s.getScore()){
                min = s.getScore();
            }
            if(max < s.getScore()){
                max = s.getScore();
            }
        }
        sum = (sum - min - max)/(students.size() - 2);
        System.out.println("全班学生去掉最高、最低分后，平均成绩为："+sum);
        System.out.println("----------------------------------");
    }
}
