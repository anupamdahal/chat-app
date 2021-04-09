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
        String hostname = "localhost";
        int port = 8080;

    	client = new ChatClient(hostname,port);
    	
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
        if(client == null){
            System.out.println("Client is null");
        }
        if(client.getWriteThread() == null){
            
            System.out.println("writter is null");
        }
        client.getWriteThread().sendMessage(text);
    }
    
    public  ArrayList<Message> getMessages(){
        return messages;
    }
    
    
    public ChatClient start(String IPaddress,int port) {
    	if(client == null)
            client = new ChatClient(IPaddress, port);
        return client;

    }
}
