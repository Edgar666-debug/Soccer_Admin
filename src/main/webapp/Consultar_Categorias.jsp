<%-- 
    Document   : Consultar_Categorias
    Created on : 23 mar. 2024, 18:28:12
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
        <title>Consulta Categorias</title>
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
         <h1 class="text-center h1">LISTA DE CATEGORIAS</h1>
         <a class="btn btn-success btn-lg" style="font-size: 15px"
         href="Altas_Categoria.jsp">Nueva Categoría <i class="fa-solid fa-arrow-right"></i></a>
            <br>
            <br><!-- comment -->
            <div class="table-responsive">   
        <table class="table table-bordered">
            <thead>
            <tr>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Categoría</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Generación</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Edad Mínima</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Edad Máxima</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Rama</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Acciones</strong></th>            
                </tr>
            </thead>
              <%
      Categorias ca = new Categorias();
    List<CategoriaDAO> list = ca.Listar();
    Iterator<CategoriaDAO> iter = list.iterator();
    CategoriaDAO car = null;
    
    while(iter.hasNext()) {
        car = iter.next();   
        String claseEstilo = car.isActivo()?"table-success": "table-danger";
        %>
      <tbody>
          <tr class="<%=claseEstilo%>">
        <td style="font-size: 17px; font-style: italic; border: 3px solid #000;" class="text-center"><%= car.getNombreCategoria() %></td>
        <td style="font-size: 17px; font-style: italic; border: 3px solid #000;" class="text-center"><%= car.getGeneracion() %></td>
        <td style="font-size: 17px; font-style: italic; border: 3px solid #000;" class="text-center"><%= car.getEdadMinima() %></td>
        <td style="font-size: 17px; font-style: italic; border: 3px solid #000;" class="text-center"><%= car.getEdadMaxima() %></td>
        <td style="font-size: 17px; font-style: italic; border: 3px solid #000;" class="text-center"><%= car.getGenero() %></td>
        <td style="font-size: 17px; font-style: italic; border: 3px solid #000;" class="text-center">
            <!--a style="font-size: 14px; font-style: italic;" class="btn btn-warning btn-sm" href="ModificarCategoria.jsp">Actualizar</a-->
        <a style="font-size: 14px; font-style: italic;" class="btn btn-warning btn-sm"
           href="Actualizar_Categoria.jsp?categoria=<%= car.getNombreCategoria() %>&generacion=<%= car.getGeneracion() %>&minima=<%= car.getEdadMinima() %>&maxima=<%= car.getEdadMaxima() %>&sexo=<%= car.getGenero() %>">Actualizar</a>
            <a style="font-size: 14px; font-style: italic;" class="btn btn-secondary btn-sm" href="Categoria_Servlet?accion=desactivar&name=<%= car.getNombreCategoria() %>"
               onclick="return confirm('¿Estás seguro de que quieres desactivar a <%= car.getNombreCategoria() %>')">Baja Temporal</a>
            <a style="font-size: 14px; font-style: italic;" class="btn btn-success btn-sm" href="Categoria_Servlet?accion=activar&name=<%= car.getNombreCategoria() %>"
               onclick="return confirm('¿Estás seguro de que quieres activar a <%= car.getNombreCategoria() %> ?')">Alta</a>
            <a style="font-size: 14px; font-style: italic;" class="btn btn-danger btn-sm" href="Categoria_Servlet?accion=eliminar&name=<%= car.getNombreCategoria() %>"
               onclick="return confirm('¿Estás seguro de que quieres eliminar a <%= car.getNombreCategoria() %>?')">Eliminar</a>
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
                alert("¡Categoría actualizada con éxito!");
            <% } %>
        });
    </script>
         
    </body>
</html>
