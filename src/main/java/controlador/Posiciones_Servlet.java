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
@WebServlet(name = "Posiciones_Servlet", urlPatterns = {"/Posiciones_Servlet"})
public class Posiciones_Servlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    
            String TorneoID = request.getParameter("TorneoID");
            Posiciones posicion = new Posiciones();
            List<PosicionesDAO> tablas = posicion.Tabla(TorneoID);
out.println("<style>");
out.println("table { border-collapse: separate; border-spacing: 0 10px; border-radius: 10px;"
                    + " overflow: hidden; width: 100%; }");
out.println("th, td { border: 1px solid #dddddd; text-align: center; padding: 8px; font-size: 20px; color: black; }");
out.println("th { background-color: #f2f2f2; color: white; }");
out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
out.println("tr { color: ; }");
out.println("</style>");
out.println("<table>");
out.println("<tr style=\"background-color: #1F0A87;\"><th>No</th><th>Equipo</th><th>PJ</th><th>G</th><th>E</th><th>P</th><th>GF</th><th>GC</th><th>DG</th><th>Pts</th></tr>");
int numeroEquipo = 1;
for (PosicionesDAO equipo : tablas) {
    out.println("<tr style=\"background-color: white;\">");
    out.println("<td>" + numeroEquipo + "</td>");
    out.println("<td>" + equipo.getEquipoID() + "</td>");
    out.println("<td>" + equipo.getPartidosJugados() + "</td>");
    out.println("<td>" + equipo.getPartidosGanados() + "</td>");
    out.println("<td>" + equipo.getPartidosEmpatados() + "</td>");
    out.println("<td>" + equipo.getPartidosPerdidos() + "</td>");
    out.println("<td>" + equipo.getGolesAFavor() + "</td>");
    out.println("<td>" + equipo.getGolesEnContra() + "</td>");
    out.println("<td>" + equipo.getDiferenciaGoles() + "</td>");
    out.println("<td>" + equipo.getPuntosGanados() + "</td>");
    out.println("</tr>");
    numeroEquipo++;
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
