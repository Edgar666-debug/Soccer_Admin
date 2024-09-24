<%-- 
    Document   : Partidos
    Created on : 25 mar. 2024, 01:05:20
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
        <title>Consultar Partidos</title>
            <style>
        .partido {
            border: 1px solid #000;
            padding: 10px;
            margin-bottom: 10px;
            text-align: center;
            margin-left: 30px;
            margin-right: 30px;
        }
    </style>
    </head>
    <body>
       <header>
        <div class="nav-principal">
          <nav>
              <a href="Panel_Administrador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
              <a href="Consultar_Enfrentamientos.jsp" style="font-size: 18px;" class="btn btn-success btn-lg float-end">
                <i class="fa-solid fa-arrow-right"></i> Asignar Horario</a>
              <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
        
       <section>
        <br>
        <!--div class="formulario col-lg-10"-->
            <h1 class="h1 mb-4"><strong>Jornada Semanal</strong></h1>  
              <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
        <% Rol_Juegos rol = new Rol_Juegos();
        List<Rol_JuegosDAO> lista = rol.Consultar_Partidos2();
        Iterator<Rol_JuegosDAO> iter = lista.iterator();
        int count = 0; // Contador para contar los enfrentamientos
        while(iter.hasNext()){
            if (count % 4 == 0) { %>
                </div> <!-- Cerrar la fila anterior si se inicia una nueva fila -->
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4"> <!-- Iniciar una nueva fila -->
            <% } %>
            <div class="col"> <!-- Utilizar columnas Bootstrap para cada enfrentamiento -->
                <% Rol_JuegosDAO partido = iter.next(); %>
                <div style="background-color: white" class="partido">
                    <h3 class="text-center" style="color: #003399">Torneo: <%= partido.getTorneo() %></h3>
                    <p class="text-center" style="color: #003399">Fecha: <%= partido.getFechaEnfrentamiento() != null ? partido.getFechaEnfrentamiento() : "Pendiente" %></p>
                    <p class="text-center" style="color: #003399"><%= partido.getEnfrentamientoLocal() %> vs
                        <%= partido.getEnfrentamientoVisitante() %></p>
                    <a href="Cedula_Partido.jsp?torneo=<%=partido.getTorneo()%>&fecha=<%=partido.getFechaEnfrentamiento()%>&local=<%= partido.getEnfrentamientoLocal() %>&visitante=<%= partido.getEnfrentamientoVisitante() %>"
                       class="btn btn-primary btn-lg">Jugar</a>
                </div>
            </div>
            <% count++; %>
        <% } %>
    </div> <!-- Cerrar la última fila -->    
         <!--/div-->
        <br>
       </section>
     <div>     
    <footer>
        <p class="texto--blanco">Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
    </footer>
    </div>
    </body>
</html>
