/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import java.util.List;


public class AdministradorDAO {
 
    String nombre_completo,contrasena;
    String numero_telefono,correo,fecha_nacimiento,sexo;
    String foto;
    
    public AdministradorDAO() {
        
    }

    public AdministradorDAO(String nombre_completo, String contrasena, String numero_telefono, String correo, String fecha_nacimiento, String sexo) {
        this.nombre_completo = nombre_completo;
        this.contrasena = contrasena;
        this.numero_telefono = numero_telefono;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
    }

    
    public AdministradorDAO(String nombre_completo, String contrasena, String numero_telefono, String correo, String fecha_nacimiento, String sexo, String foto) {
        this.nombre_completo = nombre_completo;
        this.contrasena = contrasena;
        this.numero_telefono = numero_telefono;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.foto = foto;
    }

   
    
    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
     
   public boolean agregar(){
       
        return false;   
    }
    
   public List consultar(){   
        return null;
   }
   
   public boolean validar(String correo,String contrasena){    
    return false;    
   }

    
    
    
}
