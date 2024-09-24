/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public Connection conexionBD;
    
  //public final String puerto="3306";
    public final String bd="soccer_admin";
    public final String driver = "com.mysql.cj.jdbc.Driver";    
    public final String bd_ubicacion = String.format("jdbc:mysql://localhost:3306/%s",bd);    
    public final String bd_usuario = "root";
    public final String bd_password = "12345";

     public void abrir_Conexion(){
      try {
          Class.forName(driver);
          conexionBD= DriverManager.getConnection(bd_ubicacion,bd_usuario,bd_password);    
      } catch (ClassNotFoundException | SQLException e) {
          System.out.println("Error...." + e.getMessage());
      }
  }

     public void cerrar_conexion(){
      try {
      conexionBD.close();
          
      } catch (SQLException e) {
          System.out.println("Error..."+e.getMessage());
      }
  }  
}
