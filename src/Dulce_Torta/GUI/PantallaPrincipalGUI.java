package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PantallaPrincipalGUI extends GUI{


    public PantallaPrincipalGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        System.out.println("Hola");
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);
        JButton btn = new JButton();
        btn.setBounds(300,300,200,200);
        addToJPanel(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
