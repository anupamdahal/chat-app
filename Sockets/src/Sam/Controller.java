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
    private static Controller me;
    static ChatClient client;
    static ArrayList<Message> messages = new ArrayList<>();
    private Controller (String IP,int p) {
        
    	client = new ChatClient(IP,p);
        client.execute();
    	String hostname = "localhost";
		int port = 8080;

		ChatClient client = new ChatClient(hostname, port);
		client.execute();
    }
    public static Controller getInstance (String IP,int p) { 
        if(me == null){
            me = new Controller(IP, p);
        }
    	return me;
    }
    public static Controller getInstance () { 
    	if(me == null){
            me = new Controller("localhost", 8080);
        }
    	return me;
    }
    /**
     * This makes a message with the local users name, and the string of the message
     * @param message the string of what the message is
     * 
     */
    
    public void addMessage(String message){
        Message m = new Message(client.getUserName(),message); 
        messages.add(m);
    }
     public void addMessage(Message message){
        messages.add(message);
        
    }
     
     
     
    public void sendMessage (String text){
        client.getWriteThread().sendMessage(text);
    }
    
    public  ArrayList<Message> getMessages(){
        return messages;
    }
    
    
    public void start(String IPaddress,int port) {
    	
    	ChatClient client = new ChatClient(IPaddress, port);
    	client.execute();
    }
}
