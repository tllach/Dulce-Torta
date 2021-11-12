package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class OrdenGUI extends GUIP implements ItemListener {

    //variables a usar al principio;p
    JButton btnShowListOrder;
    JButton btnAddOrden;

    //variables a usar en la lista orden
    JButton btnSearchOrder;
    JTextField txtIDOrder;
    JTable tableOrder;
    JScrollPane scrollPane;
    int IDToSearch;

    // variables a usar al momento de crear una orden D:
    JTextField txtIDCliente, txtDireccionC;
    JComboBox tipoCelebracion;
    JCheckBox CBTorta, CBTortaML, CBCupcake, CBBrownie, CBCakepops, CBGalletas;
    JTextArea txADescripcion;
    public JButton btnAtras, btnCrearOrder;
    String tipoCeleb;

    public OrdenGUI(Handler handler, int width, int height) {super(handler, width, height);}

    protected void declaration() {
        btnShowListOrder = new JButton();
        lblBackground = new JLabel();
        btnAddOrden= new JButton();
        urlBackground = "src/Dulce_Torta/Assets/Orden.png";

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

        btnShowListOrder.setBounds(positionX + 260, positionY + 120 , 160, 270);
        btnShowListOrder.addActionListener(this);

        btnAddOrden.setBounds(positionX + 560, positionY + 130, 160,250);
        btnAddOrden.addActionListener(this);

        addToJPanel(lblBackground, btnAddOrden, btnShowListOrder);
        buttonTransparent(btnAddOrden, btnShowListOrder);
    }
    public void ShowTableOrder(){
        removeAll();
        //declaracion
        btnSearchOrder= new JButton();
        btnAtras= new JButton();
        txtIDOrder= new JTextField();
        tableOrder= new JTable();
        scrollPane= new JScrollPane();
        //iniciar componentes
        urlBackground = "src/Dulce_Torta/Assets/Lista.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        btnSearchOrder.setBounds(897, positionY + 20, 50,54);
        txtIDOrder.setBounds(706, positionY + 24, 188,47);
        btnAtras.setBounds(positionX + 53, positionY + 17, 80,80);
        txtIDOrder.setBorder(null);
        txtIDOrder.addActionListener(this);
        btnSearchOrder.addActionListener(this);
        btnAtras.addActionListener(this);

        addToJPanel(lblBackground, btnSearchOrder, txtIDOrder, btnAtras);
        buttonTransparent(btnSearchOrder, btnAtras);

        createTable();

    }
    public void createTable(){
        tableOrder.setModel(new DefaultTableModel(
                new Object[][]{
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                },
                new String[]{"ID", "Nombre", "Apellidos", "Direccion", "Celular"}
                            ){
                                Class[] types = new Class[]{
                                        int.class, String.class, String.class, String.class, long.class
                                };
                                boolean[] canEdit = new boolean[]{
                                        false, false, false, false, false
                                };
                                public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
                                public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit[columnIndex];}

                            }
        );

        if(tableOrder.getColumnModel().getColumnCount() > 0){
            tableOrder.getColumnModel().getColumn(0).setResizable(false);
            tableOrder.getColumnModel().getColumn(1).setResizable(false);
            tableOrder.getColumnModel().getColumn(2).setResizable(false);
            tableOrder.getColumnModel().getColumn(3).setResizable(false);
            tableOrder.getColumnModel().getColumn(4).setResizable(false);
        }
        tableOrder.setAutoCreateRowSorter(true);
        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 110, positionY + 120, 750, 320);
    }

    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Orden.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnAddOrden, btnShowListOrder);
        buttonTransparent(btnAddOrden, btnShowListOrder);
    }

    public void AddUnaOrdenGUI(){
        removeAll();
        System.out.println("añadir orden");
        // declaracion variables
        String k[]={"-", "Bodas", "Cumpleaños", "BabyShower", "RevelacionGenero", "Quinceañero", "DespedidaSoltera"};
        txtIDCliente= new JTextField();
        txtDireccionC= new JTextField();
        tipoCelebracion= new JComboBox(k);
        CBTorta= new JCheckBox("Torta");
        CBTortaML= new JCheckBox("Torta 1/2L");
        CBCupcake= new JCheckBox("Cupcake");
        CBBrownie= new JCheckBox("Brownie");
        CBCakepops= new JCheckBox("Cakepops");
        CBGalletas= new JCheckBox("Galletas");
        txADescripcion= new JTextArea();
        btnAtras= new JButton();
        btnCrearOrder= new JButton();
        //inicializar
        changeBackground("src/Dulce_Torta/Assets/ORDEN_AgregarOrden.png");

        txtIDCliente.setBounds(positionX + 240, positionY + 50 , 230, 30);
        txtDireccionC.setBounds(positionX + 280, positionY + 105 , 230, 30);
        tipoCelebracion.setBounds(positionX +278, positionY + 170 , 230, 30);
        CBTorta.setBounds(positionX+220, positionY+240, 60, 20);
        CBTortaML.setBounds(positionX+370, positionY+240, 90, 20);
        CBCupcake.setBounds(positionX+ 520, positionY+240, 80, 20);
        CBBrownie.setBounds(positionX+220, positionY+300, 75, 20);
        CBCakepops.setBounds(positionX+370, positionY+300, 85, 20);
        CBGalletas.setBounds(positionX+520, positionY+300, 80, 20);
        txADescripcion.setBounds(positionX+220, positionY+360, 340, 90);
        btnAtras.setBounds(positionX+20, positionY+430, 80, 100);
        btnCrearOrder.setBounds(positionX+780, positionY+420, 200, 80);

        txtIDCliente.addActionListener(this);
        txtDireccionC.addActionListener(this);
        tipoCelebracion.addActionListener(this);
        CBTorta.addActionListener(this);
        CBTortaML.addActionListener(this);
        CBCupcake.addActionListener(this);
        CBBrownie.addActionListener(this);
        CBCakepops.addActionListener(this);
        CBGalletas.addActionListener(this);
        btnAtras.addActionListener(this);
        btnCrearOrder.addActionListener(this);
        addToJPanel(lblBackground, txtIDCliente, txtDireccionC, tipoCelebracion, txADescripcion, CBTorta, CBTortaML, CBCupcake, CBBrownie, CBCakepops, CBGalletas, btnAtras, btnCrearOrder);
        buttonTransparent(btnAtras, btnCrearOrder);
        txtSetBorder(txtIDCliente, txtDireccionC);
    }

    private void showOrderGUI(){

    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnShowListOrder){
            System.out.println("Click Show List Btn");
            ShowTableOrder();
            handler.getDisplay().dataBaseManager.showRegistroCliente();
        }
        if(e.getSource() == btnAddOrden){
            System.out.println("Click Agg Cliente Btn");
            AddUnaOrdenGUI();
        }
        if(e.getSource() == txtIDCliente){
            System.out.println("Enter en el text ID CLiente a buscar");
            IDToSearch = Integer.parseInt(txtIDCliente.getText());
        }
        if(e.getSource() == btnSearchOrder){
            System.out.println("Searching");
        }
        if(e.getSource() == btnAtras){
            System.out.println("Click btn Atras");
            removeAll();
            principalGUI();
            handler.getDisplay().pantallaPrincipalGUI.actionPerformed(e);
        }
        if(e.getSource() == btnCrearOrder) {

        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tipoCelebracion) {
            tipoCeleb = (String) tipoCelebracion.getSelectedItem();
        }
        if(CBTorta.isSelected()){

        }
    }
}