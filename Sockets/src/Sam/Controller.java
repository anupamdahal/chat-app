/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sam;

import java.util.ArrayList;

import net.codejava.networking.chat.client.ChatClient;

/**
 *
 * @author Sam
 */
public class Controller {
	Controller me = new Controller();
    User user;
    ChatClient client;
    private Controller (){
    	String hostname = "localhost";
		int port = 8080;

		ChatClient client = new ChatClient(hostname, port);
		client.execute();
    }
    public Controller getInstance (String IP,int p) { 
    	client = new ChatClient(IP,p);
        client.execute();
    	return me;
    }
    /**
     * This makes a message with the local users name, and the string of the message
     * @param message the string of what the message is
     * @return this will return a copy of the message object
     */
    
    public void sendMessage (Message message){
        
    }
    
    public void start(String IPaddress,int port) {
    	
    	ChatClient client = new ChatClient(IPaddress, port);
    	client.execute();
    }
}
