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
import ModeloDAO.*;
import java.util.List;
import modelo.*;
/**
 *
 * @author jaime
 */
@WebServlet(name = "Goleadores_Servlet", urlPatterns = {"/Goleadores_Servlet"})
public class Goleadores_Servlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String TorneoID = request.getParameter("TorneoID");
           Jugadores_Equipos goleadores = new Jugadores_Equipos();
           List<Jugadores_EquiposDAO> lista = goleadores.Estadistica_Jugador(TorneoID);
        
out.println("<style>");
            out.println("table { border-collapse: separate; border-spacing: 0 10px; border-radius: 10px;"
                    + " overflow: hidden; width: 100%; }");
out.println("th, td { border: 1px solid #dddddd; padding: 8px; font-size:20px; text-align: center; color:black; }");
out.println("th { background-color: black; }");
out.println(".medal { color: gold; }"); // Estilo para las posiciones con medallas
out.println("</style>");

out.println("<table>");
out.println("<tr style=\"background-color: white;\">");
out.println("<th>No</th>");
out.println("<th>Equipo</th>");
out.println("<th>Posición</th>");
out.println("<th>Jugador</th>");
out.println("<th>PJ</th>");
out.println("<th>Goles</th>");
out.println("<th>GPP</th>");
out.println("</tr>");

int posicion = 1;   
for(Jugadores_EquiposDAO goleo : lista){
       out.println("<tr style=\"background-color: white;\">");
    if (posicion <= 3) {
        out.print("<td><i class=\"fas fa-medal medal\"></i> " + posicion + "</td>");
    } else {
        out.print("<td>" + posicion + "</td>");
    }
    out.print("<td>"+ goleo.getEquipoID() +"</td>");
    out.print("<td>"+ goleo.getPosicion() +"</td>");
    out.print("<td>"+ goleo.getNombreJugador()  + " (Dorsal: " + goleo.getDorsal() +")</td>");
    out.print("<td>"+ goleo.getPartidosJugados() +"</td>");
    out.print("<td>"+ goleo.getGolID() +"</td>");
    double promedioGolesPorPartido = (double) goleo.getGolID() / goleo.getPartidosJugados();
    out.print("<td>"+ String.format("%.1f", promedioGolesPorPartido) +"</td>");
    out.println("</tr>");
    posicion++;
}
out.println("</table>");

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
