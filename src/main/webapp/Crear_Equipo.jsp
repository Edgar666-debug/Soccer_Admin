<%-- 
    Document   : Crear_Equipo
    Created on : 23 mar. 2024, 21:10:52
    Author     : jaime
--%>
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
        <title>Crear Equipo</title>
          <style>.form-group { margin-bottom: 15px;}</style>
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
          <%String nombreRepresentante = (String) session.getAttribute("nombre_completo");
           String telefonoUsuario = (String) session.getAttribute("numeroTelefonoJugador");%>
       <section>
          <br>
            <div class="formulario col-lg-4">
         <form action="Equipo_Servlet" method="post" class="form-group">
          <!--a href="Mis_Equipos.jsp" style="font-size: 16px;" class="btn btn-success">Mis Equipos <i class="fa-solid fa-arrow-right"></i></a-->
          
         <div class="form-group text-center">
        <h1 class="h1"><strong>Datos de tu Equipo</strong></h1>
           <br>
            <div style="display: flex; justify-content: center;">
                <div style="width: 140px; height: 140px; border-radius: 50%; overflow: hidden;">
                    <img src="Iconos/Escudo.jpg" class="img-circle"width="130" height="130"/>
                </div>
            </div>
          </div>         
          <br>  
          
    <div class ="form-group text-center">    
        <label class="form-label h" >
            <i class="fas fa-solid fa-shield-halved fa-flip"></i> Nombre del Equipo:</label> 
        <input style="font-size: 15px;" class="form-control" type="text" name="txtEquipo" placeholder="Digite el nombre del equipo">
    </div> 
                
    <div class ="form-group text-center">    
        <label class="form-label h"><i class="fa-solid fa-person"></i>
            Nombre del Representante:</label> 
        <input class="form-control" type="text" name="txtRepresentante" style="font-size: 15px;" value="<%=nombreRepresentante%>" placeholder="Nombre del capitan del equipo">
    </div>
                
    <div class ="form-group text-center">
        <label class="form-label h"><i class="fas fa-regular fa-phone fa-shake"></i>
            Número de Telefono:</label> 
        <input class="form-control" type="tel" name="txtTelefono" style="font-size: 15px;" pattern="[0-9]{10}" value="<%=telefonoUsuario%>" placeholder="Ejemplo: 7752349078" required>
    </div> 
    
    <div class ="form-group text-center">    
        <label class="form-label h"><i class="fa-solid fa-shirt"></i>
            Color de Uniforme:</label> 
        <input class="form-control" type="text" name="txtPlayera" style="font-size: 15px;" placeholder="Color rojo">
    </div>
    
        <div class="form-group text-center">    
              <button name="btnAgregar" style="font-size: 18px;" value="agregar" class="btn btn-primary btn-lg ">Registrar</button>   
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
                alert("¡Equipo creado con éxito!");
            <% } %>
        });
    </script>
    
    </body>
</html>
