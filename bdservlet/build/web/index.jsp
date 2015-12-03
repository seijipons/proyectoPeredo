<%-- 
    Document   : index
    Created on : Nov 10, 2015, 1:14:11 PM
    Author     : PCCoco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</html>
