package _8_多态.d1;

public class Teacher extends People{
    @Override
    public void run(){
        System.out.println("老师跑的贼慢");
    }

    public void teach() {
        System.out.println("老师要讲课");
    }
}
