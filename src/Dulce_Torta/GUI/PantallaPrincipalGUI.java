package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PantallaPrincipalGUI extends GUI{

    JButton btnClientes;
    JButton btnOrdenes;
    JButton btnEmpleados;
    JButton btnContabilidad;
    JButton btnInventario;
    JButton btnFacturas;
    JButton btnMiPerfil;
    String bg2;

    public PantallaPrincipalGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        btnClientes = new JButton();
        btnOrdenes = new JButton();
        btnEmpleados = new JButton();
        btnContabilidad = new JButton();
        btnInventario = new JButton();
        btnFacturas = new JButton();
        btnMiPerfil = new JButton();
        bg2 = "src/Dulce_Torta/Assets/ImgPantallaP.png";
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);
        JButton btn = new JButton();
        btnClientes.setBounds(160, 40, 90, 100);
        btnOrdenes.setBounds(290, 30, 90, 110);
        btnEmpleados.setBounds(420, 30, 90, 110);
        btnContabilidad.setBounds(533, 30, 110, 110);
        btnInventario.setBounds(670, 30, 90, 110);
        btnFacturas.setBounds(790, 30, 80, 110);
        btnMiPerfil.setBounds(890, 40, 80, 90);

        btnClientes.addActionListener(this);
        btnOrdenes.addActionListener(this);
        btnEmpleados.addActionListener(this);
        btnContabilidad.addActionListener(this);
        btnInventario.addActionListener(this);
        btnFacturas.addActionListener(this);
        btnMiPerfil.addActionListener(this);
        addToJPanel(btnClientes, btnOrdenes, btnEmpleados, btnContabilidad, btnInventario, btnFacturas, btnMiPerfil);
        buttonTransparent(btnClientes, btnOrdenes, btnEmpleados, btnContabilidad, btnInventario, btnFacturas, btnMiPerfil);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnClientes){
            handler.getDisplay().changeJPanel(new JPanel(),bg2);
        }

    }
}
