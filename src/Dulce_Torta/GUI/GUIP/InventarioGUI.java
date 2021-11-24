package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Actors.Insumo;
import Dulce_Torta.Handler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class InventarioGUI extends GUIP implements ItemListener {
    //variables a usar al principio
    private JButton btnListaInsumos;
    private JButton btnAñadirInsumo;

    //variables a usar en lista insumo
    private JButton btnAtras;
    private JTextField txtSearch;
    private JTable tableInventario;
    private DefaultTableModel modelTable;
    private JScrollPane scrollPane;
    private int IDToSearch;
    private JButton btnSearch;

    //variables a usar en añadir insumo
    private JButton btnAgregar;
    private JTextField txtNombreInsumo;

    //variables a usar mostrar insumo
    Insumo insumo;
    private JButton btnAtrasLista;
    private JButton btnCambiarValores;
    private JLabel lblNombre;
    private JLabel lblValorUnitario;
    private JLabel lblCantidad;
    private boolean wasClicked;

    //variables a usar en añadir y mostrar Insumo
    private JTextField txtCantidadInsumo;
    private JTextField txtValorUnitario;

    public InventarioGUI(Handler handler, int width, int height) {
        super(handler, width, height);
    }

    protected void declaration() {
        btnListaInsumos= new JButton();
        btnAñadirInsumo= new JButton();
        lblBackground= new JLabel();
        urlBackground="src/Dulce_Torta/Assets/Inventario/INVENTARIO.png";
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

    public void showListaInsumo() {
        btnAtras = new JButton();
        txtSearch = new JTextField();
        btnSearch= new JButton();
        tableInventario = new JTable();
        scrollPane= new JScrollPane(tableInventario);

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
        handler.getDataManager().addRow(3);
    }

    public void createTable(){
        modelTable = new DefaultTableModel(
                null,
                new String[]{"ID", "Nombre", "Cantidad"}
        ){
            Class[] types = new Class[]{
                    int.class, String.class, int.class,
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false,
            };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit[columnIndex];}

        };

        tableInventario.setModel(modelTable);
        tableInventario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableInventarioMouseClicked(evt);
            }
        });

        if(tableInventario.getColumnModel().getColumnCount() > 0){
            tableInventario.getColumnModel().getColumn(0).setResizable(false);
            tableInventario.getColumnModel().getColumn(1).setResizable(false);
            tableInventario.getColumnModel().getColumn(2).setResizable(false);
        }

        add(scrollPane, 0);
        scrollPane.setBounds(positionX + 200, positionY + 160, 600, 200);
    }

    public void ShowAñadirProducto(){
        btnAtras= new JButton();
        btnAgregar= new JButton();
        txtNombreInsumo= new JTextField();
        txtCantidadInsumo= new JTextField();
        txtValorUnitario = new JTextField();

        changeBackground("src/Dulce_Torta/Assets/Inventario/AggInsumo.png");

        txtNombreInsumo.setBounds(positionX+500, positionY+163, 300, 40);
        txtCantidadInsumo.setBounds(positionX+500, positionY+220, 300, 40);
        txtValorUnitario.setBounds(positionX+500, positionY+275, 300, 40);
        btnAtras.setBounds(positionX+70, positionY+390, 70, 70);
        btnAgregar.setBounds(positionX+360, positionY+390, 215, 55);

        txtNombreInsumo.setBorder(null);
        txtCantidadInsumo.setBorder(null);
        txtValorUnitario.setBorder(null);

        txtNombreInsumo.addActionListener(this);
        txtCantidadInsumo.addActionListener(this);
        txtValorUnitario.addActionListener(this);
        btnAtras.addActionListener(this);
        btnAgregar.addActionListener(this);

        addToJPanel(lblBackground, txtCantidadInsumo, txtNombreInsumo,
                txtValorUnitario, btnAtras, btnAgregar);
        buttonTransparent(btnAtras, btnAgregar);
    }

    private void showInsumoGUI(int opc) {
        wasClicked = false;
        removeAll();
        insumo = handler.getManager().getInsumo(IDToSearch);

        lblID = new JLabel();
        lblNombre = new JLabel();
        btnAtrasLista = new JButton();
        btnCambiarValores = new JButton();

        changeBackground("src/Dulce_Torta/Assets/Inventario/MostrarInsumo.png");

        lblID.setBounds(positionX +220, positionY + 37, 270, 40);
        lblNombre.setBounds(positionX + 320, positionY + 145, 240, 40);
        btnAtrasLista.setBounds(positionX + 50, positionY + 405, 80,70);
        btnCambiarValores.setBounds(positionX + 690, positionY + 397, 250, 70);

        lblID.setText(String.valueOf(IDToSearch));
        lblNombre.setText(insumo.getNombre());

        lblID.setFont(new Font("Verdana", Font.BOLD, 20));

        btnAtrasLista.addActionListener(this);
        btnCambiarValores.addActionListener(this);

        addToJPanel(lblBackground, lblID, lblNombre, btnAtrasLista, btnCambiarValores);

        setFontLbl(lblNombre);
        buttonTransparent(btnAtrasLista, btnCambiarValores);

        if(opc == 1) {
            wasClicked = true;
            lblCantidad = new JLabel();
            lblValorUnitario = new JLabel();

            lblCantidad.setBounds(positionX + 470, positionY + 205, 240, 50);
            lblValorUnitario.setBounds(positionX + 400, positionY + 270, 220, 40);

            lblCantidad.setText(String.valueOf(insumo.getCantidad()));
            lblValorUnitario.setText(String.valueOf(insumo.getValorUnitario()));

            addToJPanel(lblCantidad, lblValorUnitario);
            setFontLbl(lblCantidad, lblValorUnitario);

            insumo.notificarEscasez();
        }
        if(opc == 2){
            wasClicked = false;
            txtCantidadInsumo = new JTextField();
            txtValorUnitario = new JTextField();

            txtCantidadInsumo.setBounds(positionX + 470, positionY + 205, 240, 50);
            txtValorUnitario.setBounds(positionX + 400, positionY + 270, 220, 40);

            addToJPanel(txtCantidadInsumo, txtValorUnitario);
            txtSetBorder(txtCantidadInsumo, txtValorUnitario);
        }
    }

    public void addRow(Object[] info){
        modelTable.addRow(info);
    }

    @Override
    public boolean isTxtValid(int opc) {
        try{
            //añadir un insumo
            if(opc == 1){
                if(txtNombreInsumo.getText().equals("") || txtValorUnitario.getText().equals("") || txtCantidadInsumo.getText().equals("")){
                    showDialog(4);
                    return false;
                }else{
                    int i = Integer.parseInt(txtValorUnitario.getText());
                    i = Integer.parseInt(txtCantidadInsumo.getText());
                }
                return true;
            }
            //check for search
            if(opc == 2){
                //check que el id ingresado corresponde a un cliente ya creado
                Insumo insumo = handler.getManager().getInsumo(IDToSearch);
                if(insumo == null){
                    showDialog(2);
                    return false;
                }
                return true;
            }
            //check info al cambiar valores
            if(opc == 3){
                if(txtValorUnitario.getText().equals("") || txtCantidadInsumo.getText().equals("")){
                    showDialog(4);
                    return false;
                }else{
                    int i = Integer.parseInt(txtValorUnitario.getText());
                    i = Integer.parseInt(txtCantidadInsumo.getText());
                }
                return true;
            }

        }catch(Exception e){
            showDialog(3);
            return false;
        }
        return false;
    }

    @Override
    public void showDialog(int opc) {
        switch (opc) {
            case 1:
                String yesOpt = "Si";
                String noOpt = "No";
                Object[] options = {yesOpt, noOpt};
                int n = JOptionPane.showOptionDialog(null,
                        "Desea mostrar la informacion del Insumo: " + handler.getManager().getInsumo(IDToSearch).getNombre(),
                        "Mostrar Insumo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        yesOpt
                );
                if (n == JOptionPane.YES_OPTION) {
                    showInsumoGUI(1);
                }
                break;
            case 2:
                String okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "No se encontro ningun Insumo con el ID: " + IDToSearch,
                        "No se encontro el insumo",
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
                break;
            case 4:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "Alguna de los campos esta vacio",
                        "Falta Informacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
        }
    }

    private void changeBackground(String url){
        urlBackground = url;
        lblBackground.setIcon(new ImageIcon(urlBackground));
    }

    public void principalGUI(){
        urlBackground = "src/Dulce_Torta/Assets/Inventario/INVENTARIO.png";
        lblBackground.setIcon(new ImageIcon(urlBackground));
        addToJPanel(lblBackground, btnListaInsumos, btnAñadirInsumo);
        buttonTransparent(btnListaInsumos, btnAñadirInsumo);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListaInsumos) {
            removeAll();
            showListaInsumo();
        }
        if (e.getSource() == btnAtras) {
            removeAll();
            principalGUI();
        }
        if (e.getSource() == btnAñadirInsumo) {
            removeAll();
            ShowAñadirProducto();
        }
        if (e.getSource() == btnAgregar) {
            handler.getDisplay().addInsumo(txtNombreInsumo.getText(), Integer.parseInt(txtCantidadInsumo.getText()), Integer.parseInt(txtValorUnitario.getText()));
            removeAll();
            ShowAñadirProducto();
        }
        if (e.getSource() == btnCambiarValores) {
            if (wasClicked) {
                showInsumoGUI(2);
            } else {
                if (isTxtValid(3)) {
                    handler.getDataManager().updateCantidadInsumo(Integer.parseInt(lblID.getText()),
                            Integer.parseInt(txtCantidadInsumo.getText()), Integer.parseInt(txtValorUnitario.getText()));
                    insumo.setCantidad(Integer.parseInt(txtCantidadInsumo.getText()));
                    insumo.setValorUnitario(Integer.parseInt(txtValorUnitario.getText()));
                    showInsumoGUI(1);
                }
            }
        }
        if (e.getSource() == btnAtrasLista) {
            removeAll();
            showListaInsumo();
        }
        if(e.getSource() == btnSearch){
            IDToSearch = Integer.parseInt(txtSearch.getText());
            if(isTxtValid(2)){
                showDialog(1);
                showInsumoGUI(1);
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
    }

    public void tableInventarioMouseClicked(MouseEvent e) {
        if(e.getClickCount() == 1){
            JTable receptor = (JTable) e.getSource();
            IDToSearch = Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            showDialog(1);
        }
    }
}
