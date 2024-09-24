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

/**
 *
 * @author jaime
 */
@WebServlet(name = "Torneo_Servlet", urlPatterns = {"/Torneo_Servlet"})
public class Torneo_Servlet extends HttpServlet {
    Torneo t = new Torneo();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if("agregar".equals(request.getParameter("btnAgregar"))){
              Torneo TR = new Torneo();
              TR.setNombreTorneo(request.getParameter("txtTorneo"));
              TR.setCategoriaID(request.getParameter("txtcategoria"));
              TR.setTemporada(Integer.parseInt
                  (request.getParameter("Temporada")));
              TR.setFechaInicio(request.getParameter("txtFecha_I"));
              TR.agregar();
              response.sendRedirect("Altas_Torneos.jsp?success=true");
            }else if ("finalizar".equals(request.getParameter("accion"))) {
                // Obtener el nombre del torneo a finalizar
                String nombreTorneo = request.getParameter("txtTorneo");
                String fecha = request.getParameter("txtFecha_F");
                String camp = request.getParameter("txtCampeon");
                
            Torneo tor = new Torneo(nombreTorneo,fecha,camp);
            tor.finalizar();
                // Llamar al método finalizar
             response.sendRedirect("Consultar_Torneos.jsp?success=true");
            }else if ("eliminar".equals(request.getParameter("accion"))) {
                // Obtener el nombre del torneo a eliminar
                String nombreTorneo = request.getParameter("name");
                
                // Llamar al método eliminar
                t.eliminar(nombreTorneo);
                response.sendRedirect("Consultar_Torneos.jsp");
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
