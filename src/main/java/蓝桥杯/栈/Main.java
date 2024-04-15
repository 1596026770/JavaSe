package 蓝桥杯.栈;

import java.util.*;

/**
 假设一个表达式有英文字母（小写）、运算符（+、-、*、/）和左右小（圆）括号构成，以 @ 作为表达式的结束符。
 请编写一个程序检查表达式中的左右圆括号是否匹配，若匹配，则输出 YES；否则输出 NO。表达式长度小于255，左圆括号少于20 个。

 输入格式
 一行：表达式。

 输出格式
 一行：YES 或 NO。

 输入输出样例
 输入 #1复制
 2*(x+y)/(1-x)@
 输出 #1复制
 YES
 输入 #2复制
 (25+x)*(a*(a+b+b)@
 输出 #2复制
 NO
 */
public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
//        Map<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
       char [] c = sc.next().toCharArray();
       boolean flag=true;
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='@') break;
            if(c[i]=='('){
                stack.push(c[i]);
            }
            if(c[i]==')'){
                if(stack.isEmpty())
                    flag=false;
                else {
                    stack.pop();
                }
            }

        }
        if(!stack.isEmpty()){
            flag=false;
        }
        if(flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
