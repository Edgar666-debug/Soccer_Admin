<%-- 
    Document   : Goleadores
    Created on : 31 mar. 2024, 21:09:36
    Author     : jaime
--%>
<%@page import="java.util.Iterator"%>
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
        <title>Goleo Individual</title>
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
            <br><!-- comment -->
            <div class="formulario col-lg-8">
                <h1 class="h1"><strong>GOLEADORES</strong></h1>
                <br>
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
                      <table id="tablaGoleadores" style="background-color: #ffffff" class="table table-striped">
                        <!-- Aquí se mostrarán los datos de los jugadores -->
                    </table>
                  </div>
                </div>
              </div>
                
         </div>
            <!-- comment --><br>
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
                        document.getElementById('tablaGoleadores').innerHTML = xhr.responseText;
                    } else {
                        console.error('Hubo un problema al obtener los equipos');
                    }
                }
            };

            xhr.open('POST', 'Goleadores_Servlet', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send('TorneoID=' + encodeURIComponent(TorneoID));
        });
    </script>                   
                
    <footer>
        <p class="texto--blanco">Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
    </footer>
    </body>
</html>
