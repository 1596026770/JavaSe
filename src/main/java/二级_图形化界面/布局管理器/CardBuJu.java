package 二级_图形化界面.布局管理器;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardBuJu implements ActionListener {
    //卡片式布局
    private Panel p1,p2,p3;
    private Button b1,b2,b3;
    private Frame frame;
    private CardLayout cardLayout = new CardLayout();
    public void Create(){
        b1 = new Button("first");
        b2 = new Button("second");
        b3 = new Button("third");
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        frame = new Frame("CardLayout");
        p1.add(b1);
        b1.addActionListener(this);//监听器
        p2.add(b2);
        b2.addActionListener(this);
        p3.add(b3);
        b3.addActionListener(this);
        frame.setLayout(cardLayout);
        frame.add(p1,"first");
        frame.add(p2,"second");
        frame.add(p3,"third");
        frame.setSize(200,200);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        CardBuJu cardBuJu = new CardBuJu();
        cardBuJu.Create();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.next(frame);
    }
}
