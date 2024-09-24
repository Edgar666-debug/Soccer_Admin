/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModeloDAO.*;
import modelo.*;

/**
 *
 * @author jaime
 */
@WebServlet(name = "RolJuegos_Servlet", urlPatterns = {"/RolJuegos_Servlet"})
public class RolJuegos_Servlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
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
            //processRequest(request, response);
        
        String action = request.getParameter("action");
        if ("generar".equals(action)) {
            generarRoles(request, response);
        }else if ("actualizar".equalsIgnoreCase(action)) {
            actualizarPartido(request, response);
        }
    }
    
    private void generarRoles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String seleccionadotorneo = request.getParameter("txtTorneo");
        if (seleccionadotorneo != null) {
            List<Rol_Juegos> roles = generarRolesAleatorios(seleccionadotorneo);
            request.setAttribute("roles", roles);
            request.getRequestDispatcher("Generar_Roles.jsp?success=true").forward(request, response);  
        }
    }
    
    private List<Rol_Juegos> generarRolesAleatorios(String torneo) {
        Equipos equipo = new Equipos();
        List<String> nombresEquipos = equipo.obtenerNombresEquiposPorTorneo(torneo);
         System.out.println("Equipos para el torneo " + torneo + ": " + nombresEquipos);
        List<String> copiaNombresEquipos = new ArrayList<>(nombresEquipos);
        Random rand = new Random();
        List<Rol_Juegos> roles = new ArrayList<>();

        while (!copiaNombresEquipos.isEmpty()) {
            int indiceLocal = rand.nextInt(copiaNombresEquipos.size());
            String equipoLocal = copiaNombresEquipos.get(indiceLocal);
            copiaNombresEquipos.remove(indiceLocal);

            if (!copiaNombresEquipos.isEmpty()) {
                int indiceVisitante = rand.nextInt(copiaNombresEquipos.size());
                String equipoVisitante = copiaNombresEquipos.get(indiceVisitante);
                copiaNombresEquipos.remove(indiceVisitante);

                Rol_Juegos rol = new Rol_Juegos();
                rol.setTorneo(torneo);
                rol.setEnfrentamientoLocal(equipoLocal);
                rol.setEnfrentamientoVisitante(equipoVisitante);
                roles.add(rol);
                rol.insertar();
                System.out.println("Nuevo rol generado: " + rol);
                // Aquí podrías guardar el rol en la base de datos si es necesario
            } else {
                break;
            }
        }
        return roles;
    }
    
   private void actualizarPartido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Lógica para actualizar un partido
    String torneo = request.getParameter("txtTorneo");
    String enfrentamientoLocal = request.getParameter("equipoLocal");
    String enfrentamientoVisitante = request.getParameter("equipoVisitante");
    String fecha = request.getParameter("txtFecha");
    String horarioStr = request.getParameter("txtHorario");
    Time horario = null;
    System.out.println("Guardado con éxito" + horarioStr);
    try {
        if (horarioStr != null && horarioStr.matches("^\\d{2}:\\d{2}$")) {
            horario = Time.valueOf(horarioStr + ":00"); // Agrega los segundos al final
        } else {
            System.out.println("El formato de la hora no es válido.");
        }
    } catch (IllegalArgumentException e) {
        System.out.println("Error al convertir la hora en un objeto Time: " + e.getMessage());
    }

    Rol_Juegos partido = new Rol_Juegos();
    partido.setFechaEnfrentamiento(fecha);
    partido.setHorario(horario);
    partido.setEnfrentamientoLocal(enfrentamientoLocal);
    partido.setEnfrentamientoVisitante(enfrentamientoVisitante);
    partido.setTorneo(torneo);
    partido.asignar_horario();
    
    request.getRequestDispatcher("Consultar_Enfrentamientos.jsp?success=true").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
