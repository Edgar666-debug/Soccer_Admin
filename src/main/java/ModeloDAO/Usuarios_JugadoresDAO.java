/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;


import java.util.List;


/**
 *
 * @author jaime
 */
public class Usuarios_JugadoresDAO {
   String nombre_usuario, nombre_completo,fecha_nacimiento,
          posicion,sexo,contrasena,numero_telefono,correo;
    String foto;

    public Usuarios_JugadoresDAO() {
    }
   

    public Usuarios_JugadoresDAO(String nombre_usuario, String nombre_completo, String fecha_nacimiento, String posicion, 
            String sexo, String contrasena, String numero_telefono, String correo, String foto) {
        this.nombre_usuario = nombre_usuario;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.posicion = posicion;
        this.sexo = sexo;
        this.contrasena = contrasena;
        this.numero_telefono = numero_telefono;
        this.correo = correo;
        this.foto = foto;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
   
    public boolean Validar(String correo, String contrasena){
        
       return false;
        
    }
    
    public void Crear_Cuenta(){
        
    }   
    
    public void actualizar(){
        
    }
     
    public List Consultar(){
       return null;
    }
    
    public List<Usuarios_JugadoresDAO> Consultar2(){
       return null;
    }
    
    public void eliminar(){
        
    }
}
