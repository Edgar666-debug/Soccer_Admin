/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;
import ModeloDAO.*;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Consultar_Defensa", urlPatterns = {"/Consultar_Defensa"})
public class Consultar_Defensa extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
 
            String torneoID = request.getParameter("TorneoID");
            
            Posiciones p = new Posiciones();
            List<PosicionesDAO> lista = p.Mejor_Defensa(torneoID);
            
        out.println("<table class=\"text-center\" style=\"background-color: white;\" border='1'>");
        out.println("<tr style=\"background-color: white;\" ><th class=\"text-center\">Posicion</th><th class=\"text-center\">Categoria</th>"
                + "<th class=\"text-center\">Equipo</th><th class=\"text-center\">GE</th><th class=\"text-center\">Plantilla</th></tr>");
        int numeroEquipo = 1;
        for(PosicionesDAO pt : lista){
            out.println("<tr class=\"text-center\" style=\"font-size: 18px;\">");
            out.print("<td>"+ numeroEquipo + "</td>");
            out.print("<td>"+ pt.getCategoriaID() +"</td>");
            out.print("<td>"+ pt.getEquipoID() +"</td>");
            out.print("<td>"+ pt.getGolesEnContra() +"</td>");
            out.println("<td><a class=\"btn btn-primary btn-sm\" href=\"Consultar_Plantilla.jsp?equipo="
                    + pt.getEquipoID() + "\">Ver <i class=\"fa-solid fa-eye\"></i></a></td>");

            out.println("</tr>");
            numeroEquipo++;
        }
        
        out.println("</table>");
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
