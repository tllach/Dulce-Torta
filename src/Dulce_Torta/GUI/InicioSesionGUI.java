package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;;

public class InicioSesionGUI extends GUI{

    JButton btnInicioSesion;
    JButton btnConstraseña;
    JTextField txtUsuario;
    JPasswordField txtContraseña;
    String bg;

    public InicioSesionGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        btnInicioSesion = new JButton();
        btnConstraseña = new JButton();
        txtUsuario = new JTextField();
        txtContraseña = new JPasswordField();
        bg = "src/Dulce_Torta/Assets/ImgPrincialDef.png";
    }

    @Override
    public void initComponents() {
         setOpaque(false);
         setLayout(null);
         setSize(width, height);
         setLocation(0,0);

         btnInicioSesion.setBounds(393, 546, 215, 75);
         btnConstraseña.setBounds(355,490,290,20);

         btnInicioSesion.addActionListener(this);
         btnConstraseña.addActionListener(this);
         addToJPanel(btnInicioSesion, btnConstraseña);
         buttonTransparent(btnInicioSesion, btnConstraseña);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnInicioSesion){
            handler.getDisplay().changeJPanel(new JPanel(), bg);
        }
    }
}
