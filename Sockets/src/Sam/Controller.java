/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sam;

/**
 *
 * @author Sam
 */
public class Controller {
    User me;
    
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
}
