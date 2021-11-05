package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ClientesGUI extends GUIP implements ItemListener {

    //variables a usar al principio
    JButton btnShowList;
    JButton btnAggCliente;

    //variables a usar en el panel "lista clientes"
    JButton btnSearchCliente;
    JTextField txtIDCliente;
    JTable tableCliente;
    JScrollPane scrollPane;

    int IdToSearch;

    //variables a usar para agregar un cliente
    JTextField txtNombre, txtApellidos, txtCelular, txtNroDocumento, txtDireccion, txtCorreo;
    JComboBox tipoDocBox;
    public JButton btnAtras, btnAggCliente2;
    String tipoDoc;

    public ClientesGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    //declaracion de las variables a usar al principio
    protected void declaration() {
        btnShowList = new JButton();
        lblBackground = new JLabel();
        btnAggCliente = new JButton();
        urlBackground = "src/Dulce_Torta/Assets/CLIENTE.png";
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

        btnAggCliente.setBounds(positionX + 550, positionY + 135, 220,200);
        btnAggCliente.addActionListener(this);

        btnShowList.setBounds(positionX + 220, positionY + 135 , 220, 200);
        btnShowList.addActionListener(this);

        addToJPanel(lblBackground, btnAggCliente, btnShowList);
        buttonTransparent(btnAggCliente, btnShowList);
    }

    public void showTablaCliente(){
        removeAll();
        //declaration
        btnSearchCliente = new JButton();
        btnAtras = new JButton();
        txtIDCliente = new JTextField();
        tableCliente = new JTable();
        scrollPane = new JScrollPane(tableCliente);

        //initComponets
        urlBackground = "src/Dulce_Torta/Assets/Lista.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        btnSearchCliente.setBounds(897, positionY + 20, 50,54);
        txtIDCliente.setBounds(706, positionY + 24, 188,47);
        btnAtras.setBounds(positionX + 53, positionY + 17, 80,80);

        txtIDCliente.setBorder(null);

        txtIDCliente.addActionListener(this);
        btnSearchCliente.addActionListener(this);
        btnAtras.addActionListener(this);

        addToJPanel(lblBackground, btnSearchCliente, txtIDCliente, btnAtras);
        buttonTransparent(btnSearchCliente, btnAtras);

        createTable();
    }

    public void createTable() {
        tableCliente.setModel(new DefaultTableModel(
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

        if(tableCliente.getColumnModel().getColumnCount() > 0){
            tableCliente.getColumnModel().getColumn(0).setResizable(false);
            tableCliente.getColumnModel().getColumn(1).setResizable(false);
            tableCliente.getColumnModel().getColumn(2).setResizable(false);
            tableCliente.getColumnModel().getColumn(3).setResizable(false);
            tableCliente.getColumnModel().getColumn(4).setResizable(false);
        }

        tableCliente.setAutoCreateRowSorter(true);
        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 110, positionY + 120, 750, 320);
    }

    private void prinicipalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/CLIENTE.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnAggCliente, btnShowList);
        buttonTransparent(btnAggCliente, btnShowList);
    }

    private void addUnClienteGUI(){
        removeAll();
        System.out.println("Add cliente entre");
        //declaracion variables
        String s1[] = { "CC", "Pasaporte", "RC", "NIT"};
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtDireccion = new JTextField();
        txtCelular = new JTextField();
        txtNroDocumento = new JTextField();
        txtCorreo = new JTextField();
        tipoDocBox = new JComboBox(s1);
        btnAtras = new JButton();
        btnAggCliente2 = new JButton();

        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/AggCliente.png");

        txtNombre.setBounds(positionX + 172, positionY + 65 , 247, 30);
        txtApellidos.setBounds(positionX + 190, positionY + 115, 279, 30);
        tipoDocBox.setBounds(positionX + 250, positionY + 175, 145, 30);
        txtNroDocumento.setBounds(positionX + 710, positionY + 174, 240, 30 );
        txtCelular.setBounds(positionX + 168, positionY + 232, 219, 30);
        txtDireccion.setBounds(positionX + 189, positionY + 280, 247,30);
        txtCorreo.setBounds(positionX +168, positionY + 330, 252, 30);
        btnAtras.setBounds(positionX + 20, positionY + 412, 70,70);
        btnAggCliente2.setBounds(positionX +390, positionY + 419, 220, 50);

        tipoDocBox.addItemListener(this);
        txtNombre.addActionListener(this);
        txtApellidos.addActionListener(this);
        tipoDocBox.addActionListener(this);
        txtNroDocumento.addActionListener(this);
        txtCelular.addActionListener(this);
        txtDireccion.addActionListener(this);
        txtCorreo.addActionListener(this);
        btnAtras.addActionListener(this);
        btnAggCliente2.addActionListener(this);

        add(tipoDocBox, 0);
        addToJPanel(lblBackground, txtNombre,  txtApellidos, txtNroDocumento, txtCelular, txtDireccion, txtCorreo, btnAtras, btnAggCliente2);
        buttonTransparent(btnAtras, btnAggCliente2);
        txtSetBorder(txtNombre, txtApellidos, txtNroDocumento, txtCelular, txtDireccion, txtCorreo);
    }

    private void showUnClienteGUI(){

    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnShowList){
            System.out.println("Click Show List Btn");
            showTablaCliente();
            handler.getDisplay().dataBaseManager.showRegistroCliente();
        }
        if(e.getSource() == btnAggCliente){
            System.out.println("Click Agg Cliente Btn");
            addUnClienteGUI();
        }
        if(e.getSource() == txtIDCliente){
            System.out.println("Enter en el text ID CLiente a buscar");
            IdToSearch = Integer.parseInt(txtIDCliente.getText());
        }
        if(e.getSource() == btnSearchCliente){
            System.out.println("Searching");
        }
        if(e.getSource() == btnAtras){
            System.out.println("Click btn Atras");
            removeAll();
            prinicipalGUI();
            handler.getDisplay().pantallaPrincipalGUI.actionPerformed(e);
        }
        if(e.getSource() == btnAggCliente2){
            handler.getDisplay().addCliente(txtNombre.getText(), txtApellidos.getText(), tipoDoc,
                    Long.parseLong(txtNroDocumento.getText()), txtDireccion.getText(),
                    Long.parseLong(txtCelular.getText()), txtCorreo.getText());
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tipoDocBox) {
            tipoDoc = (String) tipoDocBox.getSelectedItem();
        }
    }
}
