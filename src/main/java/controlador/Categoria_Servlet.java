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
@WebServlet(name = "Categoria_Servlet", urlPatterns = {"/Categoria_Servlet"})
public class Categoria_Servlet extends HttpServlet {
    Categorias categoria = new Categorias();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        if("agregar".equals(request.getParameter("accion"))){
           String categori = request.getParameter("txtcategoria");
           String generacion = request.getParameter("txtgeneracion");
           int edadMin = Integer.parseInt(request.getParameter("minima")); 
           int edadMax = Integer.parseInt(request.getParameter("maxima"));
           String sex = request.getParameter("sexo");
                        Categorias nueva = new Categorias();
        nueva.setNombreCategoria(categori);
        nueva.setGeneracion(generacion);
        nueva.setEdadMinima(edadMin);
        nueva.setEdadMaxima(edadMax);
        nueva.setGenero(sex);
        nueva.agregar();
        response.sendRedirect("Altas_Categoria.jsp?success=true");
           }else if("Actualizar".equals(request.getParameter("Accion"))){
                        // Obtener los parámetros del formulario
                String nombreCategoria = request.getParameter("txtcategoria");
                String generacion = request.getParameter("txtgeneracion");
                int edadMinima = Integer.parseInt(request.getParameter("minima"));
                int edadMaxima = Integer.parseInt(request.getParameter("maxima"));

               Categorias categorias = new Categorias();
               categorias.setNombreCategoria(nombreCategoria);
               categorias.setGeneracion(generacion);
               categorias.setEdadMinima(edadMinima);
               categorias.setEdadMaxima(edadMaxima);
               // Llamar al método modificar para actualizar la categoría
            categorias.modificar();
            response.sendRedirect("Consultar_Categorias.jsp?success=true");
        }
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String action = request.getParameter("accion");
    String listar = "Consultar_Categorias.jsp";
    Categorias ca = new Categorias();
    if (action != null) {
        if (action.equalsIgnoreCase("desactivar")) {
            // Obtener el nombre de la categoría a desactivar
            String nombreCategoria = request.getParameter("name");
            // Desactivar la categoría
            ca.desactivar(nombreCategoria);
        } else if (action.equalsIgnoreCase("activar")) {
            // Obtener el nombre de la categoría a activar
            String nombreCategoria = request.getParameter("name");
            // Activar la categoría
            ca.activar(nombreCategoria);
        } else if (action.equalsIgnoreCase("eliminar")) {
            // Obtener el nombre de la categoría a eliminar
            String nombreCategoria = request.getParameter("name");
            // Eliminar la categoría
            ca.eliminar(nombreCategoria);
        }
        // Redirigir a la página de listado de categorías
        response.sendRedirect(listar);
    }
    // Llamar a processRequest después de la redirección
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
