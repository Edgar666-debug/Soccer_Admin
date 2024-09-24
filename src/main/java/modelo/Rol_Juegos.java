/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import ModeloDAO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime
 */
public class Rol_Juegos extends Rol_JuegosDAO{
    private Conexion cn;
    ResultSet rs;

    public Rol_Juegos() {
    }

    public Rol_Juegos(String torneo, String fechaEnfrentamiento, Time horario, String enfrentamientoLocal, String enfrentamientoVisitante) {
        super(torneo, fechaEnfrentamiento, horario, enfrentamientoLocal, enfrentamientoVisitante);
    }
    
     public void jugado(String fechaEnfrentamiento, String enfrentamientoLocal, String enfrentamientoVisitante) {
    String sql = "UPDATE rol SET Jugado = true WHERE fecha_enfrentamiento = ? " +
                    "AND enfrentamiento_local = ? AND enfrentamiento_visitante = ?;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, fechaEnfrentamiento);  // Corregido aquí
        parametro.setString(2, enfrentamientoLocal);
        parametro.setString(3, enfrentamientoVisitante);
        parametro.executeUpdate();
        cn.cerrar_conexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
   }

    @Override
    public boolean insertar() {
    try {
        cn = new Conexion();
        cn.abrir_Conexion();
        PreparedStatement parametro;
        String sql = "INSERT INTO `Rol` (`torneo`, `enfrentamiento_local`, `enfrentamiento_visitante`) VALUES (?, ?, ?)";
        parametro = cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getTorneo());
        parametro.setString(2, getEnfrentamientoLocal());
        parametro.setString(3, getEnfrentamientoVisitante());
        // Ejecutar la consulta SQL
        int resultado = parametro.executeUpdate();
        // Cerrar la conexión
        cn.cerrar_conexion();
        // Retornar true si se insertó correctamente
        return resultado > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    
    @Override
   public void asignar_horario() {
    try {
        // Consulta SQL para actualizar la fecha y el horario en la tabla 'rol'
        String sql = "UPDATE soccer_admin.rol SET fecha_enfrentamiento = ?, horario = ? " +
                     "WHERE enfrentamiento_local = ? AND enfrentamiento_visitante = ? AND torneo = ?";

        // Preparar la declaración SQL
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getFechaEnfrentamiento());
        parametro.setTime(2, getHorario());
        parametro.setString(3, getEnfrentamientoLocal());
        parametro.setString(4, getEnfrentamientoVisitante());
        parametro.setString(5, getTorneo());
        // Ejecutar la actualización
        parametro.executeUpdate();
        // Cerrar la conexión
        cn.cerrar_conexion();
    } catch (Exception e) {
        // Manejar la excepción apropiadamente (puede imprimirse o registrarse en un log)
        e.printStackTrace();
    }
   }

   @Override
    public List Consultar_Partidos(){
            ArrayList<Rol_JuegosDAO> consulta = new ArrayList<>();
            String sql ="SELECT torneo,fecha_enfrentamiento, enfrentamiento_local, enfrentamiento_visitante FROM rol where Jugado = true;";
        try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
        Rol_JuegosDAO rol = new Rol_JuegosDAO();
        rol.setTorneo(rs.getString("torneo"));
        rol.setFechaEnfrentamiento(rs.getString("fecha_enfrentamiento"));
        rol.setEnfrentamientoLocal(rs.getString("enfrentamiento_local"));
        rol.setEnfrentamientoVisitante(rs.getString("enfrentamiento_visitante"));
        consulta.add(rol);
        }
        
        }catch(SQLException e) {
        e.printStackTrace();
    } finally {
        cn.cerrar_conexion();
    }
    return consulta;
        
    }

    @Override
   public List<Rol_JuegosDAO> Consultar_Partidos2() {
    ArrayList<Rol_JuegosDAO> consulta = new ArrayList<>();
    String sql = "SELECT torneo,fecha_enfrentamiento, enfrentamiento_local, enfrentamiento_visitante FROM rol where Jugado = false;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
            Rol_JuegosDAO rol = new Rol_JuegosDAO();
            rol.setTorneo(rs.getString("torneo"));
            rol.setFechaEnfrentamiento(rs.getString("fecha_enfrentamiento"));
            rol.setEnfrentamientoLocal(rs.getString("enfrentamiento_local"));
            rol.setEnfrentamientoVisitante(rs.getString("enfrentamiento_visitante"));
            consulta.add(rol);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cn.cerrar_conexion();
    }
    return consulta;
}
   
    @Override
    public List<Rol_JuegosDAO> Listar() {
    ArrayList<Rol_JuegosDAO> lista = new ArrayList<>();
    String sql = "SELECT * FROM soccer_admin.rol where Jugado = false ORDER BY fecha_enfrentamiento;";
    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
            Rol_JuegosDAO rol = new Rol_JuegosDAO();
            rol.setTorneo(rs.getString("torneo"));
            rol.setFechaEnfrentamiento(rs.getString("fecha_enfrentamiento"));
            rol.setHorario(rs.getTime("horario"));
            rol.setEnfrentamientoLocal(rs.getString("enfrentamiento_local"));
            rol.setEnfrentamientoVisitante(rs.getString("enfrentamiento_visitante"));
            lista.add(rol);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cn.cerrar_conexion();
    }
    return lista;
}
   
  @Override
    public void eliminar(String enfrentamientoLocal, String enfrentamientoVisitante) {
    String sql = "DELETE FROM soccer_admin.rol WHERE enfrentamiento_local = ? AND enfrentamiento_visitante = ?;";

    try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);  
        parametro.setString(1, enfrentamientoLocal);
        parametro.setString(2, enfrentamientoVisitante);
        parametro.executeUpdate();
    } catch (SQLException e) {
        // Manejar adecuadamente la excepción (p. ej., registrarla o mostrar un mensaje de error)
        e.printStackTrace();
    }finally{
       cn.cerrar_conexion(); 
    }
}
    
    
}
