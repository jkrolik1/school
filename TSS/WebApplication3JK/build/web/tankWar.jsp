<%-- 
    Document   : tankWar
    Created on : 2021-04-14, 18:52:30
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bitwa</title>
    </head>
    <body>
        <form action="war" method="post">
            <b> Wybrany czołg: </b> <br/> ${tank2.getName()} <br/><br/>
            <b> Wylosowany czołg przeciwnika: </b> <br/> ${tank1.getName()} <br/><br/><br/>
            <button type="submit">Walcz!</button>
        </form>
    </body>
</html>
