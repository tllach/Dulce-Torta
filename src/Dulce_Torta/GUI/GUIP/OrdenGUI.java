package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Actors.Orden;
import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    ArrayList<Boolean> productos;
    HashMap<String, Integer> tipoCelebracionPrecio;
    int valorTotal;

    // variables orden completadas GUI
    JLabel lblOrden;
    JLabel lblValorTotal;
    JButton btnAtrasOrdenCompletada;

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
        String[] t = {"-", "Luxury", "Combo#1", "Combo#2", "Combo#3", "No Combo"};
        String[] k ={"-", "Bodas", "Cumpleaños", "BabyShower", "Revelacion Genero", "Quinceañero", "Despedida Soltera"};

        tipoCelebracionPrecio = new HashMap<String, Integer>();

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
        productos = new ArrayList<Boolean>();
        //inicializar
        changeBackground("src/Dulce_Torta/Assets/Orden/AgregarOrden.png");

        tipoCelebracionPrecio.put("Bodas", 50000);
        tipoCelebracionPrecio.put("Cumpleaños", 0);
        tipoCelebracionPrecio.put("BabyShower", 20000);
        tipoCelebracionPrecio.put("Revelacion Genero",10000);
        tipoCelebracionPrecio.put("Quinceañero", 40000);
        tipoCelebracionPrecio.put("Despedida Soltera", 30000);

        txtIDCliente.setBounds(positionX + 240, positionY + 38 , 230, 30);
        txtEmpleadosEncargados.setBounds(positionX + 680, positionY + 90, 230,30);
        tipoCombo.setBounds(positionX + 225, positionY + 95 , 230, 30);
        tipoCelebracion.setBounds(positionX + 278, positionY + 158 , 230, 30);
        CBTorta.setBounds(positionX + 220, positionY + 228, 60, 20);
        CBTortaML.setBounds(positionX + 350, positionY + 228 , 90, 20);
        CBCupcake.setBounds(positionX + 500, positionY + 228, 80, 20);
        CBBrownie.setBounds(positionX + 220, positionY + 288, 75, 20);
        CBCakepops.setBounds(positionX + 350, positionY + 288, 85, 20);
        CBGalletas.setBounds(positionX + 500, positionY + 288, 80, 20);
        txADescripcion.setBounds(positionX + 220, positionY + 348, 340, 90);
        btnAtrasOrden.setBounds(positionX + 20, positionY + 418, 80, 100);
        btnCrearOrder.setBounds(positionX + 760, positionY + 408, 200, 80);

        txtIDCliente.addActionListener(this);
        txtEmpleadosEncargados.addActionListener(this);
        tipoCombo.addItemListener(this);
        tipoCelebracion.addItemListener(this);
        CBTorta.addItemListener(this);
        CBTortaML.addItemListener(this);
        CBCupcake.addItemListener(this);
        CBBrownie.addItemListener(this);
        CBCakepops.addItemListener(this);
        CBGalletas.addItemListener(this);
        btnAtrasOrden.addActionListener(this);
        btnCrearOrder.addActionListener(this);

        addToJPanel(lblBackground, txtIDCliente, txtEmpleadosEncargados, tipoCombo, tipoCelebracion, txADescripcion, CBTorta, CBTortaML, CBCupcake, CBBrownie, CBCakepops, CBGalletas, btnAtrasOrden, btnCrearOrder);
        buttonTransparent(btnAtrasOrden, btnCrearOrder);
        txtSetBorder(txtIDCliente, txtEmpleadosEncargados);
    }

    private void showOrderGUI(){
        removeAll();
        System.out.println("Show Orden");

        //declaracion variables
        lblOrden = new JLabel();
        lblValorTotal = new JLabel();
        btnAtrasOrdenCompletada = new JButton();

        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/Orden/OrdenCompletada.png");

        lblOrden.setBounds(positionX + 400, positionY + 100, 60, 50);
        lblValorTotal.setBounds(positionX + 400, positionY + 250, 60, 50);
        btnAtrasOrdenCompletada.setBounds(positionX + 30, positionY + 700, 50,50);

        lblOrden.setText("12345");
        lblValorTotal.setText(String.valueOf(valorTotal));

        addToJPanel(lblBackground, lblOrden, lblValorTotal, btnAtrasOrdenCompletada);

    }


    public void addRow(Object[] info){
        modelTable.addRow(info);
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    private int calcularValorTotal() {
        valorTotal = 0;
        //String tipoCelebracion, ArrayList<Boolean> productos
        valorTotal += tipoCelebracionPrecio.get(tipoCeleb);
        int i = 0;
        for(boolean b: productos){
            if(i == 0 && b){
                System.out.println("Torta");
                valorTotal += 100000;
            }else if(i == 1 && b){
                System.out.println("Torta 1/2 L");
                valorTotal += 70000;
            }else if(i == 2 && b){
                System.out.println("Brownie");
                valorTotal += 40000;
            }else if(i == 3 && b){
                System.out.println("Cupcake");
                valorTotal += 60000;
            }else if(i == 4 && b){
                System.out.println("Cakepops");
                valorTotal += 40000;
            }else if(i == 5 && b){
                System.out.println("Galletas");
                valorTotal += 40000;
            }
            i++;
        }
        System.out.println("Total: " + valorTotal);
        return valorTotal;
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
            handler.getPrincipalGUI().actionPerformed(e);
        }
        if(e.getSource() == btnCrearOrder) {
            addProductToArray();
            //int idCliente, String tipoCelebracion,
            // String tipoCombo, String empleadosEncargados,
            // int valorTotal, String descripcion,
            // ArrayList<Boolean> productos
            handler.getDisplay().addOrder(Integer.parseInt(txtIDCliente.getText()), tipoCeleb, tipoCom,
                                           txtEmpleadosEncargados.getText(), calcularValorTotal(),
                                            txADescripcion.getText(), productos);
            showOrderGUI();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tipoCelebracion) {
            tipoCeleb = (String) tipoCelebracion.getSelectedItem();
        } else if (e.getSource() == tipoCombo) {
            tipoCom = (String) tipoCombo.getSelectedItem();
        }
    }

    public void addProductToArray(){
        productos.add(0, CBTorta.isSelected());
        productos.add(1, CBTortaML.isSelected());
        productos.add(2, CBBrownie.isSelected());
        productos.add(3, CBCupcake.isSelected());
        productos.add(4, CBCakepops.isSelected());
        productos.add(5, CBGalletas.isSelected());
    }

    private void tableOrderMouseClicked(MouseEvent evt) {

    }
}