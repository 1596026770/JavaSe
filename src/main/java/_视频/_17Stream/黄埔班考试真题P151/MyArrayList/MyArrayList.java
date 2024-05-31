package _视频._17Stream.黄埔班考试真题P151.MyArrayList;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    private Object[]  list = {};
    private int size;//数组大小 及下一个元素索引
    private int DEFAULT_CAPACITY = 10;//默认容量

    public boolean add(E e){
        //1.判断是否需要扩容
        if(size == list.length){
            grow();
        }

        list[size++] = e;
        return true;
    }

    public E get(int index){
        //越界判断
        checkIndex(index);
        return (E) list[index];
    }

    public E remove(int index){
        //判断索引是否越界
        checkIndex(index);
        //删除2
        //1 2 3 4 5 6   index = 1    size = 6   拷贝数量 = 4 = size -index -1 = moveFlag
        //             size指向7(索引为6)
        //1 3 4 5 6
        //被删除的数据
        E e = (E) list[index];

        //判断index是否为最后一个位置 是否需要移位
        int moveFlag = size - index - 1;//大于等于0需要移位
        if(moveFlag != 0){//需要移位
//        if(index == size - 1){//不需要移位
            System.arraycopy(list,index + 1, list, index, moveFlag);
        }
        //最后一个数据改为null
        list[--size] = null;
        return e;
    }

    public int size(){
        return size;
    }

    public void forEach(MyConsumer<E> action){
        //对action判空
        Objects.requireNonNull(action);
        for (int i = 0; i < size; i++) {
            action.accept((E) list[i]);
        }
    }

    /**
     * 判断索引是否越界
     * @param index
     */
    public void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(index + "超出最大长度" + (size - 1));
        }
    }

    /**
     * 扩容
     */
    private void grow() {
        if(size == 0){
            list = new Object[DEFAULT_CAPACITY];
        }else {
            //后几次扩容:长度变为原来1.5倍
            list = Arrays.copyOf(list,list.length + list.length >> 1);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            E e = (E) list[i];
            if(i == size -1){
                sb.append(e).append("]");
            }else {
                sb.append(e).append(", ");
            }

        }
        return sb.toString();
    }
}
