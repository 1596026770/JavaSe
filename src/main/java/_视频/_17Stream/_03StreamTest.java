package _视频._17Stream;

import java.util.*;
import java.util.stream.Stream;


public class _03StreamTest {
    public static void main(String[] args) {
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores,16.5,77.2,33.6,88.4,66.2,33.4);

        //分数 >60 升序
        scores.stream().filter(s -> s>60).sorted().forEach(s-> System.out.println(s));
        System.out.println("------------------");

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精",26,175.3);
        Student s2 = new Student("蜘蛛精",26,175.3);
        Student s3 = new Student("牛魔王",23,166.3);
        Student s4 = new Student("哈哈精",24,185.3);
        Student s5 = new Student("螃蟹精",26,135.3);
        Student s6 = new Student("蛤蟆精",18,172.3);
        Collections.addAll(students,s1,s2,s3,s4,s5,s6);

        //年龄>=23 <=30 降序
        students.stream().filter(s -> (s.getAge()>=23 && s.getAge()<=30)).sorted((o1,o2) -> o2.getAge()-o1.getAge())
                .forEach(s -> System.out.println(s));
        System.out.println("------------------");

        //身高最高前3
//        students.stream().sorted((o1,o2)-> (int) (o2.getHeight()-o1.getHeight())).forEach(s -> System.out.println(s));
        students.stream().sorted((o1,o2)-> Double.compare(o2.getHeight(),o1.getHeight())).limit(3)
                .forEach(s -> System.out.println(s));
        //                                              o2>o1 +
        //                                              o2<o1 -
        System.out.println("------------------");

        //身高倒数2名
        //skip()跳过前多少条
        students.stream().sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight()))
                        .skip(students.size() -2).forEach(System.out::println);
        System.out.println("------------------");

        //身高>168 的名字 去重
        //distinct去重针对学生对象，但学生对象无重复，需要对学生名字去重   需要重新hashCode equals
        students.stream().filter(s -> s.getHeight() > 168).map(s -> s.getName()).distinct()
                .forEach(System.out::println);
        System.out.println("------------------");

        //合并流 Stream.concat()
        Stream<String> st1 = Stream.of("张三","李四");
        Stream<String> st2 = Stream.of("张三2","李四2","王五");
        Stream<String> allStu = Stream.concat(st1, st2);
        allStu.forEach(System.out::println);

    }
}
