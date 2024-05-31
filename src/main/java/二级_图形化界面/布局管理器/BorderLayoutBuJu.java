package 二级_图形化界面.布局管理器;

import java.awt.*;

public class BorderLayoutBuJu {
    //边界式布局
    public static void main(String[] args) {

        Frame frame = new Frame("BorderLayout");
        frame.setLayout(new BorderLayout());//边界式布局

        frame.add("North",new Button("North"));
        frame.add("South",new Button("S"));
        frame.add("West",new Button("W"));
        frame.add("East",new Button("E"));
        frame.add("Center",new Button("Center"));

        frame.setSize(200,200);
        frame.setVisible(true);



    }
}
