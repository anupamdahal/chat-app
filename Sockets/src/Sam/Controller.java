/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sam;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Controller {
    User me;
    ArrayList<Message> messages;
    public Controller (User user){
        me = user; 
    }
    /**
     * This makes a message with the local users name, and the string of the message
     * @param message the string of what the message is
     * @return this will return a copy of the message object
     */
    public Message makeMessage(String message){
        return new Message(me.getName(),message);
    }
    public void sendMessage (Message message){
        
    }
    public boolean verifyIP(String IPaddress) {
    	
    	
    	return true;
    }
    public void makeConnection(String IPaddress) {
    	
    }
}
