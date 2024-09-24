    <%-- 
        Document   : Inscripciones
        Created on : 23 mar. 2024, 21:11:18
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
            <title>Inscribirse</title>
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
                  <a href="Panel_Jugador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
                <p class="p">Soccer Admin</p>         
              </nav>
            </div>  
           </header>
            <%String nombre_comleto = (String) session.getAttribute("nombre_completo");%>
            <section>
                 <br><!-- comment -->
             <!--div class="formulario col-lg-8"-->
                 <!--form action="Equipo_Servlet" method="post"-->
                 <div style="margin-right: 150px; margin-left: 150px;">
                 <label class="form-label h1" style="font-size: 20px;">Selecciona un equipo:</label>
                 <select style="font-size: 15px; color: #090909;" class="form-select mb-3" name="equipoID" required>
                    <% Equipos Modelo = new Equipos();
                        List<EquiposDAO> equipos = Modelo.Listar(nombre_comleto);
                        for (EquiposDAO equipo : equipos) { %>
                        <option class="text-center" style="font-size: 15px; color: #090909;" 
                                value="<%=equipo.getNombreEquipo()%>"><%= equipo.getNombreEquipo() %></option>  
                 </select>
                </div>


                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3">
                 <% Torneo torneo = new Torneo();
                 List<TorneoDAO> convocatoria = torneo.Convocatoria();
                 Iterator<TorneoDAO> iter = convocatoria.iterator();
                  int count = 0; 
                 while(iter.hasNext()){
                 if (count % 3 == 0) { %>
                 </div> <!-- Cerrar la fila anterior si se inicia una nueva fila -->
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3"> 
                              <% }%>
                <div class="col"> <!-- Utilizar columnas Bootstrap para cada enfrentamiento -->
                    <% TorneoDAO partido = iter.next(); %>
                    <div class="partido">
                    <p style="color: #090909; font-size: 20px;"><strong>Categoría</strong></p>
                    <p style="color: #090909; font-size: 18px;"><%=partido.getNombreCategoria()%> (Nacidos en <%= partido.getGeneracion()%>)</p>
                    <p style="color: #090909; font-size: 20px;"><strong>Torneo:</strong> <%= partido.getNombreTorneo() %></p>
                    <p style="color: #090909; font-size: 18px;">Fecha de Inicio: <%= partido.getFechaInicio() %></p>
                    <p style="color: #090909; font-size: 20px;"><strong>Requisitos</strong></p>
                    <p style="color: #090909; font-size: 18px;">Contar con al menos 6 integrantes y máximo 14 integrantes</p>
                    <p style="color: #090909; font-size: 18px;">Rango de edad <%= partido.getEdadMinima()%> a <%= partido.getEdadMaxima()%> años</p> 
                    <a class="btn btn-primary" style="font-size: 15px;" 
           href="Equipo_Servlet?Accion=Inscribir&equipo=<%=equipo.getNombreEquipo()%>&categoria=<%=partido.getNombreCategoria()%>&torneo=<%=partido.getNombreTorneo()%>">Inscribirse</a>
                    </div>
                </div>
                <% count++; %>  
                <% } %>
                   <% } %>
                <!--% } %-->
                  </div>
                <!--/form-->
             <!--/div-->
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
                <%-- Verifica si hay un parámetro de solicitud llamado "success" --%>
                <% if (request.getParameter("success") != null && request.getParameter("success").equals("true")) { %>
                    <%-- Si el parámetro "success" es true, muestra un mensaje de alerta --%>
                    alert("¡Equipo inscrito con éxito!");
                <% } %>
            });
        </script>

        </body>
    </html>
