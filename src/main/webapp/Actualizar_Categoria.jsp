<%-- 
    Document   : Actualizar_Categoria
    Created on : 23 mar. 2024, 19:33:15
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
        <title>Actualizar Categoría</title>
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
   <%String categoria = request.getParameter("categoria");
    String generacion = request.getParameter("generacion");
    String minima = request.getParameter("minima");
    String maxima = request.getParameter("maxima");
    String sexo = request.getParameter("sexo");%>
    <section>
        <br><!-- comment -->
          <div class="formulario col-lg-4">
    <form action="Categoria_Servlet" method="post" class="form-group">
        <a class="btn btn-success" style="font-size: 15px" href="Consultar_Categorias.jsp"><i class="fa-solid fa-arrow-left"></i> Regresar a Consultas</a>
        <br>
        <br>
        <div class="form-group text-center">
            <h1 class="h1"><strong>Actualizar Categoría</strong></h1>
        </div>
       
        <div class="form-group text-center">
            <label class="form-label h">Categoría</label>
            <input class="form-control" style="font-size: 15px" type="text" name="txtcategoria" id="categoria" value="<%= categoria %>">
        </div>
        
        <div class="form-group text-center">
            <label class="form-label h">Generación</label>
            <input class="form-control" style="font-size: 15px" type="text" name="txtgeneracion" id="generacion" value="<%= generacion %>">
        </div>
        
        <div class="form-group text-center">
            <label class="form-label h">Edad Mínima</label>
            <input class="form-control" style="font-size: 15px" type="number" name="minima" id="minima" min="1" value="<%= minima %>" placeholder="Escriba la edad mínima">
        </div>
        
        <div class="form-group text-center">
            <label class="form-label h">Edad Máxima</label>
            <input class="form-control" style="font-size: 15px" type="number" name="maxima" id="maxima" min="1" value="<%= maxima %>" placeholder="Escriba la edad máxima">
        </div>
        
        <div class="form-group text-center">
            <label class="h">Rama de la Categoría</label>
            <input class="form-control" style="font-size: 15px" type="text" name="sexo" value="<%= sexo %>" disabled>  
        </div>
       
        <div class="form-group centrar">
            <button name="Accion" style="font-size: 18px" value="Actualizar" class="btn btn-primary btn-lg">Actualizar</button>
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
