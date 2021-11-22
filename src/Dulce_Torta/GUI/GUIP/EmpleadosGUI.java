package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Actors.Empleado;
import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class EmpleadosGUI extends GUIP implements ItemListener {

    //variables a usar al principio
    JButton btnShowList, btnAddEmpleadoMenu;

    //variables a usar en el panel "lista empleados"
    JButton btnSearchEmpleado;
    JTextField txtIDEmpleado;
    JTable tableEmpleados;
    DefaultTableModel modelTable;
    JScrollPane scrollPane;
    int IdToSearch;

    //variables a usar para agregar un empleado
    JTextField txtNombre, txtApellidos, txtCelular;
    JTextField txtSueldo, txtNroDocumento, txtDireccion;
    JComboBox tipoDocBox, tipoCargoBox;
    JButton btnAtrasEmpleado, btnCrearEmpleado;
    String tipoDoc, tipoCargo;

    //varibles a usar para mostrar un empleado
    JLabel lblImgEmpleado,lblNombre, lblApellidos, lblCelular;
    JLabel lblCargo, lblFechaIngreso, lblSueldo;
    JButton btnAtrasVisualizarEmpleado, btnEliminarEmpleado;
    Empleado empleado;

    public EmpleadosGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    //declaracion de las variables a usar al principio
    protected void declaration() {
        btnShowList = new JButton();
        lblBackground = new JLabel();
        btnAddEmpleadoMenu = new JButton();
        urlBackground = "src/Dulce_Torta/Assets/Empleados/EMPLEADOS.png";
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

        btnAddEmpleadoMenu.setBounds(positionX + 550, positionY + 135, 220,200);
        btnAddEmpleadoMenu.addActionListener(this);

        btnShowList.setBounds(positionX + 220, positionY + 135 , 220, 200);
        btnShowList.addActionListener(this);

        addToJPanel(lblBackground, btnAddEmpleadoMenu, btnShowList);
        buttonTransparent(btnAddEmpleadoMenu, btnShowList);
    }

    public void showTablaEmpleados(){
        removeAll();
        //declaration
        btnSearchEmpleado = new JButton();
        btnAtrasEmpleado = new JButton();
        txtIDEmpleado = new JTextField();
        tableEmpleados = new JTable();
        scrollPane = new JScrollPane(tableEmpleados);

        //initComponets
        urlBackground = "src/Dulce_Torta/Assets/Lista.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        btnSearchEmpleado.setBounds(897, positionY + 20, 50,54);
        txtIDEmpleado.setBounds(706, positionY + 24, 188,47);
        btnAtrasEmpleado.setBounds(positionX + 53, positionY + 17, 80,80);

        txtIDEmpleado.addActionListener(this);
        btnSearchEmpleado.addActionListener(this);
        btnAtrasEmpleado.addActionListener(this);

        addToJPanel(lblBackground, btnSearchEmpleado, txtIDEmpleado, btnAtrasEmpleado);
        buttonTransparent(btnSearchEmpleado, btnAtrasEmpleado);
        txtSetBorder(txtIDEmpleado);

        createTable();
        handler.getDataManager().addRow(2);
    }

    public void createTable() {
        modelTable = new DefaultTableModel(
                null,
                new String[]{"ID", "Nombre", "Apellidos", "Cargo", "Celular", "Direccion"}
        ){
            Class[] types = new Class[]{
                    int.class, String.class, String.class, String.class, long.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit[columnIndex];}

        };

        tableEmpleados.setModel(modelTable);
        tableEmpleados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });

        if(tableEmpleados.getColumnModel().getColumnCount() > 0){
            tableEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(4).setResizable(false);
        }

        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 110, positionY + 120, 750, 320);
    }

    private void prinicipalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Empleados/EMPLEADOS.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnAddEmpleadoMenu, btnShowList);
        buttonTransparent(btnAddEmpleadoMenu, btnShowList);
    }

    private void addUnEmpleadoGUI(){
        removeAll();
        System.out.println("Add cliente entre");

        //declaracion variables
        String s1[] = {"-", "CC", "Pasaporte", "RC", "NIT"};
        String s2[] = {"-", "Administrador", "Pastelerx", "Ayudante", "Repartidor(a)"};
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtDireccion = new JTextField();
        txtCelular = new JTextField();
        txtNroDocumento = new JTextField();
        tipoCargoBox = new JComboBox(s2);
        txtSueldo = new JTextField();
        tipoDocBox = new JComboBox(s1);
        btnAtrasEmpleado = new JButton();
        btnCrearEmpleado = new JButton();

        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/Empleados/AggEmpleado.png");

        txtNombre.setBounds(positionX + 300, positionY + 40 , 247, 30);
        txtApellidos.setBounds(positionX + 317, positionY + 87, 249, 30);
        tipoDocBox.setBounds(positionX + 395, positionY + 129, 145, 30);
        txtNroDocumento.setBounds(positionX + 390, positionY + 177, 240, 30);
        txtCelular.setBounds(positionX + 288, positionY + 220, 219, 30);
        txtDireccion.setBounds(positionX + 318, positionY + 273, 247,30);
        tipoCargoBox.setBounds(positionX + 285, positionY + 315, 252, 30);
        txtSueldo.setBounds(positionX + 290, positionY + 363, 250, 30);
        btnAtrasEmpleado.setBounds(positionX + 40, positionY + 412, 70,70);
        btnCrearEmpleado.setBounds(positionX +390, positionY + 419, 220, 50);

        tipoDocBox.addItemListener(this);
        txtNombre.addActionListener(this);
        txtApellidos.addActionListener(this);
        tipoDocBox.addItemListener(this);
        txtNroDocumento.addActionListener(this);
        txtCelular.addActionListener(this);
        txtDireccion.addActionListener(this);
        tipoCargoBox.addItemListener(this);
        txtSueldo.addActionListener(this);
        btnAtrasEmpleado.addActionListener(this);
        btnCrearEmpleado.addActionListener(this);

        add(tipoDocBox, 0);
        addToJPanel(lblBackground, txtNombre,  txtApellidos, txtNroDocumento,
                    txtCelular, txtDireccion, tipoCargoBox, txtSueldo,
                    btnAtrasEmpleado, btnCrearEmpleado);
        buttonTransparent(btnAtrasEmpleado, btnCrearEmpleado);
        txtSetBorder(txtNombre, txtApellidos, txtNroDocumento, txtSueldo,
                        txtCelular, txtDireccion);
    }

    private void showUnEmpleadoGUI(){
        removeAll();
        System.out.println("Show cliente entre");

        //declaracion variables
        String imgUrl[] = {"src/Dulce_Torta/Assets/Empleados/Nicolas.jpg","src/Dulce_Torta/Assets/Empleados/Julian.jpg", "src/Dulce_Torta/Assets/Empleados/Liceth.jpg", "src/Dulce_Torta/Assets/Empleados/Jimeno.jpg", "src/Dulce_Torta/Assets/Empleados/Kathy.jpg", "src/Dulce_Torta/Assets/Empleados/Tabata.jpg", "src/Dulce_Torta/Assets/Empleados/Kathy.jpg"};
        lblImgEmpleado = new JLabel();
        lblID = new JLabel();
        lblNombre = new JLabel();
        lblApellidos = new JLabel();
        lblCargo = new JLabel();
        lblCelular = new JLabel();
        lblFechaIngreso = new JLabel();
        lblSueldo = new JLabel();
        btnEliminarEmpleado = new JButton();
        btnAtrasVisualizarEmpleado = new JButton();

        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/Empleados/MostrarEmpleado.png");
        System.out.println(IdToSearch);

        lblImgEmpleado.setBounds(positionX + 110, positionY + 27, 230, 230);
        lblID.setBounds(positionX + 170, positionY + 307, 200, 30);
        lblNombre.setBounds(positionX + 470, positionY + 34, 230,40);
        lblApellidos.setBounds(positionX + 480, positionY + 88, 260, 40);
        lblFechaIngreso.setBounds(positionX + 540, positionY + 153, 300, 30);
        lblCelular.setBounds(positionX + 460, positionY + 215, 280, 30);
        lblCargo.setBounds(positionX + 450, positionY + 268, 250, 30);
        lblSueldo.setBounds(positionX + 460, positionY + 323, 300, 40);
        btnAtrasVisualizarEmpleado.setBounds(positionX + 53, positionY + 405, 70, 70);
        btnEliminarEmpleado.setBounds(positionX + 692, positionY + 396, 250, 70);

        btnEliminarEmpleado.addActionListener(this);
        btnAtrasVisualizarEmpleado.addActionListener(this);


        empleado = handler.getManager().getEmpleado(IdToSearch);

        int choice = empleado.getID() - 1;
        lblImgEmpleado.setIcon(new ImageIcon(imgUrl[choice]));
        lblID.setText(String.valueOf(empleado.getID()));
        lblNombre.setText(empleado.getNombre());
        lblApellidos.setText(empleado.getApellidos());
        lblFechaIngreso.setText(empleado.getFechaIngreso());
        lblCelular.setText(String.valueOf(empleado.getCelular()));
        lblCargo.setText(empleado.getTipoEmpleado());
        lblSueldo.setText(String.valueOf(empleado.getSueldo()));

        addToJPanel(lblBackground, lblImgEmpleado, lblID, lblNombre, lblApellidos, lblSueldo,
                     lblFechaIngreso, lblCelular, lblCargo, btnEliminarEmpleado, btnAtrasVisualizarEmpleado);
        buttonTransparent(btnAtrasVisualizarEmpleado, btnEliminarEmpleado);
        setFontLbl(lblID, lblNombre, lblApellidos, lblSueldo,lblFechaIngreso,
                    lblCelular, lblCargo);

    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    public void addRow(Object[] obj){
        modelTable.addRow(obj);
    }

    @Override
    public boolean isTxtValid(int opc){
        switch(opc){
            case 1:
                try{
                    //busca por si no digito ninguna info
                    if(txtNombre.getText().equals("") || txtApellidos.getText().equals("")
                            || txtDireccion.getText().equals("") || txtCelular.getText().equals("")
                            || txtNroDocumento.getText().equals("")) {
                        showDialog(3);
                        return false;
                    }
                    long i = Long.parseLong(txtCelular.getText()) + 1;
                    i = Long.parseLong(txtNroDocumento.getText()) + 1;
                    i = Integer.parseInt(txtSueldo.getText()) + 1;
                    tipoDocBox.getSelectedItem();
                    tipoCargoBox.getSelectedItem();
                    return true;
                }catch(Exception e){
                    showDialog(3);
                    return false;
                }
            case 2:
                try{
                    Empleado empleado = handler.getManager().getEmpleado(IdToSearch);
                    if(empleado == null){
                        return false;
                    }
                    return true;
                }catch(Exception e){
                    showDialog(2);
                    return false;
                }
        }
        return false;
    }

    public void showDialog(int opc) {
        switch (opc) {
            case 1:
                String yesOpt = "Si";
                String noOpt = "No";
                Object[] options = {yesOpt, noOpt};
                int n = JOptionPane.showOptionDialog(null,
                        "Desea mostrar la informacion del empleado con el ID: " + IdToSearch,
                        "Mostrar Empleado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        yesOpt
                );
                if (n == JOptionPane.YES_OPTION) {
                    showUnEmpleadoGUI();
                }
                break;
            case 2:
                String okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "No se encontro ningun empleado con el ID: " + IdToSearch,
                        "No se encontro el empleado",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
            case 3:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "Alguna de la informacion ingresada esta errada \nPor favor verifica y vuelve a digitar",
                        "Información Errada",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnShowList){
            System.out.println("Click Show List Btn");
            showTablaEmpleados();
        }
        if(e.getSource() == btnAddEmpleadoMenu){
            System.out.println("Click Agg Cliente Menu");
            addUnEmpleadoGUI();
        }
        if(e.getSource() == txtIDEmpleado){
            System.out.println("Entre en el text ID empleado a buscar");
            IdToSearch = Integer.parseInt(txtIDEmpleado.getText());
        }
        if(e.getSource() == btnSearchEmpleado){
            System.out.println("Searching Empleado");
            IdToSearch = Integer.parseInt(txtIDEmpleado.getText());
            if(isTxtValid(2)){
                showDialog(1);
            }else{
                showDialog(2);
            }
            clearTxtField(txtIDEmpleado);
        }
        if(e.getSource() == btnAtrasEmpleado){
            System.out.println("Click btn Atras empleado");
            removeAll();
            prinicipalGUI();
            handler.getPrincipalGUI().actionPerformed(e);
        }
        if(e.getSource() == btnCrearEmpleado){
            System.out.println("undi btn agg empleado");
            if(isTxtValid(1)){
                System.out.println("All info is correct");
                handler.getDisplay().addEmpleado(txtNombre.getText(), txtApellidos.getText(), tipoDoc,
                        Long.parseLong(txtNroDocumento.getText()), txtDireccion.getText(),
                        Long.parseLong(txtCelular.getText()), tipoCargo, Integer.parseInt(txtSueldo.getText()));
                addUnEmpleadoGUI();
            }
        }
        if(e.getSource() == btnAtrasVisualizarEmpleado) {
            showTablaEmpleados();
        }
        if(e.getSource() == btnEliminarEmpleado){
            handler.getDataManager().deleteRegistroEmpleado(IdToSearch);
            showTablaEmpleados();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tipoDocBox) {
            tipoDoc = (String) tipoDocBox.getSelectedItem();
        }
        if(e.getSource() == tipoCargoBox){
            tipoCargo = (String) tipoCargoBox.getSelectedItem();
        }
    }

    public void tableClienteMouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            JTable receptor = (JTable) e.getSource();
            IdToSearch = Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            showDialog(1);
        }
    }

    public JButton getBtnAtrasEmpleado() { return btnAtrasEmpleado; }

    public JButton getBtnCrearEmpleado() { return btnCrearEmpleado; }

    public int  getIdToSearch() { return IdToSearch; }

}
