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
public class Jugadores_EquiposDAO extends Usuarios_JugadoresDAO{
    private String nombreJugador;
    private String equipoID;
    private int dorsal;
    private String torneoID;
    private int partidosJugados;
    private int golID;
    private int tarjetaA;
    private int tarjetaR;

    public Jugadores_EquiposDAO() {
    }

    public Jugadores_EquiposDAO(String nombreJugador, String equipoID, int dorsal, String torneoID, int partidosJugados, int golID, int tarjetaA, int tarjetaR) {
        this.nombreJugador = nombreJugador;
        this.equipoID = equipoID;
        this.dorsal = dorsal;
        this.torneoID = torneoID;
        this.partidosJugados = partidosJugados;
        this.golID = golID;
        this.tarjetaA = tarjetaA;
        this.tarjetaR = tarjetaR;
    }
    
    public Jugadores_EquiposDAO(String nombreJugador, String equipoID, int dorsal, String torneoID) {
        this.nombreJugador = nombreJugador;
        this.equipoID = equipoID;
        this.dorsal = dorsal;
        this.torneoID = torneoID;
    }

    public Jugadores_EquiposDAO(int partidosJugados, int golID, int tarjetaA, int tarjetaR) {
        this.partidosJugados = partidosJugados;
        this.golID = golID;
        this.tarjetaA = tarjetaA;
        this.tarjetaR = tarjetaR;
    }

    public Jugadores_EquiposDAO(String nombreJugador,int partidosJugados, int golID, int tarjetaA, int tarjetaR) {
        this.nombreJugador = nombreJugador;
        this.partidosJugados = partidosJugados;
        this.golID = golID;
        this.tarjetaA = tarjetaA;
        this.tarjetaR = tarjetaR;
    }

    @Override
    public String getNombre_completo() {
        return nombre_completo;
    }

    @Override
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    @Override
    public String getPosicion() {
        return posicion;
    }

    @Override
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(String equipoID) {
        this.equipoID = equipoID;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
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

    public int getGolID() {
        return golID;
    }

    public void setGolID(int golID) {
        this.golID = golID;
    }

    public int getTarjetaA() {
        return tarjetaA;
    }

    public void setTarjetaA(int tarjetaA) {
        this.tarjetaA = tarjetaA;
    }

    public int getTarjetaR() {
        return tarjetaR;
    }

    public void setTarjetaR(int tarjetaR) {
        this.tarjetaR = tarjetaR;
    }
    
    public void Agregar_Plantilla(){
        
    }
    
    public void Estadisticas_Jugador1(String nombreJugador, String equipoID,String torneoID){
        
    }
    
    public void eliminar(String nombreJugador){
        
    }
    
    public List Consultar_Plantilla(String equipoID){
        
        return null;    
    }
    
    public List consultar(String equipoID, String TorneoID){
        
        return null;    
    }
    
    public List Consultar_Estadistica(String equipoID){
        
        return null;    
    }
    
    public List Estadistica_Jugador(String torneoID){
        
        return null;    
    }
    
    public void actualizar(String nombreJugador){
        
    }
}
