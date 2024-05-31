package _视频._5_arraylist;
import org.junit.Test;
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
//        1.创建一个ArrayList对象
        ArrayList<String> list = new ArrayList<>();
        list.add("echo");
        list.add("(+_+)");
        list.add("0.0");
        System.out.println(list);

//        2.往集合中某个索引位置处添加一个数据
        list.add(2,"小可爱");
        System.out.println(list);

//        3.根据索引获取某个位置的值
        System.out.println(list.get(2));

//        4.获取集合的大小
        System.out.println(list.size());

//        5.根据据索引删除集合中的某个元素值，会返回被删除的元素给我们
        System.out.println(list.remove(2));
        System.out.println(list);

//        6.删除集合中某个元素值(如果有多个删除第一个)，成功返回true，反之false
        list.add("echo");
        System.out.println(list);
        System.out.println(list.remove("echo"));
        System.out.println(list);

//        7.修改某个索引位置的数据，修改后会返回原来的值给我们
        System.out.println(list.set(2, "凌霜华"));
        System.out.println(list);

    }
    @Test
    public void arraylistTest(){

    }
}
