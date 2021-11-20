package Dulce_Torta.Actors;

import Dulce_Torta.Handler;

import java.util.HashMap;

public class Cliente extends Persona{

    private String correo;
    private HashMap<Integer, Orden> lasFacturas;

    public Cliente(Handler handler) {
        super(handler);
        lasFacturas = new HashMap<Integer, Orden>();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public HashMap<Integer, Orden> getLasFacturas() {
        return lasFacturas;
    }

    public void addToLasFacturas(Orden orden) {
        lasFacturas.put(orden.getIDVenta(),orden);
    }

    public Orden getFactura(int idOrden){
        return lasFacturas.get(idOrden);
    }
}
