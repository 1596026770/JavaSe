package _11_内部类.匿名内部类.应用;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        //匿名内部类在开发中的真实使用场景
        //GUI编程
        //1.创建窗口
        JFrame win = new JFrame("登录界面");
        //桌布
        JPanel panel = new JPanel();
        win.add(panel);

        //按钮
        JButton btn = new JButton("登录");
        panel.add(btn);

        //给按钮绑定单击事件监听器
        //调接口的实例或匿名内部类
/*        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(win,"登录一下");
            }
        });*/
        //最终目的：简化代码
        //lamda（拉姆达）表达式
        btn.addActionListener( e -> JOptionPane.showMessageDialog(win,"登录一下") );



        //设置窗口大小
        win.setSize(400,400);
        //居中
        win.setLocationRelativeTo(null);
        //关闭窗口退出程序
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //可见
        win.setVisible(true);

    }
}
