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
public class Jugadores_Equipos extends Jugadores_EquiposDAO{
    private Conexion cn;
    ResultSet rs;
    
    public Jugadores_Equipos() {
    }

    public Jugadores_Equipos(String nombreJugador, String equipoID, int dorsal, String torneoID, int partidosJugados, int golID, int tarjetaA, int tarjetaR) {
        super(nombreJugador, equipoID, dorsal, torneoID, partidosJugados, golID, tarjetaA, tarjetaR);
    }

    
    public Jugadores_Equipos(String nombreJugador, String equipoID, int dorsal, String torneoID) {
        super(nombreJugador, equipoID, dorsal, torneoID);
    }

    public Jugadores_Equipos(String nombreJugador, int partidosJugados, int golID, int tarjetaA, int tarjetaR) {
        super(nombreJugador, partidosJugados, golID, tarjetaA, tarjetaR);
    }

    public Jugadores_Equipos(int partidosJugados, int golID, int tarjetaA, int tarjetaR) {
        super(partidosJugados, golID, tarjetaA, tarjetaR);
    }
   
    
    @Override
    public void Agregar_Plantilla(){
        try {
          cn = new Conexion();
         PreparedStatement parametro;
         String sql = "INSERT INTO JugadoresEquipos (NombreJugador, EquipoID, Dorsal, TorneoID)"
                 + "  VALUES (?, ?, ?, ?)";         
         cn.abrir_Conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getNombreJugador());
        parametro.setString(2, getEquipoID());
        parametro.setInt(3, getDorsal());
        parametro.setString(4, getTorneoID());   
        parametro.executeUpdate();
        cn.cerrar_conexion();   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void Agregar() {
        try {
         cn = new Conexion();
         PreparedStatement parametro;
         String sql = "INSERT INTO `jugadoresequipos`(`NombreJugador`,`EquipoID`,`Dorsal`,`TorneoID`)\n"+
                 "VALUES(?,?,?,?);";   
        cn.abrir_Conexion();
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getNombreJugador());
        parametro.setString(2, getEquipoID());
        parametro.setInt(3, getDorsal());
        parametro.setString(4, getTorneoID());
        parametro.executeUpdate();
        cn.cerrar_conexion();
        } catch (SQLException e) {
            
        }
    }
    
    @Override
    public void Estadisticas_Jugador1(String nombreJugador, String equipoID, String torneoID){
        try{
        PreparedStatement parametro;
        cn = new Conexion();
        String sql = "UPDATE JugadoresEquipos SET Partidos = Partidos + ?, GolID = GolID + ?, "
                + "Tarjeta_A = Tarjeta_A + ?, Tarjeta_R = Tarjeta_R + ?\n" +
                "WHERE NombreJugador = ? AND EquipoID = ? AND TorneoID = ?;";
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql); 
        parametro.setInt(1, getPartidosJugados());
        parametro.setInt(2, getGolID());
        parametro.setInt(3, getTarjetaA());
        parametro.setInt(4, getTarjetaR());
        parametro.setString(5, nombreJugador);
        parametro.setString(6, equipoID);
        parametro.setString(7, torneoID);
        parametro.executeUpdate();
        }catch(SQLException E){
            E.printStackTrace();
        }finally{
            if(cn != null){
              cn.cerrar_conexion();   
            }
        }     
    }   
    
    @Override
    public void eliminar(String nombreJugador){
         try {
        PreparedStatement parametro;
        cn = new Conexion();
        String sql = "DELETE FROM JugadoresEquipos WHERE NombreJugador = ?";
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, nombreJugador);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        System.out.println(e);
    }   
    }
    
    public List<Jugadores_EquiposDAO> Mis_Equipos(String nombreJugador) {
    List<Jugadores_EquiposDAO> jugadores = new ArrayList<>();
    try {
        cn = new Conexion();
        String sql = "SELECT EquipoID FROM jugadoresequipos WHERE NombreJugador = ?";
        cn.abrir_Conexion();
        PreparedStatement statement = cn.conexionBD.prepareStatement(sql);
        statement.setString(1, nombreJugador);
        ResultSet rs = statement.executeQuery();

        // Procesar los resultados y almacenar en la lista
        while (rs.next()) {
            Jugadores_EquiposDAO jugador = new Jugadores_EquiposDAO();  // Asumiendo que tienes una clase Jugadores
            jugador.setEquipoID(rs.getString("EquipoID"));
            // Puedes agregar más atributos según tu necesidad
            jugadores.add(jugador);
        }

        // Cerrar recursos
        rs.close();
        statement.close();
        cn.cerrar_conexion();

    } catch (SQLException e) {
        // Manejo de excepciones
        e.printStackTrace();  // Puedes personalizar el manejo de la excepción según tus necesidades
    }
    return jugadores;
}
    
    @Override
    public List Consultar_Plantilla(String equipoID){
        List<Jugadores_EquiposDAO> jugadores = new ArrayList<>();
        try {
            PreparedStatement statement;
            cn = new Conexion();
            String sql = "SELECT * FROM Jugadoresequipos WHERE EquipoID = ?;"; // Filtra por el ID del equipo
            cn.abrir_Conexion();
            statement = cn.conexionBD.prepareStatement(sql);
            statement.setString(1, equipoID); // Asigna el valor del equipoID al parámetro en la consulta SQL
            rs = statement.executeQuery();
            while (rs.next()) {
             Jugadores_EquiposDAO player = new Jugadores_EquiposDAO();
              player.setNombreJugador(rs.getString("NombreJugador"));
              player.setEquipoID(rs.getString("EquipoID"));
              player.setDorsal(rs.getInt("Dorsal"));
              player.setTorneoID(rs.getString("TorneoID"));
              jugadores.add(player);
            }
            statement.close();
            cn.cerrar_conexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;

    }
    
    @Override
        public List consultar(String equipoID, String TorneoID){
        List<Jugadores_EquiposDAO> jugadores = new ArrayList<>();
        try {
            PreparedStatement statement;
            cn = new Conexion();
            String sql = "SELECT NombreJugador, Dorsal FROM jugadoresequipos\n" +
                      "WHERE EquipoID = ? AND TorneoID = ?;"; // Filtra por el ID del equipo
            cn.abrir_Conexion();
            statement = cn.conexionBD.prepareStatement(sql);
            statement.setString(1, equipoID); 
            statement.setString(2, TorneoID);// Asigna el valor del equipoID al parámetro en la consulta SQL
            rs = statement.executeQuery();
            while (rs.next()) {
                Jugadores_EquiposDAO player = new Jugadores_EquiposDAO();
                player.setNombreJugador(rs.getString("NombreJugador"));
                player.setDorsal(rs.getInt("Dorsal"));
                jugadores.add(player);
            }

            statement.close();
            cn.cerrar_conexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;      
    }
    
    public List consultar(String equipoID){
        List<Jugadores_EquiposDAO> jugadores = new ArrayList<>();
        try {
            PreparedStatement statement;
            cn = new Conexion();
            String sql = "SELECT u.nombre_completo, u.posicion, je.Dorsal, je.EquipoID FROM usuarios u\n" +
            "INNER JOIN JugadoresEquipos je ON u.nombre_completo = je.NombreJugador\n" +
            "WHERE je.EquipoID = ?;"; // Filtra por el ID del equipo
            cn.abrir_Conexion();
            statement = cn.conexionBD.prepareStatement(sql);
            statement.setString(1, equipoID); 
            rs = statement.executeQuery();
            while (rs.next()) {
                Jugadores_EquiposDAO player = new Jugadores_EquiposDAO();
                player.setNombreJugador(rs.getString("u.nombre_completo"));
                player.setPosicion(rs.getString("u.posicion"));
                player.setDorsal(rs.getInt("je.Dorsal"));
                jugadores.add(player);
            }

            statement.close();
            cn.cerrar_conexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return jugadores;      
    }
    
    @Override
    public List Consultar_Estadistica(String equipoID){
        List<Jugadores_EquiposDAO> plantilla = new ArrayList<>();
        try{
            PreparedStatement statement;
            cn = new Conexion();
            String sql = "SELECT u.nombre_completo, je.Dorsal, u.posicion, je.Partidos, je.GolID,"
                    + " je.Tarjeta_A, je.Tarjeta_R FROM usuarios u \n" +
           "INNER JOIN JugadoresEquipos je ON u.nombre_completo = je.NombreJugador WHERE je.EquipoID = ?;"; // Filtra por el ID del equipo
            cn.abrir_Conexion();
            statement = cn.conexionBD.prepareStatement(sql);
            statement.setString(1, equipoID);  
            rs = statement.executeQuery();
            while(rs.next()){
                Jugadores_EquiposDAO player = new Jugadores_EquiposDAO();
                player.setNombreJugador(rs.getString("u.nombre_completo"));
                player.setDorsal(rs.getInt("je.Dorsal"));
                player.setPosicion(rs.getString("u.posicion"));
                player.setPartidosJugados(rs.getInt("je.Partidos"));
                player.setGolID(rs.getInt("je.GolID"));
                player.setTarjetaA(rs.getInt("je.Tarjeta_A"));
                player.setTarjetaR(rs.getInt("je.Tarjeta_R"));
                plantilla.add(player);
            }
            
            statement.close();
            cn.cerrar_conexion();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return plantilla;    
    }
    
    @Override
    public List Estadistica_Jugador(String torneoID){
        List<Jugadores_EquiposDAO> goleadores = new ArrayList<>();
        try {
            PreparedStatement statement;
            cn = new Conexion();
            String sql = "SELECT je.EquipoID,u.nombre_completo,je.Dorsal,u.posicion,je.Partidos,je.GolID\n" +
            "FROM usuarios u INNER JOIN JugadoresEquipos je ON u.nombre_completo = je.NombreJugador\n" +
            "WHERE je.TorneoID = ? ORDER BY GolID DESC LIMIT 10;";
            cn.abrir_Conexion();
            statement = cn.conexionBD.prepareStatement(sql);
            statement.setString(1, torneoID);
            rs = statement.executeQuery();
            while(rs.next()){
            Jugadores_EquiposDAO jugador = new Jugadores_EquiposDAO();
            jugador.setEquipoID(rs.getString("je.EquipoID"));
            jugador.setNombreJugador(rs.getString("u.nombre_completo"));
            jugador.setDorsal(rs.getInt("je.Dorsal"));
            jugador.setPosicion(rs.getString("u.posicion"));
            jugador.setPartidosJugados(rs.getInt("je.Partidos"));
            jugador.setGolID(rs.getInt("je.GolID"));
            goleadores.add(jugador);                     
            }
        // Cerrar la conexión y el statement
        cn.cerrar_conexion();
        statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return goleadores;    
    }
     
        @Override
   public void actualizar(String nombreJugador) {
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        String sql = "UPDATE JugadoresEquipos SET Dorsal = ? WHERE NombreJugador = ?";
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setInt(1, getDorsal());
        parametro.setString(2, nombreJugador);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        System.out.println(e);
    }
}
    
}
