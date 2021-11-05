package Dulce_Torta.GUI;
import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class OrdenGUI extends GUI {
    JTextField txtNombreCliente;
    JTextField txtDireccionCliente;
    JComboBox Productos;
    JComboBox Combo;
    JComboBox tipoCeleb;
    JTextArea descripcionP;
    JTextArea ValorTotal;
    JButton btnBack;
    JButton btnCrearOrden;
    String bg;

    public OrdenGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        txtNombreCliente = new JTextField();
        txtDireccionCliente = new JTextField();
        Productos = new JComboBox();
        Combo = new JComboBox();
        tipoCeleb = new JComboBox();
        descripcionP = new JTextArea();
        ValorTotal = new JTextArea();
        btnBack = new JButton();
        btnCrearOrden = new JButton();
        bg = "src/Dulce_Torta/Assets/ImgCrearOrden.png";
    }

    public void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0, 0);

        txtNombreCliente.setBounds(300, 160, 290, 30);
        txtDireccionCliente.setBounds(319, 220, 270, 30);
        Productos.setBounds(240, 290, 200, 30);
        Combo.setBounds(180, 350, 210, 30);
        tipoCeleb.setBounds(320, 410, 200, 30);
        descripcionP.setBounds(250, 460, 290, 90);
        ValorTotal.setBounds(680, 340, 280, 70);
        btnBack.setBounds(20, 580, 90, 90);
        btnCrearOrden.setBounds(700, 570, 280, 90);

        txtNombreCliente.addActionListener(this);
        txtDireccionCliente.addActionListener(this);
        Productos.addActionListener(this);
        Combo.addActionListener(this);
        tipoCeleb.addActionListener(this);
        btnBack.addActionListener(this);
        btnCrearOrden.addActionListener(this);

        addToJPanel(txtDireccionCliente, Productos, Combo, tipoCeleb, descripcionP, ValorTotal, btnBack, btnCrearOrden);
        buttonTransparent(btnBack, btnCrearOrden);
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}
