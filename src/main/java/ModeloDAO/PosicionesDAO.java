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
public class PosicionesDAO {
    private String equipoID;
    private String categoriaID;
    private String torneoID;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaGoles;
    private int puntosGanados;

    public PosicionesDAO() {
    }
    
    public PosicionesDAO(String equipoID, String categoriaID, String torneoID) {
        this.equipoID = equipoID;
        this.categoriaID = categoriaID;
        this.torneoID = torneoID;
    }

    public PosicionesDAO(String equipoID, String categoriaID, String torneoID, int partidosJugados, int partidosGanados, int partidosEmpatados, int partidosPerdidos, int golesAFavor, int golesEnContra, int diferenciaGoles, int puntosGanados) {
        this.equipoID = equipoID;
        this.categoriaID = categoriaID;
        this.torneoID = torneoID;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.diferenciaGoles = diferenciaGoles;
        this.puntosGanados = puntosGanados;
    }

    

    public String getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(String equipoID) {
        this.equipoID = equipoID;
    }

    public String getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(String categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getTorneoID() {
        return torneoID;
    }

    public void setTorneoID(String torneoID) {
        this.torneoID = torneoID;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }

    public void setDiferenciaGoles(int diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }

    
    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(int puntosGanados) {
        this.puntosGanados = puntosGanados;
    }
    
    public void agregar_equipo(){
        
    }
    
    public void puntos(String equipoID, String categoriaID, String torneoID){
        
    }
    
    public List Tabla(String torneoID){
        
        return null;    
    }
    
    public List Mejor_Defensa(String torneoID){
        return null;   
    }
    
}
