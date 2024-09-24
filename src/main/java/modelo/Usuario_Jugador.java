/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import ModeloDAO.Usuarios_JugadoresDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jaime
 */
public class Usuario_Jugador extends Usuarios_JugadoresDAO{
    private Conexion cn;
    ResultSet rs;
    
    public Usuario_Jugador() {
    }

    public Usuario_Jugador(String nombre_usuario, String nombre_completo, String fecha_nacimiento, String posicion, String sexo, String contrasena, String numero_telefono, String correo, String foto) {
        super(nombre_usuario, nombre_completo, fecha_nacimiento, posicion, sexo, contrasena, numero_telefono, correo, foto);
    }

    @Override
    public void Crear_Cuenta(){
        String sql = "INSERT INTO Soccer_Admin.usuarios (nombre_usuario, nombre_completo, posicion, fecha_nacimiento, sexo, contrasena, numero_telefono, correo)\n" +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement parametro;     
        cn = new Conexion();
        cn.abrir_Conexion();
        try {
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, getNombre_usuario());
        parametro.setString(2,getNombre_completo());
        parametro.setString(3,getPosicion());
        parametro.setString(4,getFecha_nacimiento());
        parametro.setString(5,getSexo());
        parametro.setString(6,getContrasena());
        parametro.setString(7,getNumero_telefono());
        parametro.setString(8,getCorreo());
        parametro.executeUpdate();
        cn.cerrar_conexion();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    @Override
     public boolean Validar(String nombre_usuario, String contrasena){
         boolean valido = false; 
         try {
         PreparedStatement parametro; 
         cn = new Conexion();
         cn.abrir_Conexion();
         String sql = "Select * from usuarios where nombre_usuario=? and contrasena=?;";
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(sql);  
         parametro.setString(1, nombre_usuario);
         parametro.setString(2, contrasena);
         rs = parametro.executeQuery();
         if(rs.next()){
            this.setNombre_usuario(rs.getString("nombre_usuario"));
            this.setNombre_completo(rs.getString("nombre_completo"));
            this.setPosicion(rs.getString("posicion"));
            this.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            this.setSexo(rs.getString("sexo"));
            this.setContrasena(rs.getString("contrasena"));
            this.setNumero_telefono(rs.getString("numero_telefono"));
            this.setCorreo(rs.getString("correo"));
            valido = true;
         }
          cn.cerrar_conexion();  
        } catch (SQLException e) {
        }
        
       return valido;
        
    }
    
    @Override
     public void actualizar(){
        
    }
     
          
    @Override
    public List Consultar(){
    ArrayList<Usuarios_JugadoresDAO> jugadores = new ArrayList<>();
    String sql = "SELECT nombre_usuario, nombre_completo, posicion, fecha_nacimiento FROM usuarios;";
        try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();   
        while(rs.next()){
            Usuarios_JugadoresDAO jugador = new Usuarios_JugadoresDAO();
            jugador.setNombre_usuario(rs.getString("nombre_usuario"));
            jugador.setNombre_completo(rs.getString("nombre_completo"));
            jugador.setPosicion(rs.getString("posicion"));
            jugador.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            jugadores.add(jugador);
        }    
            
        } catch (SQLException e) {
        
        }finally{
            cn.cerrar_conexion();
        }
       return jugadores;
    }
    
    
    
    @Override
    public List<Usuarios_JugadoresDAO> Consultar2(){
        ArrayList<Usuarios_JugadoresDAO> juga_dispo = new ArrayList<>();
        String sql = "SELECT u.nombre_completo FROM usuarios u LEFT JOIN JugadoresEquipos j ON u.nombre_completo = j.NombreJugador\n" +
                     "WHERE j.NombreJugador IS NULL;";
        try {
        PreparedStatement parametro;
        cn = new Conexion();
        cn.abrir_Conexion();
        parametro = cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
                    while(rs.next()) {
                Usuarios_JugadoresDAO usuario = new Usuarios_JugadoresDAO();
                usuario.setNombre_completo(rs.getString("nombre_completo"));
                juga_dispo.add(usuario);
            }
            cn.cerrar_conexion();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return juga_dispo;
    }        
    
    @Override
    public void eliminar(){
        
    }
     
     
}
