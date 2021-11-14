package Dulce_Torta;

import Dulce_Torta.Actors.*;

import Dulce_Torta.Actors.Enums.TipoDocumento;
import Dulce_Torta.Databases.DataBaseManager;
import Dulce_Torta.GUI.*;
import Dulce_Torta.GUI.GUIP.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Display implements Runnable {

    private JFrame frame;
    private JLayeredPane content;
    private JLabel lblBackground;

    private JPanel backGroundPanel;
    public JPanel lastJPanel;
    public JPanel lastJPanelInMain;

    private int width, height;

    private Handler handler;
    public Manager manager;

    public InicioSesionGUI inicioSesionGUI;
    public PantallaPrincipalGUI pantallaPrincipalGUI;

    public ClientesGUI clientesGUI;
    public EmpleadosGUI empleadosGUI;
    public OrdenGUI ordenGUI;

    public RestablecerCntaGUI restablecerCntaGUI;
    public AnuncioRestablecer anuncioRestablecer;

    public DataBaseManager dataBaseManager;
    public TipoDocumento tipoDoc;

    public Display(int width, int height) {
        this.width = width;
        this.height = height;
        frame = new JFrame("Dulce Torta ;)");
        declaration();
        initComponents();
    }

    private void declaration() {
        frame.setIconImage(new ImageIcon("src/Dulce_Torta/Assets/Logo.png").getImage());

        backGroundPanel = new JPanel();
        lblBackground = new JLabel();
        content = new JLayeredPane();

        handler = new Handler(this);
        dataBaseManager = new DataBaseManager(handler);
        manager = new Manager(handler);

        inicioSesionGUI = new InicioSesionGUI(handler, width, height);
        pantallaPrincipalGUI = new PantallaPrincipalGUI(handler, width, height);
        restablecerCntaGUI = new RestablecerCntaGUI(handler, width, height);
        ordenGUI = new OrdenGUI(handler, width, height);
        anuncioRestablecer = new AnuncioRestablecer(handler, width, height);

        clientesGUI = new ClientesGUI(handler, 1000, 530);
        ordenGUI = new OrdenGUI(handler, 1000, 530);

        lastJPanel = inicioSesionGUI;
        lastJPanelInMain = new JPanel();
        lastJPanelInMain.setOpaque(false);
        lastJPanelInMain.setBounds(0, 0, 1, 1);
    }

    private void initComponents() {
        frame.setSize(width, height);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(content);

        content.setLayout(new OverlayLayout(content));

        content.add(backGroundPanel, JLayeredPane.DEFAULT_LAYER, -1);
        content.add(inicioSesionGUI, JLayeredPane.PALETTE_LAYER, 2);

        backGroundPanel.setLayout(new BorderLayout());
        backGroundPanel.add(lblBackground);
        backGroundPanel.setBackground(Color.DARK_GRAY);

        lblBackground.setIcon(new ImageIcon("src/Dulce_Torta/Assets/ImgInicioSesion.png"));
        lblBackground.setBounds(0, 0, -1, -1);
    }

    public void changeJPanel(JPanel lastJPanel, JPanel panel) {
        this.lastJPanel = panel;
        content.remove(lastJPanel);
        content.add(panel, JLayeredPane.PALETTE_LAYER, 2);
        content.add(lastJPanelInMain, JLayeredPane.PALETTE_LAYER, 1);
        content.revalidate();
        content.repaint();
    }

    public void addJpanelToMain(JLayeredPane panel) {
        content.remove(1);
        content.add(panel, JLayeredPane.PALETTE_LAYER, 1);
        content.revalidate();
        content.repaint();
    }

    public void changeBackGroundPanel(String url) {
        lblBackground.setIcon(new ImageIcon(url));
    }

    public void addCliente(String nombre, String apellidos, String tipoDoc, long nroDocumento, String direccion, long celular, String correo) {
        Cliente cliente = new Cliente(handler);
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setTipoDoc(tipoDoc);
        cliente.setNroDoc(nroDocumento);
        cliente.setDireccion(direccion);
        cliente.setCelular(celular);
        cliente.setCorreo(correo);
        dataBaseManager.addRegistroCliente(cliente);
        showInfoCliente(1);
    }

    public void showInfoCliente(int idCliente){
        Cliente cliente= manager.getCliente(idCliente);
        System.out.println("ID:" + cliente.getID());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellidos: " + cliente.getApellidos());
        System.out.println("TipoDoc: " + cliente.getTipoDoc());
        System.out.println("NroDoc: " + cliente.getNroDoc());
        System.out.println("Celular: " + cliente.getCelular());
        System.out.println("Direcion: " + cliente.getDireccion());
        System.out.println("Correo: " + cliente.getCorreo());
    }

    public void addOrder(String estado, int idCliente, String tipoCelebracion, String tipoCombo, String empleadosEncargados, String descripcion, boolean... productos) {
        Orden orden = new Orden(handler);
        orden.setEstado(estado);
        orden.setCliente(manager.getCliente(idCliente));
        orden.setTipoCelebracion(tipoCelebracion);
        orden.setTipoCombo(tipoCombo);
        orden.setEmpleadosEncargados(empleadosEncargados);
        orden.setValorTotal(12345);
        orden.setDescripcion(descripcion);
        for (boolean producto : productos) {
            orden.setProductos(producto);
        }
        dataBaseManager.addRegistroOrden(orden);
        manager.getCliente(idCliente).addToLasFacturas(orden);
    }

    public void addEmpleado(){
        Empleado empleado = new Empleado(handler);


    }

    public JFrame getFrame(){
        return frame;
    }

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
