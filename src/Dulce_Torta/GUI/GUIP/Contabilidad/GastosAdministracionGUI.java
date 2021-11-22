package Dulce_Torta.GUI.GUIP.Contabilidad;

import Dulce_Torta.Actors.Empleado;
import Dulce_Torta.GUI.GUIP.GUIP;
import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GastosAdministracionGUI extends GUIP {

    private JButton btnGastosNomina;
    private JButton btnGastosFijos;
    private JButton btnAtras;

    //variables a usar en gastos de nomina
    private JLabel lblAdmin;
    private JLabel lblPasteleros;
    private JLabel lblAyudantes;
    private JLabel lblRepartidores;
    private JLabel lblTotal;

    private int totalAdmin;
    private int totalPasteleros;
    private int totalAyudantes;
    private int totalRepartidores;
    private int totalEmpleados;
    private int totalGastosFijos;

    //variables a usar en gastos fijos
    private JButton btnServiciosP;
    private JButton btnArrendamiento;
    private JButton btnImpuestos;
    private JButton btnAtrasMain;

    //variables a usar en Servicios publicos
    private JTextField txtEnergia;
    private JTextField txtAgua;
    private JButton btnRegistrarS;
    private boolean isValidS;

    //variables a usar en arrendamiento
    private JTextField txtArrendamiento;
    private JButton btnRegistrarA;
    private boolean isValidA;

    //variables a usar en impuestos
    private JTextField txtImpuestoRFuente;
    private JTextField txtImpuestoRICA;
    private JTextField txtImpuestoRenta;
    private JButton btnRegistrarI;
    private boolean isValidI;

    private JButton btnAtrasGastoFijosMenu;

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

        isValidI = false;
        isValidS = false;
        isValidA = false;

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

        lblAdmin.setBounds(positionX + 385, positionY + 125, 240, 30);
        lblPasteleros.setBounds(positionX + 385, positionY + 190, 240, 30);
        lblAyudantes.setBounds(positionX + 385, positionY + 255, 210, 30);
        lblRepartidores.setBounds(positionX + 385, positionY + 325, 220, 30);
        lblTotal.setBounds(positionX + 370, positionY + 388, 180, 40);
        btnAtrasMain.setBounds(positionX + 32, positionY + 407, 75, 75);

        btnAtrasMain.addActionListener(this);

        lblAdmin.setText(String.valueOf(totalAdmin));
        lblPasteleros.setText(String.valueOf(totalPasteleros));
        lblAyudantes.setText(String.valueOf(totalAyudantes));
        lblRepartidores.setText(String.valueOf(totalRepartidores));
        lblTotal.setText(String.valueOf(totalEmpleados));


        addToJPanel(lblBackground, lblAdmin, lblPasteleros, lblAyudantes, lblRepartidores, lblTotal, btnAtrasMain);

        lblTotal.setFont(new Font("Verdana", Font.BOLD, 25));
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

    public void setTotal() {
        totalAdmin = 0;
        totalPasteleros = 0;
        totalAyudantes = 0;
        totalRepartidores = 0;
        for(Empleado empleado: handler.getManager().getEmpleados().values()){
            if(empleado.getTipoEmpleado().equals("Administrador")){
                totalAdmin += empleado.getSueldo();
            }
            if(empleado.getTipoEmpleado().equals("Pastelerx")){
                totalPasteleros += empleado.getSueldo();
            }
            if(empleado.getTipoEmpleado().equals("Ayudante")){
                totalAyudantes += empleado.getSueldo();
            }
            if(empleado.getTipoEmpleado().equals("Repartidor(a)")){
                totalRepartidores += empleado.getSueldo();
            }
        }
        this.totalEmpleados = totalAdmin + totalPasteleros + totalAyudantes + totalRepartidores;
    }

    @Override
    public boolean isTxtValid(int opc) {
        try {
            if (opc == 0) {
                //check if is empty
                if (txtEnergia.getText().equals("") || txtAgua.getText().equals("")) {
                    showDialog(1);
                    return false;
                } else {
                    //check that txts has numbers
                    int i = Integer.parseInt(txtEnergia.getText()) + 1;
                    i = Integer.parseInt(txtAgua.getText()) + 1;
                }
                return true;
            }
            if (opc == 1) {
                if (txtArrendamiento.getText().equals("")) {
                    showDialog(1);
                    return false;
                } else {
                    int i = Integer.parseInt(txtArrendamiento.getText()) + 1;
                }
                return true;
            }
            if (opc == 2) {
                if(txtImpuestoRFuente.getText().equals("") || txtImpuestoRICA.getText().equals("") || txtImpuestoRenta.getText().equals("")){
                    showDialog(1);
                    return false;
                }else{
                    int i = Integer.parseInt(txtImpuestoRFuente.getText()) + 1;
                    i = Integer.parseInt(txtImpuestoRICA.getText()) + 1;
                    i = Integer.parseInt(txtImpuestoRenta.getText()) + 1;
                }
                return true;
            }
        }catch(Exception e) {
            showDialog(2);
            return false;
        }
        return false;
    }

    public void showDialog(int opc) {
        switch (opc) {
            case 1:
                String okOpt = "Ok";
                Object[] options = {okOpt};
                int n = JOptionPane.showOptionDialog(null,
                        "Alguno de los campos esta vacio :(",
                        "Campo vacio",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
            case 2:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "Alguna de la informacion ingresada esta errada o\nla informacion no ha sido registrada",
                        "Error",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
            case 4:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "La informacion se registro correctamente",
                        "Información registrada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnGastosNomina){
            setTotal();
            removeAll();
            ShowGastosNomina();
        }
        if(e.getSource() == btnGastosFijos){
            removeAll();
            ShowGastosFijos();
        }
        if(e.getSource()== btnServiciosP){
            removeAll();
            ShowServiciosPublicos();
        }
        if(e.getSource()== btnArrendamiento){
            removeAll();
            ShowArrendamiento();
        }
        if(e.getSource()== btnImpuestos){
            removeAll();
            ShowImpuestos();
        }
        if(e.getSource() == btnRegistrarS){
            if (isTxtValid(0)) {
                isValidS = true;
                showDialog(4);
                btnAtrasGastoFijosMenu.doClick();
            }
        }
        if(e.getSource() == btnRegistrarA){
            if (isTxtValid(1)) {
                isValidA = true;
                showDialog(4);
                btnAtrasGastoFijosMenu.doClick();
            }
        }
        if(e.getSource() == btnRegistrarI){
            if (isTxtValid(2)) {
                isValidI = true;
                showDialog(4);
                btnAtrasGastoFijosMenu.doClick();
            }
        }
        if(e.getSource() == btnAtrasGastoFijosMenu){
            //servicios publicos
            if(isValidS){
                totalGastosFijos += Integer.parseInt(txtEnergia.getText())
                                    + Integer.parseInt(txtAgua.getText());
            }else{
                //arrendamiento
                if(isValidA){
                    totalGastosFijos += Integer.parseInt(txtArrendamiento.getText());
                }else{
                    //impuestos
                    if(isValidI){
                        totalGastosFijos += Integer.parseInt(txtImpuestoRFuente.getText())
                                + Integer.parseInt(txtImpuestoRICA.getText())
                                + Integer.parseInt(txtImpuestoRenta.getText());
                    }else{
                        showDialog(2);
                        return;
                    }
                }
            }
            removeAll();
            ShowGastosFijos();
        }
        if(e.getSource() == btnAtrasMain){
            removeAll();
            principalGUI();
        }
        if(e.getSource() == btnAtras){
            handler.getContabilidadGUI().actionPerformed(e);
        }
    }

    public int getTotalEmpleados() {
        return this.totalEmpleados;
    }

    public JButton getBtnAtras() {
        return this.btnAtras;
    }

    public int getTotalGastosFijos() {
        return this.totalGastosFijos;
    }

}
