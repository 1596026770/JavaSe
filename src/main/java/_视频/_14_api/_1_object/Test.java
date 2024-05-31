package _视频._14_api._1_object;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student("赵敏",12);
//        System.out.println(s1.toString());
        System.out.println(s1);//重写

        Student s2 = new Student("赵敏",12);
        System.out.println(s2.getClass());

        System.out.println(s2.equals(s1));//比较地址
        System.out.println(s2 == s1);

        //Object克隆方法，protected修饰，只能在该包内（lang）或子类调用
        Student s3 = (Student) s1.clone();//抛出异常
        System.out.println(s3.getName());//

    }
}
