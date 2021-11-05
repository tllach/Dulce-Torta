package Dulce_Torta.Databases;

import java.sql.*;

public class Conexion {

    String strConexionDB = "src/Dulce_Torta/Databases/Files/Cliente.s3db";
    Connection con = null;

    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + strConexionDB);

            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String s) {
        try {
            PreparedStatement ptm = con.prepareStatement(s);
            return ptm;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet resultSet(String s){
        try {
            PreparedStatement ptm = prepareStatement(s);
            return ptm.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
