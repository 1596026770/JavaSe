package 二级_图形化界面.swing组件;

import javax.swing.*;
import java.awt.*;

public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Swing Test");
//        JFrame jFrame = new JFrame();
//        jFrame.setTitle("股票");
//        new FileChooser().showOpenDialog()
        JLabel jLabel = new JLabel("Hello Swing");//label 标签

        Button button1 = new Button("Yes");
        Button button2 = new Button("No");
        //流式布局
//        jFrame.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(new BorderLayout());

//        button1.addActionListener();
        //获取面板
        jFrame.getContentPane().add(jLabel);
        jFrame.getContentPane().add("North",button1);
        jFrame.getContentPane().add("Center",button2);

        jFrame.setSize(200,80);
        jFrame.setVisible(true);
//        Scanner scanner = new Scanner(System.in);
//        JOptionPane.showMessageDialog();
//        System.exit(0);

    }

//    public class JFrameTest extends JFrame{
//        public void javaTest(){
//            super("sas");
//        }
//    }
}
