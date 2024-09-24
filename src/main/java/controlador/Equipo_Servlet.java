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
@WebServlet(name = "Equipo_Servlet", urlPatterns = {"/Equipo_Servlet"})
public class Equipo_Servlet extends HttpServlet {
    String agregar = "Crear_Equipo.jsp?success=true"; 
    String mensaje = "Inscripciones.jsp?success=true";
     String equipos = "Consultar_Equipos.jsp?success=true";
     Equipos eq = new Equipos();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
               
        if ("agregar".equals(request.getParameter("btnAgregar"))) {
           Equipos equipo = new Equipos(
                request.getParameter("txtEquipo"),
                request.getParameter("txtPlayera"),
                request.getParameter("txtRepresentante"),
                request.getParameter("txtTelefono")
            );
            equipo.agregar();
            response.sendRedirect(agregar);
            
        }else if("Inscribir".equals(request.getParameter("Accion"))){
            String nombreEquipo = request.getParameter("equipo");
            String nombreCategoria = request.getParameter("categoria");
            String nombreTorneo = request.getParameter("torneo");
            Equipos eq = new Equipos();
            Posiciones p = new Posiciones(nombreEquipo, nombreCategoria, nombreTorneo);
            eq.inscribir(nombreEquipo, nombreCategoria, nombreTorneo);
            p.agregar_equipo();           
            response.sendRedirect(mensaje);
            
        }else if("delete".equals(request.getParameter("accion"))){
            String equip = request.getParameter("name"); 
            eq.eliminar(equip);
            response.sendRedirect(equipos);
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
