<%-- 
    Document   : jsp1
    Created on : 2021-03-09, 14:37:38
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formularz logowania</title>
    </head>
    <body>
        <h1>Tanks Battle Game</h1>
        <h2>Autor: Krolik Jakub</h2>
        <h3>Przedmiot: Technologie Server Side</h3>
             
        <br/><br/>
        
        <h2>Logowanie</h2>
        
        <h3 style = "color: red;"> ${message} </h2>
        <h3 style = "color: green;"> ${success} </h2>
        
        <form action="loginRegister" method="post">
            Login użytkownika: <input type="text" name="login"/><br/><br/>  
            Hasło: <input type="password" name="password"/><br/><br/> 
            <input type="submit" value="logowanie" name="submit"/>  
        </form>  
        <a href="register.jsp">Zarejestruj</a> 
        
        <br/><br/><br/>
        
        <h4>Aktualna data: <%= (new java.util.Date()).toLocaleString()%></h4>
        
    </body>
</html>