package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Actors.Cliente;
import Dulce_Torta.Actors.Orden;
import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrdenGUI extends GUIP implements ItemListener {

    //variables a usar al principio;p
    JButton btnShowListOrden;
    JButton btnAddOrdenMenu;

    //variables a usar en la lista orden
    JButton btnSearchOrden;
    JTextField txtIDOrden;
    JTable tableOrder;
    DefaultTableModel modelTable;
    JScrollPane scrollPane;
    int IDToSearch;

    // variables a usar al momento de crear una orden D:
    JTextField txtIDCliente, txtEmpleadosEncargados;
    JComboBox tipoCelebracion, tipoCombo;
    JCheckBox CBTorta, CBTortaML, CBCupcake;
    JCheckBox CBBrownie, CBCakepops, CBGalletas;
    JTextArea txADescripcion;
    JButton btnAtrasOrden, btnCrearOrden;
    String tipoCeleb, tipoCom;
    ArrayList<Boolean> productos;
    HashMap<String, Integer> tipoCelebracionPrecio;
    int valorTotal;

    // variables visualizar orden GUI
    Orden orden;
    JLabel lblIDCliente, lblDireccion, lblProductos;
    JLabel lblCelular, lblTipoCom, lblTipoCel, lblEstado;
    JLabel lblEmpleadosEncargados, lblDescripcion, lblValorTotal;
    JButton btnAtrasVisualizarOrden, btnCambiarEstado;
    String antEstado, sgtEstado;
    String[] TipoEstado;

    public OrdenGUI(Handler handler, int width, int height) {super(handler, width, height);}

    protected void declaration() {
        btnShowListOrden = new JButton();
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

        btnShowListOrden.setBounds(positionX + 260, positionY + 120 , 160, 270);
        btnShowListOrden.addActionListener(this);

        btnAddOrdenMenu.setBounds(positionX + 560, positionY + 130, 160,250);
        btnAddOrdenMenu.addActionListener(this);

        addToJPanel(lblBackground, btnAddOrdenMenu, btnShowListOrden);
        buttonTransparent(btnAddOrdenMenu, btnShowListOrden);
    }

    public void ShowTableOrden(){
        removeAll();
        //declaracion
        btnSearchOrden = new JButton();
        btnAtrasOrden = new JButton();
        txtIDOrden = new JTextField();
        tableOrder= new JTable();
        scrollPane= new JScrollPane(tableOrder);
        //iniciar componentes
        urlBackground = "src/Dulce_Torta/Assets/Lista.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));

        btnSearchOrden.setBounds(897, positionY + 20, 50,54);
        txtIDOrden.setBounds(706, positionY + 24, 188,47);
        btnAtrasOrden.setBounds(positionX + 53, positionY + 17, 80,80);

        txtIDOrden.addActionListener(this);
        btnSearchOrden.addActionListener(this);
        btnAtrasOrden.addActionListener(this);

        addToJPanel(lblBackground, btnSearchOrden, txtIDOrden, btnAtrasOrden);
        buttonTransparent(btnSearchOrden, btnAtrasOrden);
        txtSetBorder(txtIDOrden);

        createTable();
        handler.getBaseManager().addRow(4);
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
        addToJPanel(lblBackground, btnAddOrdenMenu, btnShowListOrden);
        buttonTransparent(btnAddOrdenMenu, btnShowListOrden);
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
        btnCrearOrden = new JButton();
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
        btnCrearOrden.setBounds(positionX + 760, positionY + 408, 200, 80);

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
        btnCrearOrden.addActionListener(this);

        addToJPanel(lblBackground, txtIDCliente, txtEmpleadosEncargados, tipoCombo, tipoCelebracion,
                    txADescripcion, CBTorta, CBTortaML, CBCupcake, CBBrownie, CBCakepops,
                    CBGalletas, btnAtrasOrden, btnCrearOrden);
        buttonTransparent(btnAtrasOrden, btnCrearOrden);
        txtSetBorder(txtIDCliente, txtEmpleadosEncargados);
    }

    private void showOrdenGUI() {
        removeAll();
        System.out.println("Show Orden");

        //declaracion variables
        lblID = new JLabel();
        lblIDCliente = new JLabel();
        lblDireccion = new JLabel();
        lblCelular = new JLabel();
        lblTipoCom = new JLabel();
        lblTipoCel = new JLabel();
        lblEstado = new JLabel();
        lblEmpleadosEncargados = new JLabel();
        lblDescripcion = new JLabel();
        lblValorTotal = new JLabel();
        lblProductos = new JLabel();
        btnCambiarEstado = new JButton();
        btnAtrasVisualizarOrden = new JButton();
        TipoEstado = new String[]{"Asignado","En Progreso", "A Repartir", "Entregado"};
        //inicializacion
        changeBackground("src/Dulce_Torta/Assets/Orden/MostrarOrden.png");

        lblID.setBounds(positionX + 185, positionY + 17, 170, 40);
        lblIDCliente.setBounds(positionX + 245, positionY + 89, 160, 30);
        lblDireccion.setBounds(positionX + 200, positionY + 138, 190, 30);
        lblCelular.setBounds(positionX + 180, positionY + 185, 160, 30);
        lblTipoCom.setBounds(positionX + 230, positionY + 235, 160, 30);
        lblTipoCel.setBounds(positionX + 280, positionY + 285, 200, 30);
        lblEstado.setBounds(positionX + 690, positionY + 21, 160, 30);
        lblEmpleadosEncargados.setBounds(positionX + 600, positionY + 125, 350, 30);
        lblDescripcion.setBounds(positionX + 600, positionY + 203, 300, 90);
        lblValorTotal.setBounds(positionX + 665, positionY + 328, 230, 50);
        btnCambiarEstado.setBounds(positionX +  710, positionY + 400, 240, 70);
        btnAtrasVisualizarOrden.setBounds(positionX + 37, positionY + 400, 70, 70);

        //actionListeners
        btnCambiarEstado.addActionListener(this);
        btnAtrasVisualizarOrden.addActionListener(this);

        //set txts
        orden = handler.getManager().getOrden(IDToSearch);

        lblID.setText(String.valueOf(orden.getIDVenta()));
        lblIDCliente.setText(String.valueOf(orden.getCliente().getID()));
        lblDireccion.setText(orden.getCliente().getDireccion());
        lblCelular.setText(String.valueOf(orden.getCliente().getCelular()));
        lblTipoCom.setText(orden.getTipoCombo());
        lblTipoCel.setText(orden.getTipoCelebracion());
        lblEstado.setText(orden.getEstado());
        lblDescripcion.setText(orden.getDescripcion());
        lblEmpleadosEncargados.setText(orden.getEmpleadosEncargadosName());
        lblValorTotal.setText(String.valueOf(orden.getValorTotal()));

        int yCheckBox = positionY + 345;
        int xInicial = positionX + 230;
        int height = 10;
        int k = 0;
        StringBuilder productos = new StringBuilder("<html><body>");
        for(Boolean b: orden.getProducto()){
            if(b){
                switch(k){
                    case 0 -> productos.append("Torta<br>");
                    case 1 -> productos.append("Torta1/2L<br>");
                    case 2 -> productos.append("Cupcake<br>");
                    case 3 -> productos.append("Brownie<br>");
                    case 4 -> productos.append("Cakepops<br>");
                    case 5 -> productos.append("Galletas<br>");
                }
                height += 20;
            }
            k++;
        }
        productos.append("</body></html>");

        lblProductos.setBounds(xInicial, yCheckBox, 200, height);
        lblProductos.setText(productos.toString());
        lblProductos.setFont(new Font("Vedana", Font.PLAIN, 17));

        //format the description string
        String[] text  = lblDescripcion.getText().split("[,.]+");
        StringBuilder descripcion = new StringBuilder("<html><body>");
        for(String i: text){
            descripcion.append(i).append("<br>");
        }
        descripcion.append("</body></html>");
        lblDescripcion.setText(descripcion.toString());
        lblDescripcion.setFont(new Font("Verdana", Font.PLAIN, 17));

        lblDireccion.setFont(new Font("Verdana", Font.PLAIN, 17));

        addToJPanel(lblBackground, lblID, lblIDCliente, lblDireccion, lblCelular, lblProductos,
                     lblTipoCom, lblTipoCel, lblEstado, lblEmpleadosEncargados, lblDescripcion,
                     lblValorTotal, btnCambiarEstado, btnAtrasVisualizarOrden);

        setFontLbl(lblID, lblIDCliente, lblCelular, lblTipoCel, lblTipoCom,
                    lblEstado, lblEmpleadosEncargados, lblValorTotal);

        buttonTransparent(btnCambiarEstado, btnAtrasVisualizarOrden);
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    public void addRow(Object[] info){
        modelTable.addRow(info);
    }

    private int calcularValorTotal() {
        valorTotal = 0;
        //String tipoCelebracion, ArrayList<Boolean> productos
        valorTotal += tipoCelebracionPrecio.get(tipoCeleb);
        int i = 0;
        for(boolean b: productos){
            if(i == 0 && b){
                valorTotal += 100000;
            }else if(i == 1 && b){
                valorTotal += 70000;
            }else if(i == 2 && b){
                valorTotal += 40000;
            }else if(i == 3 && b){
                valorTotal += 60000;
            }else if(i == 4 && b){
                valorTotal += 40000;
            }else if(i == 5 && b){
                valorTotal += 40000;
            }
            i++;
        }
        return valorTotal;
    }

    public boolean isTxtValid(int opc){
        switch(opc){
            case 1:
                try{
                    //busca por si no digito ninguna info
                    if(txtIDCliente.getText().equals("") || txtEmpleadosEncargados.getText().equals("")
                        || txADescripcion.getText().equals("")) {
                        showDialog(3);
                        return false;
                    }
                    //check si se digito un numero en el idCliente
                    int i = Integer.parseInt(txtIDCliente.getText()) + 1;
                    //check que se haya seleccionado algun elemento
                    tipoCombo.getSelectedItem();
                    tipoCelebracion.getSelectedItem();
                    //check si al menos un checkbox haya sido seleccionado
                    if(!(CBTorta.isSelected() || CBTortaML.isSelected() || CBCupcake.isSelected()
                        ||CBBrownie.isSelected() || CBCakepops.isSelected() || CBGalletas.isSelected())){
                        showDialog(3);
                        return false;
                    }
                    //check que el id ingresado corresponde a un cliente ya creado
                    Cliente cliente = handler.getManager().getCliente(IDToSearch);
                    if(cliente == null){
                        showDialog(2);
                        return false;
                    }
                    return true;
                }catch(Exception e){
                    showDialog(3);
                    return false;
                }
            case 2:
                try{
                    Orden orden = handler.getManager().getOrden(IDToSearch);
                    if(orden == null){
                        return false;
                    }
                    return true;
                }catch(Exception e){
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
                        "Desea mostrar la informacion de la orden con el ID: " + IDToSearch,
                        "Mostrar Orden",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        yesOpt
                );
                if (n == JOptionPane.YES_OPTION) {
                    showOrdenGUI();
                }
                break;
            case 2:
                String okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "No se encontro ninguna orden con el ID: " + IDToSearch,
                        "No se encontro la orden",
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
        if(e.getSource() == btnShowListOrden){
            System.out.println("Click Show List Btn");
            ShowTableOrden();
        }
        if(e.getSource() == btnAddOrdenMenu){
            System.out.println("Click Agg Orden Menu");
            AddUnaOrdenGUI();
        }
        if(e.getSource() == txtIDOrden){
            System.out.println("Enter en el text ID Orden a buscar");
            IDToSearch = Integer.parseInt(txtIDOrden.getText());
        }
        if(e.getSource() == btnSearchOrden){
            System.out.println("Searching Orden");
            IDToSearch = Integer.parseInt(txtIDOrden.getText());
            if(isTxtValid(2)){
                showDialog(1);
            }else{
                showDialog(2);
            }
            clearTxtField(txtIDOrden);
        }
        if(e.getSource() == btnAtrasOrden){
            System.out.println("Click btn Atras Orden");
            removeAll();
            principalGUI();
            handler.getPrincipalGUI().actionPerformed(e);
        }
        if(e.getSource() == btnCrearOrden) {
            addProductToArray();
            IDToSearch = Integer.parseInt(txtIDCliente.getText());
            if(isTxtValid(1)){
                handler.getDisplay().addOrder(Integer.parseInt(txtIDCliente.getText()), tipoCeleb, tipoCom,
                        txtEmpleadosEncargados.getText(), calcularValorTotal(),
                        txADescripcion.getText(), productos);
                AddUnaOrdenGUI();
            }else{
                int i = productos.toArray().length - 1;
                System.out.println(i);
                while(i >= 0){
                    System.out.println(productos.remove(i));
                    i--;
                }
            }
        }
        if(e.getSource() == btnCambiarEstado){
            antEstado = orden.getEstado();
            if(!antEstado.equals("Entregado")){
                sgtEstado = "Asignado";
                if(lblEstado.getText().equals("Asignado")){
                    sgtEstado = "En Progreso";
                }else if (lblEstado.getText().equals("En Progreso")){
                    sgtEstado = "A Repartir";
                }else if (lblEstado.getText().equals("A Repartir")){
                    sgtEstado = "Entregado";
                }
                handler.getBaseManager().updateOrdenEstado(sgtEstado,lblID.getText());
                orden.setEstado(sgtEstado);
                showOrdenGUI();
            }
        }
        if(e.getSource() == btnAtrasVisualizarOrden){
            System.out.println("Atras visualizar Orden");
            ShowTableOrden();
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

    public void tableOrderMouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            JTable receptor = (JTable) e.getSource();
            IDToSearch = Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            showDialog(1);
        }
    }

}