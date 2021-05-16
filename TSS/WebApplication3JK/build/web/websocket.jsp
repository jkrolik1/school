<%-- 
    Document   : websocket
    Created on : 2021-05-16, 12:31:07
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
        <script langunage="javascript" type="text/javascript">
            var wsUri = getRootUri() + "/WebApplication3JK/endpoint";
            
            var webSend = setInterval(doSend,1000);
            
            function getRootUri(){
                return "ws://" + (document.location.hostname == "" ? 
                "localhost" : 
                        document.location.hostname) + ":" +
                        (document.location.port == "" ? "8081" :
                        document.location.port);
            }
            function init(){
                output = document.getElementById("output");
                initWebSocket();
            }
            function initWebSocket(){
                websocket = new WebSocket(wsUri);
                websocket.onopen = function (evt) {
                    onOpen(evt);
                };
                websocket.onmessage = function (evt) {
                    onMessage(evt);
                };
                websocket.onerror = function (evt) {
                    onError(evt);
                };
            }
            function onOpen(evt){
                //writeToScreen("CONNECTED");
            }
            function onMessage(evt){
                writeToScreen(evt.data);
            }
            function onError(evt){
                writeToScreen('<span style = "color: red;"> ERROR: </span>');
            }
            function doSend(message){
                websocket.send(message);
            }
            function writeToScreen(message){
                var pre = document.getElementById("messageID");
                pre.innerHTML = message;
            }
            window.addEventListener("load",init,false);
        </script>
        
        <h4>Ilość bitew na serwerze: <span id="messageID"></span></h4>
    </body>
</html>
