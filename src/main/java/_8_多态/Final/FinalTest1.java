package _8_多态.Final;

public class FinalTest1 {
    public static final String SCHOOL_NAME = "华夏";
    public static void main(String[] args) {
        //目标：认识常量
        /*
        * 可读性好，可维护性好
        * 编译后宏替换
        * */
        System.out.println(SCHOOL_NAME);
    }
}
