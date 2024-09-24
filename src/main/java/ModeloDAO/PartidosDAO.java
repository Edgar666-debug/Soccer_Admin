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
public class PartidosDAO {
    private String arbitro1;
    private String arbitro2;
    private String fechaPartido;
    private String categoriaID;
    private String rama;
    private String torneoID;
    private String equipoLocalID;
    private String equipoVisitanteID;
    private int marcadorLocal;
    private int marcadorVisitante;
    private boolean jugado;

    public PartidosDAO() {
    }

    public PartidosDAO(String arbitro1, String arbitro2, String fechaPartido, String categoriaID, String rama, String torneoID, String equipoLocalID, String equipoVisitanteID, int marcadorLocal, int marcadorVisitante, boolean jugado) {
        this.arbitro1 = arbitro1;
        this.arbitro2 = arbitro2;
        this.fechaPartido = fechaPartido;
        this.categoriaID = categoriaID;
        this.rama = rama;
        this.torneoID = torneoID;
        this.equipoLocalID = equipoLocalID;
        this.equipoVisitanteID = equipoVisitanteID;
        this.marcadorLocal = marcadorLocal;
        this.marcadorVisitante = marcadorVisitante;
        this.jugado = jugado;
    }

    public String getArbitro1() {
        return arbitro1;
    }

    public void setArbitro1(String arbitro1) {
        this.arbitro1 = arbitro1;
    }

    public String getArbitro2() {
        return arbitro2;
    }

    public void setArbitro2(String arbitro2) {
        this.arbitro2 = arbitro2;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(String categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getRama() {
        return rama;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public String getTorneoID() {
        return torneoID;
    }

    public void setTorneoID(String torneoID) {
        this.torneoID = torneoID;
    }

    public String getEquipoLocalID() {
        return equipoLocalID;
    }

    public void setEquipoLocalID(String equipoLocalID) {
        this.equipoLocalID = equipoLocalID;
    }

    public String getEquipoVisitanteID() {
        return equipoVisitanteID;
    }

    public void setEquipoVisitanteID(String equipoVisitanteID) {
        this.equipoVisitanteID = equipoVisitanteID;
    }

    public int getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(int marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public int getMarcadorVisitante() {
        return marcadorVisitante;
    }

    public void setMarcadorVisitante(int marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
    
    public void Alta_partido(){
        
    }
    
    public List Consulta(){
        
        return null;      
    }
    
    public List Consulta_2(String torneoID){
        
        return null;      
    }
}
