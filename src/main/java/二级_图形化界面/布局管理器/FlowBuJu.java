package 二级_图形化界面.布局管理器;

import java.awt.*;

public class FlowBuJu {
    //流式布局
    private Frame frame;
    private Button button1;
    private Button button2;

    public static void main(String[] args) {
        FlowBuJu two = new FlowBuJu();
        two.go();
    }

    public void go(){
        frame = new Frame("FlowLayout");
        frame.setLayout(new FlowLayout());//流式布局
        button1 = new Button("Press Me");
        button2 = new Button("NO Press Me");
        frame.add(button1);
        frame.add(button2);
        frame.pack();
        frame.setVisible(true);
    }

}
