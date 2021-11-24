package Dulce_Torta.GUI.GUIP.Contabilidad;

import Dulce_Torta.Actors.Orden;
import Dulce_Torta.GUI.GUIP.GUIP;
import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BalanceGeneralGUI extends GUIP {

    //variables a usar en balance general
    private JButton btnActivos;
    private JButton btnPasivos;
    private JButton btnPatrimonio;
    private JButton btnAtras;

    //variables a usar en Activos
    private int valorInventario;
    private int valorTotalActivos;
    private JLabel lblValorInventario;
    private JLabel lblTotalActivos;
    private JLabel lblValorPPE;
    private int valorPPE;

    //variables a usar en Pasivos
    private int valorCuentasInsumos;
    private int valorBeneficiosEmpleados;
    private int valorTotalPasivos;
    private JLabel lblCuentasInsumos;
    private JLabel lblBeneficios;
    private JLabel lblTotalPasivos;

    //variables a usar en Patrimonio
    private int valorPatrimonio;
    private JLabel lblPatrimonio;

    private JButton btnAtrasMenu;//se usa en activos, pasivos y patrimonio

    public BalanceGeneralGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        lblBackground = new JLabel();
        btnActivos = new JButton();
        btnPasivos = new JButton();
        btnPatrimonio = new JButton();
        btnAtras = new JButton();
        urlBackground = "src/Dulce_Torta/Assets/Contabilidad/BalanceGeneral.png";
    }

    @Override
    public void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height + 200);
        setLocation(0, 75);

        positionX = this.getX();
        positionY = this.getY();
        valorInventario = 0;

        lblBackground.setIcon(new ImageIcon(urlBackground));
        lblBackground.setBounds(positionX, positionY, 1000,500);

        btnActivos.setBounds(positionX+100, positionY+160, 160, 200);
        btnPasivos.setBounds(positionX+420, positionY+150, 150, 200);
        btnPatrimonio.setBounds(positionX+680, positionY+150, 180, 200);
        btnAtras.setBounds(positionX + 35, positionY + 407, 75,75);

        btnPasivos.addActionListener(this);
        btnActivos.addActionListener(this);
        btnPatrimonio.addActionListener(this);
        btnAtras.addActionListener(this);

        addToJPanel(lblBackground, btnActivos, btnPasivos,btnPatrimonio, btnAtras);
        buttonTransparent(btnActivos, btnPasivos,btnPatrimonio, btnAtras);
    }

    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Contabilidad/BalanceGeneral.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnActivos, btnPasivos,btnPatrimonio, btnAtras);
        buttonTransparent(btnActivos, btnPasivos,btnPatrimonio, btnAtras);
    }

    public void ShowActivos(){
        valorPPE = 15000000;

        lblValorInventario = new JLabel();
        lblValorPPE = new JLabel();
        lblTotalActivos = new JLabel();
        btnAtrasMenu = new JButton();

        valorTotalActivos = valorInventario + valorPPE;
        lblTotalActivos.setText(String.valueOf(valorTotalActivos));

        urlBackground = "src/Dulce_Torta/Assets/Contabilidad/Activos2.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        lblValorInventario.setBounds(positionX + 515, positionY + 90, 200, 70);
        lblValorPPE.setBounds(positionX+515, positionY+215, 280, 70);
        lblTotalActivos.setBounds(positionX + 515, positionY + 339, 200, 70);
        btnAtrasMenu.setBounds(positionX+35, positionY+407, 70, 70);

        btnAtrasMenu.addActionListener(this);

        lblValorInventario.setText(String.valueOf(valorInventario));
        lblValorPPE.setText(String.valueOf(valorPPE));

        addToJPanel(lblBackground, lblValorInventario, lblValorPPE, lblTotalActivos, btnAtrasMenu);

        lblTotalActivos.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTotalActivos.setForeground(new Color(127, 189, 70));

        lblValorPPE.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblValorInventario.setFont(new Font("Tahoma", Font.BOLD, 25));

        buttonTransparent(btnAtrasMenu);
    }

    public void ShowPasivos(){
        lblCuentasInsumos = new JLabel();
        lblBeneficios = new JLabel();
        lblTotalPasivos = new JLabel();
        btnAtrasMenu = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Pasivos.png");

        lblCuentasInsumos.setBounds(positionX + 515, positionY + 77, 200, 70);
        lblBeneficios.setBounds(positionX + 515, positionY + 199, 280, 70);
        lblTotalPasivos.setBounds(positionX + 515, positionY + 322, 200, 70);
        btnAtrasMenu.setBounds(positionX + 35, positionY + 390, 70, 70 );

        btnAtrasMenu.addActionListener(this);

        lblCuentasInsumos.setText(String.valueOf(valorCuentasInsumos));
        lblBeneficios.setText(String.valueOf(valorBeneficiosEmpleados));
        lblTotalPasivos.setText(String.valueOf(valorTotalPasivos));

        addToJPanel(lblBackground, lblCuentasInsumos, lblBeneficios, lblTotalPasivos, btnAtrasMenu);

        lblTotalPasivos.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTotalPasivos.setForeground(Color.red);

        setFontLbl(lblCuentasInsumos, lblBeneficios);

        buttonTransparent(btnAtrasMenu);
    }

    public void ShowPatrimonio(){
        lblPatrimonio = new JLabel();
        btnAtrasMenu = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Patrimonio.png");

        lblPatrimonio.setBounds(positionX + 432, positionY + 355, 150, 70);
        btnAtrasMenu.setBounds(positionX + 35, positionY + 405, 70, 70 );

        btnAtrasMenu.addActionListener(this);

        lblPatrimonio.setText(String.valueOf(valorPatrimonio));
        lblPatrimonio.setFont(new Font("Tahoma", Font.BOLD,22));

        addToJPanel(lblBackground, lblPatrimonio, btnAtrasMenu);
        buttonTransparent(btnAtrasMenu);
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    public void setValorInventario(){
        valorInventario = 0;
        for(Orden orden: handler.getManager().getOrdenes().values()){
            valorInventario += orden.getValorTotal();
        }
    }

    @Override
    public boolean isTxtValid(int opc) {
        try{
            //condicion activos
            if(opc == 0){
                if(lblValorPPE.getText().equals("")){
                    showDialog(0);
                    return false;
                }else{
                    int i = Integer.parseInt(lblValorPPE.getText());
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            showDialog(1);
        }

        return false;
    }

    @Override
    public void showDialog(int opc) {
        switch (opc) {
            case 0:
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
            case 1:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "Alguna de la informacion ingresada esta errada",
                        "Error",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAtrasMenu){
            removeAll();
            principalGUI();
        }
        if(e.getSource() == btnActivos){
            setValorInventario();
            removeAll();
            ShowActivos();
        }
        if(e.getSource() == btnPasivos){
            setValorCuentasInsumos();
            setValorBeneficiosEmpleados();
            setValorTotalPasivos();
            removeAll();
            ShowPasivos();
        }
        if(e.getSource() == btnPatrimonio){
            setValorPatrimonio();
            removeAll();
            ShowPatrimonio();
        }
        if(e.getSource() == btnAtras){
            handler.getContabilidadGUI().actionPerformed(e);
        }
    }

    private void setValorTotalPasivos() {
        valorTotalPasivos = valorBeneficiosEmpleados + valorCuentasInsumos;
    }

    private void setValorCuentasInsumos() {
        handler.getInventario().calcularCostoTotal();
        valorCuentasInsumos = handler.getInventario().getCostoTotal() + handler.getContabilidadGUI().totalGastosFijos;
    }

    private void setValorBeneficiosEmpleados(){
        handler.getContabilidadGUI().gastosAdmin.setTotal();
        valorBeneficiosEmpleados = handler.getContabilidadGUI().gastosAdmin.getTotalEmpleados();
    }

    private void setValorPatrimonio(){
        valorPatrimonio = valorTotalActivos - valorTotalPasivos;
    }

    public JButton getBtnAtras(){
        return btnAtras;
    }

}
