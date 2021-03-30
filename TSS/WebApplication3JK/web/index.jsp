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
        <h2>Autor: Krolik Jakub <img src="images/tankPhoto.jpg" width="100" height="100"> </h2>
        <h3>Przedmiot: Technologie Server Side</h3>
        <h4>Wydział Nauk Ścisłych i Technicznych - Sosnowiec</h4>
        <h3>2020/2021</h3>
        
        <br/><br/><br/>
        
        <form action="<%= request.getContextPath() %>/register" method="post">
            Login użytkownika: <input type="text" name="login"/><br/><br/>  
            Hasło: <input type="password" name="password"/><br/><br/>  
            Email <input type="text" name="email"/><br/><br/>  
            <input type="submit" value="Zaloguj"/>  
        </form>  
        
        <br/><br/><br/><br/>
        
        <h3>Liczba rozegranych bitew na serwerze: <!-- Dane z bazy --></h3> 
        <h4>Aktualna data: <%= (new java.util.Date()).toLocaleString()%></h4>
        
    </body>
</html>
