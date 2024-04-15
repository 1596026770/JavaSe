package 蓝桥杯.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] chars = scan.next().toCharArray();
//        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                char temp;
                if(chars[i]<chars[j]){
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
    }
}
