package Dulce_Torta.GUI;
import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class RestablecerCnsñ extends GUI{
    JTextField txtDocID;
    JPasswordField nuevaContraseña;
    JPasswordField confirmacionNC;
    JButton btnback;
    JButton btnRestablecer;
    String bg;
    public RestablecerCnsñ(Handler handler, int width, int height) { super(handler, width, height);}

    @Override
    protected void declaration() {
        txtDocID = new JTextField();
        nuevaContraseña = new JPasswordField();
        confirmacionNC = new JPasswordField();
        btnback = new JButton();
        btnRestablecer = new JButton();
        bg = "src/Dulce_Torta/Assets/ImgRestablecerC.png";
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        txtDocID.setBounds(480, 250, 360, 40);
        nuevaContraseña.setBounds(480, 320, 360, 40);
        confirmacionNC.setBounds(300, 450, 360, 40);
        btnback.setBounds(53, 550, 100, 100);
        btnRestablecer.setBounds(380, 560, 240, 90);

        txtDocID.addActionListener(this);
        nuevaContraseña.addActionListener(this);
        confirmacionNC.addActionListener(this);
        btnback.addActionListener(this);
        btnRestablecer.addActionListener(this);
        addToJPanel(txtDocID, nuevaContraseña, confirmacionNC, btnback, btnRestablecer);
        buttonTransparent(btnback, btnRestablecer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnback){
            handler.getDisplay().changeJPanel(new JPanel(), bg);
        }
    }
}
