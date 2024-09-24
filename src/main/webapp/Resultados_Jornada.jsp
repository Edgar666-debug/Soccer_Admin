<%-- 
    Document   : Resultados_Jornada
    Created on : 3 abr. 2024, 23:50:29
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
        <title>Historial de partidos</title>
                <style>.partido {
            border: 1px solid #000;
            padding: 10px;
            background-color: white;
            margin-bottom: 10px;
            font-style: oblique;
            text-align: center;
            margin-left: 30px;
            margin-right: 30px;
        }</style>
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
         
        <h1 class="h1 mb-4"><strong>Resultados de los Partidos</strong></h1>
              <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
        <% Partidos rol = new Partidos();
        List<PartidosDAO> lista = rol.Consulta();
        Iterator<PartidosDAO> iter = lista.iterator();
        int count = 0; // Contador para contar los enfrentamientos
        while(iter.hasNext()){
            if (count % 4 == 0) { %>
                </div> <!-- Cerrar la fila anterior si se inicia una nueva fila -->
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4"> <!-- Iniciar una nueva fila -->
            <% } %>
            <div class="col"> <!-- Utilizar columnas Bootstrap para cada enfrentamiento -->
                <% PartidosDAO partido = iter.next(); %>
                <div style="background-color: white" class="partido">
                    <h3 class="text-center" style="color: #003399">Fecha: <%= partido.getFechaPartido()%></h3>
                    <h3 class="text-center" style="color: #003399">Torneo: <%= partido.getTorneoID() %> </h3>
                    <h3 class="text-center" style="color: #003399">Cateogoría: <%= partido.getCategoriaID() %> <%= partido.getRama() %></h3>
                    <h3 class="text-center" style="color: #003399">Resultado</h3>
                    <p class="text-center" style="color: #003399"><%= partido.getEquipoLocalID() %> <%= partido.getMarcadorLocal() %> -
                        <%= partido.getMarcadorVisitante() %> <%= partido.getEquipoVisitanteID() %></p>
                </div>
            </div>
            <% count++; %>
        <% } %>
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
                alert("¡ Cedula guardada con éxito!");
            <% } %>
        });
    </script>
    </body>
</html>
