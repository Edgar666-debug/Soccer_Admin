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
public class EquiposDAO {
    private String NombreEquipo;
    private String Color_Playera;
    private String Representante;
    private String NumeroRepresentante;
    private String CategoriaID;
    private String TorneoID;

    public EquiposDAO() {
    }

    public EquiposDAO(String NombreEquipo, String Color_Playera, String Representante, String NumeroRepresentante) {
        this.NombreEquipo = NombreEquipo;
        this.Color_Playera = Color_Playera;
        this.Representante = Representante;
        this.NumeroRepresentante = NumeroRepresentante;
    }

    public EquiposDAO(String NombreEquipo, String Color_Playera, String Representante, String NumeroRepresentante, String CategoriaID, String TorneoID) {
        this.NombreEquipo = NombreEquipo;
        this.Color_Playera = Color_Playera;
        this.Representante = Representante;
        this.NumeroRepresentante = NumeroRepresentante;
        this.CategoriaID = CategoriaID;
        this.TorneoID = TorneoID;
    }

    
    
    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }

    public String getColor_Playera() {
        return Color_Playera;
    }

    public void setColor_Playera(String Color_Playera) {
        this.Color_Playera = Color_Playera;
    }

    public String getRepresentante() {
        return Representante;
    }

    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }

    public String getNumeroRepresentante() {
        return NumeroRepresentante;
    }

    public void setNumeroRepresentante(String NumeroRepresentante) {
        this.NumeroRepresentante = NumeroRepresentante;
    }

    public String getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(String CategoriaID) {
        this.CategoriaID = CategoriaID;
    }

    public String getTorneoID() {
        return TorneoID;
    }

    public void setTorneoID(String TorneoID) {
        this.TorneoID = TorneoID;
    }
    
    public void agregar(){
        
    }
     public void inscribir(String NombreEquipo, String CategoriaID, String TorneoID){
        
    }
     
     public void actualizar(){
         
     }
      public void eliminar(String NombreEquipo){
        
    }
      
    public List Listar2(String TorneoID){
        
        return null;        
    }
    public List list(String NombreEquipo){
        return null;
    }
     
     public List Listar(String representante){
         
        return null;
         
     }
    
    
}
