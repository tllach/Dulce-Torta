package Dulce_Torta.Actors;

import Dulce_Torta.Handler;

import javax.swing.*;

public class Insumo{

    Handler handler;
    private int ID;
    private String nombre;
    private int cantidad;
    private int valorUnitario;

    public Insumo(Handler handler){
        this.handler = handler;
    }

    public void notificarEscasez(){
        if(cantidad < 10){
            String okOpt = "Ok";
            Object[] options = new Object[]{okOpt};
            int n = JOptionPane.showOptionDialog(null,
                    "El producto: " + nombre + " se esta agotando\nCantidad: " + cantidad,
                    "Producto Agotandose",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    okOpt
            );
        }
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getValorUnitario(){
        return valorUnitario;
    }

    public int getCantidad(){
        return cantidad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
