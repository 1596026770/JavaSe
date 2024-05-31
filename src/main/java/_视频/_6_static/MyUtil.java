package _视频._6_static;

import java.util.Random;

public class MyUtil {

    // 应用：工具类       工具类没有创建对象的需求，建议将工具类的构造器（无参）私有,不让别人实例对象
    private MyUtil() {
    }

    //随机验证码
    public static String yzm(int n){
        //    实现随机产生验证码，验证码每位可能是数字、大小写字母
        Random r = new Random();
        String yzm = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";//26+26+10=62
        String str = "";
        for (int i = 0; i < n; i++) {
            str += yzm.charAt(r.nextInt(yzm.length()));
        }
        System.out.println(str);
        return str;
    }
}
