package Dulce_Torta.Actors;

import Dulce_Torta.Actors.Enums.TipoEmpleado;
import Dulce_Torta.Handler;
import Dulce_Torta.Orden;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Empleado extends Persona{

    private String fechaIngreso;
    private TipoEmpleado tipoEmpleado;
    private int sueldo;
    private ArrayList<Orden> lasFacturas;

    public Empleado(Handler handler) {
        super(handler);
        System.out.println("Empleado creado");
        lasFacturas = new ArrayList<Orden>();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
        fechaIngreso = dateFormat.format(currentDate);
        System.out.println(fechaIngreso);
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public TipoEmpleado getTipoEmpleado(){
        return tipoEmpleado;
    }

    public int getSueldo(){
        return sueldo;
    }

    public ArrayList<Orden> getLasFacturas() {
        return lasFacturas;
    }

    public void addToLasFacturas(Orden ...ordenes) {
        lasFacturas.addAll(Arrays.asList(ordenes));
    }
}
