package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiPerfilGUI extends JLayeredPane implements ActionListener {

    protected JLabel lblBackground, lblID;

    protected Handler handler;

    protected int width;
    protected int height;
    protected int positionX;
    protected int positionY;

    protected String urlBackground;

    private JButton btnCerrarSesion;
    private JLabel lblUsuario;
    private JLabel lblTelefono;
    private JLabel lblCargo;

    public MiPerfilGUI(Handler handler, int width, int height) {
        this.width = width;
        this.height = height;
        this.handler = handler;
        declaration();
    }

    protected void declaration() {
        btnCerrarSesion = new JButton();
        lblBackground = new JLabel();
        lblUsuario = new JLabel();
        lblTelefono = new JLabel();
        lblCargo = new JLabel();
        urlBackground= "src/Dulce_Torta/Assets/Cuenta.png";
    }

    public void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0, 160);

        positionX = this.getX();
        positionY = this.getY();

        lblUsuario.setBounds(positionX + 280, positionY + 130, 330, 40);
        lblTelefono.setBounds(positionX + 290, positionY + 210, 320, 50);
        lblCargo.setBounds(positionX + 260, positionY + 310, 210, 40);

        lblUsuario.setText(handler.getManager().getEmpleado(handler.getDisplay().getIDLogeado()).getNombre() + " " + handler.getManager().getEmpleado(handler.getDisplay().getIDLogeado()).getApellidos());
        lblTelefono.setText(String.valueOf(handler.getManager().getEmpleado(handler.getDisplay().getIDLogeado()).getCelular()));
        lblCargo.setText(handler.getDisplay().getCargoLogeado());

        lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 20));
        lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 20));
        lblCargo.setFont(new Font("Verdana", Font.PLAIN, 20));

        lblBackground.setIcon(new ImageIcon(urlBackground));
        lblBackground.setBounds(positionX, positionY, 1000,500);

        btnCerrarSesion.setBounds(positionX + 360, positionY + 390, 270,60);

        btnCerrarSesion.addActionListener(this);

        add(lblBackground, 2);
        add(lblUsuario,0);
        add(lblTelefono,0);
        add(lblCargo,0);
        add(btnCerrarSesion, 0);

        btnCerrarSesion.setOpaque(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnCerrarSesion){
            System.out.println("Click btn Cerrar Sesión");
            handler.getDisplay().addJpanelToMain(new JLayeredPane());
            handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgInicioSesion.png");
            handler.getDisplay().changeJPanel(handler.getDisplay().pantallaPrincipalGUI, handler.getInicioSesionGUI());
        }
    }
}
