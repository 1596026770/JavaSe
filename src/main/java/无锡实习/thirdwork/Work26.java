package 无锡实习.thirdwork;

public class Work26 {
    public static void main(String[] args) {
        int n = 6;
//        int[] arr = new int[n];
        int[] arr = {12,4,36,3,25,16};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print(arr[i]+" ");
        }
    }
}
