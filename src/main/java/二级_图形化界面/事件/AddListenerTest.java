package 二级_图形化界面.事件;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AddListenerTest implements ActionListener, WindowListener {
    Frame frame;
    Button button;
    public void Create(){
        frame = new Frame("Add Listener");
        button = new Button("press me");
        button.addActionListener(this);
        frame.addWindowListener(this);
        frame.add(button,"North");
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AddListenerTest addListenerTest = new AddListenerTest();
        addListenerTest.Create();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("the button is pressed");
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(1);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
