<%-- 
    Document   : Altas_Torneos
    Created on : 23 mar. 2024, 13:04:34
    Author     : jaime
--%>
<%@page import="java.util.List"%>
<%@page import="modelo.*"%>
<%@page import="ModeloDAO.*"%>
<%@page import="java.time.LocalDate"%>
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
        <title>Alta Torneos</title>
        <style>
        /* Estilos personalizados */
        .form-group {
            margin-bottom: 15px; /* Espacio entre cada grupo de etiqueta y campo */
        }
    </style>
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
        <%
       Categorias categorias = new Categorias();
       List<CategoriaDAO> listaCategorias = categorias.Listar2();
       %>
       <section>
             <br><!-- comment -->
         <div class="formulario col-lg-4">
             <form action="Torneo_Servlet" method="post" class="form-group">
                 <a href="Consultar_Torneos.jsp" style="font-size: 16px;" class="btn btn-success">Ver Torneos <i class="fa-solid fa-arrow-right"></i></a>
        <div class="form-group text-center">
            <h1 class="h1"><strong>Nuevo Torneo</strong></h1>
            <br>
            <div style="display: flex; justify-content: center;">
                <div style="width: 140px; height: 140px; border-radius: 50%; overflow: hidden;">
            <img src="Iconos/Trofeo.png" class="img-circle"width="130" height="130"/>
                </div>
            </div>
        </div>
            
    <div class ="form-group text-center">  
        <label class="form-label h"><i class="fas fa-regular fa-futbol"></i> Categoria</label>
        <select style="font-size: 16px;" class="form-control" name="txtcategoria" id="categoria">
            <option style="font-size: 15px;" required>Seleccionar Categoría</option>
            <% for (CategoriaDAO categoria : listaCategorias) { %>
            <option style="font-size: 15px;" value="<%= categoria.getNombreCategoria() %>"><%= categoria.getNombreCategoria() %></option>
             <% } %>
        </select>
    </div>
      
    <div class="form-group text-center"> 
            <label class="form-label h"><i class="fas fa-solid fa-trophy"></i> Nombre del Torneo:</label>
            <input style="font-size: 15px;" class="form-control"type="text" name="txtTorneo" required>
    </div>  
    
    <div class="form-group text-center">
        <label class="form-label h"><i class="fas fa-regular fa-calendar-check"></i> Temporada:</label>
        <input style="font-size: 15px;" class="form-control"type="number" value="<%= LocalDate.now().getYear() %>"  name="Temporada" placeholder="Año" required>
      </div>
        
    <div class="form-group text-center">
        <label class="form-label h"><i class="fa-solid fa-calendar-days"></i> Fecha de Inicio:</label>
        <input style="font-size: 15px;" class="form-control"type="date" min="<%=LocalDate.now()%>" name="txtFecha_I" required>
      </div>
        
        <br>
    <div class="form-group text-center"> 
        <button style="font-size: 18px;" name="btnAgregar" value="agregar" class="btn btn-primary btn-lg ">Registrar</button>     
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
             <%-- Importa la librería jQuery para utilizarla --%>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <%-- Script de JavaScript para mostrar el mensaje de alerta --%>
    <script>
        $(document).ready(function() {
            <%-- Este código se ejecutará cuando la página se haya cargado completamente --%>

            <%-- Verifica si hay un parámetro de solicitud llamado "success" --%>
            <% if (request.getParameter("success") != null && request.getParameter("success").equals("true")) { %>
                <%-- Si el parámetro "success" es true, muestra un mensaje de alerta --%>
                alert("¡Torneo creada con éxito!");
            <% } %>
        });
    </script>
        
    </body>
</html>
