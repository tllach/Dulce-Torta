package Dulce_Torta.GUI.RestablecerContraseña;

import Dulce_Torta.Actors.Empleado;
import Dulce_Torta.GUI.GUI;
import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AnuncioRestablecer extends GUI {

    JLabel lblID, lblContrasena;
    JButton btnVolverPrincipal;

    public AnuncioRestablecer(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration(){
        btnVolverPrincipal = new JButton();
        lblID = new JLabel();
        lblContrasena = new JLabel();
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        lblID.setBounds(225, 253, 390, 40);
        lblContrasena.setBounds(370, 359, 390, 40);
        btnVolverPrincipal.setBounds(350, 535, 300, 100);

        lblID.setFont(new Font("Tahoma", Font.PLAIN, 27));
        lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 27));

        btnVolverPrincipal.addActionListener(this);

        addToJPanel(lblID, lblContrasena, btnVolverPrincipal);
        buttonTransparent(btnVolverPrincipal);
    }

    public void setLbl(String id, String contrasena){
        lblID.setText(id);
        lblContrasena.setText(contrasena);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVolverPrincipal){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().inicioSesionGUI);
            handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgInicioSesion.png");
        }
    }

}
