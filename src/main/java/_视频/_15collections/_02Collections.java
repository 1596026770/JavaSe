package _视频._15collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections集合工具类的使用
 */
public class _02Collections {
    public static void main(String[] args) {
        //addAll()
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"zhangsan","lisi","wangwu","zhaoyun");
        System.out.println(names);

        //shuffle   打乱List集合中的元素顺序
        Collections.shuffle(names);
        System.out.println(names);

        //sort  对List集合进行排序
        Collections.sort(names, (o1,o2) -> o1.compareTo(o2));
        System.out.println(names);
    }
}
