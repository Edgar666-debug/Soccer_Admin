<%-- 
    Document   : Consultar_Equipos
    Created on : 24 mar. 2024, 23:00:55
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
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Equipos</title>
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
    <% Torneo torneo = new Torneo();
    List<TorneoDAO> listaTorneos = torneo.Listar(); %>
       <section>
        <br>
         <div class="formulario col-lg-8">
             <h1 class="h1 mb-4">Equipos Inscritos</h1>
             
        <form id="formTorneo" method="post" class="form-group">
            <div class="form-group text-center">  
                <label id="torneo"  style="color: white; font-size: 18px;"  class="form-check-label text-center"><i class="fas fa-trophy"></i> Seleccione un torneo:</label>
                <select style="font-size: 18px;" class="form-control text-center" id="selectTorneo" name="txtTorneo">
                    <option class="text-center" style="display:none; font-size: 20px;">Seleccionar Torneo</option>
                    <% for (TorneoDAO torne : listaTorneos) { %>
                    <option class="text-center" style="font-size: 18px;" value="<%= torne.getNombreTorneo() %>"><%= torne.getNombreTorneo() %></option>
                    <% } %>
                </select>
                <br>
                 <button type="submit" style="font-size: 18px;" class="btn btn-primary ">Mostrar Equipos</button>
            </div>   
       </form>
                <br>
           <div class="row">
                <div class="col">
                  <div class="table-responsive">
                      <table id="tablaEquipos" style="background-color: #ffffff" class="table table-striped">
                        <!-- Aquí se mostrarán los datos de los jugadores -->
                    </table>
                  </div>
                </div>
              </div>
                
         </div>
        <br>
       </section>
                
       <script>
        document.getElementById('formTorneo').addEventListener('submit', function(event) {
            event.preventDefault();
            var TorneoID = document.getElementById('selectTorneo').value;

            // Realizar la solicitud AJAX y actualizar la tabla de jugadores
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        document.getElementById('tablaEquipos').innerHTML = xhr.responseText;
                    } else {
                        console.error('Hubo un problema al obtener los equipos');
                    }
                }
            };

            xhr.open('POST', 'ConsultaEquipo_Servlet', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send('TorneoID=' + encodeURIComponent(TorneoID));
        });
    </script>           
                
     <div>     
    <footer>
        <p class="texto--blanco">Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
    </footer>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <%-- Script de JavaScript para mostrar el mensaje de alerta --%>
    <script>
        $(document).ready(function() {
            <%-- Este código se ejecutará cuando la página se haya cargado completamente --%>

            <%-- Verifica si hay un parámetro de solicitud llamado "success" --%>
            <% if (request.getParameter("success") != null && request.getParameter("success").equals("true")) { %>
                <%-- Si el parámetro "success" es true, muestra un mensaje de alerta --%>
                alert("¡ Equipo eliminado con éxito!");
            <% } %>
        });
    </script>
    
    </body>
</html>
