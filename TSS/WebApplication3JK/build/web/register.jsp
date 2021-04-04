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
        <title>Formularz rejestracji</title>
    </head>
    <body>
        <h1>Tanks Battle Game</h1>
        <h2>Autor: Krolik Jakub</h2>
        <h3>Przedmiot: Technologie Server Side</h3>
        <h4>Wydział Nauk Ścisłych i Technicznych - Sosnowiec</h4>
        
        <br/><br/>
        
        <h2>Rejestracja</h2>
        <form action="loginRegister" method="post">
            Login użytkownika: <input type="text" name="login"/><br/><br/>
            Imię: <input type="text" name="name"/><br/><br/>
            Hasło: <input type="password" name="password1"/><br/><br/>  
            Powtórz hasło: <input type="password" name="password2"/><br/><br/>  
            <input type="submit" value="rejestracja" name="submit"/>  
        </form>  
        
        <br/><br/><br/>
        
        <h4>Aktualna data: <%= (new java.util.Date()).toLocaleString()%></h4>
        
    </body>
</html>
