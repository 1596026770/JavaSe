package _10_接口._1interface;

public class Test {
    public static void main(String[] args) {
        A s = new A();
        s.sing();
        s.drive();

    }
}

class A extends Student implements Singer, Driver {

    @Override
    public void drive() {

    }

    @Override
    public void sing() {

    }
}

class Student{

}

interface Driver{
    void drive();
}

interface Singer{
    void sing();
}








