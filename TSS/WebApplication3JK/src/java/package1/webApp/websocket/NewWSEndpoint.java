package package1.webApp.websocket;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import package1.webApp.persistence.battlestatDAOimpl;
import package1.webApp.persistence.battlestatDAO;
import package1.webApp.data.ApplicationLogic1;


@ServerEndpoint("/endpoint")
public class NewWSEndpoint {

    battlestatDAO battleDAO = new battlestatDAOimpl();
    
    @OnMessage
    public String onMessage(String message) {
        return ApplicationLogic1.getBattleNumber() + "";
        //return battleDAO.battleNumber()+"";
    }
    @OnOpen
    public String onOpen() {
        return "onOpen";
    }

    @OnError
    public void onError(Throwable t) {
    }

    @OnClose
    public void onClose() {
        
    }
}
