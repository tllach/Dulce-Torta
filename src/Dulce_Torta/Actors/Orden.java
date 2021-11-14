package Dulce_Torta.Actors;

import Dulce_Torta.Handler;

import java.util.ArrayList;
import java.util.Date;

public class Orden {

    private Handler handler;
    private int IDVenta;
    private Date fechaVenta;
    private String estado;
    private int valorTotal;
    private String tipoCelebracion;
    private String tipoCombo;
    private String descripcion;
    private ArrayList<Boolean> productos;
    private String empleadosEncargados;

    Cliente cliente;

    public Orden(Handler handler) {
        this.handler = handler;
    }

    public void calcularValorTotal(){

    }

    public void setEmpleadosEncargados(String names) {
        this.empleadosEncargados = names;
    }

    public String getEmpleadosEncargadosName() {
        return empleadosEncargados;
    }

    public void setProductos(boolean... productos) {
        for (boolean producto : productos) {
            this.productos.add(producto);
        }
    }

    public ArrayList<Boolean> getProducto() {
        return productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoCelebracion() {
        return this.tipoCelebracion;
    }

    public void setTipoCelebracion(String tipoCelebracion) {
        this.tipoCelebracion = tipoCelebracion;
    }

    public String getTipoCombo() {
        return tipoCombo;
    }

    public void setTipoCombo(String tipoCombo) {
        this.tipoCombo = tipoCombo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
