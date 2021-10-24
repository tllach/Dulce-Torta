package Dulce_Torta.GUI;
import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistroPrincipalGUI extends GUI{
JTextField txtNombres;
JTextField txtApellidos;
JComboBox tipoDoc;
JTextField txtNumDoc;
JTextField txtDireccion;
JComboBox tipoCargo;
JTextField txtCelular;
JPasswordField txtContraseñaR;
JButton btnBack;
JButton btnRegistrar;
String bg;


    public RegistroPrincipalGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }
    @Override
    protected void declaration() {
        txtNombres = new JTextField();
        txtApellidos = new JTextField();
        tipoDoc = new JComboBox();
        txtNumDoc = new JTextField();
        txtDireccion = new JTextField();
        tipoCargo = new JComboBox();
        txtCelular = new JTextField();
        txtContraseñaR = new JPasswordField();
        btnBack = new JButton();
        btnRegistrar = new JButton();
        bg = "src/Dulce_Torta/Assets/ImgRegistroP.png";
    }
    @Override
    protected void initComponents(){
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        txtNombres.setBounds(230, 160, 250, 30);
        txtApellidos.setBounds(680, 160, 280, 30);
        tipoDoc.setBounds(410, 230, 200, 30);
        txtNumDoc.setBounds(320, 290, 230, 30);
        txtDireccion.setBounds(240, 360, 230, 30);
        tipoCargo.setBounds(630, 360, 160, 30);
        txtCelular.setBounds(200, 420, 220, 30);
        txtContraseñaR.setBounds(270, 490, 250, 30);
        btnBack.setBounds(40, 570, 100, 90);
        btnRegistrar.setBounds(710, 580, 260, 80);

        txtNombres.addActionListener(this);
        txtApellidos.addActionListener(this);
        tipoDoc.addActionListener(this);
        txtNumDoc.addActionListener(this);
        txtDireccion.addActionListener(this);
        tipoCargo.addActionListener(this);
        txtCelular.addActionListener(this);
        txtContraseñaR.addActionListener(this);
        btnBack.addActionListener(this);
        btnRegistrar.addActionListener(this);

        addToJPanel(txtNombres, txtApellidos, tipoDoc, txtNumDoc, txtDireccion, tipoCargo, txtCelular, txtContraseñaR, btnBack, btnRegistrar);
        buttonTransparent(btnBack, btnRegistrar);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== btnBack){

        }
    }
}
