package _视频._2_1_案例;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        //生成验证码 生成指定位数的验证码，可以是数字、大小写字母
        yzm(6);
    }

    public static  String yzm(int num){
        Random r = new Random();
//        定义一个String变量
        String code = "";
        for (int i = 0; i < num; i++) {
//            为每个位置生成一个随机字符
//            随机一个 0 1 2 之间的数，0：数字 1、2：大小写字母
            int type = r.nextInt(3);
            if(type==0){
//                数字
                code += r.nextInt(10);

            } else if (type==1) {
//                大写    A:65    Z:65+26-1
                code += (char)(r.nextInt(26) + 65);//是26而不是27,0~25
            }else {
                code += (char)(r.nextInt(26) + 97);

            }
        }
        System.out.println("生成的验证码为：" + code);
        return code;
    }
}
