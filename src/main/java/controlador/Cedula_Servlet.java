/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import modelo.*;
/**
 *
 * @author jaime
 */
@WebServlet(name = "Cedula_Servlet", urlPatterns = {"/Cedula_Servlet"})
public class Cedula_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String btnAccion = request.getParameter("Accion");

            if ("Enviar".equals(btnAccion)) {
                String arbitro = request.getParameter("txtArbitro");
                String asistente = request.getParameter("txtAsistente");
                String fecha = request.getParameter("txtFecha");
                String categoria = request.getParameter("txtCategoria");
                String rama = request.getParameter("txtGenero");
                String torneo = request.getParameter("txtTorneo");
                String E_local = request.getParameter("equipoLocal");
                String E_visitante = request.getParameter("equipoVisitante");
                int M_local = Integer.parseInt(request.getParameter("marcadorLocal"));
                int M_visitante = Integer.parseInt(request.getParameter("marcadorVisitante"));
                int partido_jugado = 1;

            Rol_Juegos rol = new Rol_Juegos();
            Partidos p = new Partidos(arbitro, asistente, fecha, categoria, rama, torneo,
              E_local, E_visitante, M_local, M_visitante, true);
            p.Alta_partido();
            rol.jugado(fecha, E_local, E_visitante);
            // Calcula los puntos y estadísticas para el equipo local
            calcularEstadisticasYActualizarPuntos(E_local, M_local, M_visitante, categoria, torneo, partido_jugado);
            // Calcula los puntos y estadísticas para el equipo visitante
            calcularEstadisticasYActualizarPuntos(E_visitante, M_visitante, M_local, categoria, torneo, partido_jugado);
            // Procesar estadísticas de los jugadores del equipo local
            procesarEstadisticasJugadores(request, E_local, torneo);
            // Procesar estadísticas de los jugadores del equipo visitante
            procesarEstadisticasJugadores(request, E_visitante, torneo);
                response.sendRedirect("Resultados_Jornada.jsp?success=true");
            }
        } catch (NumberFormatException ex) {
            // Manejar errores de conversión de números
            response.sendRedirect("Cedula_Partido.jsp?error=true");
           }
        }

    
    private void calcularEstadisticasYActualizarPuntos(String equipo, int golesAFavor, int golesEnContra, String categoria, String torneo, int partido_jugado) {
    int puntos;
    int partidosGanados, partidosEmpatados, partidosPerdidos;

    if (golesAFavor > golesEnContra) {
        puntos = 3;
        partidosGanados = 1;
        partidosEmpatados = 0;
        partidosPerdidos = 0;
    } else if (golesAFavor < golesEnContra) {
        puntos = 0;
        partidosGanados = 0;
        partidosEmpatados = 0;
        partidosPerdidos = 1;
    } else {
        puntos = 1;
        partidosGanados = 0;
        partidosEmpatados = 1;
        partidosPerdidos = 0;
    }

    Posiciones puntosEquipo = new Posiciones();
    puntosEquipo.setPartidosJugados(partido_jugado);
    puntosEquipo.setPartidosGanados(partidosGanados);
    puntosEquipo.setPartidosEmpatados(partidosEmpatados);
    puntosEquipo.setPartidosPerdidos(partidosPerdidos);
    puntosEquipo.setGolesAFavor(golesAFavor);
    puntosEquipo.setGolesEnContra(golesEnContra);
    puntosEquipo.setPuntosGanados(puntos);
    puntosEquipo.puntos(equipo, categoria, torneo);
    }

    private void procesarEstadisticasJugadores(HttpServletRequest request, String equipo, String torneo) {    
       Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();

            // Verificar si el parámetro corresponde a goles, amarillas o rojas de un jugador
            if (paramName.startsWith("goles_") || paramName.startsWith("amarillas_") || paramName.startsWith("rojas_")) {
                String nombreJugador = paramName.substring(paramName.indexOf('_') + 1); // Obtener el nombre del jugador
                int goles = 0;
                int amarillas = 0;
                int rojas = 0;
                int presente = 0;

            // Determinar si el jugador está presente
               if (request.getParameter("presente_" + nombreJugador) != null) {
                presente = 1;
                }
                // Dependiendo del prefijo del parámetro, actualizar la variable correspondiente
                if (paramName.startsWith("goles_")) {
                    goles = Integer.parseInt(request.getParameter(paramName));
                } else if (paramName.startsWith("amarillas_")) {
                    amarillas = Integer.parseInt(request.getParameter(paramName));
                } else if (paramName.startsWith("rojas_")) {
                    rojas = Integer.parseInt(request.getParameter(paramName));
                }

                // Actualizar las estadísticas del jugador
                Jugadores_Equipos jugador = new Jugadores_Equipos(presente, goles, amarillas, rojas); // Suponiendo que tengas una clase Jugador
                // Llamar al método para actualizar las estadísticas del jugador
                jugador.Estadisticas_Jugador1(nombreJugador, equipo, torneo);
                   // Imprimir los resultados en la consola
            System.out.println("Nombre del Jugador: " + nombreJugador);
            System.out.println("Goles: " + goles);
            System.out.println("Amarillas: " + amarillas);
            System.out.println("Rojas: " + rojas);
            System.out.println("Presente: " + presente);
            System.out.println("Equipo: " + equipo);
            System.out.println("Torneo: " + torneo);
            }
        }
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
