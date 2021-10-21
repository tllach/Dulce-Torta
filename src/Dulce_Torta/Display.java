package Dulce_Torta;

import Dulce_Torta.GUI.InicioSesionGUI;
import Dulce_Torta.GUI.PantallaPrincipalGUI;

import javax.swing.*;
import java.awt.*;

public class Display implements Runnable {

    private JFrame frame;
    private JLayeredPane content;
    private JLabel lblBackground;

    private JPanel backGroundPanel;
    private int width, height;
    private Handler handler;


    public InicioSesionGUI inicioSesionGUI;
    public PantallaPrincipalGUI pantallaPrincipalGUI;

    public Display(int width, int height){
        this.width = width;
        this.height = height;
        frame = new JFrame("Dulce Torta ;)");
        declaration();
        initComponents();
    }

    private void declaration(){
        backGroundPanel = new JPanel();
        lblBackground = new JLabel();
        content = new JLayeredPane();
        handler = new Handler(this);
        inicioSesionGUI = new InicioSesionGUI(handler,width, height);
        pantallaPrincipalGUI = new PantallaPrincipalGUI(handler, width, height);
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

        content.add(backGroundPanel, JLayeredPane.DEFAULT_LAYER);
        content.add(inicioSesionGUI, JLayeredPane.PALETTE_LAYER);
        backGroundPanel.setLayout(new BorderLayout());
        backGroundPanel.add(lblBackground);
        backGroundPanel.setBackground(Color.BLACK);
        lblBackground.setIcon(new ImageIcon("src/Dulce_Torta/Assets/ImgInicioSesion.png"));
        lblBackground.setBounds(0,500,-1,-1);
    }

    public void changeJPanel(JPanel panel, String urlBg){
        content.removeAll();
        content.add(panel, JLayeredPane.PALETTE_LAYER);
        content.revalidate();
        content.repaint();
    }

    public void changeBackGroundPanel(String url){
        lblBackground.setIcon(new ImageIcon(url));
    }

    protected JFrame getFrame(){return frame;}

    @Override
    public void run() {
        frame.setVisible(true);
    }
}
