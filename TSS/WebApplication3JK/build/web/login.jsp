<%-- 
    Document   : login
    Created on : 2021-04-18, 17:28:34
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logowanie</title>
    </head>
    <body>
        <h1>Tanks Battle Game</h1>
        <h2>Autor: Krolik Jakub</h2>
        <h3>Przedmiot: Technologie Server Side</h3>
             
        <br/><br/>
        
        <%
            if (request.isUserInRole("admin") || request.isUserInRole("user")){
                session.setAttribute("usrLogin", request.getUserPrincipal().getName());
                session.setAttribute("logged", 1);
                request.getRequestDispatcher("main.jsp").forward(request, response);   
            }
            else {
        %>       
                <form action="j_security_check" method="post">
                    Login użytkownika: <input type="text" name="j_username"/><br/><br/>  
                    Hasło: <input type="password" name="j_password"/><br/><br/> 
                    <input type="submit" value="logowanie" name="submit"/>  
                </form>
        <% 
            }
        %>       
        
        <br/><br/><br/>
        <a href="register.jsp"><input type="button" value="Zarejestruj"></a>
        <br/>
        <h4>Aktualna data: <%= (new java.util.Date()).toLocaleString()%></h4>
    </body>
</html>
