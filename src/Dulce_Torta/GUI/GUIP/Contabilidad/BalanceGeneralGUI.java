package Dulce_Torta.GUI.GUIP.Contabilidad;

import Dulce_Torta.GUI.GUIP.GUIP;
import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BalanceGeneralGUI extends GUIP {

    //variables a usar en balance general
    JButton btnActivos;
    JButton btnPasivos;
    JButton btnPatrimonio;
    JButton btnAtras;

    //variables a usar en Activos
    JLabel lblValorInventario;
    JLabel lblTotalActivos;
    JButton btnCheck;
    JTextField txtValorPPE;
    JButton btnAtrasMenu;//se usa en activos, pasivos y patrimonio

    //variables a usar en Pasivos
    JLabel lblCuentasInsumos;
    JLabel lblBeneficios;
    JLabel lblTotalPasivos;

    //variables a usar en Patrimonio
    JLabel lblPatrimonio;

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
        lblValorInventario = new JLabel();
        txtValorPPE= new JTextField();
        btnCheck= new JButton();
        lblTotalActivos = new JLabel();
        btnAtrasMenu = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Contabilidad/Activos.png");

        lblValorInventario.setBounds(positionX + 515, positionY + 90, 200, 70);
        txtValorPPE.setBounds(positionX+515, positionY+215, 280, 70);
        btnCheck.setBounds(positionX+820, positionY+220, 60, 60);
        lblTotalActivos.setBounds(positionX + 515, positionY + 339, 200, 70);
        btnAtrasMenu.setBounds(positionX+35, positionY+407, 70, 70);

        txtValorPPE.addActionListener(this);
        btnCheck.addActionListener(this);
        btnAtrasMenu.addActionListener(this);

        lblValorInventario.setText("123456789");
        lblTotalActivos.setText("00000000000");

        addToJPanel(lblBackground, lblValorInventario, txtValorPPE, btnCheck, lblTotalActivos, btnAtrasMenu);

        lblTotalActivos.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTotalActivos.setForeground(new Color(127, 189, 70));

        lblValorInventario.setFont(new Font("Tahoma", Font.BOLD, 25));

        buttonTransparent(btnCheck, btnAtrasMenu);
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

        lblCuentasInsumos.setText("123456789");
        lblBeneficios.setText("9876543");
        lblTotalPasivos.setText("0000000");

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

        lblPatrimonio.setText("123456789");
        lblPatrimonio.setFont(new Font("Tahoma", Font.BOLD,22));

        addToJPanel(lblBackground, lblPatrimonio, btnAtrasMenu);
        buttonTransparent(btnAtrasMenu);
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
        if(e.getSource() == btnAtrasMenu){
            System.out.println("Click btn back al menu balance general");
            removeAll();
            principalGUI();
        }
        //btnActivos, btnPasivos,btnPatrimonio,
        if(e.getSource() == btnActivos){
            removeAll();
            ShowActivos();
        }
        if(e.getSource() == btnPasivos){
            removeAll();
            ShowPasivos();
        }
        if(e.getSource() == btnPatrimonio){
            removeAll();
            ShowPatrimonio();
        }
        if(e.getSource() == btnAtras){
            handler.getContabilidadGUI().actionPerformed(e);
        }
    }
}
