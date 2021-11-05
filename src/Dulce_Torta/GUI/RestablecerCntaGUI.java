package Dulce_Torta.GUI;
import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class RestablecerCntaGUI extends GUI{

    JTextField txtDocID;
    JPasswordField nuevaCtr;
    JPasswordField confirmacionNC;

    JButton btnBack;
    JButton btnRestablecer;

    String bg;
    public RestablecerCntaGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        txtDocID = new JTextField();
        nuevaCtr = new JPasswordField();
        confirmacionNC = new JPasswordField();
        btnBack = new JButton();
        btnRestablecer = new JButton();
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        txtDocID.setBounds(480, 230, 360, 40);
        nuevaCtr.setBounds(480, 305, 360, 40);
        confirmacionNC.setBounds(305, 435, 360, 40);

        btnBack.setBounds(53, 537, 100, 90);
        btnRestablecer.setBounds(380, 540, 240, 90);

        txtDocID.addActionListener(this);
        nuevaCtr.addActionListener(this);
        confirmacionNC.addActionListener(this);

        btnBack.addActionListener(this);
        btnRestablecer.addActionListener(this);

        addToJPanel(txtDocID, nuevaCtr, confirmacionNC, btnBack, btnRestablecer);
        buttonTransparent(btnBack, btnRestablecer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().inicioSesionGUI);
            handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgInicioSesion.png");
        }else if(e.getSource() == btnRestablecer){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().anuncioRestablecer);
            handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgCntrRestablecida.png");
        }
    }
}
