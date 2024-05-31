package _视频._17Stream.黄埔班考试真题P151.MyArrayList;

public class Test {
    public static void main(String[] args) {
//        ArrayList<Object> list = new ArrayList<>();
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(1);
        myList.add(2);
        myList.add(5);

        System.out.println(myList.remove(3));



//        for (int i = 0; i < myList.size(); i++) {
//            System.out.println(myList.get(i));
//        }
        myList.forEach(integer -> System.out.println(integer));
        System.out.println(myList);
        System.out.println(myList.size());
    }
}
