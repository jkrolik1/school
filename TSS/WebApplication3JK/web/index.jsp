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
        <title>Strona startowa</title>
    </head>
    <body>
        <h1>Tanks Battle Game</h1>
        <h2>Autor: Krolik Jakub</h2>
        <h3>Przedmiot: Technologie Server Side</h3>
        
        <br/>
        
        <h3 style = "color:red"> ${messageError} </h3>
        <h3 style = "color:green"> ${messageSuccess} </h3>
        
        <br/><br/>
        
        <%
            out.println("<a href=\"login.jsp\"><input type=\"button\" value=\"Zaloguj\"></a>");
            out.println("<a href=\"register.jsp\"><input type=\"button\" value=\"Zarejestruj\"></a>");
        %>
        
        <br/><br/><br/>
        
        <h4>Aktualna data: <%= (new java.util.Date()).toLocaleString()%></h4>
        
    </body>
</html>
