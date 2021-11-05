package Dulce_Torta.GUI;

import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class InicioSesionGUI extends GUI{

    JTextField txtUsuario;
    JPasswordField txtCtr;

    JButton btnInicioSesion;
    JButton btnRsbCtr;

    String bgPrincipal;
    String bgRestablecerC;

    public InicioSesionGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        txtUsuario = new JTextField();
        txtCtr = new JPasswordField();
        btnInicioSesion = new JButton();
        btnRsbCtr = new JButton();
        bgPrincipal = "src/Dulce_Torta/Assets/pantallaPrincipal.png";
        bgRestablecerC = "src/Dulce_Torta/Assets/ImgRestablecerC.png";
    }

    @Override
    public void initComponents() {
         setOpaque(false);
         setLayout(null);
         setSize(width, height);
         setLocation(0,0);

         txtUsuario.setBounds(368, 235, 355, 50);
         txtCtr.setBounds(368, 398, 355, 50);
         btnInicioSesion.setBounds(395, 543, 210, 80);
         btnRsbCtr.setBounds(360, 486, 280, 25);

         txtUsuario.addActionListener(this);
         txtCtr.addActionListener(this);
         btnInicioSesion.addActionListener(this);
         btnRsbCtr.addActionListener(this);

         addToJPanel(btnInicioSesion, btnRsbCtr, txtUsuario, txtCtr);
         buttonTransparent(btnInicioSesion, btnRsbCtr);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRsbCtr){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel,handler.getDisplay().restablecerCntaGUI);
            handler.getDisplay().changeBackGroundPanel(bgRestablecerC);
        }
        if(e.getSource() == btnInicioSesion){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().pantallaPrincipalGUI);
            handler.getDisplay().changeBackGroundPanel(bgPrincipal);
        }
    }
}
