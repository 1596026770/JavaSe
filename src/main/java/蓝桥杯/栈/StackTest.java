package 蓝桥杯.栈;

import java.util.Scanner;
import java.util.Stack;

/**

 小鱼最近被要求参加一个数字游戏，要求它把看到的一串数字ai

 （长度不一定，以0 结束），记住了然后反着念出来（表示结束的数字0 就不要念出来了）。
 这对小鱼的那点记忆力来说实在是太难了，你也不想想小鱼的整个脑袋才多大，其中一部分还是好吃的肉！所以请你帮小鱼编程解决这个问题。

 输入格式
 一行内输入一串整数，以0 结束，以空格间隔。

 输出格式
 一行内倒着输出这一串整数，以空格间隔。

 输入输出样例
 输入 #1复制
 3 65 23 5 34 1 30 0
 输出 #1复制
 30 1 34 5 23 65 3
 说明/提示
 */
public class StackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        //push压栈    pop出栈
        //peek查看栈顶对象
        //isEmpty判断是否为空
        while (!sc.hasNext("0")){
            int item = sc.nextInt();

            stack.push(item);
        }

        while (!stack.isEmpty()){
//            if(stack.peek()=='0'){
//                stack.remove(stack.peek());
//            }
            System.out.print(stack.pop()+ " ");
        }
    }
}
