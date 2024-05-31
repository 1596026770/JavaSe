package _视频._17Stream.黄埔班考试真题P151;

import java.time.LocalDate;
import java.util.*;

public class JavaTest2 {
    public static void main(String[] args) {
        String userStrs = "10001:张三:男:1990-01-01#10002:李四:女:1980-01-01#10003:王五:男:1990-01-01#10004:刘备:男:1990-01-01" +
                "#10005:孙悟空:男:1990-01-01#10006:张三:女:1990-01-01#10007:刘备:女:1990-01-01#10008:张三:女:1999-01-01#10009:猪八戒:男:1990-01-01";

        List<User> userList = new ArrayList<>();
        //1.先拿到每一个对象数据
        Object[] array = Arrays.stream(userStrs.split("#")).toArray();
        for (int i = 0; i < array.length; i++) {
            String[] split = array[i].toString().split(":");
            long id = Long.parseLong(split[0]);
            String name = split[1];
            String gender = split[2];
            LocalDate birthday = LocalDate.parse(split[3]);
            userList.add(new User(id,name,gender,birthday));
        }
        System.out.println(userList);

        //2.统计名字出现次数
        Map<String,Integer> map = new HashMap<>();
        for (User user : userList) {
            String name = user.getName();
            map.put(name,map.getOrDefault(name,0)+1);
        }
       map.forEach((k,v) -> System.out.println(k+":"+v+"次"));

    }

}
