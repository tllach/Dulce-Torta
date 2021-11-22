package Dulce_Torta.GUI;

import Dulce_Torta.Handler;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class InicioSesionGUI extends GUI{

    JTextField txtUsuario;
    JPasswordField txtCtr;

    JButton btnInicioSesion;
    JButton btnRsbCtr;

    String bgPrincipal;
    String bgRestablecerC;

    long IDLogin;
    String cargoLogin;

    public InicioSesionGUI(Handler handler, int width, int height){
        super(handler, width, height);
    }

    @Override
    protected void declaration() {
        txtUsuario = new JTextField();
        txtCtr = new JPasswordField();
        btnInicioSesion = new JButton();
        btnRsbCtr = new JButton();
        bgPrincipal = "src/Dulce_Torta/Assets/pantallaPrincipal.png";
        bgRestablecerC = "src/Dulce_Torta/Assets/ImgRestablecerC.png";
    }

    @Override
    public void initComponents() {
         setOpaque(false);
         setLayout(null);
         setSize(width, height);
         setLocation(0,0);

         txtUsuario.setBounds(368, 235, 355, 50);
         txtCtr.setBounds(368, 398, 355, 50);
         btnInicioSesion.setBounds(395, 543, 210, 80);
         btnRsbCtr.setBounds(360, 486, 280, 25);

         txtUsuario.addActionListener(this);
         txtCtr.addActionListener(this);
         btnInicioSesion.addActionListener(this);
         btnRsbCtr.addActionListener(this);

         addToJPanel(btnInicioSesion, btnRsbCtr, txtUsuario, txtCtr);
         buttonTransparent(btnInicioSesion, btnRsbCtr);
    }

    public boolean isTxtValid(int opc){
        try{
            StringBuilder contrasena = new StringBuilder();
            //.getPassword can return NUllPointer
            for(char a: txtCtr.getPassword()){
                contrasena.append(a);
            }
            //check que los campos tengan algo
            if(txtUsuario.getText().equals("") || contrasena.toString().equals("")){
                showDialog(0);
                return false;
            }else{
                return handler.getDataManager().canIniciarSesion(Long.parseLong(txtUsuario.getText()), contrasena.toString());
            }
        }catch(Exception e){
            showDialog(0);
            e.printStackTrace();
            return false;
        }
    }

    public void showDialog(int i){
        String title = "Error iniciar sesion";
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
                        "Contraseña Incorrecta",
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
                        "Usuario no encontrado",
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

    public void setCargoLogin(String cargo){
        this.cargoLogin = cargo;
    }

    public String getCargoLogin(){
        return cargoLogin;
    }

    public void setIDLogin(long id){
        this.IDLogin = id;
    }

    public long getIDLogin() {
        return IDLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnRsbCtr){
            handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel,handler.getDisplay().restablecerCntaGUI);
            handler.getDisplay().changeBackGroundPanel(bgRestablecerC);
        }
        if(e.getSource() == btnInicioSesion){
            if(isTxtValid(0)){
                handler.getDisplay().setIDLogeado(getIDLogin());
                handler.getDisplay().setCargoLogeado(getCargoLogin());
                txtUsuario.setText("");
                txtCtr.setText("");
                handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().pantallaPrincipalGUI);
                handler.getDisplay().changeBackGroundPanel(bgPrincipal);
            }
            //handler.getDisplay().changeJPanel(handler.getDisplay().lastJPanel, handler.getDisplay().pantallaPrincipalGUI);
            //handler.getDisplay().changeBackGroundPanel(bgPrincipal);
        }
    }
}
