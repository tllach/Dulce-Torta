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

    public void addRegistroOrden(Orden orden){
        st = con.prepareStatement("INSERT INTO Ordenes (ID_venta, Estado, ID_Cliente, TipoCelebracion, TipoCombo, EmpleadosEncargados, FechaVenta, ValorTotal, Descripcion, Torta, TortaMediaLibra, Brownie, Cupcake, Cakepops, Galletas) VALUES (null, ?, ?, ?, ?, ?, date('now'), ?, ?, ?, ?, ?, ?, ?, ?)");
        try {
            st.setString(1, orden.getEstado());
            st.setInt(2, orden.getCliente().getID());
            st.setString(3, orden.getTipoCelebracion());
            st.setString(4, orden.getTipoCombo());
            st.setString(5, orden.getEmpleadosEncargadosName());
            st.setInt(7, orden.getValorTotal());
            st.setString(8, orden.getDescripcion());
            int index = 9;
            for(boolean producto: orden.getProducto()){
                st.setBoolean(index, producto);
                index ++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //para cuando se inicice el programa se llene el Hashmap de clientes
    public void showAllRegistrosClientes(){
        r = con.resultSet("SELECT * FROM Clientes");
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
                    info = new Object[]{Integer.parseInt(r.getString("ID_Cliente")), r.getString("Nombre"),
                            r.getString("Apellidos"), r.getString("Direccion"),
                            Long.parseLong(r.getString("Celular"))};
                    handler.getClientesGUI().addRow(info);
                }else if(opc == 2){
                    System.out.println("...");
                }else if(opc == 3){
                    System.out.println("...");
                }else if(opc == 4){
                    info = new Object[]{r.getString("ID_Venta"), r.getString("Estado"), r.getString("ID_Cliente"),
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
