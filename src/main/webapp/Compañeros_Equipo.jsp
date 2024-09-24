<%-- 
    Document   : Compañeros_Equipo
    Created on : 5 abr. 2024, 14:04:59
    Author     : jaime
--%>
<%@page import="java.util.List"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plantila</title>
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
       <section>
       <%String nombreRepresentante = (String) session.getAttribute("nombre_completo");%>
             <br><!-- comment -->
         <div class="formulario col-lg-6">
             <form action="" id="formEquipo" method="post" class="form-group text-center">
                    <label for="selectEquipo" class="form-label h">Selecciona un equipo:</label>
                    <select id="selectEquipo" style=" font-size: 15px;" class="form-select text-center" name="txtequipo" required>
                    <option value="" style="display:none;">Seleccionar Equipo</option>
                    <% Jugadores_Equipos equipoModelo = new Jugadores_Equipos();
                            List<Jugadores_EquiposDAO> equipos = equipoModelo.Mis_Equipos(nombreRepresentante);
                            for (Jugadores_EquiposDAO equipo : equipos) { %>
                            <option value="<%= equipo.getEquipoID() %>"><%= equipo.getEquipoID() %></option>
                        <% } %>
                    </select>
                    <br>
                    <br>
                    <button type="submit" style="font-size: 18px;" class="btn btn-primary">Mostrar Jugadores</button>
             <br>
             <br>
        <div class="row">
            <div class="col">
                <div class="table-responsive">
                    <table id="tablaJugadores" class="table table-striped">
                        <!-- Aquí se mostrarán los datos de los jugadores -->
                        
                    </table>
                </div>
            </div>
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
        <script>
        document.getElementById('formEquipo').addEventListener('submit', function(event) {
            event.preventDefault();
            var equipoID = document.getElementById('selectEquipo').value;

            // Realizar la solicitud AJAX y actualizar la tabla de jugadores
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        document.getElementById('tablaJugadores').innerHTML = xhr.responseText;
                    } else {
                        console.error('Hubo un problema al obtener los jugadores');
                    }
                }
            };

            xhr.open('POST', 'Consultar_Estadisticas', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send('equipoID=' + encodeURIComponent(equipoID));
        });
    </script> 
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"><!-- comment -->

    </body>
</html>
