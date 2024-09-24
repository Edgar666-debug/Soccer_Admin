<%-- 
    Document   : Crear_Cuenta
    Created on : 18 mar. 2024, 12:51:37
    Author     : jaime
--%>
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
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cuenta</title>
        <style>
        /* Estilos personalizados */
        .form-group {
            margin-bottom: 10px; /* Espacio entre cada grupo de etiqueta y campo */
        }
    </style>
    </head>
    <body>
        <header>
        <div class="nav-principal">
          <nav>
              <a href="index.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
        <!--br><!-- comment -->
    <section>
        <br>
        <div class="formulario col-lg-4">
        <form action="Cuenta_Servlet" method="post" class="form-group"> 
            <a href="Login_Jugador.jsp" style="font-size: 18px;" class="btn btn-success btn-lg">Inicio de Sesión</a>
         <br> 
         <div class="form-group"> 
             <h1 class="text-bold h1"><i class="fa-solid fa-registered"></i> <strong>Registrate</strong></h1>
             <br>
        </div>
        <!--i class="fas fa-solid fa-user"></i--> 
        <div class ="form-group text-center">    
          <label class="h">
            <i class="fas fa-solid fa-user"></i> Nombre de usuario:</label>  
          <input style="font-size: 15px;" class="form-control text-center"type="text" name="txtNombre" placeholder="Ingrese nombre de usuario" required> 
        </div>
         
        <div class="form-group text-center">
                <label class="h">
                <i class="bi bi-person-circle"></i> Nombre completo:</label>   
             <input style="font-size: 15px;" class="form-control text-center" type="text" name="txtNombre_Completo" placeholder="Ingrese nombre completo" required>
        </div>
        
        <div class="form-group text-center">
            <label class="h">
              <i class="fa-solid fa-person-running fa-shake"></i> Posición de Juego</label> 
              <select name="txtPosicion" style="font-size: 15px;" class="form-control text-center" required>
                  <option style="font-size: 15px;"> Seleccione una opción</option>
                  <option style="font-size: 15px">Portero</option>
                  <option style="font-size: 15px">Defensa</option>
                  <option style="font-size: 15px">Centrocampista</option>
                  <option style="font-size: 15px">Delantero</option>
              </select>
        </div>
         
        <div class="form-group text-center">      
          <label class="h">
          <i class="fas fa-solid fa-cake-candles"></i> Fecha de Nacimiento:</label>   
          <%-- Calcula la fecha actual y resta 9 años para obtener la fecha máxima --%>
          <% LocalDate fechaActual = LocalDate.now(); %>
          <% LocalDate fechaMaxima = fechaActual.minusYears(10); %>
          <%-- Convierte la fecha máxima en un formato adecuado para el campo de fecha --%>
          <% String fechaMaximaString = fechaMaxima.toString(); %>
          <%-- Establece la fecha máxima permitida en el campo de fecha de nacimiento --%>
          <input style="font-size: 15px;" class="form-control text-center" type="date" name="txtFecha" required max="<%= fechaMaximaString %>">
        </div>
         
        <div class="form-group text-center">
            <label class="h">
                <i class="fas fa-solid fa-neuter"></i> Genero:</label>   
            <select name="sexo" style="font-size: 15px;" class="form-control text-center" required>
            <option style="font-size: 16px;"> Seleccione una opción</option>
                <option style="font-size: 15px; ">Hombre</option>
                <option style="font-size: 15px; ">Mujer</option>
            </select>
        </div>
         
        <div class="form-group text-center">
            <label class="h" for="lbl_P">
            <i class="fa-solid fa-lock"></i> Contraseña:</label>   
            <input style="font-size: 15px;" class="form-control text-center" type="password" name="txtContra" placeholder="Ingrese contraseña" required>
        </div>  
         
        <div class="form-group text-center">
            <label class="h">
            <i class="fa-solid fa-mobile-screen"></i> Numero de Telefono:</label>   
            <input style="font-size: 15px;" class="form-control text-center" type="tel" name="txtTelefono" pattern="[0-9]{10}" placeholder="Ejemplo: 7752349078" required>
        </div>  
            
        <div class="form-group text-center">
            <label class="h">
            <i class="fas fa-solid fa-envelope"></i> Correo Electronico:</label>   
            <input style="font-size: 15px;" class="form-control text-center" type="email" name="txtCorreo" placeholder="Ejempl@gmail.com" required>
            </div>    
          <br><!-- comment -->
          
       <div class="text-center">
           <button name="btnAgregar" style="font-size: 18px" id="btnAgregar" value="agregar" class="btn btn-primary btn-lg">Registrarse</button>  
       </div>
          <br><!-- comment -->
          
          <!-- Verifica si hay un mensaje de éxito y muestra el mensaje si está presente -->
          <!--div class="text-center">
                    <% String mensaje = (String) request.getAttribute("mensaje");
                    if (mensaje != null && !mensaje.isEmpty()) { %>
                        <div class="alert alert-success" role="alert">
                            <%= mensaje %>
                        </div>
                    <% } %>
                </div-->
        <!-- Verifica si hay un mensaje de error y muestra el mensaje si está presente -->
        <div class="text-center">
        <% String error = (String) request.getAttribute("error");
        if (error != null && !error.isEmpty()) { %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
        <% } %>
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
                alert("¡Cuenta creado con éxito!");
            <% } %>
        });
    </script>
    
    </body>
</html> 
