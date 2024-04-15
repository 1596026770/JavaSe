package _7_继承.test1;

public class Test {
    public static void main(String[] args) {

        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        t1.name = "凌霜华";
        t1.setSkill("睡大觉");
        t1.skillFangFa();

        System.out.println("------------");

        t2.name = "凌霜华1";
        t2.setSkill("睡大觉o.O");
        t2.skillFangFa();

        System.out.println("---------");
        Access a1 = new Access();
        a1.name = "echo";
        a1.setNum(10);
        a1.jiedaFangFa();
    }
}
