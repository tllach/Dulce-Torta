package Dulce_Torta;

import Dulce_Torta.Actors.Cliente;
import Dulce_Torta.Actors.Empleado;
import Dulce_Torta.Actors.Orden;

import java.util.HashMap;

public class Manager{

    private Handler handler;
    private HashMap<Integer,Cliente> Clientes;
    private HashMap<Integer, Orden> Ordenes;
    private HashMap<Integer, Empleado> Empleados;
    private int countOrder, countCliente, countEmpleado;

    public Manager(Handler handler){
        this.handler = handler;
        Clientes = new HashMap<Integer, Cliente>();
        Empleados = new HashMap<Integer, Empleado>();
        Ordenes = new HashMap<Integer, Orden>();
        countOrder = countCliente = countEmpleado = 1;
    }

    public void setAllRegistros(){
        handler.getBaseManager().putAllRegistros();
    }

    public void addCliente(Cliente cliente) {
        countCliente++;
        Clientes.put(cliente.getID(), cliente);
    }

    public Cliente getCliente(int idCliente){
        return Clientes.get(idCliente);
    }

    public void addEmpleado(Empleado empleado){
        countEmpleado++;
        Empleados.put(empleado.getID(), empleado);
    }

    public Empleado getEmpleado(int idEmpleado){
        return Empleados.get(idEmpleado);
    }

    public Empleado getEmpleado(long numDocEmpleado){
        for(Empleado empleado : Empleados.values()){
            if(empleado.getNroDoc() == numDocEmpleado){
                return empleado;
            }
        }
        return null;
    }

    public void addOrden(Orden orden){
        countOrder++;
        Ordenes.put(orden.getIDVenta(), orden);
    }

    public Orden getOrden(int idVenta){
        return Ordenes.get(idVenta);
    }

    public int getCountOrden(){
        return countOrder;
    }

    public int getCountEmpleado(){
        return countEmpleado;
    }

    public int getCountCliente(){
        return countCliente;
    }

    public HashMap<Integer, Cliente> getClientes() {
        return Clientes;
    }

    public HashMap<Integer, Orden> getOrdenes() {
        return Ordenes;
    }

    public HashMap<Integer, Empleado> getEmpleados() {
        return Empleados;
    }
}
