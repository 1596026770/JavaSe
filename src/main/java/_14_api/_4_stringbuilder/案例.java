package _14_api._4_stringbuilder;

public class 案例 {
    public static void main(String[] args) {

        System.out.println(shuzu(new int[]{11, 22, 33}));
    }



    public static String shuzu(int[] arr){
        if(arr == null){
            return null;
        }
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i!=0){
                s.append(", " + arr[i]);
            }else {
                s.append(arr[i]);
            }
        }
        s.append("]");
        return s.toString();
    }
}
