package Dulce_Torta.Actors;

import java.util.ArrayList;

public class Producto{

    private int ID;
    private String nombre;
    private ArrayList<Insumo> Insumos;

    public Producto(int ID, String nombre){
        this.ID = ID;
        this.nombre = nombre;
    }

    public int getID(){
        return this.ID;
    }

    public void setInsumo(Insumo insumo){
        Insumos.add(insumo);
    }

    public ArrayList<Insumo> getInsumo(String ID){
        return Insumos;
    }

}
