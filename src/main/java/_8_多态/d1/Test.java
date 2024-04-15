package _8_多态.d1;

public class Test {
    public static void main(String[] args) {
        //对象多态  左父类 右子类
        //多态好处
        //好处1.实现解耦合，对象可随时切换后续业务随机改变
        People p1 = new Student();
        p1.run();//编译看左边，运行看右边
        //多态存在问题：无法直接调用子类独有的功能
        //解决：强制类型转换


        //强制类型转换可能存在问题：编译阶段有继承或实现关系就可以强转，但运行是可能出现类型转换异常
        //用instanceof判断是否为强转对象
        if(p1 instanceof Student){
            Student s = (Student) p1;//若换为Teacher 出现ClassCastException异常
            s.test();//调用子类独有方法
        }else {
            Teacher t2 = (Teacher) p1;
            t2.teach();
        }

        //好处2.可以使用父类类型的变量作为形参，可以接受一切子类对象
        People p2 = new Teacher();
        p2.run();
        go(p2);



    }

    public static void go(People p1){
        p1.run();
        if(p1 instanceof Student){
            Student s = (Student) p1;//若换为Teacher 出现ClassCastException异常
            s.test();//调用子类独有方法
        }else if(p1 instanceof Teacher){
            Teacher t2 = (Teacher) p1;
            t2.teach();
        }
    }

}
