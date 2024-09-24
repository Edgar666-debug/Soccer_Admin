/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import ModeloDAO.AdministradorDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaime
 */
public class Administrador extends AdministradorDAO{
    private Conexion cn;
    ResultSet rs;

    public Administrador() {
    }

    public Administrador(String nombre_completo, String contrasena, String numero_telefono, String correo, String fecha_nacimiento, String sexo) {
        super(nombre_completo, contrasena, numero_telefono, correo, fecha_nacimiento, sexo);
    }

    public Administrador(String nombre_completo, String contrasena, String numero_telefono, String correo, String fecha_nacimiento, String sexo, String foto) {
        super(nombre_completo, contrasena, numero_telefono, correo, fecha_nacimiento, sexo, foto);
    }

    
    
   @Override
    public boolean agregar() {
    try {
        PreparedStatement parametro;     
        cn = new Conexion();
        String sql = "INSERT INTO administrador (nombre_completo, contrasena, numero_telefono, correo, fecha_nacimiento, sexo)\n" +
                     "VALUES (?, ?, ?, ?, ?, ?);";
        cn.abrir_Conexion();
        parametro=(PreparedStatement)cn.conexionBD.prepareStatement(sql);
        //parametro = cn.conexionBD.prepareStatement(query);
        parametro.setString(1, getNombre_completo());
        parametro.setString(2, getContrasena());
        parametro.setString(3, getNumero_telefono());
        parametro.setString(4, getCorreo());
        parametro.setString(5, getFecha_nacimiento());
        parametro.setString(6, getSexo());
        parametro.executeUpdate();
        cn.cerrar_conexion();
        return true; // Devuelve true si la inserción fue exitosa
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false; // Devuelve false si hubo algún error
    }
}

    @Override
    public boolean validar(String nombre_completo,String contrasena){   
        boolean valido = false;
        try {
        PreparedStatement parametro; 
        cn = new Conexion();
        String sql = "Select * from administrador where nombre_completo=? and contrasena=?;";
        cn.abrir_Conexion();
        parametro=(PreparedStatement)cn.conexionBD.prepareStatement(sql);
        parametro.setString(1, nombre_completo);
        parametro.setString(2, contrasena);
        rs = parametro.executeQuery();
        if(rs.next()){
        this.setNombre_completo(rs.getString("nombre_completo"));
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
    public List consultar(){   
        ArrayList<AdministradorDAO> lista = new ArrayList<>();
        try {
        PreparedStatement parametro; 
        cn = new Conexion();
        String sql = "Select * from administrador;";
        cn.abrir_Conexion();
        parametro=(PreparedStatement)cn.conexionBD.prepareStatement(sql);
        rs = parametro.executeQuery();
        while (rs.next()) {
            AdministradorDAO admin = new AdministradorDAO();
            admin.setNombre_completo(rs.getString("nombre_completo"));
            admin.setContrasena(rs.getString("contrasena"));
            admin.setNumero_telefono(rs.getString("numero_telefono"));
            admin.setCorreo(rs.getString("correo"));
            admin.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            admin.setSexo(rs.getString("sexo"));
            lista.add(admin);
            
        }    
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            cn.cerrar_conexion();
        }
        return lista;
    }
    
    
}
