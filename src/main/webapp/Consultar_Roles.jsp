<%-- 
    Document   : Consultar_Roles
    Created on : 25 mar. 2024, 13:45:07
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles de Juego</title>
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
        
       <section>
        <br>
        <div class="formulario col-lg-10">
             <h1 class="h1 mb-4">Partidos de la Semana</h1>
               <div class="table-responsive" style="margin: 0 auto; width: 80%;">  
                    <table class="table table-bordered" style="margin: 0 auto; margin-top: 20px; border: 3px solid #000;">
                        <thead>
                            <tr>
                                <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                                     border: 3px solid #000;"class="text-center"><strong>Fecha</strong></th>     
                                <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                                     border: 3px solid #000;"class="text-center"><strong>Hora</strong></th>     
                                <th style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                    border: 3px solid #000;" class="text-center" ><strong>Torneo</strong></th>
                                <th style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                    border: 3px solid #000;" class="text-center"><strong>Equipo Local</strong></th>
                                <th style="background-color: #000080; color: white; font-size: 20px; font-style: italic;
                                    border: 3px solid #000;" class="text-center"><strong>Equipo Visitante</strong></th>       
                                </tr>
                        </thead>
                         <tbody>
                        <% Rol_Juegos roll = new Rol_Juegos();
                        List<Rol_JuegosDAO> lista = roll.Listar();
                        Iterator<Rol_JuegosDAO> iter = lista.iterator();
                        while(iter.hasNext()) {
                            Rol_JuegosDAO rol = iter.next();%>
                            <tr>
                                 <td style="background-color: #ddd; color: #090909;font-size: 20px; font-style: italic; border: 3px solid #000;" class="text-center">
                                    <%= rol.getFechaEnfrentamiento() != null ? rol.getFechaEnfrentamiento() : "Pendiente"  %></td>
                                 <td style="background-color: #ddd; color: #090909;font-size: 20px; font-style: italic; border: 3px solid #000;" class="text-center">
                                    <%= rol.getHorario() != null ? rol.getHorario() : "Pendiente" %></td>
                                 <td style="background-color: #ddd; color: #090909;font-size: 20px; font-style: italic; border: 3px solid #000;" class="text-center">
                                    <%= rol.getTorneo() %></td>
                                <td style="background-color: #ddd; color: #090909;font-size: 20px; font-style: italic; border: 3px solid #000;" class="text-center">
                                    <%= rol.getEnfrentamientoLocal() %></td>
                                <td style="background-color: #ddd; color: #090909;font-size: 20px; font-style: italic; border: 3px solid #000;" class="text-center">
                                    <%= rol.getEnfrentamientoVisitante() %></td>
                                </tr>
                               <% } %>
                        </tbody>
                    </table>
                </div>
                        
         </div>
        </div>
        <br>
       </section>
     
    <div>     
    <footer>
        <p class="texto--blanco">Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
    </footer>
    </div>
        
    </body>
</html>
