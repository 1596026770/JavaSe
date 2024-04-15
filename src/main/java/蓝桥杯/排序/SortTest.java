package 蓝桥杯.排序;

import java.util.*;

import org.junit.Test;

public class SortTest {
    public static void main(String[] args) {
        Integer [] a = {1,2,5,85,65,42};
        Arrays.sort(a,(o1,o2)-> o1-o2);// ->:return     o1-o2:如果o1-o2>0交换位置，即o1>o2交换位置升序
        for (int n = 0; n < a.length; n++) {
            System.out.print(a[n] + " ");
        }
    }

    @Test
    public void 二维数组排序(){
        Integer [][] a = {{6,3,5},{2,5,9}};
        Arrays.sort(a,(o1, o2) -> o1[0]-o2[0]);//根据数组[0]元素大小进行行排序，每个数组中数据不排序
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void 集合排序(){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(9);
        Collections.sort(list,(o1,o2)->o2-o1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+ " ");
        }
    }
}
