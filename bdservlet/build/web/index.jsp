<%-- 
    Document   : index
    Created on : Nov 10, 2015, 1:14:11 PM
    Author     : PCCoco

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Control de Usuarios</h1>
            <form action="Login" method="post">
                <h1 align="center">Usuario</h1>
                <input type="text" align="center" maxlength="10" size="10" name="usu" placeholder="Usuario" required />
                <h1 align="center">Password</h1>
                <input type="password" align="center" maxlength="10" size="10" name="pas" placeholder="Password" required />
                <hr>
                <input type="submit" value="enviar"/>
                <input type="reset" value="Limpiar"/>                
            </form>
        </center>
    </body>
</html
-->





<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link rel="stylesheet" href="css/materialize.min.css">
    <link rel="stylesheet" href="css/Style.css">
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script src="js/materialize.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
           $(".button-collapse-large").sideNav();
           // Initialize collapsible (uncomment the line below if you use the dropdown variation)
            $('.collapsible').collapsible({
               
            });
            $('.modal-trigger').leanModal();
             $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
            $('.slider').slider({full_width: true});
        });
        
        
    </script>
</head>
<body class="#212121 grey darken-4">
    <div class="navbar-fixed">
     <nav class="#00897b teal darken-1">
        <div class="nav-wrapper">
            <a href="index.jsp" class="brand-logo center"><marquee direction="left">Farmacia del Dr Goku - lo mismo pero mas poderoso</marquee></a>
  <!--   menu de informacion donde te puedes     -->
  <ul id="slide-out" class="side-nav">
    <li><a class="waves-effect waves-light" href="#!">Inicio</a></li>
    <li><a class="waves-effect waves-light" href="#!">Medicina freemium</a></li>
    <li><a class="waves-effect waves-light" href="#!">Creditos</a></li>
  </ul>
  <a href="#" data-activates="slide-out" class="button-collapse-large"><i class="mdi-navigation-menu"></i></a>
      </div>
    </nav>
    </div>
    <div id="cuerpo">
      <!-- esta parte es la del slider donde se muestran las imagenes perronas      -->
      <div id="slider">
      <div class="slider">
    <ul class="slides">
      <li>
        <img src="Multimedia/auxiliar-farmacia2.jpg"> <!-- random image -->
        <div class="caption right-align">
          <h3>Bienvenido a la farmacia!</h3>
          <h5 class="light grey-text text-lighten-3">Hello</h5>
        </div>
      </li>
      <li>
        <img src="Multimedia/farmacia-dolores-rosa-01.jpg"> <!-- random image -->
        <div class="caption left-align">
          <h3>Somos el mejor de nuestra linea</h3>
          <h5 class="light grey-text text-lighten-3">Aqui es un gran lugar</h5>
        </div>
      </li>
    </ul>
  </div></div>
      <div id="login">
       <!-- esta parte es la de login donde sale el cuadro de texto      -->
         <a class="waves-effect waves-light btn modal-trigger" href="#modal1">Login</a>
         <a class="waves-effect waves-light btn" href="registro.html">Registrarse</a>
          <div class="modal" id="modal1">
           <div class="modal-content">
               <h4>Registro de usuario nuevo</h4>
               <p><div class="row">
        <form action="Login" method="post">
       <div class="input-field col s6">
          <input id="Nombre" name="usu" type="text" class="validate">
          <label for="usu">Usuario</label>
        </div>  
       <div class="input-field col s6">
          <input id="Apellido" name="pas" type="password" class="validate">
          <label for="pas">Contraseña</label>
          
         
        </div>
            <div class="modal-footer"><button type="submit" class="waves-effect waves-light btn" value="Submit">Entrar</button></div>
        </form>
      </div></p>
           </div>
        </div>
     </div>
    </div>
</body>
</html>
