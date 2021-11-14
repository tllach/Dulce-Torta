package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class OrdenGUI extends GUIP implements ItemListener {

    //variables a usar al principio;p
    JButton btnShowListOrder;
    JButton btnAddOrdenMenu;

    //variables a usar en la lista orden
    JButton btnSearchOrder;
    JTextField txtIDOrder;
    JTable tableOrder;
    DefaultTableModel modelTable;
    JScrollPane scrollPane;
    int IDToSearch;

    // variables a usar al momento de crear una orden D:
    JTextField txtIDCliente, txtEmpleadosEncargados;
    JComboBox tipoCelebracion, tipoCombo;
    JCheckBox CBTorta, CBTortaML, CBCupcake, CBBrownie, CBCakepops, CBGalletas;
    JTextArea txADescripcion;
    JButton btnAtrasOrden, btnCrearOrder;
    String tipoCeleb, tipoCom;

    public OrdenGUI(Handler handler, int width, int height) {super(handler, width, height);}

    protected void declaration() {
        btnShowListOrder = new JButton();
        lblBackground = new JLabel();
        btnAddOrdenMenu = new JButton();
        urlBackground = "src/Dulce_Torta/Assets/Orden/Orden.png";

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

        btnShowListOrder.setBounds(positionX + 260, positionY + 120 , 160, 270);
        btnShowListOrder.addActionListener(this);

        btnAddOrdenMenu.setBounds(positionX + 560, positionY + 130, 160,250);
        btnAddOrdenMenu.addActionListener(this);

        addToJPanel(lblBackground, btnAddOrdenMenu, btnShowListOrder);
        buttonTransparent(btnAddOrdenMenu, btnShowListOrder);
    }

    public void ShowTableOrder(){
        removeAll();
        //declaracion
        btnSearchOrder= new JButton();
        btnAtrasOrden = new JButton();
        txtIDOrder= new JTextField();
        tableOrder= new JTable();
        scrollPane= new JScrollPane(tableOrder);
        //iniciar componentes
        urlBackground = "src/Dulce_Torta/Assets/Lista.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        btnSearchOrder.setBounds(897, positionY + 20, 50,54);
        txtIDOrder.setBounds(706, positionY + 24, 188,47);
        btnAtrasOrden.setBounds(positionX + 53, positionY + 17, 80,80);

        txtIDOrder.addActionListener(this);
        btnSearchOrder.addActionListener(this);
        btnAtrasOrden.addActionListener(this);

        addToJPanel(lblBackground, btnSearchOrder, txtIDOrder, btnAtrasOrden);
        buttonTransparent(btnSearchOrder, btnAtrasOrden);
        txtSetBorder(txtIDOrder);

        createTable();
    }

    public void createTable(){
        modelTable = new DefaultTableModel(
                null,
                new String[]{"ID", "Estado", "ID_Cliente", "Tipo Celebracion", "Tipo Combo", "Empledos Encargados",  }
        ){
            Class[] types = new Class[]{
                    int.class, String.class, int.class, String.class, String.class, String.class,
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit[columnIndex];}

        };

        tableOrder.setModel(modelTable);
        tableOrder.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableOrderMouseClicked(evt);
            }
        });

        if(tableOrder.getColumnModel().getColumnCount() > 0){
            tableOrder.getColumnModel().getColumn(0).setResizable(false);
            tableOrder.getColumnModel().getColumn(1).setResizable(false);
            tableOrder.getColumnModel().getColumn(2).setResizable(false);
            tableOrder.getColumnModel().getColumn(3).setResizable(false);
            tableOrder.getColumnModel().getColumn(4).setResizable(false);
            tableOrder.getColumnModel().getColumn(5).setResizable(false);
        }

        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 110, positionY + 120, 750, 320);
    }

    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Orden/Orden.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnAddOrdenMenu, btnShowListOrder);
        buttonTransparent(btnAddOrdenMenu, btnShowListOrder);
    }

    public void AddUnaOrdenGUI(){
        removeAll();
        System.out.println("añadir orden");
        // declaracion variables
        String t[] = {"-", "Luxury", "Combo#1", "Combo#2", "Combo#3", "No Combo"};
        String k[]={"-", "Bodas", "Cumpleaños", "BabyShower", "Revelacion Genero", "Quinceañero", "Despedida Soltera"};

        txtIDCliente = new JTextField();
        txtEmpleadosEncargados = new JTextField();
        tipoCombo = new JComboBox(t);
        tipoCelebracion= new JComboBox(k);
        CBTorta= new JCheckBox("Torta");
        CBTortaML= new JCheckBox("Torta 1/2L");
        CBCupcake= new JCheckBox("Cupcake");
        CBBrownie= new JCheckBox("Brownie");
        CBCakepops= new JCheckBox("Cakepops");
        CBGalletas= new JCheckBox("Galletas");
        txADescripcion= new JTextArea();
        btnAtrasOrden = new JButton();
        btnCrearOrder= new JButton();
        //inicializar
        changeBackground("src/Dulce_Torta/Assets/Orden/AgregarOrden.png");

        txtIDCliente.setBounds(positionX + 240, positionY + 50 , 230, 30);
        txtEmpleadosEncargados.setBounds(positionX + 680, positionY + 107, 230,30);
        tipoCombo.setBounds(positionX + 225, positionY + 107 , 230, 30);
        tipoCelebracion.setBounds(positionX +278, positionY + 170 , 230, 30);
        CBTorta.setBounds(positionX+220, positionY+240, 60, 20);
        CBTortaML.setBounds(positionX+350, positionY+240, 90, 20);
        CBCupcake.setBounds(positionX+ 500, positionY+240, 80, 20);
        CBBrownie.setBounds(positionX+220, positionY+300, 75, 20);
        CBCakepops.setBounds(positionX+350, positionY+300, 85, 20);
        CBGalletas.setBounds(positionX+500, positionY+300, 80, 20);
        txADescripcion.setBounds(positionX+220, positionY+360, 340, 90);
        btnAtrasOrden.setBounds(positionX+20, positionY+430, 80, 100);
        btnCrearOrder.setBounds(positionX+780, positionY+420, 200, 80);

        txtIDCliente.addActionListener(this);
        txtEmpleadosEncargados.addActionListener(this);
        tipoCombo.addItemListener(this);
        tipoCelebracion.addItemListener(this);
        CBTorta.addActionListener(this);
        CBTortaML.addActionListener(this);
        CBCupcake.addActionListener(this);
        CBBrownie.addActionListener(this);
        CBCakepops.addActionListener(this);
        CBGalletas.addActionListener(this);
        btnAtrasOrden.addActionListener(this);
        btnCrearOrder.addActionListener(this);

        addToJPanel(lblBackground, txtIDCliente, txtEmpleadosEncargados, tipoCombo, tipoCelebracion, txADescripcion, CBTorta, CBTortaML, CBCupcake, CBBrownie, CBCakepops, CBGalletas, btnAtrasOrden, btnCrearOrder);
        buttonTransparent(btnAtrasOrden, btnCrearOrder);
        txtSetBorder(txtIDCliente);
    }

    public void addRow(Object[] info){
        modelTable.addRow(info);
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
            handler.getBaseManager().addRow(4);
        }
        if(e.getSource() == btnAddOrdenMenu){
            System.out.println("Click Agg Orden Btn");
            AddUnaOrdenGUI();
        }
        if(e.getSource() == txtIDOrder){
            System.out.println("Enter en el text ID Orden a buscar");
            IDToSearch = Integer.parseInt(txtIDOrder.getText());
        }
        if(e.getSource() == btnSearchOrder){
            System.out.println("Searching");
        }
        if(e.getSource() == btnAtrasOrden){
            System.out.println("Click btn Atras");
            removeAll();
            principalGUI();
            handler.getDisplay().pantallaPrincipalGUI.actionPerformed(e);
        }
        if(e.getSource() == btnCrearOrder) {
            //String estado, int idCliente, String tipoCelebracion,
            // String tipoCombo, String empleadosEncargados,
            // int valorTotal, String descripcion,
            // boolean ...productos

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e){
        if (e.getSource() == tipoCelebracion) {
            tipoCeleb = (String) tipoCelebracion.getSelectedItem();
        }else if(e.getSource() == tipoCombo){
            tipoCom = (String) tipoCombo.getSelectedItem();
        }
        if(CBTorta.isSelected()){

        }
    }

    private void tableOrderMouseClicked(MouseEvent evt) {

    }
}