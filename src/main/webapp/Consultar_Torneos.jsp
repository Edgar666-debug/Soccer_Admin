<%-- 
    Document   : Consultar_Torneos
    Created on : 23 mar. 2024, 18:28:37
    Author     : jaime
--%>
<%@page import="java.util.Iterator"%>
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
        <title>Consulta Torneos</title>
    </head>
    <body>
       <header>
        <div class="nav-principal">
          <nav>
              <a href="Panel_Administrador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
       <section>
        <br>
        <div class="formulario col-lg-10">   
         <h1 class="h1">Torneos actuales</h1>
          <a class="btn btn-success btn-lg" style="font-size: 15px" href="Altas_Torneos.jsp">Nueva Torneo <i class="fa-solid fa-arrow-right"></i></a>
            <br>
            <br><!-- comment -->
            <div class="table-responsive">   
        <table class="table table-bordered">
            <thead>
            <tr>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Torneo</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Categoría</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Temporada</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Fecha de Inico</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Acciones</strong></th>            
                </tr>
            </thead>
              <%
                 Torneo car = new Torneo();
                 List<TorneoDAO> list = car.Listar();
                 Iterator<TorneoDAO> iter = list.iterator();
                 TorneoDAO ca = null;
                  while(iter.hasNext()) {
                 ca = iter.next(); %>
       <tbody>
        <tr>
        <td style="background-color: aliceblue; color: #000; font-size: 20px; font-style: italic; border: 3px solid #000;" 
            class="text-center"><%= ca.getNombreTorneo() %></td>
        <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;" 
            class="text-center"><%= ca.getCategoriaID()%></td>
        <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= ca.getTemporada() %></td>
        <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= ca.getFechaInicio()%></td>
        <td style="background-color: aliceblue; color: #000;font-size: 20px; font-style: italic; border: 3px solid #000;"
            class="text-center">
            <a style="font-size: 20px; font-style: italic;"
               class="btn btn-warning btn-sm" href="Finalizar_Torneo.jsp?torneo=<%= ca.getNombreTorneo() %>">Finalizar</a>
            <a style="font-size: 20px; font-style: italic;"
               class="btn btn-danger btn-sm" href="Torneo_Servlet?accion=eliminar&name=<%= ca.getNombreTorneo()%>"
             onclick="return confirm('¿Estás seguro de que quieres eliminar este <%= ca.getNombreTorneo()%>?')">Cancelar</a>
        </td>
          </tr> 
          <% } %>
          </tbody>
        </table>
        </div> 
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
                alert("¡Torneo finalizado con éxito!");
            <% } %>
        });
    </script>
    </body>
</html>
