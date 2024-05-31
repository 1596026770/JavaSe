package _视频._17Stream.黄埔班考试真题P151;

import org.junit.jupiter.api.Test;

import java.util.*;

public class JavaTest1 {
    @Test
    public void test1(){
        /**
         * 生成100个不重复1-200间的数字作为囚犯编号，100个囚犯站一排
         * 若为奇数则寄，求最后存活的人的初始位置及编号
         * 答案64
         */

        Random random = new Random();
        List<People> list = new ArrayList<>();

        //生成100个不重复1-200间的数字作为囚犯编号
        for (int i = 1; i <=100; i++) {
            while (true) {
                int code = random.nextInt(200)+1;
//                if (list.contains(code)) {
//                    i--;
//                } else {
//                    list.add(new People(i,code));
//                }
                if (!containsByCode(list,code)) {
                    list.add(new People(i,code));
                    break;
                }
            }
        }

//
//        //删除奇数位置的人  置换
//        //            people = [p1, p2, p3, p4, ...]
//        //                      0   1   2   3
//        while (list.size()>1){
//            //定义临时集合留下偶数位置的人
//            List<People> temPeople = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                if(i%2 ==1){
//                    temPeople.add(list.get(i));
//                }
//            }
//            list.clear();
//            list.addAll(temPeople);
//        }

        //删除
        while (list.size()>1){
            //从集合后面开始   倒着删除
            //            people = [p1, p2, p3, p4, p5, p6, p7]
            //                      0   1   2   3   4    5  6
//            for (int i = list.size()-1; i >=0; i--) {
//                if(i%2==0){
//                    list.remove(i);
//                }
//            }
            //正着删除
            for (int i = 0; i < list.size(); i++) {
                //删除后 后一位会直接前移 所以可以直接删除就是删除奇数位置的数
                list.remove(i);
            }
        }

        for (People people : list) {
            System.out.println(people.index+ " "+people.code);
        }

    }

    private boolean containsByCode(List<People> list,int code) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).code == code){
                return true;
            }
        }
        return false;
    }

    class People{
        private int index;
        private int code;

        public People(int index, int code) {
            this.index = index;
            this.code = code;
        }
    }
}
