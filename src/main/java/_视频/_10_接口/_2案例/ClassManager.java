package _视频._10_接口._2案例;

import java.util.ArrayList;

public class ClassManager {

    private ArrayList<Student> students = new ArrayList<>();

    public ClassManager(){
        students.add(new Student("凌霜华","女",80));
        students.add(new Student("echo","女",90));
        students.add(new Student("三毛","女",82));
        students.add(new Student("丁典","男",85));

    }
    StudentOperator studentOperator = new StudentOperatorImpl2();

    //打印全班学生信息
    public void printInfo(){
        studentOperator.printAllInfo(students);
    }

    //打印全班同学平均分
    public void printScore(){
        studentOperator.printAverageScore(students);
    }

}
