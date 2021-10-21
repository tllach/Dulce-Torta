package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class GUI extends JPanel implements ActionListener {

    protected int width, height;
    protected Handler handler;

    public GUI(Handler handler, int width, int height) {
        this.width = width;
        this.height = height;
        this.handler = handler;
        declaration();
        initComponents();
    }

    protected abstract void declaration();
    protected abstract void initComponents();

    protected void buttonTransparent(JButton ...buttons) {
        for(JButton button : buttons){
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
        }
    }

    protected void addToJPanel(JComponent ...objs) {
        for(JComponent obj : objs) {
            add(obj);
        }
    }

}
