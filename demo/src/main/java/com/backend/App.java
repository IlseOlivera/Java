package com.backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class App {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/pruebaJdbc";
        String user = "root";
        String password = "root01";
        try {
            Connection con = DriverManager.getConnection(URL, user, password); // Crea conexión
            System.out.println("Conexion exitosa a la base de datos");
            Statement statement = con.createStatement(); // Interfaz statement creado apartir del método createStatement
                                                         // para enviar una instrucción SQL a una base de datos
            String consulta = "SELECT * FROM usuarios";// String que guarda el SQL
            ResultSet resultSet = statement.executeQuery(consulta); // Interfaz resulSet que guarda los resultados de
                                                                    // una consulta SQL
            while (resultSet.next()){
                int id = resultSet.getInt("idUser");
                String nombre = resultSet.getString("nomUser");
                String ap = resultSet.getString("apUser");
                int tel = resultSet.getInt("telUser");
                System.out.println("Id: " + id + "\nNombre: " + nombre+" Apellidos: "+ap+"Telefono: "+ tel+" | ");
            }
            con.close();
            resultSet.close();
            statement.close();
            System.out.println("Cerrando conexión");
            
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}