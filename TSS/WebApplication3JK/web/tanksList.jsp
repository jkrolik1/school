<%-- 
    Document   : tanksList
    Created on : 2021-04-03, 19:20:14
    Author     : Jakub
--%>

<%@page import="java.util.List"%>
<%@page import="package1.webApp.model.Tank"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
        <c:when test="${listTanks.size() > 0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Zagraj</th>
                        <th>Id</th>
                        <th>Nazwa</th>
                        <th>Pancerz</th>
                        <th>Kaliber</th>
                        <th>Edytuj nazwę</th>
                        <th>Usuń czołg</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="counter" value="${0}"/>
                    <c:forEach var="tank" items="${listTanks}">
                        <tr bgcolor="${counter % 2 == 0 ? 'Gainsboro' : 'Silver'}">
                            <td><a href="play?id=<c:out value='${tank.tankId}'/>">Wybierz do gry</a></td>
                            <td><c:out value="${tank.tankId}"/></td>
                            <td><c:out value="${fn:toUpperCase(tank.name)}"/></td>
                            <td><c:out value="${tank.armorAmount}"/></td>
                            <td><c:out value="${tank.gunCaliber}"/></td>
                            <td><a href="edit?id=<c:out value='${tank.tankId}'/>">Edytuj nazwę</a></td>
                            <td><a href="delete?id=<c:out value='${tank.tankId}'/>">Usuń czołg</a></td>
                        </tr>
                        <c:set var="counter" value="${counter + 1}"/>
                    </c:forEach>

                </tbody>
            </table> 
            
            <br/><br/>
        
            <a href="<%=request.getContextPath()%>/add">Dodaj czołg</a>
        <br/>    
        </c:when>
        <c:otherwise>
            <h2>Nie masz jeszcze czołgów.</h2>
            
            <br/>
            <a href="<%=request.getContextPath()%>/add">Dodaj swój pierwszy czołg</a> 
            <br/>
        </c:otherwise>
        </c:choose>

        <br/>
        <a href="<%=request.getContextPath()%>/back">Powrót do poprzedniej strony</a>
        <br/><br/>   
        
        <h2 style="color:${color}"> ${tankBattleResult} </h2>
        <h3 style="color: green"> ${crudMessage} </h2>
    </body>
</html>
