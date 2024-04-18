package _无锡实习.secondwork;

import java.util.ArrayList;
import java.util.Scanner;

public class Work16 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Student zs = new Student("1001","张三");
        Student ls = new Student("1002","李四");
        Student ww = new Student("1003","王五");
        Student echo = new Student("1004","echo");
        System.out.println("欢迎进入学生成绩录入系统");
        System.out.print("学号："+zs.id+ ",姓名："+zs.name+",成绩：");
        zs.setScore(scan.nextDouble());
        System.out.print("学号："+ls.id+ ",姓名："+ls.name+",成绩：");
        ls.setScore(scan.nextDouble());
        System.out.print("学号："+ww.id+ ",姓名："+ww.name+",成绩：");
        ww.setScore(scan.nextDouble());
        System.out.print("学号："+echo.id+ ",姓名："+echo.name+",成绩：");
        echo.setScore(scan.nextDouble());
        System.out.println("学生录入完成");
        students.add(zs);
        students.add(ls);
        students.add(ww);
        students.add(echo);

        System.out.println("成绩显示如下:");
        for (Student student : students) {
            System.out.println("学号："+student.id+ ",姓名："+student.name+",成绩："+student.score);
        }



    }

    public static class Student{
        private String name;
        private String id;
        private double score;

        public Student() {
        }

        public Student(String id, String name) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
}
