package Dulce_Torta.Actors;

import Dulce_Torta.Handler;

import javax.swing.*;
import java.util.ArrayList;

public class Inventario {

    public Handler handler;
    private final int CAPACIDAD_MAX;
    private int almacenado;
    private int costoTotal;
    private ArrayList<Insumo> Insumos;

    public Inventario(Handler handler, int capacidad){
        this.handler = handler;
        this.CAPACIDAD_MAX = capacidad;
        Insumos = new ArrayList<Insumo>();    }

    public void addInsumo(Insumo insumo){
        Insumos.add(insumo);
    }

    public Insumo getInsumo(int idInsumo){
        for(Insumo insumo: Insumos){
            if(insumo.getID() == idInsumo){
                return insumo;
            }
        }
        return null;
    }

    public void calcularCostoTotal(){
        costoTotal = 0;
        for(Insumo insumo: Insumos){
            costoTotal += insumo.getValorUnitario() * insumo.getCantidad();
        }
    }

    public void setAlmacenado(){
        almacenado = 0;
        for(Insumo insumo: Insumos){
            almacenado += insumo.getCantidad();
        }
    }

    public void notificarCapacidadMax(){
        if(almacenado + 200 >= CAPACIDAD_MAX){
            String okOpt = "Ok";
            Object[] options = new Object[]{okOpt};
            int n = JOptionPane.showOptionDialog(null,
                    "Esta llegando al limite de la capacidad del inventario",
                    "Capacidad casi alcanzada",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    okOpt
            );
        }
    }

    public int getCostoTotal(){
        return costoTotal;
    }

}
