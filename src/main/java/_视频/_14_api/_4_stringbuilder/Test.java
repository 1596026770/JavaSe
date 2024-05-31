package _视频._14_api._4_stringbuilder;

public class Test {
    public static void main(String[] args) {

//        StringBuilder s = new StringBuilder();
        StringBuilder s = new StringBuilder("echo");

        //1.拼接内容
        s.append(12);
        s.append("小可爱");

        //支持链式编程  一直.下去
        //append 返回值为this,即谁调用返回谁
        s.append("凌霜华").append(15);
        System.out.println(s);

        //2.反转
        System.out.println(s.reverse());

        //3.返回字符串长度
        System.out.println(s.length());

        //4.把StringBuilder对象转换成String类型
        System.out.println(s.toString());

//        5.将字符串插入到指定位置
        System.out.println(s);
        System.out.println(s.insert(8, "大笨蛋"));

    }
}
