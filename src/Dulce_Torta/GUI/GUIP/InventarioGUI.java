package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InventarioGUI extends GUIP implements ItemListener {
    //variables a usar al principio
    JButton btnListaInsumos;
    JButton btnAñadirInsumo;

    //variables a usar en lista insumo
    JButton btnAtras;
    JTextField txtSearch;
    JButton btnSearch;
    JTable tableOrder;
    JScrollPane scrollPane;

    //variables a usar en añadir insumo
    JButton btnAgregar;
    JTextField txtNombreInsumo;
    JTextField txtCantidadInsumo;
    JTextField txtValorInsumo;

    public InventarioGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    protected void declaration() {
        btnListaInsumos= new JButton();
        btnAñadirInsumo= new JButton();
        lblBackground= new JLabel();
        urlBackground="src/Dulce_Torta/Assets/INVENTARIO.png";
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

        btnListaInsumos.setBounds(positionX+190, positionY+100, 220, 270);
        btnAñadirInsumo.setBounds(positionX+580, positionY+120, 230, 250);

        btnListaInsumos.addActionListener(this);
        btnAñadirInsumo.addActionListener(this);

        addToJPanel(lblBackground, btnListaInsumos, btnAñadirInsumo);
        buttonTransparent(btnAñadirInsumo, btnListaInsumos);
    }

    @Override
    public boolean isTxtValid(int opc) {
        return false;
    }

    public void ShowListaInsumo() {
        btnAtras = new JButton();
        txtSearch = new JTextField();
        btnSearch= new JButton();
        tableOrder= new JTable();
        scrollPane= new JScrollPane();

        changeBackground("src/Dulce_Torta/Assets/Lista.png");

        btnAtras.setBounds(positionX + 55, positionY + 20, 70, 70);
        txtSearch.setBounds(positionX+705, positionY+23, 180, 48);
        btnSearch.setBounds(positionX+890, positionY+23, 50, 48);

        txtSearch.setBorder(null);

        btnAtras.addActionListener(this);
        txtSearch.addActionListener(this);
        btnSearch.addActionListener(this);

        addToJPanel(lblBackground, btnAtras, txtSearch, btnSearch);
        buttonTransparent(btnAtras, btnSearch);
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
                                    new String[]{"Codigo", "Nombre", "Cantidad", "Valor Unitario"}
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
        }
        tableOrder.setAutoCreateRowSorter(true);
        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 110, positionY + 120, 750, 320);
    }
    public void ShowAñadirProducto(){
        btnAtras= new JButton();
        btnAgregar= new JButton();
        txtNombreInsumo= new JTextField();
        txtCantidadInsumo= new JTextField();
        txtValorInsumo= new JTextField();

        changeBackground("src/Dulce_Torta/Assets/AggInsumo.png");

        txtNombreInsumo.setBounds(positionX+500, positionY+163, 300, 40);
        txtCantidadInsumo.setBounds(positionX+500, positionY+220, 300, 40);
        txtValorInsumo.setBounds(positionX+500, positionY+275, 300, 40);
        btnAtras.setBounds(positionX+70, positionY+390, 70, 70);
        btnAgregar.setBounds(positionX+360, positionY+390, 215, 55);

        txtNombreInsumo.setBorder(null);
        txtCantidadInsumo.setBorder(null);
        txtValorInsumo.setBorder(null);

        txtNombreInsumo.addActionListener(this);
        txtCantidadInsumo.addActionListener(this);
        txtValorInsumo.addActionListener(this);
        btnAtras.addActionListener(this);
        btnAgregar.addActionListener(this);

        addToJPanel(lblBackground, txtCantidadInsumo, txtNombreInsumo,
                    txtValorInsumo, btnAtras, btnAgregar);
        buttonTransparent(btnAtras, btnAgregar);
    }
    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }
    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/INVENTARIO.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnListaInsumos, btnAñadirInsumo);
        buttonTransparent(btnListaInsumos, btnAñadirInsumo);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnListaInsumos){
            System.out.println("Clinck Btn Lista Insumo");
            removeAll();
            ShowListaInsumo();
        }
        if(e.getSource()==btnAtras){
            System.out.println("Click btn atras");
            removeAll();
            principalGUI();
        }
        if(e.getSource()== btnAñadirInsumo){
            System.out.println("Click btn Añadir Insumo");
            removeAll();
            ShowAñadirProducto();
        }
    }

    public void itemStateChanged(ItemEvent e) {

    }
}
