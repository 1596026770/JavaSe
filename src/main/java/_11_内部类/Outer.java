package _11_内部类;

public class Outer {
    private int age=99;
    public static String a;
    //成员内部类
    //添加static为静态内部类
    public class Inner{
        private String name;
        private  int age = 88;
//        public static String schoolName;//jdk16开始可以定义静态成员

        public void test() {
            int age = 66;
            System.out.println(age);//66
            System.out.println(this.age);//88
            System.out.println(Outer.this.age);//99拿外部类的值

            System.out.println(a);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



    private void test2(){
        System.out.println(age);
        System.out.println(a);
    }

}
