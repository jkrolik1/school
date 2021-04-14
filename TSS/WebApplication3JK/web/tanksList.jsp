<%-- 
    Document   : tanksList
    Created on : 2021-04-03, 19:20:14
    Author     : Jakub
--%>

<%@page import="java.util.List"%>
<%@page import="package1.webApp.model.Tank"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
		<tr>
                    <th></th>
                    <th>Id</th>
                    <th>Nazwa</th>
                    <th>Pancerz</th>
                    <th>Kaliber</th>
		</tr>
            </thead>
            <tbody>
                
                <% 
                    List<Tank> tanks = (List<Tank>) request.getAttribute("listTanks"); 
                    Tank tank;
                %>
                <%  for (int i = 0; i < tanks.size(); ++i) {

                        tank = tanks.get(i);

                        out.print("<tr>");
                            out.print("<td>");
                %>
                                <a href="play?id=<%=tank.getTankId() %>">Wybierz do gry</a>
                <%
                            out.print("</td>");
                            out.print("<td>");
                                out.print(tank.getTankId());
                            out.print("</td>");
                            out.print("<td>");
                                out.print(tank.getName());
                            out.print("</td>");
                            out.print("<td>");
                                out.print(tank.getArmorAmount());
                            out.print("</td>");
                            out.print("<td>");
                                out.print(tank.getGunCaliber());
                            out.print("</td>");
                            out.print("<td>");
                %>
                                <a href="edit?id=<%=tank.getTankId() %>">Edytuj nazwę</a>
                <%
                            out.print("</td>");
                            out.print("<td>");
                %>
                                <a href="delete?id=<%=tank.getTankId() %>">Usuń czołg</a>
                <%
                            out.print("</td>");
                        out.print("</tr>");    
                    }     
                %>    

                
                
            </tbody>
	</table>
                
        <br/><br/>
        
        <a href="<%=request.getContextPath()%>/add">
            Dodaj czołg
        </a><br/>        
        <a href="<%=request.getContextPath()%>/back">
            Powrót do poprzedniej strony
        </a><br/><br/>   
        
        <h2 style="color:${color}"> ${tankBattleResult} </h2>
        
    </body>
</html>
