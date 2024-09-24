<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
     <head>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
       integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
       <script src="https://kit.fontawesome.com/7e1c11bff0.js" crossorigin="anonymous"></script>
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
       <link href="css/style.css" rel="stylesheet" type="text/css"/>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
       <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Jugador</title>
    </head>  
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .profile {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .profile h1 {
            text-align: center;
            color: #333;
        }

        .profile-info {
            margin-top: 20px;
        }

        .profile-info p {
            margin-bottom: 10px;
            line-height: 1.5;
        }

        .profile-info strong {
            font-weight: bold;
        }

    </style>
    <title>Perfil Jugador</title>
</head>
<body>
<div class="nav-principal">
    <nav>
        <a href="Panel_Jugador.jsp" style="font-size: 18px" class="btn btn-success btn-lg"><i
                    class="fa-solid fa-arrow-left"></i> Regresar</a>
        <p class="p">Soccer Admin</p>
    </nav>
</div>
<section>
    <div class="formulario col-lg-6">
        <div class="profile">
            <h1>Perfil de Usuario</h1>
            <div class="profile-info">
          
           
                 
                <p style=""><strong>Nombre de Usuario:</strong> <%= session.getAttribute("nombre_usuario")%></p>
                        <p><strong>Nombre Completo:</strong> <%= session.getAttribute("nombre_completo") %></p>
                        <p><strong>Contraseña:</strong> <%= session.getAttribute("contrasen") %></p>
                        <p><strong>Posicion:</strong> <%= session.getAttribute("posicion") %></p>
                        <p><strong>Fecha de Nacimiento:</strong> <%= session.getAttribute("fechaNacimientoJugador") %></p>
                        <p><strong>Género:</strong> <%= session.getAttribute("sexoJugador") %></p>
                        <p><strong>Número de Teléfono:</strong> <%= session.getAttribute("numeroTelefonoJugador") %></p>
                        <p><strong>Correo Electrónico:</strong> <%= session.getAttribute("correoJugador") %></p>
            
            </div>
        </div>
    </div>
</section>
<footer class="h">
    <p>Todos los derechos Reservados, 2024 <i class="fa-brands fa-java"></i></p>
</footer>
</body>
</html>
