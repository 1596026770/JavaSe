package _视频._13_泛型.定义泛型类;
//泛型类
public class MyArrayList<E> {
    private Object[] arr = new Object[10];
    private int size;//记录当前数据位置

    public boolean add(E e){
        arr[size++] = e;
        return true;
    }

    public E get(int index){

        return (E)arr[index];
    }
}
