package _视频._17Stream;

import java.util.*;
import java.util.stream.Stream;


public class _02StreamTest {
    public static void main(String[] args) {
        //1.如何获取List集合的Stream流
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张无忌","张三丰","赵敏","周芷若","赵强","张拉到了骄傲了");
        Stream<String> stream = names.stream();

        //2.Set
        Set<String> set = new HashSet<>();
        Collections.addAll(set,"张无忌","张三丰","赵敏","周芷若","赵强","张拉到了骄傲了");
        Stream<String> stream1 = set.stream();
        stream1.filter(name -> name.contains("赵")).forEach(s -> System.out.println(s));


        //3.Map
        Map<String,Double> map = new HashMap<>();
        map.put("adada",111.1);
        map.put("bdad",111.1);
        map.put("cddde",111.1);
        map.put("dewe",111.1);
        Stream<Map.Entry<String, Double>> kvs = map.entrySet().stream();
        kvs.filter(e -> e.getKey().contains("e")).forEach(e -> System.out.println(e));


        //4.数组
        String[] names2 = {"张无忌","张三丰","赵敏","周芷若","赵强","张拉到了骄傲了"};
        //Arrays.stream()
        Stream<String> stream2 = Arrays.stream(names2);
        //Stream.of()
        Stream<String> names21 = Stream.of(names2);

    }
}
