package _视频._16Map;

import java.util.*;

/**
 * 统计投票人数   80学生    ABCD四个景点
 */
public class MapDemo {
    public static void main(String[] args) {
        //A:0 B:1 C:2 D:3
        //1.把80个学生选择的景点数据拿到
        Random random = new Random();
        Map<String,Integer> map = new HashMap<>();
        String[] jingdian = {"A","B","C","D"};
        List<String> students = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            int a = random.nextInt(4);
            switch (jingdian[a]){
                case "A":
                    map.put("A",map.getOrDefault("A",0)+1);
                    break;
                case "B":
                    map.put("B",map.getOrDefault("B",0)+1);
                    break;
                case "C":
                    map.put("C",map.getOrDefault("C",0)+1);
                    break;
                case "D":
                    map.put("D",map.getOrDefault("D",0)+1);
                    break;
            }
            students.add(jingdian[a]);
        }
        System.out.println(students);
        map.forEach((k,v)->{
            System.out.println(k + "--->" + v);
        });


    }
}
