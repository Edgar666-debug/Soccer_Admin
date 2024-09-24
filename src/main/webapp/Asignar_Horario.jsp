<%-- 
    Document   : Asignar_Horario
    Created on : 25 mar. 2024, 00:40:20
    Author     : jaime
--%>
<%@page import="java.time.LocalDate"%>
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
        <title>Asignar Horario</title>
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
              <a href="Panel_Administrador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
        <% String torneo = request.getParameter("torneo");
           String local = request.getParameter("local");
           String visitante = request.getParameter("visitante");
        %>
       <section>
        <br>
        <div class="formulario col-lg-4">
             <h1 class="h1 mb-4">Asignar Horario</h1>
             <form action="RolJuegos_Servlet" method="post" class="form-group">
                  <div class="form-group text-center" >
                <label class="form-group h"> <i class="fas fa-trophy"></i> Torneo</label>
                <input class="form-control text-center" style="font-size: 15px;" value="<%= torneo %>" name="txtTorneo">
            </div>
                
                <!-- Campo de equipo local -->
            <div class="form-group text-center" >
                <label class="form-group h"> <i class="fas fa-solid fa-shield-halved fa-flip"></i> Equipo Local:</label>
                <input class="form-control text-center" style="font-size: 15px;" value="<%=local%>" name="equipoLocal">
            </div>

            <!-- Campo de equipo visitante -->
            <div class="form-group text-center" >
                <label class="form-group h"> <i class="fas fa-solid fa-shield-halved fa-flip"></i> Equipo Visitante:</label>
                <input class="form-control text-center" style="font-size: 15px;" value="<%=visitante%>" name="equipoVisitante">
            </div>
            
            <div class ="form-group text-center">    
                  <label class="form-group h"><i class="fa-solid fa-calendar-check"></i> Fecha de Enfrentamiento</label>         
                  <input class="form-control text-center" type="date" style="font-size: 15px;" min="<%= LocalDate.now() %>" name="txtFecha">
           </div>
                 
            <div class ="form-group text-center">    
                <label class="form-group h"><i class="fa-solid fa-clock"></i> Horario</label> 
                <input class="form-control text-center" style="font-size: 15px;" type="time" min="15:00" max="21:00" name="txtHorario">
            </div> 
                 
                <div class="form-group centrar">
               <button name="action" style="font-size: 18px;" value="actualizar" class="btn btn-primary btn-lg">Registrar</button>     
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
       
    </body>
</html>
