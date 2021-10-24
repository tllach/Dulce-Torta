package Dulce_Torta.GUI;

import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class OrdenEmpleado extends GUI{
    String bg;
    public OrdenEmpleado(Handler handler, int width, int height) {super(handler, width, height);}
    @Override
    protected void declaration(){
        bg= "src/Dulce_Torta/Assets/ImgOrdenP.png";
    }
    @Override
    public void initComponents(){
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}
