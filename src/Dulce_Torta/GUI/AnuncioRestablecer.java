package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AnuncioRestablecer extends GUI{

    JButton btnVolverPrincipal;

    public AnuncioRestablecer(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        btnVolverPrincipal = new JButton();
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        btnVolverPrincipal.setBounds(350, 535, 300, 100);
        btnVolverPrincipal.addActionListener(this);

        addToJPanel(btnVolverPrincipal);
        buttonTransparent(btnVolverPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVolverPrincipal){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().inicioSesionGUI);
            handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgInicioSesion.png");
        }
    }
}
