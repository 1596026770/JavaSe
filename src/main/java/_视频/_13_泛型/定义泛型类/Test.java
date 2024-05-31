package _视频._13_泛型.定义泛型类;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("java");
        list.add("java1");
        System.out.println(list.get(1));

        MyClass2<Cat,String> c2 = new MyClass2<>();
        c2.put(new Cat(),"b");

        MyClass3<Dog> c3 = new MyClass3();




    }
}
