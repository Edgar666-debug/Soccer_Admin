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
import modelo.*;
import ModeloDAO.*;
import java.util.List;

/**
 *
 * @author jaime
 */
@WebServlet(name = "Partidos_Servlet", urlPatterns = {"/Partidos_Servlet"})
public class Partidos_Servlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
         String torneoID = request.getParameter("torneoID");
         String equipoID = request.getParameter("equipoID");
         
         Partidos partido = new Partidos();
         List<PartidosDAO> lista = partido.Consulta_2(torneoID);
        
              out.println("<style>");
out.println("table { border-collapse: collapse; width: 100%; }");
out.println("th, td { border: 1px solid #dddddd; text-align: center; padding: 8px; font-size: 20px; }");
out.println("th { background-color: #1F0A87; color: white; border-radius: 5px; }");
out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
out.println("</style>");
out.println("<table>");
out.println("<tr style=\"background-color: #1F0A87; color: white;\"><th>No</th><th>Fecha</th><th>Categoria</th><th>Resultado</th></tr>");

int numeroEquipo = 1;
for (PartidosDAO pt : lista) {
    out.println("<tr style=\"background-color: white;\">");
    out.println("<td>" + numeroEquipo + "</td>");
    out.println("<td>" + pt.getFechaPartido() + "</td>");
    out.println("<td>" + pt.getCategoriaID() + "</td>");
    out.println("<td>" + pt.getEquipoLocalID() + " " + pt.getMarcadorLocal() + "-" + pt.getMarcadorVisitante() +
            " " + pt.getEquipoVisitanteID() + "</td>");
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
