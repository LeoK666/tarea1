<%-- 
    Document   : login
    Created on : 4/03/2018, 03:43:06 PM
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="post">
            <label> Correo </label>
            <input type="text" name="email"/>
            <br>
            <label> Contraseña </label>
            <input tyoe="password" name="password">
            <br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
