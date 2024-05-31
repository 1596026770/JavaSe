package _视频._16Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的遍历方式
 */
public class _01Map {
    public static void main(String[] args) {
        Map<String,Double> map = new HashMap<>();
        map.put("蜘蛛精",162.5);
        map.put("蜘蛛精",168.7);
        map.put("紫霞",143.4);
        map.put("青牛精",122.5);
        map.put("拉拉精",142.5);
        System.out.println(map);

        //1.获取map集合的全部键
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "->"+map.get(key));
        }

        System.out.println("------------");

        //2.map.entrySet()
        System.out.println(map.entrySet());
        for(Map.Entry<String,Double> kv : map.entrySet()){
            System.out.println(kv.getKey()+" ---> "+ kv.getValue());
        }

        //3.lambda
        System.out.println("-------------------------");
        map.forEach((k,v)->{
            System.out.println(k + "-->" + v);
        });
    }
}
