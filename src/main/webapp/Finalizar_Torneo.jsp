<%-- 
    Document   : Finalizar_Torneo
    Created on : 23 mar. 2024, 20:21:07
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
        <title>Finalizar Torneo</title>
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
        <%String torneo = request.getParameter("torneo");%>
        
        <div class=" col-lg-4 formulario">
        <form action="Torneos_Servlet" method="post">
            <a class="btn btn-success" style="font-size: 15px;" href="Consultar_Torneos.jsp"><i class="fa-solid fa-arrow-left"></i> Regresar a Consultas</a>
        <div class="form-group text-center">
            <br>
            <h1 class="h1"><strong>Finalizar Torneo</strong></h1>
            <br>
            <div style="display: flex; justify-content: center;">
                <div style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden;">
            <img src="Iconos/Trofeo.png" class="img-circle"width="100" height="100"/> 
                </div>
            </div>
        </div>
            
      <div class ="form-group text-center">  
            <label class="form-label h"><i class="fas fa-trophy"></i> Seleccione un torneo:</label>
        <input style="font-size: 15px;" class="form-control text-center" type="text" name="txtTorneo" id="torneo" value="<%= torneo %>">
        </div>   
        
      <div class="form-group text-center">
        <label class="form-label h"><i class="fas fa-solid fa-calendar-days"></i> Fecha Final:</label>
        <input style="font-size: 15px;" class="form-control text-center"type="date" name="txtFecha_F" min="<%= LocalDate.now() %>">
      </div>
        
        <div class="form-group text-center">
        <label class="form-label h"><i class="fas fa-solid fa-crown"></i> Campeón:</label>
        <select id="slectEquipo" class="form-select text-center" name="txtCampeon">
            
        </select>
      </div>
            
            
         <br>
    <div class="form-group text-center"> 
        <button name="accion" style="font-size: 18px;" value="finalizar" class="btn btn-primary btn-lg ">Finalizar</button>     
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
