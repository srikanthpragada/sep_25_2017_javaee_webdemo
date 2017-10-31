package endpoints;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/upper")
public class UpperEndPoint {
    @OnOpen
    public void openConnection(Session session) {
        System.out.println("Connection opened");
    }
    
    // receive data sent from client 
    @OnMessage
    public void onMessage(Session session, String message) {
        try {
           // System.out.println("message received :" + message);
            session.getBasicRemote().sendText(message.toUpperCase());
        } catch (Exception ex) {
        }
    }
}
