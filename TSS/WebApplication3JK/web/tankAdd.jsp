<%-- 
    Document   : tankAdd
    Created on : 2021-04-13, 16:35:15
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj czołg</title>
    </head>
    <body>
        <form action="add2" method="post">
            <label>Nazwa czołgu</label><br/>
            <input type="text" name="name" value="" /><br/><br/>
            
            <label>Pancerz kadłuba - Generowane automatycznie po dodaniu czołgu</label><br/>

            <label>Kaliber działa - Generowane automatycznie po dodaniu czołgu</label><br/><br/>

            <button type="submit">Dodaj czołg</button>
        </form>
        <br/><br/>
            
        <a href="<%=request.getContextPath()%>/list">
            Powrót do listy czołgów
        </a><br/><br/>
        <a href="<%=request.getContextPath()%>/back">
            Powrót do menu
        </a><br/><br/>   
    </body>
</html>
