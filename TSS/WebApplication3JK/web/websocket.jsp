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
        <script src='https://cdn.plot.ly/plotly-latest.min.js'></script>
        <title>WebSocket</title>
    </head>
    <body>
        <script langunage="javascript" type="text/javascript">
            var wsUri = getRootUri() + "/WebApplication3JK/endpoint";
            
            var webSend = setInterval(doSend,1000);
            
            function getRootUri(){
                var wsUri = (location.protocol === "http:" ? "ws://":"wss://");
                return wsUri + (document.location.hostname == "" ? 
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
                var data = [
                    {
                      x: ['Wszystkie bitwy'],
                      y: [evt.data],
                      type: 'bar'
                    }
                ];

                Plotly.newPlot('myDiv', data);

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
        <div id='myDiv'></div>
    </body>
</html>
