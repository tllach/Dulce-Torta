package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ContabilidadGUI extends GUIP implements ItemListener {

    //variables a usar al principio
    JButton btnGastosAdmin;
    JButton btnBalanceG;

    //variables a usar en gastos de Administrador
    JButton btnGastosNomina;
    JButton btnGastosFijos;
    JButton btnAtras;

    //variables a usar en gastos de nomina
    JButton btnAtras3;

    //variables a usar en gastos fijos
    JButton btnServiciosP;
    JButton btnArrendamiento;
    JButton btnImpuestos;
    JButton btnAtras4;

    //variables a usar en Servicios publicos
    JTextField txtEnergia;
    JTextField txtAgua;
    JButton btnRegistrarS;
    JButton btnAtras5;

    //variables a usar en arrendamiento
    JTextField txtArrendamiento;
    JButton btnRegistrarA;
    JButton btnAtras6;

    //variables a usar en impuestos
    JTextField txtImpuestoRFuente;
    JTextField txtImpuestoRICA;
    JTextField txtImpuestoRenta;
    JButton btnRegistrarI;
    JButton btnAtras7;

    //variables a usar en balance general
    JButton btnActivos;
    JButton btnPasivos;
    JButton btnPatrimonio;
    JButton btnAtras2;

    //variables a usar en Activos
    JButton btnCheck;
    JTextField txtValorPPE;
    JButton btnAtras8;//se usa en activos, pasivos y patrimonio

    public ContabilidadGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }


    protected void declaration() {
        btnGastosAdmin= new JButton();
        btnBalanceG= new JButton();
        lblBackground= new JLabel();
        urlBackground="src/Dulce_Torta/Assets/CONTABILIDAD.png";
    }

    public void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0, 160);

        positionX = this.getX();
        positionY = this.getY();
        System.out.println(positionX);
        System.out.println(positionY);

        lblBackground.setIcon(new ImageIcon(urlBackground));
        lblBackground.setBounds(positionX, positionY, 1000,500);

        btnGastosAdmin.setBounds(positionX+190, positionY+100, 220, 270);
        btnGastosAdmin.addActionListener(this);

        btnBalanceG.setBounds(positionX+580, positionY+120, 230, 250);
        btnBalanceG.addActionListener(this);

        addToJPanel(lblBackground, btnBalanceG, btnGastosAdmin);
        buttonTransparent(btnBalanceG, btnGastosAdmin);
    }

    public void ShowGastosAdministrador(){
        removeAll();
        //declaracion de variables
        btnAtras= new JButton();
        btnGastosNomina= new JButton();
        btnGastosFijos= new JButton();

        //iniciar Componentes
        changeBackground("src/Dulce_Torta/Assets/Contabilidad_Gastos de administracion.png");

        btnAtras.setBounds(positionX + 37, positionY + 410, 75,75);
        btnGastosNomina.setBounds(positionX + 230, positionY + 150, 220,220);
        btnGastosFijos.setBounds(positionX + 600, positionY + 150, 160,220);

        btnGastosNomina.addActionListener(this);
        btnAtras.addActionListener(this);
        btnGastosFijos.addActionListener(this);

        addToJPanel(lblBackground, btnAtras, btnGastosNomina, btnGastosFijos);
        buttonTransparent(btnAtras, btnGastosNomina, btnGastosFijos);

    }
    public void ShowBalanceGeneral(){
        removeAll();
        //declaracion de variables
        btnActivos= new JButton();
        btnPasivos= new JButton();
        btnPatrimonio= new JButton();
        btnAtras2= new JButton();

        changeBackground("src/Dulce_Torta/Assets/21.png");

        btnActivos.setBounds(positionX+100, positionY+160, 160, 200);
        btnPasivos.setBounds(positionX+420, positionY+150, 150, 200);
        btnPatrimonio.setBounds(positionX+680, positionY+150, 180, 200);
        btnAtras2.setBounds(positionX + 35, positionY + 407, 75,75);

        btnPasivos.addActionListener(this);
        btnActivos.addActionListener(this);
        btnPatrimonio.addActionListener(this);
        btnAtras2.addActionListener(this);

        addToJPanel(lblBackground, btnActivos, btnPasivos,btnPatrimonio, btnAtras2);
        buttonTransparent(btnActivos, btnPasivos,btnPatrimonio, btnAtras2);

    }
    public void ShowGastosNomina(){
        btnAtras3= new JButton();
        changeBackground("src/Dulce_Torta/Assets/Contabilidad_Gastos de administracion_Nomina.png");

        btnAtras3.setBounds(positionX+35, positionY+407, 75, 75);

        btnAtras3.addActionListener(this);

        addToJPanel(lblBackground, btnAtras3);
        buttonTransparent(btnAtras3);
    }
    public void ShowGastosFijos(){
        btnServiciosP= new JButton();
        btnArrendamiento= new JButton();
        btnImpuestos= new JButton();
        btnAtras4= new JButton();

        changeBackground("src/Dulce_Torta/Assets/Gastos de administracion_Gastos fijos.png");

        btnServiciosP.setBounds(positionX+140, positionY+140, 150, 230);
        btnArrendamiento.setBounds(positionX+380, positionY+140, 200, 230);
        btnImpuestos.setBounds(positionX+650, positionY+140, 235, 230);
        btnAtras4.setBounds(positionX+35, positionY+400, 65, 65);

        btnServiciosP.addActionListener(this);
        btnArrendamiento.addActionListener(this);
        btnImpuestos.addActionListener(this);
        btnAtras4.addActionListener(this);

        addToJPanel(lblBackground, btnServiciosP, btnArrendamiento, btnImpuestos, btnAtras4);
        buttonTransparent(btnServiciosP, btnArrendamiento, btnImpuestos, btnAtras4);
    }
    public void ShowServiciosPublicos(){
        txtEnergia= new JTextField();
        txtAgua= new JTextField();
        btnRegistrarS= new JButton();
        btnAtras5= new JButton();

        changeBackground("src/Dulce_Torta/Assets/Servicios publicos.png");

        txtEnergia.setBounds(positionX+350, positionY+300, 110, 35);
        txtAgua.setBounds(positionX+705, positionY+303, 110, 35);
        btnRegistrarS.setBounds(positionX+415, positionY+400, 175, 60);
        btnAtras5.setBounds(positionX+42, positionY+408, 70, 70);

        txtEnergia.addActionListener(this);
        txtAgua.addActionListener(this);
        btnRegistrarS.addActionListener(this);
        btnAtras5.addActionListener(this);

        addToJPanel(lblBackground, txtEnergia, txtAgua, btnRegistrarS, btnAtras5);
        buttonTransparent(btnRegistrarS, btnAtras5);
    }
    public void ShowArrendamiento(){
       txtArrendamiento= new JTextField();
       btnRegistrarA= new JButton();
       btnAtras6= new JButton();

       changeBackground("src/Dulce_Torta/Assets/Arrendamiento.png");

       txtArrendamiento.setBounds(positionX+510, positionY+347, 170, 40);
       btnRegistrarA.setBounds(positionX+415, positionY+430, 170, 50);
       btnAtras6.setBounds(positionX+55, positionY+390, 70, 70 );

       txtArrendamiento.addActionListener(this);
       btnRegistrarA.addActionListener(this);
       btnAtras6.addActionListener(this);

       addToJPanel(lblBackground, txtArrendamiento, btnRegistrarA, btnAtras6);
       buttonTransparent(btnRegistrarA, btnAtras6);
    }
    public void ShowImpuestos(){
       txtImpuestoRFuente= new JTextField();
       txtImpuestoRICA= new JTextField();
       txtImpuestoRenta= new JTextField();
       btnRegistrarI= new JButton();
       btnAtras7= new JButton();

       changeBackground("src/Dulce_Torta/Assets/Impuestos2.png");

       txtImpuestoRFuente.setBounds(positionX+325, positionY+132, 150, 40);
       txtImpuestoRICA.setBounds(positionX+325, positionY+307, 150, 40);
       txtImpuestoRenta.setBounds(positionX+800, positionY+230, 150, 40);
       btnRegistrarI.setBounds(positionX+410, positionY+435, 175, 50);
       btnAtras7.setBounds(positionX+35, positionY+407, 70, 70);

       txtImpuestoRFuente.addActionListener(this);
       txtImpuestoRICA.addActionListener(this);
       txtImpuestoRenta.addActionListener(this);
       btnRegistrarI.addActionListener(this);
       btnAtras7.addActionListener(this);

       addToJPanel(lblBackground, txtImpuestoRenta, txtImpuestoRICA, txtImpuestoRFuente, btnRegistrarI, btnAtras7);
       buttonTransparent(btnRegistrarI, btnAtras7);
    }
    public void ShowActivos(){
        txtValorPPE= new JTextField();
        btnCheck= new JButton();
        btnAtras8= new JButton();

        changeBackground("src/Dulce_Torta/Assets/22.png");

        txtValorPPE.setBounds(positionX+515, positionY+215, 280, 70);
        btnCheck.setBounds(positionX+820, positionY+220, 60, 60);
        btnAtras8.setBounds(positionX+35, positionY+407, 70, 70);

        txtValorPPE.addActionListener(this);
        btnCheck.addActionListener(this);
        btnAtras8.addActionListener(this);

        addToJPanel(lblBackground, txtValorPPE, btnCheck, btnAtras8);
        buttonTransparent(btnCheck, btnAtras8);
    }
    public void ShowPasivos(){
        btnAtras8= new JButton();

        changeBackground("src/Dulce_Torta/Assets/23.png");

        btnAtras8.setBounds(positionX+35, positionY+405, 70, 70 );

        btnAtras8.addActionListener(this);

        addToJPanel(lblBackground, btnAtras8);
        buttonTransparent(btnAtras8);
    }
    public void ShowPatrimonio(){
        btnAtras8= new JButton();

        changeBackground("src/Dulce_Torta/Assets/24.png");

        btnAtras8.setBounds(positionX+35, positionY+405, 70, 70 );

        btnAtras8.addActionListener(this);

        addToJPanel(lblBackground, btnAtras8);
        buttonTransparent(btnAtras8);
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }
    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/CONTABILIDAD.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnGastosAdmin, btnBalanceG);
        buttonTransparent(btnGastosAdmin, btnBalanceG);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGastosAdmin){
            System.out.println("Click Show List Btn");
            ShowGastosAdministrador();
        }
        if(e.getSource() == btnBalanceG){
            System.out.println("Click Show List Btn");
            ShowBalanceGeneral();
        }
        if(e.getSource()==btnAtras){
            System.out.println("Click btn Atras");
            removeAll();
            principalGUI();
        }
        if(e.getSource()==btnAtras2){
            System.out.println("Click btn Atras ");
            removeAll();
            principalGUI();
        }
        if(e.getSource()==btnGastosNomina){
            System.out.println("click bnt Gasto Nomina");
            removeAll();
            ShowGastosNomina();
        }
        if(e.getSource()== btnAtras3){
            System.out.println("Click btn Atras ");
            removeAll();
            ShowGastosAdministrador();
        }
        if(e.getSource()== btnGastosFijos){
            System.out.println("Click btn Gastos fijos");
            removeAll();
            ShowGastosFijos();
        }
        if(e.getSource()== btnAtras4){
            System.out.println("Click btn Atras4");
            removeAll();
            ShowGastosAdministrador();
        }
        if(e.getSource()== btnServiciosP){
            System.out.println("Click btn servicios p");
            removeAll();
            ShowServiciosPublicos();
        }
        if(e.getSource()==btnAtras5){
            System.out.println("Click btn Atras ");
            removeAll();
            ShowGastosFijos();
        }
        if(e.getSource()== btnRegistrarS){
            System.out.println("Click btn registrar S");
            //notificacion se ha registrado los gastos de los servicion publicos
        }
        if(e.getSource()== btnArrendamiento){
            System.out.println("Click btn arrendamiento");
            removeAll();
            ShowArrendamiento();
        }
        if(e.getSource()==btnAtras6){
            System.out.println("Click btn atras ");
            removeAll();
            ShowGastosFijos();
        }
        if(e.getSource()==btnRegistrarA){
            System.out.println("Click btn RegistrarA");
            //notificacion se ha registrado el valor del arrendamiento
        }
        if(e.getSource()== btnImpuestos){
            System.out.println("click btn Impuestos");
            removeAll();
            ShowImpuestos();
        }
        if(e.getSource()== btnAtras7){
            System.out.println("Click btn Atras");
            removeAll();
            ShowGastosFijos();
        }
        if(e.getSource()== btnRegistrarI){
            System.out.println("Click registrar Impuesto");
            //notificacion se ha registrado el valor de los impuestos
        }
        if(e.getSource()== btnActivos){
            System.out.println("Click btn activos");
            removeAll();
            ShowActivos();
        }
        if(e.getSource()== btnAtras8){
            System.out.println("Click btn Atras");
            removeAll();
            ShowBalanceGeneral();
        }
        if(e.getSource()== btnPasivos){
            System.out.println("Click btn pasivos ");
            removeAll();
            ShowPasivos();
        }
        if(e.getSource()==btnPatrimonio){
            System.out.println("click btn patrimonio");
            removeAll();
            ShowPatrimonio();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
