package _无锡实习.secondwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Work12 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            list.add("echo"+i);
        }
        System.out.println("欢迎进入抽奖系统");
        System.out.println("本轮抽取三等奖三名");
        System.out.print("恭喜:");
        for (int i = 0; i < 3; i++) {
            if(!list.isEmpty()){
                String name = list.get(random.nextInt(list.size()));
                System.out.print(name+" ");
                list.remove(name);
            }else break;
        }
        System.out.println();
        System.out.println("本轮抽取二等奖二名");
        System.out.print("恭喜:");
        for (int i = 0; i < 2; i++) {
            if(!list.isEmpty()){
                String name = list.get(random.nextInt(list.size()));
                System.out.print(name+" ");
                list.remove(name);
            }else break;
        }
        System.out.println();
        System.out.println("本轮抽取一等奖一名");
        System.out.print("恭喜:");
        if(!list.isEmpty()){
            String name = list.get(random.nextInt(list.size()));
            System.out.print(name+" ");
            list.remove(name);
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
