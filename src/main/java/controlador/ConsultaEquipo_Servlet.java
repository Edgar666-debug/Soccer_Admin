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
@WebServlet(name = "ConsultaEquipo_Servlet", urlPatterns = {"/ConsultaEquipo_Servlet"})
public class ConsultaEquipo_Servlet extends HttpServlet {
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                     
        String TorneoID = request.getParameter("TorneoID");

        // Lógica para obtener los jugadores del equipo
        Equipos eq = new Equipos();
        List<EquiposDAO> equipos = eq.Listar2(TorneoID);
        // Generar la tabla HTML con los datos de los equipos
           out.println("<style>");
           out.println("table { border-collapse: separate; border-spacing: 0 10px; border-radius: 10px;"
                    + " overflow: hidden; width: 100%; }");
           out.println("</style>");
            out.println("<table class=\"table\">");
            out.println("<thead>");
            out.println("<tr style=\"background-color: #1F0A87; color: white;\">");
            out.println("<th class=\"text-center\">Categoría</th>");
            out.println("<th class=\"text-center\">Equipos</th>");
            out.println("<th class=\"text-center\">Representante</th>");
            out.println("<th class=\"text-center\">Color de Playera</th>");
            out.println("<th class=\"text-center\">Número de Teléfono</th>");
            out.println("<th class=\"text-center\">Acciones</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (EquiposDAO equipo : equipos) {
                out.println("<tr class=\"text-center\" style=\"font-size: 18px;\">");
                out.println("<td>" + equipo.getCategoriaID() + "</td>");
                out.println("<td>" + equipo.getNombreEquipo() + "</td>");
                out.println("<td>" + equipo.getRepresentante() + "</td>");
                out.println("<td>" + equipo.getColor_Playera() + "</td>");
                out.println("<td>" + equipo.getNumeroRepresentante() + "</td>");
                out.println("<td>");
                out.println("<a class=\"btn btn-danger btn-sm\" href=\"Equipo_Servlet?accion=delete&name=" + equipo.getNombreEquipo() + "\" " +
                            "onclick=\"return confirm('¿Estás seguro de que quieres eliminar a " + equipo.getNombreEquipo() + "?')\">Eliminar</a>");
                out.println("<a class=\"btn btn-primary btn-sm\" href=\"Consultar_Plantilla.jsp?equipo="
                    + equipo.getNombreEquipo() + "\">Ver <i class=\"fa-solid fa-eye\"></i></a>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
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
