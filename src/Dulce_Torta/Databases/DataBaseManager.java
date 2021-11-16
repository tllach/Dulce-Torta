package Dulce_Torta.Databases;


import Dulce_Torta.Actors.Cliente;
import Dulce_Torta.Handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseManager {

    Conexion con;
    ResultSet r;
    Handler handler;
    ArrayList<String> infoCliente;

    public DataBaseManager(Handler handler){
        this.handler = handler;
        con = new Conexion();
    }

    public void addRegistroCliente(Cliente cliente){
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO Clientes (ID_Cliente, Nombre, Apellidos, Celular, Direccion, TipoDoc, NumDoc, Correo) VALUES (null,? ,? ,? ,? ,? ,? ,?)");
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

    //para cuando se inicice el progrmaa enseguida se llene el Hasmap de clientes
    public void showAllRegistrosClientes(){
        r = con.resultSet("SELECT * FROM Clientes");
        while(true){
            try {
                if (!r.next()) break;

                System.out.println("ID: " + r.getString( "ID_Cliente"));
                System.out.println("Nombre: " +r.getString("Nombre"));
                System.out.println("Apellidos: " +r.getString("Apellidos"));
                System.out.println("Direccion: " +r.getString("Direccion"));
                System.out.println("Celular: " +r.getString("Celular"));
                System.out.println("TipoDoc: " +r.getString("TipoDoc"));
                System.out.println("NumDoc: " +r.getString("NumDoc"));
                System.out.println("Correo: " +r.getString("Correo"));

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

    public void deleteRegistroCliente(){
        try{
            PreparedStatement st = con.prepareStatement("DELETE FROM Clientes WHERE ID=?");
            st.setInt(1, handler.getDisplay().clientesGUI.getIdToSearch());
            st.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addRow(){
        r = con.resultSet("SELECT * FROM Clientes");
        Object[] cliente;
        while(true){
            try {
                if (!r.next()) break;
                cliente = new Object[]{Integer.parseInt(r.getString("ID_Cliente")), r.getString("Nombre"),
                        r.getString("Apellidos"), r.getString("Direccion"),
                        Long.parseLong(r.getString("Celular"))};
                handler.getDisplay().clientesGUI.addRow(cliente);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
