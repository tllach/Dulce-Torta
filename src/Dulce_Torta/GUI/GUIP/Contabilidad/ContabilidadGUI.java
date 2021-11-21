package Dulce_Torta.GUI.GUIP.Contabilidad;

import Dulce_Torta.GUI.GUIP.GUIP;
import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ContabilidadGUI extends GUIP implements ItemListener {

    //variables a usar al principio
    JButton btnGastosAdmin;
    JButton btnBalanceG;

    GastosAdministracionGUI gastosAdmin;
    BalanceGeneralGUI balanceGeneral;

    public ContabilidadGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    protected void declaration() {
        btnGastosAdmin= new JButton();
        btnBalanceG= new JButton();
        lblBackground= new JLabel();
        urlBackground= "src/Dulce_Torta/Assets/Contabilidad/CONTABILIDAD.png";
        gastosAdmin = new GastosAdministracionGUI(handler, width, height);
        balanceGeneral = new BalanceGeneralGUI(handler, width, height);
    }

    public void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0, 160);

        positionX = this.getX();
        positionY = this.getY();

        lblBackground.setIcon(new ImageIcon(urlBackground));
        lblBackground.setBounds(positionX, positionY, 1000,500);

        btnGastosAdmin.setBounds(positionX+190, positionY+100, 220, 270);
        btnGastosAdmin.addActionListener(this);

        btnBalanceG.setBounds(positionX+580, positionY+120, 230, 250);
        btnBalanceG.addActionListener(this);

        addToJPanel(lblBackground, btnBalanceG, btnGastosAdmin);
        buttonTransparent(btnBalanceG, btnGastosAdmin);
    }

    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Contabilidad/CONTABILIDAD.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnGastosAdmin, btnBalanceG);
        buttonTransparent(btnGastosAdmin, btnBalanceG);
    }

    public void ShowGastosAdministrador(){
        remove(0);
        add(gastosAdmin, 0);
    }

    public void ShowBalanceGeneral(){
        remove(0);
        add(balanceGeneral, 0);
    }

    @Override
    public boolean isTxtValid(int opc) {
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGastosAdmin){
            System.out.println("Click Show Gastos Admin Btn");
            ShowGastosAdministrador();
        }
        if(e.getSource() == btnBalanceG){
            System.out.println("Click Show Balance General Btn");
            ShowBalanceGeneral();
        }
        if(e.getSource() == gastosAdmin.btnAtras || e.getSource() == balanceGeneral.btnAtras){
            System.out.println("Click btn Atras para volver a la pagina principal");
            removeAll();
            principalGUI();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
