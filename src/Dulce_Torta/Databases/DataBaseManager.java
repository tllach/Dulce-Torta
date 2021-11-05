package Dulce_Torta.Databases;


import Dulce_Torta.Actors.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseManager {

    Conexion con;

    public DataBaseManager(){
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

    public void showRegistroCliente(){
        ResultSet r = con.resultSet("SELECT * FROM Clientes");

        while(true){
            try {
                if (!r.next()) break;
                System.out.println(r.getString("ID_Cliente"));
                System.out.println(r.getString("Nombre"));
                System.out.println(r.getString("Apellidos"));
                System.out.println(r.getString("Celular"));
                System.out.println(r.getString("Direccion"));
                System.out.println(r.getString("TipoDoc"));
                System.out.println(r.getString("NumDoc"));
                System.out.println(r.getString("Correo"));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
