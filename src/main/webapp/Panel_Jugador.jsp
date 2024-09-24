<%-- 
    Document   : Panel_Jugador
    Created on : 23 mar. 2024, 01:38:07
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
       <link href="css/css_Panel.css" rel="stylesheet" type="text/css"/>
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel_Jugador</title>
    </head>
    <body>

          <%String nombre = (String) session.getAttribute("nombre_usuario");%>
          <%String nombre_comleto = (String) session.getAttribute("nombre_completo");%>
         <div class="sidebar close">
      <div class="logo">
        <i class="fa-solid fa-circle-user"></i>
        <span style="font-size: 18px;" class="logo-name text-center"><%=nombre_comleto%></span>
      </div>

      <ul class="nav-list">
        <li>
          <a href="Perfil_Jugador.jsp">
            <i class="fa-solid fa-user"></i>
            <span class="link-name">Perfil</span>
          </a>
            <ul class="sub-menu blank">
            <li><a href="Perfil_Jugador.jsp" class="link-name">Perfil</a></li>
          </ul>
        </li>

        <!--li>
          <div class="icon-link">
            <a href="#">
              <i class="fab fa-codepen"></i>
              <span class="link-name">Courses</span>
            </a>
            <i class="fas fa-caret-down arrow"></i>
          </div>

          <ul class="sub-menu">
            <li><a href="#" class="link-name">Courses</a></li>
            <li><a href="#">Block Chain</a></li>
            <li><a href="#">Cryptography</a></li>
            <li><a href="#">Animation</a></li>
          </ul>
        </li>

        <li>
          <div class="icon-link">
            <a href="#">
              <i class="fab fa-blogger"></i>
              <span class="link-name">Blog</span>
            </a>
            <i class="fas fa-caret-down arrow"></i>
          </div>

          <ul class="sub-menu">
            <li><a href="#" class="link-name">Blog</a></li>
            <li><a href="#">Web Design</a></li>
            <li><a href="#">Card Design</a></li>
            <li><a href="#">Form Design</a></li>
          </ul>
        </li-->

        <li>
            <a href="Crear_Equipo.jsp">
            <i class="bi bi-shield"></i>
            <span class="link-name">Crear Equipo</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="Crear_Equipo.jsp" class="link-name">Crear Equipo</a></li>
          </ul>
        </li>
        
         <li>
             <a href="IntegrantesEquipo.jsp">
            <i class="fa-solid fa-users"></i>
            <!--i class="bi bi-person-fill-add"></i-->
            <span class="link-name">Agregar Jugadores</span>
          </a>

          <ul class="sub-menu blank">
              <li><a href="IntegrantesEquipo.jsp" class="link-name">Agregar Jugadores</a></li>
          </ul>
        </li>

        <li>
            <a href="Inscripciones.jsp">
            <i class="bi bi-trophy-fill"></i>
            <span class="link-name">Torneos Disponibles</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="Inscripciones.jsp" class="link-name">Torneos Disponibles</a></li>
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
            <li><a href="Posiciones.jsp">Tabla de Posiciones <i class="fa-solid fa-award"></i></a></li>
            <li><a href="Partidos_Jugados.jsp">Resultados_Jornada <i class="fa-solid fa-person-walking"></i></a></li>
            <li><a href="Goleo_Individual.jsp">Goleo <i class="fa-solid fa-futbol"></i></a></li>
          </ul>
        </li>

        <li>
            <a href="Plantilla.jsp">
            <i class="fa-solid fa-user-shield"></i>
            <span class="link-name">Plantilla</span>
          </a>

          <ul class="sub-menu blank">
              <li><a href="Compañeros_Equipo.jsp" class="link-name">Compañeros de Equipo</a></li>
              <li><a href="Plantilla.jsp" class="link-name">Gestionar Plantilla</a></li>
          </ul>
        </li>

        <li>
            <a href="Consultar_Roles.jsp">
            <i class="fa-regular fa-clock"></i>
            <span class="link-name">Consultar Roles</span>
          </a>

          <ul class="sub-menu blank">
              <li><a href="Consultar_Roles.jsp" class="link-name">Consultar Roles</a></li>
          </ul>
        </li>

        <li>
            <a href="Validar_Credenciales?accion=CerrarSesionJugador">
            <i class="fas fa-right-to-bracket"></i>
            <!--i class="fa-solid fa-power-off"></i-->
            <span class="link-name">Cerrar Sesión</span>
          </a>

          <ul class="sub-menu blank">
            <li><a href="Validar_Credenciales?accion=CerrarSesionJugador" class="link-name">Cerrar Sesión</a></li>
          </ul>
        </li>

        <li>
          <div class="profile-details">
            <div class="profile-content">
                <img src="Iconos/Jugador_2.jpg" alt="" />
            </div>

            <div class="name-job">
              <div class="name text-center"><%=nombre%></div>
            </div>
            <i class="fa-solid fa-leaf"></i>
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
       
    </body>
</html>
