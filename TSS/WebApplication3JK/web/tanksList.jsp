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
                %>
                            <td>
                                <a href="edit?id='<%=tank.getTankId() %>'>">Edytuj nazwę</a>
                            </td>
                <%
                            
                        out.print("</tr>");    
                    }     
                %>    

                
                
            </tbody>
	</table>
        <a href="<%=request.getContextPath()%>/back">
            Powrót do poprzedniej strony
        </a><br/><br/>             
    </body>
</html>
