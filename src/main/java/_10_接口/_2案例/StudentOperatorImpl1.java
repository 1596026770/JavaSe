package _10_接口._2案例;

import java.util.ArrayList;

public class StudentOperatorImpl1 implements StudentOperator{
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("---------全班全部学生信息---------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("学生姓名：" + s.getName() + " 学生性别："+s.getSex() +" 学生成绩："+s.getScore());
        }
        System.out.println("--------------------------------");
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        System.out.println("----------全部学生平均成绩------------");
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            sum += s.getScore();
        }
        sum /= students.size();
        System.out.println("全班学生平均成绩为："+sum);
        System.out.println("----------------------------------");
    }
}
