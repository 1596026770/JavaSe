package _5_arraylist.案例;

import java.util.ArrayList;

public class ArrayListTest {
    /*
    * 掌握从集合中找数据并删除的技巧
    * */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("一梦江湖");
        list.add("特级枸杞");
        list.add("枸杞子");
        System.out.println(list);

//        [Java入门, 宁夏枸杞, 黑枸杞, 一梦江湖, 特级枸杞, 枸杞子]
//           i
//        注意：删除会改变集合的大小，使得删除位置的后一个位置变为当前位置，导致后面位置若是存在关键字会直接跳过

//        方式一：
     /*   for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("枸杞")) {
                list.remove(i);
                i--;
            }
        }*/



//        方式二：从集合后面倒着遍历
        //        [Java入门, 宁夏枸杞, 黑枸杞, 一梦江湖, 特级枸杞, 枸杞子]
//                                                             i
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).contains("枸杞")) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }



}
