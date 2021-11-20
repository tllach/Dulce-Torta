package Dulce_Torta.GUI.RestablecerContraseña;
import Dulce_Torta.Actors.Empleado;
import Dulce_Torta.GUI.GUI;
import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class RestablecerCntaGUI extends GUI {

    Empleado empleado;

    JTextField txtDocID;
    JPasswordField txtNuevaCtr;
    JPasswordField txtConfirmacionNC;

    StringBuilder contrasenaN;
    StringBuilder confirmacionN;

    JButton btnBack;
    JButton btnRestablecer;

    public RestablecerCntaGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        txtDocID = new JTextField();
        txtNuevaCtr = new JPasswordField();
        txtConfirmacionNC = new JPasswordField();
        btnBack = new JButton();
        btnRestablecer = new JButton();
    }

    @Override
    protected void initComponents() {
        setOpaque(false);
        setLayout(null);
        setSize(width, height);
        setLocation(0,0);

        txtDocID.setBounds(480, 230, 360, 40);
        txtNuevaCtr.setBounds(480, 305, 360, 40);
        txtConfirmacionNC.setBounds(305, 435, 360, 40);

        btnBack.setBounds(53, 537, 100, 90);
        btnRestablecer.setBounds(380, 540, 240, 90);

        txtDocID.addActionListener(this);
        txtNuevaCtr.addActionListener(this);
        txtConfirmacionNC.addActionListener(this);

        btnBack.addActionListener(this);
        btnRestablecer.addActionListener(this);

        addToJPanel(txtDocID, txtNuevaCtr, txtConfirmacionNC, btnBack, btnRestablecer);
        buttonTransparent(btnBack, btnRestablecer);
    }

    public boolean isTxtValid(){
        try{
            contrasenaN = new StringBuilder();
            confirmacionN = new StringBuilder();

            //.getPassword can return NUllPointer
            for(char a: txtNuevaCtr.getPassword()){
                contrasenaN.append(a);
            }
            for(char a: txtConfirmacionNC.getPassword()){
                confirmacionN.append(a);
            }

            //check que los campos tengan algo
            if(txtDocID.getText().equals("")|| confirmacionN.toString().equals("") || contrasenaN.toString().equals("")){
                showDialog(0);
                return false;
            }

            //check las contraseñas sean iguales
            if(confirmacionN.toString().equals(contrasenaN.toString())){
                //check exista un empleado con ese numDoc
                empleado = handler.getManager().getEmpleado(Long.parseLong(txtDocID.getText()));
                if(empleado != null){
                    return handler.getBaseManager().updateContrasenaEmpleado(Long.parseLong(txtDocID.getText()), contrasenaN.toString());
                }else {
                    showDialog(2);
                }
            }else{
                showDialog(1);
            }
        }catch(Exception e){
            showDialog(0);
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void showDialog(int i){
        String title = "Error al restablecer contraseña";
        switch(i){
            case 0:
                String okOpt = "Ok";
                Object[] options = {okOpt};
                int n = JOptionPane.showOptionDialog(null,
                        "Alguno de los dos campos esta vacio" ,
                        title,
                        JOptionPane.YES_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
            case 1:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "Las contraseña no coinciden",
                        title,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
            case 2:
                okOpt = "Ok";
                options = new Object[]{okOpt};
                n = JOptionPane.showOptionDialog(null,
                        "Empleado no encontrado",
                        title,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        okOpt
                );
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().inicioSesionGUI);
            handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgInicioSesion.png");
        }else if(e.getSource() == btnRestablecer){
            if(isTxtValid()){
                empleado.setContrasena(contrasenaN.toString());
                handler.getDisplay().anuncioRestablecer.setLbl(txtDocID.getText(), contrasenaN.toString());
                handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().anuncioRestablecer);
                handler.getDisplay().changeBackGroundPanel("src/Dulce_Torta/Assets/ImgCntrRestablecida.png");
            }
        }
    }
}
