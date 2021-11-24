package Dulce_Torta;

import Dulce_Torta.Actors.*;

import java.util.HashMap;

public class Manager{

    private Handler handler;
    private HashMap<Integer, Insumo> Insumos;
    private HashMap<Integer, Producto> Productos;
    private HashMap<Integer,Cliente> Clientes;
    private HashMap<Integer, Orden> Ordenes;
    private HashMap<Integer, Empleado> Empleados;
    private int countOrder, countCliente, countEmpleado, countInsumo;

    public Manager(Handler handler){
        this.handler = handler;
        Insumos = new HashMap<Integer, Insumo>();
        Productos = new HashMap<Integer, Producto>();
        Clientes = new HashMap<Integer, Cliente>();
        Empleados = new HashMap<Integer, Empleado>();
        Ordenes = new HashMap<Integer, Orden>();
        countOrder = countCliente = countEmpleado = countInsumo = 1;
    }

    public void setAllRegistros(){
        handler.getDataManager().putAllRegistros();
        addProductos();
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

    public void addInsumo(Insumo insumo){
        countInsumo++;
        Insumos.put(insumo.getID(), insumo);
    }

    public Insumo getInsumo(int id){
        return Insumos.get(id);
    }

    public Insumo getInsumo(String name){
        for(Insumo insumo: Insumos.values()){
            if(insumo.getNombre().equals(name)){
                return insumo;
            }
        }
        return null;
    }

    public void addProductos(){
        String[] productos = {"Torta", "Torta1/2L", "Cupcake", "Brownie", "Cakepops", "Galletas"};
        int n = 0;
        while(n != 5){
            Producto producto = new Producto(n, productos[n]);
            Productos.put(producto.getID(), producto);
            n++;
        }
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

    public int getCountInsumo(){
        return countInsumo;
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

    public HashMap<Integer, Insumo> getInsumos() {
        return Insumos;
    }

    public HashMap<Integer, Producto> getProductos() {
        return Productos;
    }
}
