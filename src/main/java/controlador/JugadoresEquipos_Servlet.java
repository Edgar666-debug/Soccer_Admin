package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

@WebServlet(name = "JugadoresEquipos_Servlet", urlPatterns = {"/JugadoresEquipos_Servlet"})
public class JugadoresEquipos_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Jugadores_Equipos j= new Jugadores_Equipos();
        String acceso = "Plantilla.jsp";
        String action = request.getParameter("accion");
        if(action.equals("eliminar")){
            String jugador = request.getParameter("name"); 
            j.eliminar(jugador);
            response.sendRedirect(acceso);
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
       // processRequest(request, response);
         try {
            // Crear una lista para almacenar los jugadores a insertar
            List<Jugadores_Equipos> jugadores = new ArrayList<>();
            // Obtener datos comunes a todos los jugadores
            
            String nombreEquipo = request.getParameter("txtequipo");
            String torneo = request.getParameter("torneoID");
            int cantidadJugadores = Integer.parseInt(request.getParameter("cantidadJugadores"));
            Torneo torneoModelo = new Torneo();
            //Torneo torneoSelecionado = torneoModelo.
            

            // Recorrer cada jugador enviado desde el formulario y crear instancias de Jugadores_Equipos
            for (int i = 1; i <= cantidadJugadores; i++) {
                String nombreJugador = request.getParameter("txtnombre_" + i);
                String dorsalJugador = request.getParameter("dorsal_" + i);
            
                   
                // Validar y procesar cada jugador antes de guardar en la lista
                if (nombreJugador != null && !nombreJugador.isEmpty() &&
                        dorsalJugador != null && !dorsalJugador.isEmpty()) {

                    // Crear el objeto Jugadores_Equipos y agregarlo a la lista
                    Jugadores_Equipos jugador = new Jugadores_Equipos(nombreJugador, nombreEquipo, Integer.parseInt(dorsalJugador),torneo);
                    jugadores.add(jugador);

                    // Insertar el jugador en la base de datos
                    jugador.Agregar();
                } else {
                    // Manejar algún error si faltan datos importantes para un jugador
                    // Aquí podrías redirigir a una página de error o realizar alguna acción apropiada
                    response.sendRedirect("error.jsp");
                    return; // Salir del método doPost para evitar procesamiento adicional
                }
            }

            // Puedes agregar la lista de jugadores al objeto request para que esté disponible en la página JSP
            request.setAttribute("jugadores", jugadores);

            // Redirigir a la página de listado de jugadores después de procesar todos los jugadores
            request.getRequestDispatcher("IntegrantesEquipo.jsp?success=true").forward(request, response);
        } catch (NumberFormatException | NullPointerException ex) {
            // Manejar errores específicos, como problemas al convertir datos a números o valores nulos
            ex.printStackTrace(); // Imprimir el error en la consola para ver qué está pasando
            // Redirigir a una página de error si algo salió mal
            response.sendRedirect("error.jsp");
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

