<%-- 
    Document   : Panel_Administrador
    Created on : 23 mar. 2024, 01:38:26
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
       <!--link href="css/style.css" rel="stylesheet" type="text/css"/-->
       <link href="css/css_Panel.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel_Administrador</title>
    </head>
    <body>
        <%String nombre = (String) session.getAttribute("nombre2");%>
         <div class="sidebar close">
      <div class="logo">
        <i class="fa-solid fa-circle-user"></i>
        <span style="font-size: 18px;" class="logo-name text-center"><%=nombre%></span>
      </div>

      <ul class="nav-list">
        <li>
          <a href="Perfil_Administrador.jsp">
            <i class="fa-solid fa-user"></i>
            <span class="link-name">Perfil</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="Perfil_Administrador.jsp" class="link-name">Perfil</a></li>
          </ul>
        </li>

        <li>
          <div class="icon-link">
            <a href="#">
              <i class="fa-solid fa-circle-up"></i>
              <span class="link-name">Altas</span>
            </a>
            <i class="fas fa-caret-down arrow"></i>
          </div>

          <ul class="sub-menu">
            <li><a href="#" class="link-name">Altas</a></li>
            <li><a href="Altas_Categoria.jsp">Categorías <i class="fa-regular fa-futbol"></i></a></li>
            <li><a href="Altas_Torneos.jsp">Torneos <i class="fas fa-solid fa-trophy"></i></a></li>
            <li><a href="Alta_Administrador.jsp">Administrador <i class="fa-solid fa-user-plus"></i></a></li>
          </ul>
        </li>

        <li>
          <div class="icon-link">
            <a href="#">
              <i class="bi bi-clipboard-check-fill"></i>
              <span class="link-name">Consultas</span>
            </a>
            <i class="fas fa-caret-down arrow"></i>
          </div>

          <ul class="sub-menu">
            <li><a href="#" class="link-name">Consultas</a></li>
            <li><a href="Consultar_Categorias.jsp">Categorías <i class="fa-regular fa-futbol"></i></a></li>
            <li><a href="Consultar_Torneos.jsp">Torneos <i class="fas fa-solid fa-trophy"></i></a></li>
            <li><a href="Consultar_Equipos.jsp">Equipos Inscritos <i class="fa-solid fa-shield-halved"></i></a></li>
            <li><a href="Consultar_Enfrentamientos.jsp">Enfrentamientos <i class="fa-regular fa-clock"></i></a></li>
          </ul>
        </li>

        <li>
            <a href="Generar_Roles.jsp">
            <i class="fa-solid fa-circle-half-stroke"></i>
            <span class="link-name">Rol de Juegos</span>
          </a>

          <ul class="sub-menu blank">
              <li><a href="Generar_Roles.jsp" class="link-name">Rol de Juegos</a></li>
          </ul>
        </li>

        <li>
            <a href="Partidos.jsp">
            <i class="bi bi-caret-right-square-fill"></i>
            <span class="link-name">Jornada Semanal</span>
          </a>

          <ul class="sub-menu blank">
              <li><a href="Partidos.jsp" class="link-name">Jornada Semanal</a></li>
          </ul>
        </li>

        <li>
          <div class="icon-link">
            <a href="#">
              <i class="bi bi-bar-chart"></i>
              <span class="link-name">Estadisticas</span>
            </a>
            <i class="fas fa-caret-down arrow"></i>
          </div>

          <ul class="sub-menu">
            <li><a href="#" class="link-name">Estadisticas</a></li>
            <li><a href="Resultados_Jornada.jsp">Partidos Jugados</a></li>
            <li><a href="Tabla_Posiciones.jsp">Tabla de Posiciones</a></li>
            <li><a href="Goleadores.jsp">Goleadores</a></li>
            <li><a href="Consultar_Defensivas.jsp">Mejor Defensiva</a></li>
          </ul>
        </li>

        <!--li>
          <a href="#">
            <i class="fas fa-bookmark"></i>
            <span class="link-name">Saved</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="#" class="link-name">Saved</a></li>
          </ul>
        </li>

        <li>
          <a href="#">
            <i class="fas fa-cart-shopping"></i>
            <span class="link-name">Cart</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="#" class="link-name">Cart</a></li>
          </ul>
        </li-->

        <li>
            <a href="Validar_Credenciales?accion=CerrarSesion">
            <i class="fas fa-right-to-bracket"></i>
            <span class="link-name">Cerrar Sesión</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="Validar_Credenciales?accion=CerrarSesion" class="link-name">Cerrar Sesión</a></li>
          </ul>
        </li>

        <li>
          <div class="profile-details">
            <div class="profile-content">
                <img src="Iconos/Jugador_2.jpg" alt="" />
            </div>

            <div class="name-job">
                <div style="font-size: 16px;"class="name"><%=nombre%></div>
            </div>
          </div>
        </li>
      </ul>
    </div>

    <div class="home-section">
      <div class="home-content">
        <i class="fas fa-bars"></i>
        <span class="text">Soccer Admin</span>
      </div>
    </div>
 
        <script src="JavaScript/app.js"></script>      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </body>      
</html>
