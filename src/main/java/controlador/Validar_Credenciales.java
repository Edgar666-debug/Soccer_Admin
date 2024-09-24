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
import javax.servlet.http.HttpSession;
import modelo.*;

@WebServlet(name = "Validar_Credenciales", urlPatterns = {"/Validar_Credenciales"})
public class Validar_Credenciales extends HttpServlet {
    Usuario_Jugador jugador = new Usuario_Jugador();
    Administrador admin = new Administrador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if(accion != null && accion.equals("Validar")){
                String nombre = request.getParameter("txtNombre");
                String contra = request.getParameter("txtContrasena");
                admin.setNombre_completo(nombre);
                admin.setContrasena(contra);
                boolean credenciales = admin.validar(nombre, contra);
            if(credenciales){
                HttpSession session_admin = request.getSession();
                String nombre2 = admin.getNombre_completo();
                String fecha  = admin.getFecha_nacimiento();
                String sexo = admin.getSexo();
                String contraseña = admin.getContrasena();
                String telefono = admin.getNumero_telefono();
                String correo = admin.getCorreo();
                session_admin.setAttribute("correo", correo);
                session_admin.setAttribute("telefono", telefono);
                session_admin.setAttribute("contraseña", contraseña);
                session_admin.setAttribute("sexo", sexo);
                session_admin.setAttribute("fecha",fecha);
                session_admin.setAttribute("nombre2",nombre2);
                session_admin.setAttribute("mensajeBienvenida", "¡Bienvenido al sistema Soccer Admin!");
                request.getRequestDispatcher("Panel_Administrador.jsp").forward(request, response);   
            }else{
            request.setAttribute("errorMsg", "Contraseña incorrecta. Inténtelo de nuevo.");
            request.getRequestDispatcher("Login_Administrador.jsp").forward(request, response);
            }
            }else if("Ingresar".equalsIgnoreCase(accion)){
                String usuario = request.getParameter("txtnombre");
                String contrasena = request.getParameter("txtContrasena");
                jugador.setNombre_usuario(usuario);
                jugador.setContrasena(contrasena);
                boolean validacion = jugador.Validar(usuario, contrasena);
            if(validacion){
                String nombre_usuario = jugador.getNombre_usuario();
                String nombre_completo = jugador.getNombre_completo();
                String posicion = jugador.getPosicion();
                String fechaNacimientoJugador = jugador.getFecha_nacimiento();
                String sexoJugador = jugador.getSexo();
                String numeroTelefonoJugador = jugador.getNumero_telefono();
                String correoJugador = jugador.getCorreo();
                String contrasen = jugador.getContrasena();
                
                HttpSession session_jugador = request.getSession();
                session_jugador.setAttribute("contrasen", contrasen);
                session_jugador.setAttribute("nombre_usuario", nombre_usuario);
                session_jugador.setAttribute("nombre_completo", nombre_completo);
                session_jugador.setAttribute("posicion", posicion);
                session_jugador.setAttribute("fechaNacimientoJugador", fechaNacimientoJugador);
                session_jugador.setAttribute("sexoJugador", sexoJugador);
                session_jugador.setAttribute("numeroTelefonoJugador", numeroTelefonoJugador);
                session_jugador.setAttribute("correoJugador", correoJugador);
              //session_jugador.setAttribute("mensajeBienvenida", "¡Bienvenido al sistema Soccer Admin!");
                request.getRequestDispatcher("Panel_Jugador.jsp").forward(request, response);
            }else{
            request.setAttribute("errorMsg", "Contraseña incorrecta. Inténtelo de nuevo.");
            request.getRequestDispatcher("Login_Jugador.jsp").forward(request, response);
            }
            }else if ("CerrarSesion".equalsIgnoreCase(accion)) {
                // Invalidar la sesión actual y redirigir al usuario a la página de inicio de sesión
                HttpSession session = request.getSession(false); // Obtener la sesión actual sin crear una nueva si no existe
                if (session != null) {
                    session.invalidate(); // Invalidar la sesión
                }
                response.sendRedirect("Login_Administrador.jsp");
            }else if ("CerrarSesionJugador".equalsIgnoreCase(accion)) {
                // Invalidar la sesión actual y redirigir al usuario a la página de inicio de sesión
                HttpSession session2 = request.getSession(false); // Obtener la sesión actual sin crear una nueva si no existe
                if (session2 != null) {
                    session2.invalidate(); // Invalidar la sesión
                }
                response.sendRedirect("Login_Jugador.jsp");
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
