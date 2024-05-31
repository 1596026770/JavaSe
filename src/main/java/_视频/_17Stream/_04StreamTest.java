package _视频._17Stream;

import java.util.*;
import java.util.stream.Collectors;


public class _04StreamTest {
    public static void main(String[] args) {
        //Stream 终结方法

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精",26,175.3);
        Student s2 = new Student("蜘蛛精",26,175.3);
        Student s3 = new Student("牛魔王",23,166.3);
        Student s4 = new Student("哈哈精",24,185.3);
        Student s5 = new Student("螃蟹精",26,135.3);
        Student s6 = new Student("蛤蟆精",18,172.3);
        Collections.addAll(students,s1,s2,s3,s4,s5,s6);

        //身高超过168的学生人数
        System.out.println(students.stream().filter(s -> s.getHeight() > 168).count());

        //身高最高的学生对象
        System.out.println(students.stream().max((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())));
        //身高最矮的学生对象
        System.out.println(students.stream().min((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight())));

        //身高超过170的学生对象，并放到一个新集合返回
        //注意：stream流只能收集一次
        List<Student> studentList = students.stream().filter(s -> s.getHeight() > 170).collect(Collectors.toList());
        Set<Student> studentSet = students.stream().filter(s -> s.getHeight() > 170).collect(Collectors.toSet());
        System.out.println(studentList);
        System.out.println(studentSet);

        //身高超过170 把学生名字、身高存入Map集合
        //先去重   有两个相同的key
        Map<String, Double> map = students.stream().filter(s -> s.getHeight() > 170).distinct()
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getHeight()));
        System.out.println(map);

        //数组
        Object[] array = students.stream().filter(s -> s.getHeight() > 170).toArray();
        for (Object o : array) {
            System.out.print(o +" ");
        }
    }
}
