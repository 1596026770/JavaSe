package _二级_图形化界面;

import java.awt.*;

public class FristFrame extends Frame {
    //组件    Component
//    容器    Container继承组件
    //布局管理器 LayoutManger
    public static void main(String[] args) {
        //Frame
//        FristFrame frame = new FristFrame("first contianer");
//        frame.setSize(240,240);
//        frame.setBackground(Color.cyan);
//        frame.setVisible(true);

        //面板
        FristFrame panelInFrame = new FristFrame("Frame with Panel");

        Panel panel = new Panel();//面板
        panelInFrame.setSize(240,240);
        panelInFrame.setBackground(Color.cyan);
        panelInFrame.setLayout(null);//布局
        panel.setSize(100,100);
        panel.setBackground(Color.GREEN);
        panelInFrame.add(panel);
        panelInFrame.setVisible(true);//可见


    }

    public FristFrame() throws HeadlessException{
        super();
    }

    public FristFrame(String title) throws HeadlessException{
        super(title);
    }

}
