<%-- 
    Document   : Generar_Roles
    Created on : 24 mar. 2024, 23:37:50
    Author     : jaime
--%>
<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
<%@page import="ModeloDAO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
       integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
       <script src="https://kit.fontawesome.com/7e1c11bff0.js" crossorigin="anonymous"></script>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
       <link href="css/style.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles de Juego</title>
    </head>
    <body>
        <header>
        <div class="nav-principal">
          <nav>
              <a href="Panel_Administrador.jsp" style="font-size: 18px;" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
    <% Torneo torneo = new Torneo();
    List<TorneoDAO> listaTorneos = torneo.Listar(); %>
        
        <section>
        <br><!-- comment -->
         <div class="formulario col-lg-5">
             <h1 class="h1 mb-4">Emparejamientos</h1>
             <form action="RolJuegos_Servlet" method="post" class="form-group">
            <div class="form-group text-center">  
                <label style="color: white; font-size: 18px;" class="form-check-label text-center"><i class="fas fa-trophy"></i> Seleccione un torneo:</label>
                <select style="font-size: 18px;" class="form-control text-center" id="torneo" name="txtTorneo">
                    <option class="text-center" style="display:none; font-size: 20px;">Seleccionar Torneo</option>
                    <% for (TorneoDAO torne : listaTorneos) { %>
                    <option class="text-center" style="font-size: 18px;" value="<%= torne.getNombreTorneo() %>"><%= torne.getNombreTorneo() %></option>
                    <% } %>
                </select>
                <br>
            </div> 
            
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead class="thead-light text-center">
                        <tr>
                            <th style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                    border: 3px solid #000;" class="text-center" ><strong>Torneo</strong></th>
                            <th style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                border: 3px solid #000;">Equipo Local</th>
                            <th style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                border: 3px solid #000;">Equipo Visitante</th>
              </tr>
              </thead>
                       <tbody>                               
                        <!-- ... (código para mostrar roles, ajusta según la estructura de tus datos) ... -->
                        <% if (request.getAttribute("roles") != null) { %>
                            <% List<Rol_Juegos> roles = (List<Rol_Juegos>) request.getAttribute("roles"); %>
                            <% for (Rol_Juegos rol : roles) { %>
                                <tr>
                                    <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;" 
                                        class="text-center"><%= rol.getTorneo() %></td>
                                    <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;" 
                                        class="text-center"><%= rol.getEnfrentamientoLocal() %></td>
                                    <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;"
                                        class="text-center"><%= rol.getEnfrentamientoVisitante() %></td>
                                </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>
                <br>
                <div class="form-group text-center">
                    <button type="submit" name="action" style="font-size: 18px;" value="generar" class="btn btn-primary btn-lg">Generar Enfrentamientos</button>
                    <!--a class="btn btn-success btn-lg" href="Consultar_Enfrentamientos.jsp">Asignar Horarios</a-->
                </div>
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
                alert("¡Emparejamientos creados con éxito!");
            <% } %>
        });
    </script>
    </body>
</html>
