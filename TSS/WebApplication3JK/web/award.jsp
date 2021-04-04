<%-- 
    Document   : award
    Created on : 2021-04-04, 11:38:55
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Twoja liczba bitew: ${warAmount}
        <form action="ImageServlet" method="post">
            Pasek postępu <input type="submit" value="wyswietl" name="submit"/>  Im więcej bitew tym pasek postępu jest dłuższy
        </form>  
    </body>
</html>
