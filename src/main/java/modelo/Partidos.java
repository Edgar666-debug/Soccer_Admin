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
public class Partidos extends PartidosDAO{
    private Conexion cn;
    ResultSet rs;

    public Partidos() {
    }

    public Partidos(String arbitro1, String arbitro2, String fechaPartido, String categoriaID, String rama, String torneoID, String equipoLocalID, String equipoVisitanteID, int marcadorLocal, int marcadorVisitante, boolean jugado) {
        super(arbitro1, arbitro2, fechaPartido, categoriaID, rama, torneoID, equipoLocalID, equipoVisitanteID, marcadorLocal, marcadorVisitante, jugado);
    }
    
    @Override
     public void Alta_partido(){
        try{
        PreparedStatement parametro;
        cn = new Conexion();    
        String sql = "INSERT INTO Partidos (Arbitro_1, Arbitro_2, Fecha_Partido, CategoriaID, Rama, TorneoID, EquipoLocalID, EquipoVisitanteID, MarcadorLocal, MarcadorVisitante, Jugado)\n" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getArbitro1());
        parametro.setString(2, getArbitro2());
        parametro.setString(3, getFechaPartido());
        parametro.setString(4, getCategoriaID());
        parametro.setString(5, getRama());
        parametro.setString(6, getTorneoID());
        parametro.setString(7, getEquipoLocalID());
        parametro.setString(8, getEquipoVisitanteID());
        parametro.setInt(9, getMarcadorLocal());
        parametro.setInt(10, getMarcadorVisitante());
        parametro.setBoolean(11, isJugado());
        parametro.executeUpdate();
        cn.cerrar_conexion();
        }catch(SQLException e){
         e.printStackTrace();
        }
    }
    
    @Override
    public List Consulta(){
    ArrayList<PartidosDAO> lista = new ArrayList<>(); 
    try{
     PreparedStatement parametro;
     cn = new Conexion();
     cn.abrir_Conexion();
     String sql = "SELECT Fecha_Partido, CategoriaID, Rama, TorneoID, EquipoLocalID, EquipoVisitanteID, "
             + "MarcadorLocal, MarcadorVisitante FROM Partidos;";    
    parametro = cn.conexionBD.prepareStatement(sql);
    rs = parametro.executeQuery();
    while(rs.next()){
        PartidosDAO partido = new PartidosDAO();
        partido.setFechaPartido(rs.getString("Fecha_Partido"));
        partido.setCategoriaID(rs.getString("CategoriaID"));
        partido.setRama(rs.getString("Rama"));
        partido.setTorneoID(rs.getString("TorneoID"));
        partido.setEquipoLocalID(rs.getString("EquipoLocalID"));
        partido.setEquipoVisitanteID(rs.getString("EquipoVisitanteID"));
        partido.setMarcadorLocal(rs.getInt("MarcadorLocal"));
        partido.setMarcadorVisitante(rs.getInt("MarcadorVisitante"));
        lista.add(partido);
       }
             parametro.close();
            cn.cerrar_conexion();
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return lista;      
    }
    
    @Override
    public List Consulta_2(String torneoID) {
    ArrayList<PartidosDAO> lista = new ArrayList<>();
    try {
        cn = new Conexion();
        cn.abrir_Conexion();
        String sql = "SELECT * FROM Partidos WHERE TorneoID = ?";
        PreparedStatement parametro = cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, torneoID);
        rs = parametro.executeQuery();
        while (rs.next()) {
            PartidosDAO partido = new PartidosDAO();
            partido.setFechaPartido(rs.getString("Fecha_Partido"));
            partido.setCategoriaID(rs.getString("CategoriaID"));
            partido.setRama(rs.getString("Rama"));
            partido.setTorneoID(rs.getString("TorneoID"));
            partido.setEquipoLocalID(rs.getString("EquipoLocalID"));
            partido.setEquipoVisitanteID(rs.getString("EquipoVisitanteID"));
            partido.setMarcadorLocal(rs.getInt("MarcadorLocal"));
            partido.setMarcadorVisitante(rs.getInt("MarcadorVisitante"));
            lista.add(partido);
        }
        parametro.close();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

    
}
