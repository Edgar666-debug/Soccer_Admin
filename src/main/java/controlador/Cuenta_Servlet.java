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
@WebServlet(name = "Cuenta_Servlet", urlPatterns = {"/Cuenta_Servlet"})
public class Cuenta_Servlet extends HttpServlet {
    
    Usuario_Jugador jugador; 
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("btnAgregar");
            
            if("agregar".equals(accion)){
                jugador = new Usuario_Jugador();
                jugador.setNombre_usuario(request.getParameter("txtNombre"));
                jugador.setNombre_completo(request.getParameter("txtNombre_Completo"));
                jugador.setPosicion(request.getParameter("txtPosicion"));
                jugador.setFecha_nacimiento(request.getParameter("txtFecha"));
                jugador.setSexo(request.getParameter("sexo"));
                jugador.setContrasena(request.getParameter("txtContra"));
                jugador.setNumero_telefono(request.getParameter("txtTelefono"));
                jugador.setCorreo(request.getParameter("txtCorreo"));
                try {
                jugador.Crear_Cuenta();
                request.setAttribute("mensaje", "¡Cuenta creada con éxito!");
                } catch (Exception ex) {
                  ex.printStackTrace();
                 request.setAttribute("error", "Hubo un error al crear la cuenta. Por favor, inténtalo de nuevo.");
                }
                request.getRequestDispatcher("Crear_Cuenta.jsp?success=true").forward(request, response);

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
