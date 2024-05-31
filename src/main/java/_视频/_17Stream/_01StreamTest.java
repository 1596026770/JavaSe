package _视频._17Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class _01StreamTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张无忌","张三丰","赵敏","周芷若","赵强","张拉到了骄傲了");

        List<String> zhang = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("张") && name.length()==3){
                zhang.add(name);
            }
        }
        System.out.println(zhang);

        //Stream流
        List<String> list = names.stream().filter(s -> s.startsWith("张")).filter(a -> a.length() == 3).collect(Collectors.toList());
        System.out.println(list);
    }
}
