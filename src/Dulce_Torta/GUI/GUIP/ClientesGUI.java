package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClientesGUI extends GUIP implements ItemListener {

    //variables a usar al principio
    JButton btnShowList, btnAggCliente;

    //variables a usar en el panel "lista clientes"
    JButton btnSearchCliente;
    JTextField txtIDCliente;
    JTable tableCliente;
    DefaultTableModel modelTable;
    JScrollPane scrollPane;
    int lastIDClient, IdToSearch;

    //variables a usar para agregar un cliente
    JTextField txtNombre, txtApellidos, txtCelular, txtNroDocumento, txtDireccion, txtCorreo;
    JComboBox tipoDocBox;
    JButton btnAtrasCliente, btnAggCliente2;
    String tipoDoc;
    JLabel textID;

    //varibles a usar para mostrar un cliente
    JLabel lblNombre, lblApellidos, lblCelular, lblTipoIdentidad, lblNroDoc, lblDireccion, lblCorreo;
    JButton btnAtrasCliente2;
    ArrayList<String> infoCliente;

    public ClientesGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    //declaracion de las variables a usar al principio
    protected void declaration() {
        btnShowList = new JButton();
        lblBackground = new JLabel();
        btnAggCliente = new JButton();
        urlBackground = "src/Dulce_Torta/Assets/Cliente/CLIENTE.png";
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
        btnAtrasCliente = new JButton();
        txtIDCliente = new JTextField();
        tableCliente = new JTable();
        scrollPane = new JScrollPane(tableCliente);

        //initComponets
        urlBackground = "src/Dulce_Torta/Assets/Lista.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        btnSearchCliente.setBounds(897, positionY + 20, 50,54);
        txtIDCliente.setBounds(706, positionY + 24, 188,47);
        btnAtrasCliente.setBounds(positionX + 53, positionY + 17, 80,80);

        txtIDCliente.setBorder(null);

        txtIDCliente.addActionListener(this);
        btnSearchCliente.addActionListener(this);
        btnAtrasCliente.addActionListener(this);

        addToJPanel(lblBackground, btnSearchCliente, txtIDCliente, btnAtrasCliente);
        buttonTransparent(btnSearchCliente, btnAtrasCliente);

        createTable();
    }

    public void createTable() {
        modelTable = new DefaultTableModel(
                null,
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

        };

        tableCliente.setModel(modelTable);
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });

        if(tableCliente.getColumnModel().getColumnCount() > 0){
            tableCliente.getColumnModel().getColumn(0).setResizable(false);
            tableCliente.getColumnModel().getColumn(1).setResizable(false);
            tableCliente.getColumnModel().getColumn(2).setResizable(false);
            tableCliente.getColumnModel().getColumn(3).setResizable(false);
            tableCliente.getColumnModel().getColumn(4).setResizable(false);
        }

        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 110, positionY + 120, 750, 320);
    }

    private void prinicipalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Cliente/CLIENTE.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnAggCliente, btnShowList);
        buttonTransparent(btnAggCliente, btnShowList);
    }

    private void addUnClienteGUI(){
        removeAll();
        System.out.println("Add cliente entre");

        //declaracion variables
        String s1[] = {"-", "CC", "Pasaporte", "RC", "NIT"};
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtDireccion = new JTextField();
        txtCelular = new JTextField();
        txtNroDocumento = new JTextField();
        txtCorreo = new JTextField();
        tipoDocBox = new JComboBox(s1);
        btnAtrasCliente = new JButton();
        btnAggCliente2 = new JButton();

        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/Cliente/AggCliente.png");

        txtNombre.setBounds(positionX + 172, positionY + 65 , 247, 30);
        txtApellidos.setBounds(positionX + 190, positionY + 115, 279, 30);
        tipoDocBox.setBounds(positionX + 250, positionY + 175, 145, 30);
        txtNroDocumento.setBounds(positionX + 710, positionY + 174, 240, 30 );
        txtCelular.setBounds(positionX + 168, positionY + 232, 219, 30);
        txtDireccion.setBounds(positionX + 189, positionY + 280, 247,30);
        txtCorreo.setBounds(positionX +168, positionY + 330, 252, 30);
        btnAtrasCliente.setBounds(positionX + 20, positionY + 412, 70,70);
        btnAggCliente2.setBounds(positionX +390, positionY + 419, 220, 50);

        tipoDocBox.addItemListener(this);
        txtNombre.addActionListener(this);
        txtApellidos.addActionListener(this);
        tipoDocBox.addActionListener(this);
        txtNroDocumento.addActionListener(this);
        txtCelular.addActionListener(this);
        txtDireccion.addActionListener(this);
        txtCorreo.addActionListener(this);
        btnAtrasCliente.addActionListener(this);
        btnAggCliente2.addActionListener(this);

        add(tipoDocBox, 0);
        addToJPanel(lblBackground, txtNombre,  txtApellidos, txtNroDocumento, txtCelular, txtDireccion, txtCorreo, btnAtrasCliente, btnAggCliente2);
        buttonTransparent(btnAtrasCliente, btnAggCliente2);
        txtSetBorder(txtNombre, txtApellidos, txtNroDocumento, txtCelular, txtDireccion, txtCorreo);
    }

    private void showUnClienteGUI(){
        removeAll();
        System.out.println("Show cliente entre");

        //declaracion variables
        lblID = new JLabel();
        lblNombre = new JLabel();
        lblApellidos = new JLabel();
        lblTipoIdentidad = new JLabel();
        lblNroDoc = new JLabel();
        lblCelular = new JLabel();
        lblDireccion = new JLabel();
        lblCorreo = new JLabel();
        btnAtrasCliente2 = new JButton();

        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/Cliente/MostrarCliente.png");
        System.out.println(IdToSearch);

        lblID.setBounds(positionX + 780, positionY + 21, 170, 30);
        lblNombre.setBounds(positionX + 170, positionY + 63, 230,40);
        lblApellidos.setBounds(positionX + 180, positionY + 112, 230, 40);
        lblTipoIdentidad.setBounds(positionX + 230, positionY + 173, 250, 30);
        lblNroDoc.setBounds(positionX + 685, positionY + 173, 250, 30);
        lblCelular.setBounds(positionX + 155, positionY + 232, 280, 30);
        lblDireccion.setBounds(positionX + 175, positionY + 278, 300, 30);
        lblCorreo.setBounds(positionX + 150, positionY + 324, 300, 40);
        btnAtrasCliente2.setBounds(positionX + 33, positionY + 410, 70, 70);

        btnAtrasCliente2.addActionListener(this);

        infoCliente = handler.getDisplay().dataBaseManager.showRegistroClientes(IdToSearch);

        lblID.setText(String.valueOf(IdToSearch));
        lblNombre.setText(infoCliente.get(0));
        lblApellidos.setText(infoCliente.get(1));
        lblTipoIdentidad.setText(infoCliente.get(2));
        lblNroDoc.setText(infoCliente.get(3));
        lblCelular.setText(infoCliente.get(4));
        lblDireccion.setText(infoCliente.get(5));
        lblCorreo.setText(infoCliente.get(6));

        addToJPanel(lblBackground, lblID, lblNombre, lblApellidos, lblTipoIdentidad, lblNroDoc, lblCelular, lblDireccion, lblCorreo, btnAtrasCliente2);
        buttonTransparent(btnAtrasCliente2);
        setFontLbl(lblID, lblNombre, lblApellidos, lblTipoIdentidad, lblNroDoc, lblCelular, lblDireccion, lblCorreo);
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    public void addRow(Object[] obj){
        modelTable.addRow(obj);
        lastIDClient = Integer.parseInt(String.valueOf(obj[0])) + 1;
    }

    public void showDialog(int opc) {
        switch (opc) {
            case 1:
                String yesOpt = "Si";
                String noOpt = "No";
                Object[] options = {yesOpt, noOpt};
                int n = JOptionPane.showOptionDialog(null,
                        "Desea mostrar la informacion del cliente con el ID: " + IdToSearch,
                        "Mostrar Cliente",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        yesOpt
                );
                if (n == JOptionPane.YES_OPTION) {
                    System.out.println("Yes");
                    showUnClienteGUI();
                } else if (n == JOptionPane.NO_OPTION){
                    System.out.println("No");
                }
                break;
            case 2:
                String okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "No se encontro ningun cliente con el ID: " + IdToSearch + "\n\tNombre: ",
                        "No se encontro el Cliente",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                if (n == JOptionPane.YES_OPTION) {
                    System.out.println("Ok");
                }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnShowList){
            System.out.println("Click Show List Btn");
            showTablaCliente();
            handler.getDisplay().dataBaseManager.addRow();
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
            IdToSearch = Integer.parseInt(txtIDCliente.getText());
            showDialog(1);
        }
        if(e.getSource() == btnAtrasCliente){
            System.out.println("Click btn Atras");
            removeAll();
            prinicipalGUI();
            handler.getDisplay().pantallaPrincipalGUI.actionPerformed(e);
        }
        if(e.getSource() == btnAggCliente2){
            handler.getDisplay().addCliente(txtNombre.getText(), txtApellidos.getText(), tipoDoc,
                    Long.parseLong(txtNroDocumento.getText()), txtDireccion.getText(),
                    Long.parseLong(txtCelular.getText()), txtCorreo.getText());
            clearTxtField(txtNombre, txtApellidos, txtCelular, txtNroDocumento, txtDireccion, txtCorreo);
            tipoDocBox.setSelectedIndex(0);
        }
        if(e.getSource() == btnAtrasCliente2) {
            showTablaCliente();
            handler.getDisplay().dataBaseManager.addRow();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tipoDocBox) {
            tipoDoc = (String) tipoDocBox.getSelectedItem();
        }
    }

    public void tableClienteMouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            JTable receptor = (JTable) e.getSource();
            IdToSearch = Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            System.out.println(IdToSearch);
            showDialog(1);
        }
    }

    public JButton getBtnAtrasCliente() { return btnAtrasCliente; }

    public JButton getBtnAggCliente2() { return btnAggCliente2; }

    public int  getIdToSearch() { return IdToSearch; }

}
