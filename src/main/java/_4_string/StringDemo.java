package _4_string;
import org.junit.Test;


public class StringDemo {

    @Test
    public void stringTest(){
        /*
        * String注意事项：
        * 1.String的对象是不可变字符串对象
        * 2.只要以"..."方式写出的字符串，会存储到字符串常量池（堆内存中）中，且相同内容的字符串只存储一次（复用相同字符串地址）
        * 3.通过new方式创建字符串对象，每new一次都会产生一个新的对象放在堆内存中
        * */
//        String 常用Api
//        1.获取字符串长度
        String str = "小可爱abc";
        System.out.println(str.length());

//        2.获取字符串中某个索引位置的字符
        char c = str.charAt(2);
        System.out.println(c);

//        字符串的遍历
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        System.out.println("----------------------");
//        3.字符串转字符数组
        char [] chararr = str.toCharArray();
        for (int i = 0; i < chararr.length; i++) {
            System.out.println(chararr[i]);
        }

//        4.判断字符串内容，内容一样返回true
        String s1 = "echo";
        String s2 = "echo";
        System.out.println(s1.equals(str));

//        5.判断字符串内容(忽略大小写)，内容一样返回true
        String s3 = "ECHO";
        System.out.println(s1.equalsIgnoreCase(s3));

//        6.截取字符串(不包含末尾)
        String s4 = "abcdefghijk";
        System.out.println(s4.substring(1, 3));

//        7.从当前位置截取到末尾位置
        System.out.println(s4.substring(2));

//        8.把字符串中的某个内容替换为新的内容，并返回新的字符串
        String info = "你是一个大笨蛋，啦啦啦啦啦！";
        String newinfo = info.replace("大笨蛋","(^_^)");
        System.out.println(newinfo);

//        9.判断字符串中是否包含某个关键字
        System.out.println(info.contains("大笨蛋"));

//        10.判断字符串是否以某个字符串开头
        System.out.println(info.startsWith("大笨蛋"));

//        11.将一个字符串按照指定内容分割成多个字符串，放到一个字符串数组中返回
        String info1 = "啦啦队,好啊好,拉拉是拉阿鲁,echo";
        String[] strs = info1.split(",");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

//        12.将指定字符串连接到此字符串结尾
        String s = s1.concat(s3);
        System.out.println(s);

//        13.返回指定子串在此字符串首次出现的索引，若无返回-1
        System.out.println(s.indexOf("ECH"));

    }

    public static void main(String[] args) {
        //    创建字符串对象
//    1.直接""
        String str = "abc";
//    2.new String,并用构造器初始化
        String str1 = new String("abcd");
        System.out.println(str1);

        char[] chars = {'a','好','啦'};
        String str2 = new String(chars);
        System.out.println(str2);

        byte[] bytes = {97,98,99};
        String str3 = new String(bytes);
        System.out.println(str3);


    }


}
