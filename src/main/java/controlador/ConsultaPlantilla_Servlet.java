/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import ModeloDAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 *
 * @author jaime
 */
@WebServlet(name = "ConsultaPlantilla_Servlet", urlPatterns = {"/ConsultaPlantilla_Servlet"})
public class ConsultaPlantilla_Servlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                       // Obtener el equipoID del formulario
        String equipoID = request.getParameter("equipoID");

        // Lógica para obtener los jugadores del equipo
        Jugadores_Equipos jugadoresServicio = new Jugadores_Equipos();
        List<Jugadores_EquiposDAO> jugadores = jugadoresServicio.Consultar_Plantilla(equipoID);
              // Generar la tabla HTML con los datos de los jugadores
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Plantilla de Jugadores</title>");
            out.println("<style>");
            out.println("table { border-collapse: separate; border-spacing: 0 10px; border-radius: 10px;"
                    + " overflow: hidden; width: 100%; }");
            out.println("td, th { color: black; border: 1px solid #dddddd; padding: 8px; font-size: 17px}");
            out.println("th {color: white; font-size: 17px}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<table>");
            out.println("<tr style=\"background-color: #1A0485;\">");
            out.println("<th>Nombre</th>");
            out.println("<th>Equipo</th>");
            out.println("<th>Dorsal</th>");
            out.println("<th>Torneo</th>"); 
            out.println("<th>Acciones</th>");
            out.println("</tr>");
            
            for (Jugadores_EquiposDAO jugador : jugadores) {
                out.println("<tr style=\"background-color: #F6F5FB;\">");
                out.println("<td class=\"text-center\">" + jugador.getNombreJugador() + "</td>");
                out.println("<td class=\"text-center\">" + jugador.getEquipoID() + "</td>");
                out.println("<td class=\"text-center\">" + jugador.getDorsal() + "</td>");
                out.println("<td class=\"text-center\">" + jugador.getTorneoID() + "</td>");
               out.println("<td class=\"text-center\"><a style=\"font-size: 13px;\" class=\"btn btn-danger btn-sm\""
            + " href=\"JugadoresEquipos_Servlet?accion=eliminar&name=" + jugador.getNombreJugador() + 
            "\" onclick=\"return confirm('¿Estás seguro de que quieres eliminar a " + jugador.getNombreJugador() + "?')\">Eliminar</a></td>");
 
                out.println("</tr>");
            }
           
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
