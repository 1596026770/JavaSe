package 二级_图形化界面.布局管理器;

import java.awt.*;

public class GridBuJu {
    //网格式布局
    public static void main(String[] args) {
        Frame frame = new Frame("GridBagLayout");
        frame.setLayout(new GridLayout(3,2));//网格式布局
        frame.add(new Button("echo"));
        frame.add(new Button("lucy"));
        frame.add(new Button("3"));
        frame.add(new Button("4"));
        frame.add(new Button("5"));
        frame.add(new Button("6"));
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
