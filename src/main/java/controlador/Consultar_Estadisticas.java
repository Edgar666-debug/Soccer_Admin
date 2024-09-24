/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import ModeloDAO.Jugadores_EquiposDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Jugadores_Equipos;

/**
 *
 * @author jaime
 */
@WebServlet(name = "Consultar_Estadisticas", urlPatterns = {"/Consultar_Estadisticas"})
public class Consultar_Estadisticas extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
       String equipoID = request.getParameter("equipoID");

        // Lógica para obtener los jugadores del equipo
        Jugadores_Equipos jugadoresServicio = new Jugadores_Equipos();
        List<Jugadores_EquiposDAO> jugadores = jugadoresServicio.Consultar_Estadistica(equipoID);    
        
out.println("<style>");
out.println("table { border-collapse: separate; border-spacing: 0 10px; border-radius: 10px;"
                    + " overflow: hidden; width: 100%; }");
out.println("th, td { border: 1px solid #dddddd; text-align: center; padding: 8px; font-size: 16px; }");
out.println("th { background-color: #1F0A87; color: white; border-radius: 5px; }");
out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
out.println("</style>");
out.println("<table>");
out.println("<tr style=\"background-color: #1F0A87; color: white;\"><th>Nombre</th><th>Dorsal</th><th>Posicion</th><th>PJ</th><th>Goles</th><th>TA</th><th>TR</th></tr>");

for (Jugadores_EquiposDAO jugador : jugadores) {
    out.println("<tr  style=\"background-color: white;\">");
    out.println("<td>" + jugador.getNombreJugador() + "</td>");
    out.println("<td>" + jugador.getDorsal() + "</td>");
    out.println("<td>" + jugador.getPosicion() + "</td>");
    out.println("<td>" + jugador.getPartidosJugados() + "</td>");
    out.println("<td>" + jugador.getGolID() + "</td>");
    out.println("<td>" + jugador.getTarjetaA() + "</td>");
    out.println("<td>" + jugador.getTarjetaR() + "</td>");
    out.println("</tr>");
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
