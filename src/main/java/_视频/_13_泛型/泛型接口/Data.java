package _视频._13_泛型.泛型接口;

import java.util.ArrayList;
//类型变量建议用：E、T、K、V
//泛型接口
public interface Data<T> {
    void add(T t);
    ArrayList<T> getByName(String name);
}
