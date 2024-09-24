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
public class TorneoDAO extends CategoriaDAO{
    String nombreTorneo;
    String categoriaID;
    int temporada;
    String fechaInicio;
    String fechaFinal;
    String campeon;
    boolean activo;

    public TorneoDAO() {
    }

    public TorneoDAO(String nombreTorneo, String fechaFinal, String campeon) {
        this.nombreTorneo = nombreTorneo;
        this.fechaFinal = fechaFinal;
        this.campeon = campeon;
    }

    public TorneoDAO(String nombreTorneo, String categoriaID, int temporada, String fechaInicio, String fechaFinal, String campeon, boolean activo) {
        this.nombreTorneo = nombreTorneo;
        this.categoriaID = categoriaID;
        this.temporada = temporada;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.campeon = campeon;
        this.activo = activo;
    }

    @Override
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    @Override
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String getGeneracion() {
        return generacion;
    }

    @Override
    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    @Override
    public int getEdadMinima() {
        return edadMinima;
    }

    @Override
    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    @Override
    public int getEdadMaxima() {
        return edadMaxima;
    }

    @Override
    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    @Override
    public String getGenero() {
        return genero;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(String categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getCampeon() {
        return campeon;
    }

    public void setCampeon(String campeon) {
        this.campeon = campeon;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void agregar(){
        
    }
     
     public void finalizar(){
         
     }
     public List Listar(){
         
        return null;         
     }
     
      public List Convocatoria(){
         
        return null;
         
     }
     
      public List Torneos_Nombre(String NombreTorneo){
      
          return null;
     }
    
     public void eliminar(String NombreTorneo){
         
     }
    
    
}
