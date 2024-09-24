/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import java.sql.Time;
import java.util.List;

/**
 *
 * @author jaime
 */
public class Rol_JuegosDAO {
    String torneo;
    String fechaEnfrentamiento;
    Time horario;
    String enfrentamientoLocal;
    String enfrentamientoVisitante;

    public Rol_JuegosDAO() {
    }

    public Rol_JuegosDAO(String torneo, String fechaEnfrentamiento, Time horario, String enfrentamientoLocal, String enfrentamientoVisitante) {
        this.torneo = torneo;
        this.fechaEnfrentamiento = fechaEnfrentamiento;
        this.horario = horario;
        this.enfrentamientoLocal = enfrentamientoLocal;
        this.enfrentamientoVisitante = enfrentamientoVisitante;
    }    
    
    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public String getFechaEnfrentamiento() {
        return fechaEnfrentamiento;
    }

    public void setFechaEnfrentamiento(String fechaEnfrentamiento) {
        this.fechaEnfrentamiento = fechaEnfrentamiento;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getEnfrentamientoLocal() {
        return enfrentamientoLocal;
    }

    public void setEnfrentamientoLocal(String enfrentamientoLocal) {
        this.enfrentamientoLocal = enfrentamientoLocal;
    }

    public String getEnfrentamientoVisitante() {
        return enfrentamientoVisitante;
    }

    public void setEnfrentamientoVisitante(String enfrentamientoVisitante) {
        this.enfrentamientoVisitante = enfrentamientoVisitante;
    }
    
    public List Consultar_Partidos(){
        
        return null;    
    }
    
    public List Consultar_Partidos2(){
        
        return null;    
    }
    
     public List Listar(){
        
        return null;    
    }
    
    public void asignar_horario(){
        
    }
    
    public void eliminar(String enfrentamientoLocal,String enfrentamientoVisitante){
            
    }
     
    public boolean insertar() {
        
    return false;
    }
    
    
}
