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

    public Manager(Handler handler){
        this.handler = handler;
        Clientes = new HashMap<Integer, Cliente>();
        Empleados = new HashMap<Integer, Empleado>();
        Ordenes = new HashMap<Integer, Orden>();
    }

    public void setAllClientes(){
        handler.getBaseManager().putAllRegistros();
    }

    public void addCliente(Cliente cliente){
        Clientes.put(cliente.getID(), cliente);
    }

    public Cliente getCliente(int idCliente){
        return Clientes.get(idCliente);
    }

    public void addEmpleado(Empleado empleado){
        Empleados.put(empleado.getID(), empleado);
    }

    public Empleado getEmpleado(int idEmpleado){
        return Empleados.get(idEmpleado);
    }

    public void addOrden(Orden orden){
        Ordenes.put(orden.getIDVenta(), orden);
    }

    public Orden getOrden(int idVenta){
        return Ordenes.get(idVenta);
    }

}
