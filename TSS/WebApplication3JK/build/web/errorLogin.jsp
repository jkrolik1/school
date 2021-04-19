<%-- 
    Document   : errorLogin
    Created on : 2021-04-18, 17:58:03
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wynik logowania</title>
    </head>
    <body>
        <h3 style = "color: red;"> Niepoprawne dane logowania </h2>
        
        <%
            out.println("<a href=\"login.jsp\"><input type=\"button\" value=\"Zaloguj\"></a>");
            out.println("<a href=\"register.jsp\"><input type=\"button\" value=\"Zarejestruj\"></a>");
        %>
    </body>
</html>
