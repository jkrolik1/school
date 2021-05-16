<%-- 
    Document   : main
    Created on : 2021-03-21, 13:07:19
    Author     : Jakub
--%>

<%@page import="package1.webApp.persistence.tankDAOimpl"%>
<%@page import="package1.webApp.model.Tank"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zacznij bitwę</title>
    </head>
    <body>
        <h1>Pomyślne logowanie!</h1>
        <h3> Zalogowano na Twój profil: <i><%=(String)session.getAttribute("usrLogin")%></i></h3><br/>

        <a href="<%=request.getContextPath()%>/list">Wyświetl czołgi</a>
        <br/> 
        <a href="<%=request.getContextPath()%>/award">Wyświetl bitewny pasek postępu</a>
        <br/> 
        <a href="<%=request.getContextPath()%>/battles">Wyświetl ilość bitew na serwerze</a>
        <br/><br/> 
        <a href="<%=request.getContextPath()%>/logout">Wyloguj</a>
        <br/><br/> 
        
    </body>
</html>
