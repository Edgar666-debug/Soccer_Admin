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
       <title>Inicio de sesión</title>
    </head>
    <body>
    
    <header>
        <div class="nav-principal">
          <nav>
              <a href="index.jsp" style="font-size: 18px;" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
    </header>
        
        <section>
            <br>
       <div class="formulario col-lg-3 centrar">
           <form action="Validar_Credenciales" method="post">
             
        <div class ="form-group text-center"> 
            <h1 class="h1"><strong>Bienvenido al inicio del sistema</strong></h1>
            <br>
            <div style="display: flex; justify-content: center;">
            <div style="width: 140px; height: 140px; border-radius: 50%; overflow: hidden;">
                <img src="Iconos/Admin_1.png" hight="130" width="130" /> 
            </div>
            </div>
        </div>
             
        <div class ="form-group"> 
             <label class="h">
            <i class="bi bi-person-circle"></i> Nombre: </label>
            <input class="form-control" style="font-size: 18px;" type="text" name="txtNombre" placeholder="Ingrese nombre" required> 
        </div>
            <br>    
        <div class ="form-group"> 
            <label class="h">
            <i class="fa-solid fa-lock"></i> Contraseña: </label>
            <input class ="form-control "  style="font-size: 18px;" type="password" name="txtContrasena" placeholder="hasgdsf" required>     
        </div>
            <br>
            <div class="text-center">
            <input class="btn btn-primary btn-lg" style="font-size: 18px" type="submit" name="accion" value="Validar">
            <!--a href="Panel_Administrador.jsp">Ingresar</a-->
            </div>
            <br><!-- comment -->
            <div style="background-color: blue; border-radius: 10px;" class="text-center">
                <a href="" style="color: #ffffff; font-size: 16px;">Recuperar Contraseña</a>
            </div>
            <br><!-- comment -->
              <div class="text-center">
        <% String error = (String) request.getAttribute("errorMsg");
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
        
    </body>
</html>