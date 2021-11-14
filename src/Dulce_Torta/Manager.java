package Dulce_Torta;

import Dulce_Torta.Actors.Cliente;
import Dulce_Torta.Actors.Empleado;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager{

    private Handler handler;
    private HashMap<Integer,Cliente> Clientes;
    private HashMap<Integer, Empleado> Empleados;

    public Manager(Handler handler){
        this.handler = handler;
        Clientes = new HashMap<Integer, Cliente>();
        Empleados = new HashMap<Integer, Empleado>();
    }

    public void setAllClientes(){
        handler.getBaseManager().showAllRegistrosClientes();
    }
    public void addCliente(Cliente cliente){
        Clientes.put(cliente.getID(), cliente);
    }

    public Cliente getCliente(int idCliente){
        return Clientes.get(idCliente);
    }

}
