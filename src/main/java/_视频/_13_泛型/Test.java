package _视频._13_泛型;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //泛型注意事项：
        //1.泛型是工作在编译阶段的，一旦编译成class文件，class文件中就不存在泛型了，这就是泛型擦除
        //2.泛型不支持基本类型，只支持对象类型（引用类型）
        ArrayList<String> list = new ArrayList<>();
        list.add("java1");
        list.add("java2");
        list.add("java1");
//        list.add(new Cat());


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Cat{

}
