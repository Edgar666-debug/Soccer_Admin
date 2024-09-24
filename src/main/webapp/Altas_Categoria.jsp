<%-- 
    Document   : Altas_Categoría
    Created on : 23 mar. 2024, 13:04:10
    Author     : jaime
--%>

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
        <title>Alta Categoría</title>
        <style>
        /* Estilos personalizados */
        .form-group {
            margin-bottom: 15px; }
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
             <br><!-- comment -->
         <div class="formulario col-lg-4">
            <form action="Categoria_Servlet" method="post" class="form-group">
                <a href="Consultar_Categorias.jsp" style="font-size: 16px;" class="btn btn-success">Ver Categorías <i class="fa-solid fa-arrow-right"></i></a>
        <div class ="form-group text-center"> 
            <h1 class="h1"><strong>Nueva Categoría</strong></h1> 
        </div>
            
      <div class ="form-group text-center">    
         <label class="form-label h" for="categoria">Nombre de Categoría</label> 
         <input class="form-control" type="text" style="font-size: 15px;" name="txtcategoria" placeholder="Escribe el nombre de la categoria" required>
      </div>
            
      <div class ="form-group text-center">    
          <label class="form-label h" for="generacion">Generación</label> 
          <input style="font-size: 15px;" class="form-control" type="text" name="txtgeneracion" placeholder="Digite la generacion" required>
      </div>
        
      <div class ="form-group text-center">    
           <label class="form-label h" for="minima">Edad Mínima</label> 
           <input style="font-size: 15px;" class="form-control" min="10" type="number" name="minima" placeholder="Escriba la edad minima" required>
      </div>
        
      <div class ="form-group text-center">
           <label class="form-label h" for="maxima">Edad Máxima</label> 
           <input style="font-size: 15px;" class="form-control" min="10"type="number" name="maxima" placeholder="Escriba la edad maxima" required>
        </div>
      
      <div class ="form-group text-center">
          <label class="h" style="font-size: 15px;">Rama de la Categoría</label><select style="font-size: 15px;" name="sexo" class="form-control" required>
            <option style="font-size: 16px;"> Seleccione una opción</option>
            <option style="font-size: 15px;">Masculino</option>
            <option style="font-size: 15px;">Femenino</option>
            <option style="font-size: 15px;">Mixto</option>
        </select>
      </div>
            
        <br>
    <div class="form-group centrar">
        <button style="font-size: 18px;" name="accion" value="agregar" class="btn btn-primary btn-lg">Registrar</button>     
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
                alert("¡Categoría creada con éxito!");
            <% } %>
        });
    </script>
        
    </body>
</html>
