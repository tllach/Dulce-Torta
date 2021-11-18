package Dulce_Torta.GUI.GUIP;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class GUIP extends JLayeredPane implements ActionListener {

    protected JLabel lblBackground, lblID;

    protected Handler handler;

    protected int width;
    protected int height;
    protected int positionX;
    protected int positionY;

    protected String urlBackground;

    public GUIP(Handler handler, int width, int height){
        this.width = width;
        this.height = height;
        this.handler = handler;
        declaration();
        initComponents();
    }

    protected abstract void declaration();
    public abstract void initComponents();

    protected void buttonTransparent(JButton ...buttons) {
        for(JButton button : buttons){
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
        }
    }

    protected void txtSetBorder(JTextField ...txts){
        for(JTextField txt: txts){
            txt.setBorder(null);
        }
    }

    protected void clearTxtField(JTextField ...txts) {
        for(JTextField txt: txts) {
            txt.setText("");
        }
    }

    protected void setFontLbl(JLabel ...lbls){
        for(JLabel lbl: lbls){
            if(lbl == lblID){
                lbl.setFont(new Font("Verdana", Font.BOLD, 20));
                continue;
            }
            lbl.setFont(new Font("Verdana", Font.PLAIN, 20));
        }
    }

    protected void addToJPanel(JComponent ...objs) {
        for(JComponent obj : objs) {
            if (obj == lblBackground) {
                add(obj, 2);
                continue;
            }
            add(obj, 0);
        }
    }

    public abstract boolean isTxtValid(int opc);
}
