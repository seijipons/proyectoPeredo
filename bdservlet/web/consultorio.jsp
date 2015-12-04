<%@page import="java.sql.ResultSet"%>
<%@page import="bd.Conexion"%>
<%@page import="bd.Login"%>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.lang.*" %>
<%
    Conexion ob=new Conexion();
    %>
<!DOCTYPE html>
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
             $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 30 // Creates a dropdown of 15 years to control year
  });
            
    $('select').material_select();
    
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
    <li><a class="waves-effect waves-light" href="index.jsp">Inicio</a></li>
    <li><a class="waves-effect waves-light" href="#!">Medicina freemium</a></li>
    <li><a class="waves-effect waves-light" href="#!">Creditos</a></li>
  </ul>
  <a href="#" data-activates="slide-out" class="button-collapse-large"><i class="mdi-navigation-menu"></i></a>
      </div>
    </nav>
    </div>
    <div id="cuerpo">
      <div id="login">
       <!-- esta parte es la de login donde sale el cuadro de texto      -->
       <h3>Bienvenido:
            <%
            String id=request.getParameter( "id" );
            String tomarNombre="SELECT * FROM `usuario` WHERE `id_usuario`="+id;
            ResultSet res=ob.query(tomarNombre);
            while(res.next()){
      
        out.println(res.getString(2));      
        }
            %>
        </h3>
               <h4>Indentifique su enfermedad</h4>
          <!--h1>Prueba de impresion qd</h1-->
               <form action="medicamentos." method="get">
                
                    <div class="input-field col s12">
    <select>
      <option value="" disabled selected>Haga clic aqui</option>
         
              
    <%
        
      String name = request.getParameter( "firstName" );
      
      ResultSet ej=ob.listaEnfermedades();
      
        while(ej.next()){
      String c=ob.xXx("<option value='"+ej.getString(1)+"'>"+ej.getString(2)+"</option>");
        out.println(c);      
        }
        


   %>
   </select>
    <label>Seleccione la enfermedad que tiene de las opciones  que se muestran</label>
  </div>
   <button class="waves-effect waves-light btn">Entrar</button>
              <button class="waves-effect waves-light btn">Medicinas</button>
               </form>
       </div>
     </div>
</body>
</html>