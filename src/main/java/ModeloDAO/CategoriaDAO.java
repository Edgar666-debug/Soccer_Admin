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
public class CategoriaDAO {
    String nombreCategoria;
    String generacion;
    int edadMinima;
    int edadMaxima;
    String genero;
    boolean activo;

    public CategoriaDAO() {
    }
    
    
    public CategoriaDAO(String nombreCategoria, String generacion, int edadMinima, int edadMaxima, String genero, boolean activo) {
        this.nombreCategoria = nombreCategoria;
        this.generacion = generacion;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.genero = genero;
        this.activo = activo;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public List Listar2(){
       return null;
    }
    
     public List consulta(String NombreCategoria){
        return null;
    }
    public void agregar(){}
    public void modificar(){}
    public void eliminar(String NombreCategoria){}
    public List Listar(){
        return null;
    }
    
}
