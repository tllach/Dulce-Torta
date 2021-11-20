package Dulce_Torta.Actors;

import Dulce_Torta.Handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Empleado extends Persona{

    private String fechaIngreso;
    private String tipoEmpleado;
    private String contrasena;
    private int sueldo;
    private ArrayList<Orden> lasFacturas;

    public Empleado(Handler handler) {
        super(handler);
        lasFacturas = new ArrayList<Orden>();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
        fechaIngreso = dateFormat.format(currentDate);
    }

    public void setFechaIngreso(String fe){
        this.fechaIngreso = fe;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getTipoEmpleado(){
        return tipoEmpleado;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setSueldo(int sueldo){
        this.sueldo = sueldo;
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
