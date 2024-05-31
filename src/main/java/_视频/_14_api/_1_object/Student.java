package _视频._14_api._1_object;

import java.util.Objects;

//Cloneable是一个标记接口
public class Student implements Cloneable{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //重写equals方法，比较两个对象的内容是否一样，一样返回true
    //比较者：s2 == this
    //被比较者：s1 == o
    @Override
    public boolean equals(Object o) {
        //1.判断两个对象的地址是否一样，一样返回true
        if (this == o) return true;
        //2.判断o是null直接返回false,或者比较两者类型不一样
        //      Student.Class != Pig.Class
        if (o == null || this.getClass() != o.getClass()) return false;
        //3.o不是null，且o一定是学生类型对象，开始比较内容  把o转成Student类型
        Student student = (Student) o;
        return this.age == student.age && Objects.equals(name, student.name);
    }

    //克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //super去调父类Object的clone方法
        //浅克隆
        return super.clone();
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
