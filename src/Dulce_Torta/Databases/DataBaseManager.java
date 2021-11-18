package Dulce_Torta.Databases;


import Dulce_Torta.Actors.*;
import Dulce_Torta.Handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseManager {

    Conexion con;
    ResultSet r;
    PreparedStatement st;
    Handler handler;
    ArrayList<String> infoCliente;

    public DataBaseManager(Handler handler){
        this.handler = handler;
        con = new Conexion();
    }

    public void addRegistroCliente(Cliente cliente){
        try{
            st = con.prepareStatement("INSERT INTO Clientes (ID_Cliente, Nombre, Apellidos, Celular, Direccion, TipoDoc, NumDoc, Correo) VALUES (null,? ,? ,? ,? ,? ,? ,?)");
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getApellidos());
            st.setLong(3, cliente.getCelular());
            st.setString(4, cliente.getDireccion());
            st.setString(5, cliente.getTipoDoc());
            st.setLong(6, cliente.getNroDoc());
            st.setString(7, cliente.getCorreo());
            st.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void updateOrdenEstado(String estado, String idVenta){
        String command = "UPDATE Ordenes SET Estado = '"
                + estado + "' WHERE ID_Venta = '" + idVenta + "'";
        st = con.prepareStatement(command);
        try{
            st.execute();
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void addRegistroOrden(Orden orden){
        st = con.prepareStatement("INSERT INTO Ordenes (ID_venta, Estado, ID_Cliente, TipoCelebracion, TipoCombo, EmpleadosEncargados, FechaVenta, ValorTotal, Descripcion, Torta, TortaMediaLibra, Brownie, Cupcake, Cakepops, Galletas) VALUES (null, ?, ?, ?, ?, ?, date('now'), ?, ?, ?, ?, ?, ?, ?, ?)");
        try{
            st.setString(1, orden.getEstado());
            st.setInt(2, orden.getCliente().getID());
            st.setString(3, orden.getTipoCelebracion());
            st.setString(4, orden.getTipoCombo());
            st.setString(5, orden.getEmpleadosEncargadosName());
            st.setInt(6, orden.getValorTotal());
            st.setString(7, orden.getDescripcion());
            int index = 8;
            for(boolean producto: orden.getProducto()){
                st.setBoolean(index, producto);
                index ++;
            }
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //para cuando se inicice el programa se llene el Hashmap de clientes

    public void putAllRegistros(){
        int i = 0;
        String[] names = {"Clientes", "Empleados", "Ordenes", "Insumos"};
        while(names.length > i){
            String statement = "SELECT * FROM " + names[i];
            r = con.resultSet(statement);
            if(i == 0){
                while(true){
                    try {
                        if (!r.next()) break;
                        Cliente cliente = new Cliente(handler);
                        cliente.setID(Integer.parseInt(r.getString( "ID_Cliente")));
                        cliente.setNombre(r.getString("Nombre"));
                        cliente.setApellidos(r.getString("Apellidos"));
                        cliente.setTipoDoc(r.getString("TipoDoc"));
                        cliente.setNroDoc(Long.parseLong(r.getString("NumDoc")));
                        cliente.setDireccion(r.getString("Direccion"));
                        cliente.setCelular(Long.parseLong(r.getString("Celular")));
                        cliente.setCorreo(r.getString("Correo"));
                        handler.getManager().addCliente(cliente);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            if(i == 1){
                /**
                while(true){
                    try {
                        if (!r.next()) break;
                        Empleado empleado = new Empleado(handler);
                        empleado.setID(Integer.parseInt(r.getString( "ID_Cliente")));
                        empleado.setNombre(r.getString("Nombre"));
                        empleado.setApellidos(r.getString("Apellidos"));
                        empleado.setTipoDoc(r.getString("TipoDoc"));
                        empleado.setNroDoc(Long.parseLong(r.getString("NumDoc")));
                        empleado.setDireccion(r.getString("Direccion"));
                        empleado.setCelular(Long.parseLong(r.getString("Celular")));
                        empleado.setFe
                        handler.getManager().addCliente(cliente);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                 **/
            }
            if(i == 2){
                while(true){
                    try {
                        if (!r.next()) break;
                        Orden orden = new Orden(handler);
                        orden.setIDVenta(r.getInt( "ID_Venta"));
                        orden.setFechaVenta(r.getString("FechaVenta"));
                        orden.setEstado(r.getString("Estado"));
                        orden.setValorTotal(r.getInt( "ValorTotal"));
                        orden.setTipoCelebracion(r.getString("TipoCelebracion"));
                        orden.setTipoCombo(r.getString("TipoCombo"));
                        orden.setDescripcion(r.getString("Descripcion"));

                        ArrayList<Boolean> productos = new ArrayList<Boolean>();
                        productos.add(r.getBoolean("Torta"));
                        productos.add(r.getBoolean("TortaMediaLibra"));
                        productos.add(r.getBoolean("Brownie"));
                        productos.add(r.getBoolean("Cupcake"));
                        productos.add(r.getBoolean("Cakepops"));
                        productos.add(r.getBoolean("Galletas"));

                        orden.setProductos(productos);
                        orden.setEmpleadosEncargados(r.getString("EmpleadosEncargados"));
                        orden.setCliente(handler.getManager().getCliente(r.getInt( "ID_Cliente")));
                        handler.getManager().addOrden(orden);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            i++;
        }
    }

    public ArrayList<String> showRegistroClientes(int idCliente){
        infoCliente = new ArrayList<String>();
        String statement = "SELECT * FROM Clientes WHERE ID_Cliente=" + idCliente;
        r = con.resultSet(statement);
        while(true){
            try {
                if (!r.next()) break;
                infoCliente.add(r.getString("Nombre"));
                infoCliente.add(r.getString("Apellidos"));
                infoCliente.add(r.getString("TipoDoc"));
                infoCliente.add(r.getString("NumDoc"));
                infoCliente.add(r.getString("Celular"));
                infoCliente.add(r.getString("Direccion"));
                infoCliente.add(r.getString("Correo"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return infoCliente;
    }

    public void deleteRegistroEmpleado(){
        try{
            PreparedStatement st = con.prepareStatement("DELETE FROM Clientes WHERE ID=?");
            st.setInt(1, handler.getDisplay().clientesGUI.getIdToSearch());
            st.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addRow(int opc){
        Object[] info;
        String n = switch (opc) {
            case 1 -> "Clientes";
            case 2 -> "Empleados";
            case 3 -> "Insumos";
            case 4 -> "Ordenes";
            default -> "";
        };

        String statement = "SELECT * FROM %s".formatted(n);
        r = con.resultSet(statement);

        while(true){
            try {
                if (!r.next()) break;
                if(opc == 1){
                    info = new Object[]{r.getInt("ID_Cliente"), r.getString("Nombre"),
                            r.getString("Apellidos"), r.getString("Direccion"),
                            r.getLong("Celular")};
                    handler.getClientesGUI().addRow(info);
                }else if(opc == 2){
                    System.out.println("...");
                }else if(opc == 3){
                    System.out.println("...");
                }else if(opc == 4){
                    info = new Object[]{r.getInt("ID_Venta"), r.getString("Estado"), r.getInt("ID_Cliente"),
                            r.getString("TipoCelebracion"),r.getString("TipoCombo"),
                            r.getString("EmpleadosEncargados")};
                    handler.getOrdenGUI().addRow(info);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
