package Dulce_Torta.GUI;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PantallaPrincipalGUI extends GUI{

    public JButton btnInicio, btnClientes, btnOrdenes, btnEmpleados;
    public JButton btnContabilidad, btnInventario, btnMiPerfil;


    public PantallaPrincipalGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        btnInicio = new JButton();
        btnClientes = new JButton();
        btnOrdenes = new JButton();
        btnEmpleados = new JButton();
        btnContabilidad = new JButton();
        btnInventario = new JButton();
        btnMiPerfil = new JButton();
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0, 0);

        btnInicio.setBounds(20, 15,100,100);
        btnClientes.setBounds(168, 13, 90, 110);
        btnOrdenes.setBounds(312, 16, 90, 108);
        btnEmpleados.setBounds(475, 15, 90, 110);
        btnContabilidad.setBounds(593, 15, 110, 110);
        btnInventario.setBounds(750, 14, 90, 110);
        btnMiPerfil.setBounds(890, 20, 80, 90);

        btnInicio.addActionListener(this);
        btnClientes.addActionListener(this);
        btnOrdenes.addActionListener(this);
        btnEmpleados.addActionListener(this);
        btnContabilidad.addActionListener(this);
        btnInventario.addActionListener(this);
        btnMiPerfil.addActionListener(this);

        addToJPanel(btnInicio, btnClientes, btnOrdenes, btnEmpleados, btnContabilidad, btnInventario, btnMiPerfil);
        buttonTransparent(btnInicio, btnClientes, btnOrdenes, btnEmpleados, btnContabilidad, btnInventario, btnMiPerfil);

        handler.getManager().setAllRegistros();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnInicio){
            handler.getDisplay().addJpanelToMain(new JLayeredPane());
        }
        if(e.getSource() == btnClientes){
            handler.getDisplay().addJpanelToMain(handler.getClientesGUI());
        }
        if(e.getSource() == btnOrdenes){
            handler.getDisplay().addJpanelToMain(handler.getOrdenGUI());
        }
        if(e.getSource() == btnEmpleados){
            handler.getDisplay().addJpanelToMain(handler.getEmpleadosGUI());
        }
        if(e.getSource() == btnContabilidad){
            handler.getDisplay().addJpanelToMain(handler.getContabilidadGUI());
        }
        if(e.getSource() == btnInventario){
            handler.getDisplay().addJpanelToMain(handler.getInventarioGUI());
            handler.getInventario().setAlmacenado();
            handler.getInventario().notificarCapacidadMax();
        }
        if(e.getSource() == btnMiPerfil){
            System.out.println("Click Mi Perfil");
            handler.getMiPerfilGUI().initComponents();
            handler.getDisplay().addJpanelToMain(handler.getMiPerfilGUI());
        }
    }
}
