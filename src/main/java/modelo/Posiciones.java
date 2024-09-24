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
public class Posiciones extends PosicionesDAO{
    private Conexion cn;
    ResultSet rs;

    public Posiciones() {
    }

    public Posiciones(String equipoID, String categoriaID, String torneoID) {
        super(equipoID, categoriaID, torneoID);
    }

    public Posiciones(String equipoID, String categoriaID, String torneoID, int partidosJugados, int partidosGanados, int partidosEmpatados, int partidosPerdidos, int golesAFavor, int golesEnContra, int diferenciaGoles, int puntosGanados) {
        super(equipoID, categoriaID, torneoID, partidosJugados, partidosGanados, partidosEmpatados, partidosPerdidos, golesAFavor, golesEnContra, diferenciaGoles, puntosGanados);
    }
    
    @Override
    public void agregar_equipo(){
        try {
        cn = new Conexion();
        PreparedStatement parametro;
        String sql = "INSERT INTO Posiciones (EquipoID, CategoriaID, TorneoID) VALUES (?,?,?);";
        cn.abrir_Conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getEquipoID());
        parametro.setString(2, getCategoriaID());
        parametro.setString(3, getTorneoID());
        parametro.executeUpdate();
        cn.cerrar_conexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     @Override
    public List Tabla(String torneoID) {
    List<PosicionesDAO> posiciones = new ArrayList<>();
    try {
        cn = new Conexion();
        String sql = "SELECT EquipoID, PartidosJugados, PartidosGanados, PartidosEmpatados, " +
                     "PartidosPerdidos, GolesAFavor, GolesEnContra, DiferenciaGoles, PuntosGanados " +
                     "FROM Posiciones WHERE TorneoID = ? ORDER BY PuntosGanados DESC";
        cn.abrir_Conexion();
        PreparedStatement parametro = cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, torneoID);
        ResultSet rs = parametro.executeQuery();
        while (rs.next()) {
            PosicionesDAO posicion = new PosicionesDAO();
            posicion.setEquipoID(rs.getString("EquipoID"));
            posicion.setPartidosJugados(rs.getInt("PartidosJugados"));
            posicion.setPartidosGanados(rs.getInt("PartidosGanados"));
            posicion.setPartidosEmpatados(rs.getInt("PartidosEmpatados"));
            posicion.setPartidosPerdidos(rs.getInt("PartidosPerdidos"));
            posicion.setGolesAFavor(rs.getInt("GolesAFavor"));
            posicion.setGolesEnContra(rs.getInt("GolesEnContra"));
            posicion.setDiferenciaGoles(rs.getInt("DiferenciaGoles"));
            posicion.setPuntosGanados(rs.getInt("PuntosGanados"));
            posiciones.add(posicion);
        }
    } catch (SQLException e) {
        // Manejar adecuadamente la excepción según las necesidades de tu aplicación
        e.printStackTrace();
    } finally {
        // Cerrar conexión, en caso de que se necesite
        if (cn != null) {
            cn.cerrar_conexion();
        }
    }
    return posiciones;
    }
       
    
   @Override
public void puntos(String equipoID, String categoriaID, String torneoID) {
    try {
        cn = new Conexion();
        cn.abrir_Conexion();
        String sql = "UPDATE posiciones SET PartidosJugados = PartidosJugados + ?, PartidosGanados = PartidosGanados + ?, " +
                     "PartidosEmpatados = PartidosEmpatados + ?, PartidosPerdidos = PartidosPerdidos + ?, GolesAFavor = GolesAFavor + ?," +
                     "GolesEnContra = GolesEnContra + ?, DiferenciaGoles = GolesAFavor - GolesEnContra, PuntosGanados = PuntosGanados + ? " +
                     "WHERE EquipoID = ? AND CategoriaID = ? AND TorneoID = ?";
        PreparedStatement parametro;
        parametro = cn.conexionBD.prepareStatement(sql);
        // Asignar los valores de los parámetros del PreparedStatement
        parametro.setInt(1, getPartidosJugados());
        parametro.setInt(2, getPartidosGanados());
        parametro.setInt(3, getPartidosEmpatados());
        parametro.setInt(4, getPartidosPerdidos());
        parametro.setInt(5, getGolesAFavor());
        parametro.setInt(6, getGolesEnContra());
        parametro.setInt(7, getPuntosGanados());
        // Asignar los valores de los parámetros del WHERE
        parametro.setString(8, equipoID);
        parametro.setString(9, categoriaID);
        parametro.setString(10, torneoID);
        parametro.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión si es necesario
        if (cn != null) {
            cn.cerrar_conexion();
        }
    }
}

       
    @Override
    public List Mejor_Defensa(String torneoID){
    List<PosicionesDAO> defensa = new ArrayList<>();
    try {
        cn = new Conexion();
        cn.abrir_Conexion();
        String sql = "SELECT CategoriaID, EquipoID, GolesEnContra FROM Posiciones where TorneoID = ? ORDER BY GolesEnContra ASC LIMIT 7 ;";
        PreparedStatement parametro = cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, torneoID);
        ResultSet rs = parametro.executeQuery();
        while(rs.next()){
            PosicionesDAO posicion = new PosicionesDAO();
            posicion.setCategoriaID(rs.getString("CategoriaID"));
            posicion.setEquipoID(rs.getString("EquipoID"));
            posicion.setGolesEnContra(rs.getInt("GolesEnContra"));
            defensa.add(posicion);
        }
        parametro.close();
        cn.cerrar_conexion();
    }catch(SQLException e){
        e.printStackTrace();
    }
        return defensa;   
    }  
     
     
}
