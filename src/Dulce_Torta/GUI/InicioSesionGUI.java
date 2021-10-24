package Dulce_Torta.GUI;

import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class InicioSesionGUI extends GUI{
    JTextField txtUsuario;
    JPasswordField txtContraseña;
    JButton btnInicioSesion;
    JButton rsbContraseña;
    JButton btnGoRegistro;
    JButton btnBack;
    String bg;

    public InicioSesionGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        txtUsuario = new JTextField();
        txtContraseña = new JPasswordField();
        btnInicioSesion = new JButton();
        rsbContraseña = new JButton();
        btnGoRegistro = new JButton();
        btnBack = new JButton();
        bg = "src/Dulce_Torta/Assets/ImgInicioSesion.png";
    }

    @Override
    public void initComponents() {
         setOpaque(false);
         setLayout(null);
         setSize(width, height);
         setLocation(0,0);

         txtUsuario.setBounds(360, 250, 350, 50);
         txtContraseña.setBounds(360, 410, 350, 50);
         btnInicioSesion.setBounds(400, 540, 220, 80);
         rsbContraseña.setBounds(370, 490, 280, 30);
         btnGoRegistro.setBounds(590, 643, 100, 30);
         btnBack.setBounds(70, 540, 90, 90);


         txtUsuario.addActionListener(this);
         txtContraseña.addActionListener(this);
         btnInicioSesion.addActionListener(this);
         rsbContraseña.addActionListener(this);
         btnGoRegistro.addActionListener(this);
         btnBack.addActionListener(this);

         addToJPanel(btnInicioSesion, rsbContraseña,btnGoRegistro,btnBack);
         buttonTransparent(btnInicioSesion, rsbContraseña, btnGoRegistro, btnBack);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnInicioSesion){
            handler.getDisplay().changeJPanel(new JPanel(), bg);
        }
    }
}
