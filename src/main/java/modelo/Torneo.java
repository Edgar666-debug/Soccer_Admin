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
public class Torneo extends TorneoDAO{
    private Conexion cn;
    ResultSet rs;

    public Torneo() {
    }

    public Torneo(String nombreTorneo, String fechaFinal, String campeon) {
        super(nombreTorneo, fechaFinal, campeon);
    }
    
    
    public Torneo(String nombreTorneo, String categoriaID, int temporada, String fechaInicio, String fechaFinal, String campeon, boolean activo) {
        super(nombreTorneo, categoriaID, temporada, fechaInicio, fechaFinal, campeon, activo);
    }
    
    @Override
     public void finalizar() {
        String sql = "UPDATE Torneos SET Activo = false, Fecha_Final = ?, campeon = ? WHERE NombreTorneo = ?";

        try {
            PreparedStatement parametro;
            // Asumo que 'cn' es una instancia de la clase Conexion
            cn = new Conexion();
            cn.abrir_Conexion();
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
            // Establecer la fecha actual o cualquier otra lógica que necesites
            parametro.setString(1, getFechaFinal());
            parametro.setString(2, getCampeon()); // Debes obtener el campeón de alguna manera
            parametro.setString(3, getNombreTorneo());

            parametro.executeUpdate();
        } catch (SQLException e) {
            // Manejar la excepción de manera apropiada para tu aplicación
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            cn.cerrar_conexion();
        }
    }
     
     @Override
    public List Listar() {
    ArrayList<TorneoDAO> list = new ArrayList<>();
    String sql = "SELECT * FROM Torneos WHERE Activo = true;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
            TorneoDAO torneo = new TorneoDAO();
            torneo.setNombreTorneo(rs.getString("NombreTorneo"));
            torneo.setCategoriaID(rs.getString("CategoriaID"));
            torneo.setTemporada(rs.getInt("Temporada"));
            torneo.setFechaInicio(rs.getString("Fecha_Inicio"));
            torneo.setActivo(rs.getBoolean("Activo"));
            list.add (torneo);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Asegúrate de cerrar la conexión y el conjunto de resultados
        cn.cerrar_conexion();
    }
    return list;
}
     
    @Override
    public void agregar() {
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        String sql = "INSERT INTO `Torneos`(`NombreTorneo`, `CategoriaID`, `Temporada`, `Fecha_Inicio`)"
                + "VALUES (?, ?, ?, ?);";
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getNombreTorneo());
        parametro.setString(2, getCategoriaID());
        parametro.setInt(3, getTemporada());
        parametro.setString(4, getFechaInicio());
        parametro.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cn.cerrar_conexion();
    }
}
    
      @Override
   public void eliminar(String NombreTorneo) {
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        String sql = "DELETE FROM Torneos WHERE NombreTorneo = ?";
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, NombreTorneo);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        System.err.println(e);
    }
   }
   
    @Override
    public List Convocatoria(){
     ArrayList<TorneoDAO> list = new ArrayList<>();
      String sql = "SELECT c.NombreCategoria, c.Generacion, c.EdadMinima, c.EdadMaxima, c.Genero, t.NombreTorneo, t.Fecha_Inicio\n" +
                    "FROM Categorias c INNER JOIN Torneos t ON c.NombreCategoria = t.CategoriaID;"; 
        try {
        cn = new Conexion();
        PreparedStatement parametro;
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
         TorneoDAO torneo = new TorneoDAO();
                torneo.setNombreCategoria(rs.getString("NombreCategoria"));
                torneo.setGeneracion(rs.getString("Generacion"));
                torneo.setEdadMinima(rs.getInt("EdadMinima"));
                torneo.setEdadMaxima(rs.getInt("EdadMaxima"));
                torneo.setGenero(rs.getString("Genero"));
                torneo.setNombreTorneo(rs.getString("NombreTorneo"));
                torneo.setFechaInicio(rs.getString("Fecha_Inicio"));
                // Agregar el objeto TorneoDAO a la lista
                list.add(torneo);
        }
            
        } catch (SQLException e) {
        e.printStackTrace();
        }
      
        return list;
         
     }
    
}
