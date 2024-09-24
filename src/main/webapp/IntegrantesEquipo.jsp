<%-- 
    Document   : IntegrantesEquipo
    Created on : 25 mar. 2024, 17:41:00
    Author     : jaime
--%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="ModeloDAO.*"%>
<%@page import="modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
       integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
       <script src="https://kit.fontawesome.com/7e1c11bff0.js" crossorigin="anonymous"></script>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
       <link href="css/style.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>.form-group { margin-bottom: 15px;}</style>
    </head>
    
         <header>
       <div class="nav-principal">
          <nav>
              <a href="Panel_Jugador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
    
          <%String nombreRepresentante = (String) session.getAttribute("nombre_completo");%>
           
       <section>
           
         
          <br>
            <div class="formulario col-lg-5">
      <br>
        <h2 class="h1">Agregar Jugadores</h2>
        
        <br>
        <form action="JugadoresEquipos_Servlet" method="post">
                         
            <label for="selectEquipo" class="form-label h">Selecciona un equipo:</label>
            <select id="selectEquipo" style=" font-size: 15px;" class="form-select text-center" name="txtequipo" required>
                    <option value="" style="display:none;">Seleccionar Equipo</option>
                        <% Equipos equipoModelo = new Equipos();
                            List<EquiposDAO> equipos = equipoModelo.Listar(nombreRepresentante);
                            for (EquiposDAO equipo : equipos) { %>
                            <option value="<%= equipo.getNombreEquipo() %>"><%= equipo.getNombreEquipo() %></option>
                        <% } %>
                    </select>
                    
             <label for="selectTorneo" class="form-label h">Selecciona un torneo:</label>
             <select id="selectTorneo" style=" font-size: 15px;" class="form-select text-center" name="torneoID" required>
                    <option value="" style="display:none; font-size: 15px;">Seleccionar Torneo</option>
                     <%Torneo torneo = new Torneo();
                         List<TorneoDAO> listaTorneos = torneo.Listar();
                           for (TorneoDAO torne : listaTorneos) { %>
                           <option style="font-size: 18px;" value="<%= torne.getNombreTorneo() %>"><%= torne.getNombreTorneo() %></option>
                       <% } %>
                    </select>

           <div class="mb-4">
               <label for="cantidadJugadores"  class="form-label h">Cantidad de Jugadores:</label>
                <input type="number" min="1" max="14" style=" font-size: 15px;" class="form-control text-center" id="cantidadJugadores" name="cantidadJugadores" required>
           </div>
            
         <hr>
         <h3 class="text-center form-label h"> Datos de Jugadores</h3>
         <div class="table-responsive">
             <table class="table table-bordered">
            <thead class="thead-light text-center">
                <tr>
                    <td style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                    border: 3px solid #000;" class="text-center" ><strong>Nombre</strong></td>
                    <td style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                    border: 3px solid #000;" class="text-center" ><strong>Dorsal</strong></td>
                </tr>
            </thead>
            <tbody class="text-center" id="jugadores">
            <!-- Aquí se añadirán dinámicamente las filas de la tabla -->
            </tbody>
        </table>
        </div>
         <br>
         
         <div class="text-center">
         <button type="button" onclick="agregarCampos()" class="btn btn-primary btn-lg" style="font-size: 17px;">Agregar
             <i class="bi bi-person-add" style="font-size: 17px;"></i>
             <i class="fa-solid fa-plus" style="font-size: 17px;"></i>
         </button>
         <button type="submit" class="btn btn-primary btn-lg" style="font-size: 17px;">Registrar Jugadores</button>
        </div>
        </form>
        </div>        
          <br>
       </section>
    
    <div>
       
    <footer>
        <p class="texto--blanco">Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
    </footer>
    </div>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <%-- Script de JavaScript para mostrar el mensaje de alerta --%>
    <script>
        $(document).ready(function() {
            <%-- Este código se ejecutará cuando la página se haya cargado completamente --%>

            <%-- Verifica si hay un parámetro de solicitud llamado "success" --%>
            <% if (request.getParameter("success") != null && request.getParameter("success").equals("true")) { %>
                <%-- Si el parámetro "success" es true, muestra un mensaje de alerta --%>
                alert("¡Jugadores agregados con éxito!");
            <% } %>
        });

   function agregarCampos() {
    var cantidad = document.getElementById("cantidadJugadores").value;
    var contenedor = document.getElementById("jugadores");
    var filas = "";
    for (var i = 1; i <= cantidad; i++) {
        filas += "<tr>";
        filas += "<td><select class='form-select text-center' style='font-size: 15px;' name='txtnombre_" + i + "' required>";
        filas += "<option value='' style='display:none;'>Seleccionar nombre</option>";
        <% Usuario_Jugador UsuarioModelo = new Usuario_Jugador();
           List<Usuarios_JugadoresDAO> usuarios= UsuarioModelo.Consultar2();
           for (Usuarios_JugadoresDAO usuario : usuarios) { %>
               filas += "<option value='<%= usuario.getNombre_completo() %>'><%= usuario.getNombre_completo() %></option>";
        <% } %>

       
        filas += "</select></td>";
        filas += "<td><input type='number' min='1' style='font-size: 15px;' placeholder='No.Jugador' class='form-control text-center'\n\
                  name='dorsal_" + i + "' required></td>";
        // Resto del código para la fila de la tabla
        filas += "</tr>";
    }


    contenedor.innerHTML = filas;
}

</script> 
    
</html>
