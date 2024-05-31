package _视频._4_string;

import java.util.Random;
import java.util.Scanner;
import org.junit.Test;
public class StringTest {

public static void main(String[] args) {
    //    登录    最多三次机会
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
        System.out.println("------登录------");
        System.out.println("请输入用户名：");
        String user = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        String yzm = yzm(4);
        System.out.println("请输入验证码(忽略大小写)：");
        String inputyzm = sc.nextLine();
        if(user.equals("echo")){
            if (password.equals("123")){
                if (yzm.equalsIgnoreCase(inputyzm)){
                    System.out.println("登录成功！");
                    return;
                }else {
                    System.out.println("验证码输入有误，请重新输入！(您还有"+ (2-i) +"次机会)");
                }
            }else {
                System.out.println("密码输入有误，请重新输入！(您还有"+ (2-i) +"次机会)");
            }
        }else {
            System.out.println("用户名输入有误，请重新输入！(您还有"+ (2-i) +"次机会)");
        }
        System.out.println();
    }
}

//  输入要生成验证码的位数
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

    @Test
    public void 验证码(){
//    实现随机产生验证码，验证码每位可能是数字、大小写字母
        Random r = new Random();
        String yzm = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";//26+26+10=62
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += yzm.charAt(r.nextInt(yzm.length()));
        }
        System.out.println(str);
    }


}
