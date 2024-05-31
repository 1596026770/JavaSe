package 二级_图形化界面.AWT组件;

import java.awt.*;

public class _2AWT {
    private Frame frame;
    private Button button1;
    private Button button2;
    private List list;//列表
    private MenuBar menuBar;//菜单栏
    private Menu menu1;//菜单
    private Menu menu2;//菜单
    private Menu menu3;//菜单
    private MenuItem item1;//菜单项
    private MenuItem item2;//菜单项
    private MenuItem item3;//菜单项
    private MenuItem item4;//菜单项

    public static void main(String[] args) {
        _2AWT two = new _2AWT();
        two.go();
    }

    public void go(){
        frame = new Frame("FlowLayout");
        frame.setLayout(new FlowLayout());//流式布局
        button1 = new Button("Press Me");
        button2 = new Button("NO Press Me");
        list = new List(5,true);//false:只能选一个  true：可以选多个

        //菜单
        menuBar = new MenuBar();
        menu1 = new Menu("File");
        menu2 = new Menu("Edit");
        menu3 = new Menu("Help");

        item1 = new MenuItem("Open");//菜单项
        item2 = new MenuItem("New");
        item3 = new MenuItem("Find");
        item4 = new MenuItem("About");

        menu1.add(item1);//添加菜单项到菜单
        menu1.add(item2);
        menu2.add(item3);
        menu3.add(item4);

        menuBar.add(menu1);//添加菜单到菜单栏
        menuBar.add(menu2);
        menuBar.add(menu3);

        list.add("echo");
        list.add("echo1");
        list.add("echo2");
        list.add("echo3");

        frame.add(button1);
        frame.add(button2);
        frame.add(list);
        frame.setMenuBar(menuBar);//添加菜单栏

        frame.pack();
        frame.setVisible(true);
    }
}
