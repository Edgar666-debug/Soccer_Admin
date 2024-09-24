<%-- 
    Document   : Consultar_Plantilla
    Created on : 5 abr. 2024, 00:44:47
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
        <title>Plantilla</title>
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
         <h1 class="text-center h1">Plantilla de Jugadores</h1> 
        <div class="table-responsive">   
        <table class="table table-bordered">
            <thead>
            <tr>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>No</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Nombre</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Posicion</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Dorsal</strong></th>
            <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>PJ</strong></th>
             <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>Goles</strong></th>
              <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>TA</strong></th>
              <th style="background-color: #000080;font-size: 17px; font-style: italic; color: white;
                border: 3px solid #000;"class="text-center"><strong>TR</strong></th>
                <%String equipo = request.getParameter("equipo");
                 Jugadores_Equipos ca = new Jugadores_Equipos();
                 List<Jugadores_EquiposDAO> list = ca.Consultar_Estadistica(equipo);
                 Iterator<Jugadores_EquiposDAO> iter = list.iterator();
                 int numeroJugador = 1; // Inicializamos el contador de jugador
                 while(iter.hasNext()) {
                 Jugadores_EquiposDAO rol = iter.next(); %>
         <tbody>
        <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= numeroJugador%></td>
        <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getNombreJugador() %></td>
        <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getPosicion() %></td>
        <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getDorsal() %></td>   
        <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getPartidosJugados() %></td> 
            <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getGolID() %></td> 
                <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getTarjetaA() %></td> 
                    <td style="background-color: #ffffff;font-size: 17px; font-style: italic; border: 3px solid #000;"
            class="text-center"><%= rol.getTarjetaR() %></td> 
                </tr> 
          </tbody>
          <% numeroJugador++;  } %>
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
    </body>
</html>
