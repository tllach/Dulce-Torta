package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AnuncioRestablecer extends GUI{

    JButton btnVolverAI;
    String bg;

    public AnuncioRestablecer(Handler handler, int width, int height) {super(handler, width, height);}

    @Override
    protected void declaration() {
        btnVolverAI = new JButton();
        bg= "src/Dulce_Torta/Assets/ImgNotificacion.png";
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        btnVolverAI.setBounds(350, 550, 300, 100);
        btnVolverAI.addActionListener(this);
        addToJPanel(btnVolverAI);
        buttonTransparent(btnVolverAI);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVolverAI){
            handler.getDisplay().changeJPanel(new JPanel(), bg);
        }
    }
}
