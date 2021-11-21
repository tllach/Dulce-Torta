package Dulce_Torta.GUI.GUIP.Contabilidad;

import Dulce_Torta.GUI.GUIP.GUIP;
import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GastosAdministracionGUI extends GUIP {

    JButton btnGastosNomina;
    JButton btnGastosFijos;
    JButton btnAtras;

    //variables a usar en gastos de nomina
    JLabel lblAdmin;
    JLabel lblPasteleros;
    JLabel lblAyudantes;
    JLabel lblRepartidores;
    JLabel lblTotal;

    //variables a usar en gastos fijos
    JButton btnServiciosP;
    JButton btnArrendamiento;
    JButton btnImpuestos;

    JButton btnAtrasMain;

    //variables a usar en Servicios publicos
    JTextField txtEnergia;
    JTextField txtAgua;
    JButton btnRegistrarS;

    //variables a usar en arrendamiento
    JTextField txtArrendamiento;
    JButton btnRegistrarA;

    //variables a usar en impuestos
    JTextField txtImpuestoRFuente;
    JTextField txtImpuestoRICA;
    JTextField txtImpuestoRenta;
    JButton btnRegistrarI;

    JButton btnAtrasGastoFijosMenu;

    public GastosAdministracionGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        lblBackground = new JLabel();
        btnAtras= new JButton();
        btnGastosNomina= new JButton();
        btnGastosFijos= new JButton();
        urlBackground = "src/Dulce_Torta/Assets/Contabilidad/Contabilidad_Gastos de administracion.png";
    }

    @Override
    public void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height + 200);
        setLocation(0, 75);

        positionX = this.getX();
        positionY = this.getY();

        lblBackground.setIcon(new ImageIcon(urlBackground));
        lblBackground.setBounds(positionX, positionY, 1000,500);

        btnAtras.setBounds(positionX + 37, positionY + 410, 75,75);
        btnGastosNomina.setBounds(positionX + 230, positionY + 150, 220,220);
        btnGastosFijos.setBounds(positionX + 600, positionY + 150, 160,220);

        btnGastosNomina.addActionListener(this);
        btnAtras.addActionListener(this);
        btnGastosFijos.addActionListener(this);

        addToJPanel(lblBackground, btnAtras, btnGastosNomina, btnGastosFijos);
        buttonTransparent(btnAtras, btnGastosNomina, btnGastosFijos);
    }

    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Contabilidad/Contabilidad_Gastos de administracion.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnAtras, btnGastosNomina, btnGastosFijos);
        buttonTransparent(btnGastosNomina, btnGastosFijos);
    }

    //Gastos Nomina
    public void ShowGastosNomina(){

        lblAdmin = new JLabel();
        lblPasteleros  = new JLabel();
        lblAyudantes = new JLabel();
        lblRepartidores = new JLabel();
        lblTotal = new JLabel();
        btnAtrasMain = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Contabilidad_Gastos de administracion_Nomina.png");

        btnAtrasMain.setBounds(positionX+35, positionY+407, 75, 75);

        btnAtrasMain.addActionListener(this);

        lblAdmin.setText("11111111111");
        lblPasteleros.setText("2222222222");
        lblAyudantes.setText("33333333333");
        lblRepartidores.setText("4444444444");
        lblTotal.setText("55555555");

        addToJPanel(lblBackground, lblAdmin, lblPasteleros, lblAyudantes, lblRepartidores, lblTotal, btnAtrasMain);

        lblTotal.setFont(new Font("Verdana", Font.BOLD, 20));
        lblTotal.setForeground(new Color(0, 128, 255));

        setFontLbl(lblAdmin, lblPasteleros, lblAyudantes, lblRepartidores);
        buttonTransparent(btnAtrasMain);
    }

    //Gastos Fijos
    public void ShowGastosFijos(){
        btnServiciosP = new JButton();
        btnArrendamiento = new JButton();
        btnImpuestos = new JButton();
        btnAtrasMain = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Gastos de administracion_Gastos fijos.png");

        btnServiciosP.setBounds(positionX+140, positionY+140, 150, 230);
        btnArrendamiento.setBounds(positionX+380, positionY+140, 200, 230);
        btnImpuestos.setBounds(positionX+650, positionY+140, 235, 230);
        btnAtrasMain.setBounds(positionX+35, positionY+400, 65, 65);

        btnServiciosP.addActionListener(this);
        btnArrendamiento.addActionListener(this);
        btnImpuestos.addActionListener(this);
        btnAtrasMain.addActionListener(this);

        addToJPanel(lblBackground, btnServiciosP, btnArrendamiento, btnImpuestos, btnAtrasMain);
        buttonTransparent(btnServiciosP, btnArrendamiento, btnImpuestos, btnAtrasMain);
    }

    public void ShowServiciosPublicos(){
        txtEnergia= new JTextField();
        txtAgua= new JTextField();
        btnRegistrarS= new JButton();
        btnAtrasGastoFijosMenu = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Servicios publicos.png");

        txtEnergia.setBounds(positionX+350, positionY+300, 110, 35);
        txtAgua.setBounds(positionX+705, positionY+303, 110, 35);
        btnRegistrarS.setBounds(positionX+415, positionY+400, 175, 60);
        btnAtrasGastoFijosMenu.setBounds(positionX+42, positionY+408, 70, 70);

        txtEnergia.addActionListener(this);
        txtAgua.addActionListener(this);
        btnRegistrarS.addActionListener(this);
        btnAtrasGastoFijosMenu.addActionListener(this);

        addToJPanel(lblBackground, txtEnergia, txtAgua, btnRegistrarS, btnAtrasGastoFijosMenu);
        buttonTransparent(btnRegistrarS, btnAtrasGastoFijosMenu);
    }

    public void ShowArrendamiento(){
        txtArrendamiento= new JTextField();
        btnRegistrarA= new JButton();
        btnAtrasGastoFijosMenu = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Arrendamiento.png");

        txtArrendamiento.setBounds(positionX+510, positionY+347, 170, 40);
        btnRegistrarA.setBounds(positionX+415, positionY+430, 170, 50);
        btnAtrasGastoFijosMenu.setBounds(positionX+55, positionY+390, 70, 70 );

        txtArrendamiento.addActionListener(this);
        btnRegistrarA.addActionListener(this);
        btnAtrasGastoFijosMenu.addActionListener(this);

        addToJPanel(lblBackground, txtArrendamiento, btnRegistrarA, btnAtrasGastoFijosMenu);
        buttonTransparent(btnRegistrarA, btnAtrasGastoFijosMenu);
    }

    public void ShowImpuestos(){
        txtImpuestoRFuente= new JTextField();
        txtImpuestoRICA= new JTextField();
        txtImpuestoRenta= new JTextField();
        btnRegistrarI= new JButton();
        btnAtrasGastoFijosMenu = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Impuestos2.png");

        txtImpuestoRFuente.setBounds(positionX+325, positionY+132, 150, 40);
        txtImpuestoRICA.setBounds(positionX+325, positionY+307, 150, 40);
        txtImpuestoRenta.setBounds(positionX+800, positionY+230, 150, 40);
        btnRegistrarI.setBounds(positionX+410, positionY+435, 175, 50);
        btnAtrasGastoFijosMenu.setBounds(positionX+35, positionY+407, 70, 70);

        txtImpuestoRFuente.addActionListener(this);
        txtImpuestoRICA.addActionListener(this);
        txtImpuestoRenta.addActionListener(this);
        btnRegistrarI.addActionListener(this);
        btnAtrasGastoFijosMenu.addActionListener(this);

        addToJPanel(lblBackground, txtImpuestoRenta, txtImpuestoRICA, txtImpuestoRFuente, btnRegistrarI, btnAtrasGastoFijosMenu);
        buttonTransparent(btnRegistrarI, btnAtrasGastoFijosMenu);
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    @Override
    public boolean isTxtValid(int opc) {
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGastosNomina){
            System.out.println("click bnt Gasto Nomina");
            removeAll();
            ShowGastosNomina();
        }

        if(e.getSource() == btnGastosFijos){
            System.out.println("Click btn Gastos fijos");
            removeAll();
            ShowGastosFijos();
        }

        if(e.getSource()== btnServiciosP){
            System.out.println("Click btn servicios p");
            removeAll();
            ShowServiciosPublicos();
        }

        if(e.getSource()== btnArrendamiento){
            System.out.println("Click btn arrendamiento");
            removeAll();
            ShowArrendamiento();
        }

        if(e.getSource()== btnImpuestos){
            System.out.println("click btn Impuestos");
            removeAll();
            ShowImpuestos();
        }

        if(e.getSource() == btnAtrasGastoFijosMenu){
            System.out.println("Click btn atras para ir a gastos menu");
            removeAll();
            ShowGastosFijos();
        }

        if(e.getSource() == btnAtrasMain){
            System.out.println("click btn atras al menu principal gastos administracion");
            removeAll();
            principalGUI();
        }

        if(e.getSource() == btnAtras){
            handler.getContabilidadGUI().actionPerformed(e);
        }
    }
}
