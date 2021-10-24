package Dulce_Torta.GUI;
import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class RegistroCompletado extends GUI{
    JButton btnVolverInicio;
    String bg;
    public RegistroCompletado(Handler handler, int width, int height) { super(handler, width, height);}

    @Override
    protected void declaration(){
        btnVolverInicio = new JButton();
        bg ="src/Dulce_Torta/Assets/ImgRegistroComp.png";
    }
    public void initComponents(){
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        btnVolverInicio.setBounds(360, 550, 280, 100);
        btnVolverInicio.addActionListener(this);
        addToJPanel(btnVolverInicio);
        buttonTransparent(btnVolverInicio);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnVolverInicio){
            handler.getDisplay().changeJPanel(new JPanel(), bg);
        }
    }
}
