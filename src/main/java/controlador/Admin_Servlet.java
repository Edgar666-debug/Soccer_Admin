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
@WebServlet(name = "Admin_Servlet", urlPatterns = {"/Admin_Servlet"})
public class Admin_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if ("agregar".equals(request.getParameter("accion"))){
            String nombre = request.getParameter("txtNombre");
            String contr = request.getParameter("txtContra");
            String telefono = request.getParameter("txtTelefono");
            String correo = request.getParameter("txtCorreo");
            String fecha = request.getParameter("txtFecha");
            String sexo = request.getParameter("sexo");

            // Crear una nueva instancia de Admin dentro del método
            Administrador ad = new Administrador(nombre, contr, telefono,
             correo, fecha, sexo);
            ad.agregar();
            response.sendRedirect("Alta_Administrador.jsp?success=true");
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
