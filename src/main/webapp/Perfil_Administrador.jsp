<%-- 
    Document   : Perfil_Administrador
    Created on : 23 mar. 2024, 11:59:31
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
        <title>Perfil Administrador</title>
    </head>
    <body>
        <div class="nav-principal">
          <nav>
              <a href="Panel_Administrador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i class="fa-solid fa-arrow-left"></i> Regresar</a>
            <p class="p">Soccer Admin</p>         
          </nav>
        </div>  
       </header>
       <section>
             <br><!-- comment -->
         <div class="formulario col-lg-6">
             <div class="row justify-content-center">
                    Perfil del Administrador
                </div>
                <div class="card-body">
                    <form action="" method="post" class="form">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre de Usuario:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= session.getAttribute("nombre2")%>" disabled>
                                <button type="button" class="btn btn-outline-primary" onclick="habilitarEdicion('nombre')">Editar</button>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="contraseña" class="form-label">Contraseña:</label>
                            <div class="input-group">
                                <input type="password" class="form-control" id="contraseña" name="contraseña" value="<%= session.getAttribute("contraseña")%>" disabled>
                                <button type="button" class="btn btn-outline-primary" onclick="togglePasswordVisibility('contraseña')">
                                    <i id="eyeIcon" class="fa fa-eye"></i>
                                </button>
                            </div>
                        <div class="mb-3">
                            <label for="fecha" class="form-label">Fecha de Nacimiento:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" value="<%= session.getAttribute("fecha")%>" disabled>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="sexo" class="form-label">Sexo:</label>
                            <div class="input-group">
                                <input type="text" class="form-control"value="<%= session.getAttribute("sexo")%>" disabled>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="telefono" class="form-label">Número de Teléfono:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="telefono" name="telefono" value="<%= session.getAttribute("telefono")%>" disabled>
                                <button type="button" class="btn btn-outline-primary" onclick="habilitarEdicion('telefono')">Editar</button>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="correo" class="form-label">Correo Electrónico:</label>
                            <div class="input-group">
                                <input type="email" class="form-control" id="correo" name="correo" value="<%= session.getAttribute("correo")%>" disabled>
                                <button type="button" class="btn btn-outline-primary" onclick="habilitarEdicion('correo')">Editar</button>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                    </form>
    </div>
         </div>
             <br>
       </section>
    <div>
    <footer>
        <p class="texto--blanco">Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
    </footer>
    </div>
 <script>
    function habilitarEdicion(campo) {
        var inputCampo = document.getElementById(campo);
        inputCampo.disabled = !inputCampo.disabled;
        inputCampo.focus();
        
    function togglePasswordVisibility(inputId) {
        var passwordInput = document.getElementById(inputId);
        var eyeIcon = document.getElementById('eyeIcon');

        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            eyeIcon.classList.remove('fa-eye');
            eyeIcon.classList.add('fa-eye-slash');
        } else {
            passwordInput.type = "password";
            eyeIcon.classList.remove('fa-eye-slash');
            eyeIcon.classList.add('fa-eye');
        }
    }
</script>
    </body>
</html>
