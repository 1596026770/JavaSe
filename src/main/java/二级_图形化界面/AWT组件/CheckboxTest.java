package 二级_图形化界面.AWT组件;


import java.awt.*;

public class CheckboxTest {
    //勾 复选框
    //流式布局
    private Frame frame;
    private Button button1;
    private Button button2;
    private Checkbox checkbox1;
    private Checkbox checkbox2;
    private Checkbox checkbox3;
    private CheckboxGroup checkboxGroup;//复选框组
    private Choice choice;//下拉式菜单
    private TextField textField;//单行文本输入
    private TextField textField1;//单行文本输入
    private TextArea textArea;//文本输入区

    public static void main(String[] args) {
        CheckboxTest two = new CheckboxTest();
        two.go();
    }

    public void go(){
        frame = new Frame("FlowLayout");
        frame.setLayout(new FlowLayout());//流式布局
        button1 = new Button("Press Me");
        button2 = new Button("NO Press Me");
        checkboxGroup = new CheckboxGroup();//复选框组
        //复选框组中最多只有一个能被选中,若有多个true，则为最后一个true被选中

        checkbox1 = new Checkbox("checkbox1");
        checkbox2 = new Checkbox("checkbox2",checkboxGroup,true);
        checkbox3 = new Checkbox("checkbox3",checkboxGroup,false);
        choice = new Choice();//下拉式菜单
        textField = new TextField(30);//单行文本输入  长度30
        textField1 = new TextField("echo lalala haha");
        textArea = new TextArea(20,20);//文本输入区 可以给定行数和列数

        choice.add("echo");
        choice.add("echo1");
        choice.add("echo2");

        frame.add(button1);
        frame.add(button2);
        frame.add(checkbox1);
        frame.add(checkbox2);
        frame.add(checkbox3);

        frame.add(choice);//下拉式菜单
        frame.add(textField);
        frame.add(textField1);
        frame.add(textArea);

        frame.pack();
        frame.setVisible(true);
    }
}
