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
        <title>Alta_Administrador</title>
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
        <section>
            <br>
        <div class="formulario col-lg-4">
        <form action="Admin_Servlet" method="post" class="form-group"> 
            <a href="Consultar_Administrador.jsp" style="font-size: 16px;" class="btn btn-success">Ver Admin <i class="fa-solid fa-arrow-right"></i></a>
            <div class ="form-group text-center" > 
             <h1 class="text-bold h1"><strong>Nuevo Administrador</strong></h1>
        </div>
        <!--i class="fas fa-solid fa-user"></i--> 
         <div class="form-group text-center">
             <label class="h"><i class="bi bi-person-circle"></i> Nombre completo:</label>   
             <input style="font-size: 15px;" class="form-control text-center" type="text" name="txtNombre" placeholder="Ingrese nombre completo" required>
         </div>
             
        <div class="form-group text-center">
            <label class="h"><i class="fas fa-solid fa-lock"></i> Contraseña:</label>   
            <input style="font-size: 15px;" class="form-control text-center" type="password" name="txtContra" placeholder="sdbhfvbf">
        </div>
                     
        <div class="form-group text-center">
            <label class="h"><i class="fa-solid fa-mobile-screen"></i> Numero de Telefono:</label>   
                <input style="font-size: 15px;" class="form-control text-center" type="tel" name="txtTelefono" pattern="[0-9]{10}" placeholder="Ejemplo: 7752349078" required>
            </div>
             
         <div class="form-group text-center">
             <label class="h"><i class="fas fa-solid fa-envelope"></i> Correo Electronico:</label>   
                <input style="font-size: 15px;" class="form-control text-center" type="email" name="txtCorreo" placeholder="Ejempl@gmail.com">
            </div> 
         
        <div class="form-group text-center">      
            <label class="h">
                 <i class="fa-regular fa-calendar-days"></i> Fecha de Nacimiento:</label>   
                <%-- Calcula la fecha actual y resta 18 años para obtener la fecha máxima --%>
        <% LocalDate fechaActual = LocalDate.now(); %>
        <% LocalDate fechaMaxima = fechaActual.minusYears(18); %>
        <%-- Convierte la fecha máxima en un formato adecuado para el campo de fecha --%>
        <% String fechaMaximaString = fechaMaxima.toString(); %>
        <%-- Establece la fecha máxima permitida en el campo de fecha de nacimiento --%>
        <input style="font-size: 15px;" class="form-control text-center" type="date" name="txtFecha" required max="<%= fechaMaximaString %>">
        </div>
         
        <div class="form-group text-center">
            <label class="h"><i class="fas fa-solid fa-neuter"></i> Genero:</label>   
            <select name="sexo" class="form-control text-center" required>
                <option style="font-size: 15px;"> Seleccione una opción</option>
                <option style="font-size: 15px;">Hombre</option>
                <option style="font-size: 15px;">Mujer</option></select>
            </div>  
              
          <br><!-- comment -->
          <div class="text-center">
       <button name="accion" style="font-size: 18px;" value="agregar" class="btn btn-primary btn-lg">Registrar</button>  
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
                alert("¡Administrador dado de alta con éxito!");
            <% } %>
        });
    </script>
       
    </body>
</html>
