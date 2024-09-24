<%-- 
    Document   : Cedula_Partido
    Created on : 25 mar. 2024, 03:18:25
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
       <link href="css/Form.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cedula del partido</title>
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
    <%String torneo = request.getParameter("torneo");
    String fecha = request.getParameter("fecha");
    String local = request.getParameter("local");
    String visitante = request.getParameter("visitante");%>
    <%Administrador admin = new Administrador();
    List<AdministradorDAO> listaArbitros = admin.consultar();%>
       <section>
        <br>
        <div class="formulario col-lg-8">
            <h1 class="h1 mb-4"><strong>FICHA DE CONTROL DEL PARTIDO</strong></h1>
            <form action="Cedula_Servlet" method="post">
            <div class="space">

            <!-- Campo de selección de árbitro -->
            <div class="form2">
                <label class="h"><i class="fas fa-regular fa-gavel fa-beat"></i> Árbitro:</label>
                <select style="font-size: 15px;"  class="form-control text-center" id="arbitro" name="txtArbitro" required>
                    <option value="" style="display:none;">Seleccionar Árbitro:</option>
                    <% for (AdministradorDAO arbitro :  listaArbitros){ %>
                        <option style="font-size: 15px;" value="<%= arbitro.getNombre_completo()%>"><%= arbitro.getNombre_completo()%></option>
                     <% } %>
                </select>
            </div>
                
            <!-- Campo de selección de asistente -->
            <div class="form2">
                <label class="h"><i class="fas fa-regular fa-gavel fa-beat"></i> Árbitro Asistente:</label>
                <select style="font-size: 15px;" class="form-control text-center" id="arbitro" name="txtAsistente" required>
                    <option value="" style="display:none;">Seleccionar Árbitro Asistente:</option>
                    <% for (AdministradorDAO arbitro :  listaArbitros){ %>
                    <option style="font-size: 15px;" value="<%= arbitro.getNombre_completo()%>"><%= arbitro.getNombre_completo()%></option>
                    <% } %>
                </select>
            </div>
            
              <!-- Campo de fecha del partido -->
            <div class="form2">
                <label class="h"><i class="fas fa-solid fa-calendar-days fa-beat"></i> Fecha del Partido:</label>
                <input class="form-control text-center" style="font-size: 15px;" value="<%= fecha %>" name="txtFecha">
            </div>    
                
             <!-- Campo de categoría -->
            <div class="form2">
                <label class="h" for="categoria"><i class="fas fa-tag"></i> Categoría:</label>
                <%  Categorias categorias = new Categorias();
                    List<CategoriaDAO> listaCategorias = categorias.consulta(torneo);
                    for (CategoriaDAO categoria : listaCategorias) { %>
                    <input class="form-control text-center" style="font-size: 15px;"  value="<%= categoria.getNombreCategoria() %>" name="txtCategoria">
            </div>

            <!-- Campo de rama -->
            <div class="form2">
                <label class="h"><i class="fas fa-solid fa-genderless fa-bounce"></i> Rama:</label>
                <input class="form-control text-center" style="font-size: 15px;" value="<%= categoria.getGenero()%>" name="txtGenero">
            </div>
            <% } %>

            <!-- Campo de torneo -->
            <div class="form2">
                <label class="form-label h"><i class="fas fa-trophy"></i> Torneo</label>
                <input class="form-control text-center" style="font-size: 15px;" value="<%= torneo %>" name="txtTorneo">
            </div>

            <!-- Campo de equipo local -->
            <div class="form">
                <label class="form-label h" for="equipoLocal" style="margin-right: 10px; margin-left: 60px; m"><i class="fas fa-solid fa-shield-halved fa-flip"></i> Equipo Local:</label>
                <input class="form-control text-center" style="max-width: 150px; font-size: 15px;" value="<%=local%>" name="equipoLocal">
            </div>

            <!-- Campo de equipo visitante -->
            <div class="form">
                <label class="form-label h" for="equipoVisitante" style="margin-right: 10px; margin-left: 60px;"><i class="fas fa-solid fa-shield-halved fa-flip"></i> Equipo Visitante:</label>
                <input class="form-control text-center" style="max-width: 150px; font-size: 15px;" value="<%=visitante%>" name="equipoVisitante">
            </div>

            <!-- Campo de marcador local -->
            <div class="form">
              <label class="form-label h" style="margin-right: 10px; margin-left: 50px;"><i class="fa-solid fa-futbol fa-spin"></i> Marcador Local:</label>
              <input class="form-control text-center" style="max-width: 150px; font-size: 15px;" type="number" min="0" name="marcadorLocal" id="marcadorLocal">
            </div>

            <!-- Campo de marcador visitante -->
            <div class="form">
            <label class="form-label h" style="margin-right: 10px; margin-left: 50px;"><i class="fa-solid fa-futbol fa-spin"></i> Marcador Visitante:</label>
            <input class="form-control text-center" style="max-width: 150px; font-size: 15px;" type="number" min="0" name="marcadorVisitante" id="marcadorVisitante">
            </div>
            
            <!--Tablas de Jugadores  -->
            <div class="form">
                <% Jugadores_Equipos plantilla = new Jugadores_Equipos();
                List<Jugadores_EquiposDAO> lista = plantilla.consultar(local, torneo);
                Iterator<Jugadores_EquiposDAO> iter = lista.iterator();
                Jugadores_EquiposDAO player = null;%>
                <table class="table table-bordered" style="background-color: aliceblue">
                    <thead>
                    <tr>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                        border: 3px solid #000;" class="text-center"><strong>A</strong></th>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                            border: 3px solid #000;" class="text-center"><strong>Nombre</strong></th>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                            border: 3px solid #000;" class="text-center"><strong>Dorsal</strong></th>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                            border: 3px solid #000;" class="text-center"><strong>Goles</strong></th>
                        <th style="font-size: 15px; font-style: italic; border: 3px solid #000;"
                            class="text-center"><strong><i class="fas fa-square text-warning"></i></strong></th>
                        <th style="font-size: 15px; font-style: italic; color: white; border: 3px solid #000;"
                            class="text-center"><strong><i class="fas fa-square text-danger"></i></strong></th>
                    </thead>
                    <tbody>
                    <% while(iter.hasNext()){%>
                    <% player = iter.next();%>
                    <tr>
                         <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                        <input class="form-check-input" type="checkbox" name="presente_<%= player.getNombreJugador() %>" 
                               value="<%= player.getNombreJugador() %>" checked onclick="this.value=this.checked?1:0;"></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;"
                            class="text-center"><%= player.getNombreJugador()%></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;"
                            class="text-center"><%= player.getDorsal()%></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                            <input class="text-center golesLocal" type="number" min="0" name="goles_<%= player.getNombreJugador() %>"" style="max-width: 50px;" required></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                            <input class="text-center" type="number" min="0" max="2" name="amarillas_<%= player.getNombreJugador() %>"" style="max-width: 50px;" required></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                            <input class="text-center" type="number" min="0" max="1" name="rojas_<%= player.getNombreJugador() %>"" style="max-width: 50px;" required></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>

            <!--Tablas de Jugadores 2 -->
            <div class="form">
                <%
                    List<Jugadores_EquiposDAO> lista2 = plantilla.consultar(visitante,torneo);
                    Iterator<Jugadores_EquiposDAO> iter2 = lista2.iterator();
                %>
                <table class="table table-bordered" style="background-color: aliceblue">
                    <thead>
                    <tr>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                        border: 3px solid #000;" class="text-center"><strong>A</strong></th>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                            border: 3px solid #000;" class="text-center"><strong>Nombre</strong></th>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                            border: 3px solid #000;" class="text-center"><strong>Dorsal</strong></th>
                        <th style="font-size: 15px; font-style: italic; color: #000077;
                            border: 3px solid #000;" class="text-center"><strong>Goles</strong></th>
                        <th style="font-size: 15px; font-style: italic; border: 3px solid #000;"
                            class="text-center"><strong><i class="fas fa-square text-warning"></i></strong></th>
                        <th style="font-size: 15px; font-style: italic; color: white; border: 3px solid #000;"
                            class="text-center"><strong><i class="fas fa-square text-danger"></i></strong></th>
                    </thead>
                    <tbody>
                    <% while(iter2.hasNext()){%>
                    <% player = iter2.next();%>
                    <tr>
                     <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                         <input class="form-check-input" type="checkbox"  name="presente_<%= player.getNombreJugador() %>" 
                       value="<%= player.getNombreJugador() %>" checked onclick="this.value=this.checked?1:0;"></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;"
                            class="text-center"><%= player.getNombreJugador()%></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;"
                            class="text-center"><%= player.getDorsal()%></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                            <input class="text-center golesVisitante" type="number" min="0" name="goles_<%= player.getNombreJugador() %>"" style="max-width: 50px;" required></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                            <input class="text-center" type="number" min="0" max="2" name="amarillas_<%= player.getNombreJugador() %>"" style="max-width: 50px;" required></td>
                        <td style="font-size: 15px; font-style: italic; border: 3px solid #000;">
                            <input class="text-center" type="number" min="0" max="1" name="rojas_<%= player.getNombreJugador() %>"" style="max-width: 50px;" required></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
             
            
             </div>
        <div class="text-center">
            <button name="Accion" style="font-size: 15px;" value="Enviar" class="btn btn-primary btn-lg">Enviar</button>
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
<script>
$(document).ready(function() {
    function actualizarMarcadorLocal() {
        var golesLocal = 0;
        $('.golesLocal').each(function() {
            golesLocal += parseInt($(this).val() || 0);
        });
        $('#marcadorLocal').val(golesLocal);
    }

    function actualizarMarcadorVisitante() {
        var golesVisitante = 0;
        $('.golesVisitante').each(function() {
            golesVisitante += parseInt($(this).val() || 0);
        });
        $('#marcadorVisitante').val(golesVisitante);
    }

    // Actualizar los marcadores cuando cambia el valor de los goles locales
    $('.golesLocal').change(function() {
        actualizarMarcadorLocal();
    });

    // Actualizar los marcadores cuando cambia el valor de los goles visitantes
    $('.golesVisitante').change(function() {
        actualizarMarcadorVisitante();
    }); 
    // Ajustar valor del checkbox
     $('input[type="checkbox"]').change(function() {
            if ($(this).is(':checked')) {
                $(this).val('1');
            } else {
                $(this).val('0');
            }
        });

                 // Ajustar valor del checkbox
        $('input[type="checkbox"]').change(function() {
            var isChecked = $(this).prop('checked');
            var row = $(this).closest('tr'); // Obtener la fila más cercana al checkbox
            var inputs = row.find('input[type="number"]'); // Obtener todos los inputs de la fila
            if (!isChecked) {
                // Si la casilla está desmarcada, cambiar el color de fondo a rojo y deshabilitar los inputs
                row.css('background-color', 'red');
                inputs.prop('disabled', true);
            } else {
                // Si la casilla está marcada, restaurar el color de fondo y habilitar los inputs
                row.css('background-color', '');
                inputs.prop('disabled', false);
            }
        });
                // Manejar el cambio en los inputs de tarjetas amarillas
        $('input[name^="amarillas_"]').change(function() {
            var valorAmarillas = parseInt($(this).val());
            if (valorAmarillas === 2) {
                // Cambiar automáticamente a tarjeta roja cuando se recibe una segunda amarilla
                var row = $(this).closest('tr'); // Obtener la fila más cercana al input
                var tarjetaRojaInput = row.find('input[name^="rojas_"]');
                tarjetaRojaInput.val(1); // Cambiar automáticamente a tarjeta roja
            }
        });
});
</script>

    </body>
</html>
