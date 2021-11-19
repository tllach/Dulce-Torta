package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PantallaPrincipalGUI extends GUI{

    public JButton btnInicio, btnClientes, btnOrdenes, btnEmpleados;
    public JButton btnContabilidad, btnInventario, btnFacturas, btnMiPerfil;


    public PantallaPrincipalGUI(Handler handler, int width, int height){
        super(handler, width, height);
        handler.getManager().setAllClientes();
    }

    @Override
    protected void declaration() {
        btnInicio = new JButton();
        btnClientes = new JButton();
        btnOrdenes = new JButton();
        btnEmpleados = new JButton();
        btnContabilidad = new JButton();
        btnInventario = new JButton();
        btnFacturas = new JButton();
        btnMiPerfil = new JButton();
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0, 0);

        btnInicio.setBounds(20, 15,100,100);
        btnClientes.setBounds(160, 19, 90, 110);
        btnOrdenes.setBounds(290, 18, 90, 108);
        btnEmpleados.setBounds(420, 19, 90, 110);
        btnContabilidad.setBounds(533, 20, 110, 110);
        btnInventario.setBounds(670, 17, 90, 110);
        btnFacturas.setBounds(790, 20, 80, 110);
        btnMiPerfil.setBounds(890, 20, 80, 90);

        btnInicio.addActionListener(this);
        btnClientes.addActionListener(this);
        btnOrdenes.addActionListener(this);
        btnEmpleados.addActionListener(this);
        btnContabilidad.addActionListener(this);
        btnInventario.addActionListener(this);
        btnFacturas.addActionListener(this);
        btnMiPerfil.addActionListener(this);

        addToJPanel(btnInicio, btnClientes, btnOrdenes, btnEmpleados, btnContabilidad, btnInventario, btnFacturas, btnMiPerfil);
        buttonTransparent(btnInicio, btnClientes, btnOrdenes, btnEmpleados, btnContabilidad, btnInventario, btnFacturas, btnMiPerfil);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnInicio){
            System.out.println("Click Inicio");
            handler.getDisplay().addJpanelToMain(new JLayeredPane());
        }
        if(e.getSource() == btnClientes){
            System.out.println("Click Clientes");
            handler.getDisplay().addJpanelToMain(handler.getClientesGUI());
        }
        if(e.getSource() == btnOrdenes){
            System.out.println("Click Orden");
            handler.getDisplay().addJpanelToMain(handler.getOrdenGUI());
        }
        if(e.getSource() == btnEmpleados){
            System.out.println("Click Empleados");
            handler.getDisplay().addJpanelToMain(handler.getEmpleadosGUI());
        }
        if(e.getSource() == btnContabilidad){
            System.out.println("Click Contabilidad");
            handler.getDisplay().addJpanelToMain(handler.getDisplay().contabilidadGUI);
        }
        if(e.getSource() == btnInventario){
            System.out.println("Click Inventario");
            handler.getDisplay().addJpanelToMain(handler.getDisplay().inventarioGUI);
        }
        if(e.getSource() == btnFacturas){
            System.out.println("Click Facturas");
        }
        if(e.getSource() == btnMiPerfil){
            System.out.println("Click Mi Perfil");
        }
    }
}
