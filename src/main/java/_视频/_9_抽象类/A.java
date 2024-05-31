package _视频._9_抽象类;

public abstract class A {
    //必须用abstract修饰，只有方法签名，不能有方法体
    private String name;
    public static String schoolName;

    public abstract void run();

    public A() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String schoolName) {
        A.schoolName = schoolName;
    }


}
