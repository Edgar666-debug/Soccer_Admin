/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import ModeloDAO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime
 */
public class Equipos extends EquiposDAO{
    private Conexion cn;
    ResultSet rs;

    public Equipos() {
    }

    public Equipos(String NombreEquipo, String Color_Playera, String Representante, String NumeroRepresentante) {
        super(NombreEquipo, Color_Playera, Representante, NumeroRepresentante);
    }

    public Equipos(String NombreEquipo, String Color_Playera, String Representante, String NumeroRepresentante, String CategoriaID, String TorneoID) {
        super(NombreEquipo, Color_Playera, Representante, NumeroRepresentante, CategoriaID, TorneoID);
    }
    
       @Override
    public void agregar(){
        try {
        cn = new Conexion();
        PreparedStatement parametro;
        String sql = "INSERT INTO Equipos (NombreEquipo, Color_Playera, Representante, NumeroRepresentante)\n" +
                            "VALUES (?, ?, ?, ?);";
        cn.abrir_Conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getNombreEquipo());
        parametro.setString(2, getColor_Playera());
        parametro.setString(3, getRepresentante());
        parametro.setString(4, getNumeroRepresentante());
        parametro.executeUpdate();
        cn.cerrar_conexion();
      } catch (SQLException e) {
            System.out.println(e);
        }    
    }
    
   @Override
public void inscribir(String NombreEquipo, String CategoriaID, String TorneoID){
    try {
        cn = new Conexion();
        PreparedStatement parametro;
        cn.abrir_Conexion();
        String sql = "UPDATE Equipos SET CategoriaID = ?, TorneoID = ? WHERE NombreEquipo = ?;";
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, CategoriaID);
        parametro.setString(2, TorneoID);
        parametro.setString(3, NombreEquipo);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        System.out.println(e);
    }  
}
     
    @Override
     public List Listar(String Representante){
        ArrayList<EquiposDAO> list = new ArrayList<>();
    String sql = "SELECT NombreEquipo FROM Equipos WHERE Representante = ?;";
    try {
        cn = new Conexion();
        cn.abrir_Conexion();
        try (PreparedStatement parametro = cn.conexionBD.prepareStatement(sql)) {
            parametro.setString(1, Representante);
            try (ResultSet rs = parametro.executeQuery()) {
                while (rs.next()) {
                    EquiposDAO equipo = new EquiposDAO();
                    equipo.setNombreEquipo(rs.getString("NombreEquipo"));
                    list.add(equipo);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Asegúrate de cerrar la conexión
        cn.cerrar_conexion();
    }
    return list; 
        
     }

     public List<String> obtenerNombresEquipos() {
    ArrayList<String> nombresEquipos = new ArrayList<>();
    String sql = "SELECT NombreEquipo FROM equipos;"; // Selecciona solo el nombre del equipo

    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();

        while (rs.next()) {
            // Obtiene el nombre del equipo y lo agrega a la lista
            String nombreEquipo = rs.getString("NombreEquipo");
            nombresEquipos.add(nombreEquipo);
        }
        cn.cerrar_conexion();
    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();
    }

    return nombresEquipos;
}
     
     
    @Override
    public List<EquiposDAO>  Listar2(String TorneoID){
      ArrayList<EquiposDAO> lista = new ArrayList<>(); 
      try {
            PreparedStatement statement;
            cn = new Conexion();
            String sql ="SELECT * FROM Equipos WHERE TorneoID = ?;"; 
            cn.abrir_Conexion();
            statement = cn.conexionBD.prepareStatement(sql);
            statement.setString(1, TorneoID); // Asigna el valor del equipoID al parámetro en la consulta SQL
            rs = statement.executeQuery();

            while (rs.next()) {
            EquiposDAO equipo = new EquiposDAO();
            equipo.setCategoriaID(rs.getString("CategoriaID"));
            equipo.setNombreEquipo(rs.getString("NombreEquipo"));
            equipo.setRepresentante(rs.getString("Representante"));
            equipo.setColor_Playera(rs.getString("Color_Playera"));
            equipo.setNumeroRepresentante(rs.getString("NumeroRepresentante"));
            lista.add(equipo);
            }
            statement.close();
            cn.cerrar_conexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
      return lista;
        
    }
     
     
     public List<String> obtenerNombresEquiposPorTorneo(String TorneoID) {
     ArrayList<String> nombresEquipos = new ArrayList<>();
    String sql = "SELECT NombreEquipo FROM equipos WHERE TorneoID = ?"; // Filtra por la categoría proporcionada

    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, TorneoID); // Establece el parámetro de categoría en la consulta SQL
        rs = parametro.executeQuery();

        while (rs.next()) {
            // Obtiene el nombre del equipo y lo agrega a la lista
            String nombreEquipo = rs.getString("NombreEquipo");
            nombresEquipos.add(nombreEquipo);
        }
        cn.cerrar_conexion();
    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();
    }

    return nombresEquipos;
}
     
    @Override
     public void eliminar(String NombreEquipo){
         String sql = "DELETE FROM equipos WHERE NombreEquipo=?";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, NombreEquipo);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }   
    }
     
    public List Consulta(String Representante, String NombreEquipo){
        ArrayList<EquiposDAO> list = new ArrayList<>();
    String sql = "SELECT TorneoID FROM Equipos WHERE Representante = ? AND NombreEquipo = ?;";
    try {
        cn = new Conexion();
        cn.abrir_Conexion();
        try (PreparedStatement parametro = cn.conexionBD.prepareStatement(sql)) {
            parametro.setString(1, Representante);
            parametro.setString(2, NombreEquipo);
            try (ResultSet rs = parametro.executeQuery()) {
                while (rs.next()) {
                    EquiposDAO equipo = new EquiposDAO();
                    equipo.setTorneoID(rs.getString("TorneoID"));
                    list.add(equipo);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Asegúrate de cerrar la conexión
        cn.cerrar_conexion();
    }
    return list; 
        
     }
 
     
     
}
