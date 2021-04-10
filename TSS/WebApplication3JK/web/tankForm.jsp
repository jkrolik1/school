<%-- 
    Document   : tankForm
    Created on : 2021-04-10, 19:49:30
    Author     : Jakub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="package1.webApp.model.Tank"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edycja nazwy czołgu</title>
    </head>
    <body>
        <form action="update" method="post">
            <label>Numer czołgu</label><br/>
            <input type="number" name="id" value="${tank.getTankId()}" readonly/>Tylko do odczytu<br/><br/>
            
            <label>Nazwa czołgu</label><br/>
            <input type="text" name="name" value="${tank.getName()}" /><br/><br/>
            
            <label>Pancerz kadłuba</label><br/>
            <input type="number" name="armor" value="${tank.getArmorAmount()}" readonly />Tylko do odczytu<br/><br/>
            
            <label>Kaliber działa</label><br/>
            <input type="number" name="gun" value="${tank.getGunCaliber()}" readonly />Tylko do odczytu<br/><br/>
       
            <button type="submit">Edytuj nazwę</button>
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
