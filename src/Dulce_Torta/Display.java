package Dulce_Torta;

import Dulce_Torta.Actors.*;

import Dulce_Torta.Actors.Enums.TipoDocumento;
import Dulce_Torta.Databases.DataBaseManager;
import Dulce_Torta.GUI.*;
import Dulce_Torta.GUI.GUIP.*;

import javax.swing.*;
import java.awt.*;

public class Display implements Runnable {

    private JFrame frame;
    private JLayeredPane content;
    private JLabel lblBackground;

    private JPanel backGroundPanel;
    public JPanel lastJPanel;
    public JPanel lastJPanelInMain;

    private int width, height;

    private Handler handler;
    private Manager manager;

    public InicioSesionGUI inicioSesionGUI;
    public PantallaPrincipalGUI pantallaPrincipalGUI;
    public RegistroPrincipalGUI registroPrincipalGUI;
    public RegistroCompletado registroCompletado;

    public ClientesGUI clientesGUI;
    public OrdenGUI ordenGUI;
    public ContabilidadGUI contabilidadGUI;
    public InventarioGUI inventarioGUI;

    public RestablecerCntaGUI restablecerCntaGUI;
    public AnuncioRestablecer anuncioRestablecer;

    public DataBaseManager dataBaseManager;
    public TipoDocumento tipoDoc;

    public Display(int width, int height){
        this.width = width;
        this.height = height;
        frame = new JFrame("Dulce Torta ;)");
        declaration();
        initComponents();
    }

    private void declaration(){

        frame.setIconImage(new ImageIcon("src/Dulce_Torta/Assets/Logo.png").getImage());

        backGroundPanel = new JPanel();
        lblBackground = new JLabel();
        content = new JLayeredPane();
        handler = new Handler(this);

        manager = new Manager();
        inicioSesionGUI = new InicioSesionGUI(handler,width, height);
        pantallaPrincipalGUI = new PantallaPrincipalGUI(handler, width, height);
        registroPrincipalGUI = new RegistroPrincipalGUI(handler, width, height);
        registroCompletado = new RegistroCompletado(handler, width, height);
        restablecerCntaGUI = new RestablecerCntaGUI(handler, width, height);
        ordenGUI = new OrdenGUI(handler, width, height);
        contabilidadGUI= new ContabilidadGUI(handler,width,height);
        inventarioGUI= new InventarioGUI(handler, width, height);
        anuncioRestablecer = new AnuncioRestablecer(handler, width, height);

        clientesGUI = new ClientesGUI(handler, 1000,530);
        ordenGUI = new OrdenGUI(handler, 1000, 530);
        contabilidadGUI= new ContabilidadGUI(handler, 1000, 530);
        inventarioGUI= new InventarioGUI(handler, 1000, 530);

        dataBaseManager = new DataBaseManager(handler);
        lastJPanel = inicioSesionGUI;
        lastJPanelInMain = new JPanel();
        lastJPanelInMain.setOpaque(false);
        lastJPanelInMain.setBounds(0,0,1,1);
    }

    private void initComponents(){

        frame.setSize(width,height);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(content);

        content.setLayout(new OverlayLayout(content));

        content.add(backGroundPanel, JLayeredPane.DEFAULT_LAYER,-1);
        content.add(inicioSesionGUI, JLayeredPane.PALETTE_LAYER,2);
        backGroundPanel.setLayout(new BorderLayout());
        backGroundPanel.add(lblBackground);
        backGroundPanel.setBackground(Color.DARK_GRAY);
        lblBackground.setIcon(new ImageIcon("src/Dulce_Torta/Assets/ImgInicioSesion.png"));
        lblBackground.setBounds(0,0,-1,-1);
    }

    public void changeJPanel(JPanel lastJPanel, JPanel panel){
        this.lastJPanel = panel;
        content.remove(lastJPanel);
        content.add(panel, JLayeredPane.PALETTE_LAYER, 2);
        content.add(lastJPanelInMain, JLayeredPane.PALETTE_LAYER,1);
        content.revalidate();
        content.repaint();
    }

    public void addJpanelToMain(JLayeredPane panel){
        content.remove(1);
        content.add(panel, JLayeredPane.PALETTE_LAYER, 1);
        content.revalidate();
        content.repaint();
    }

    public void changeBackGroundPanel(String url){
        lblBackground.setIcon(new ImageIcon(url));
    }

    public void addCliente(String nombre, String apellidos, String tipoDoc, long nroDocumento, String direccion, long celular, String correo){
        Cliente cliente = new Cliente(handler);
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setTipoDoc(tipoDoc);
        cliente.setNroDoc(nroDocumento);
        cliente.setDireccion(direccion);
        cliente.setCelular(celular);
        cliente.setCorreo(correo);
        manager.addCliente(cliente);
        dataBaseManager.addRegistroCliente(cliente);
    }
    public void addOrder(){

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
