/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import net.codejava.networking.chat.client.ChatClient;

/**
 *
 * @author Sam
 */
public class Controller {
    static private Controller me = new Controller();
    
    private ArrayList<String> recivedMessages;
    public String userName="";
    private String error="";
   
    ChatClient client;
    
    private Controller(){
        recivedMessages = new ArrayList<>();
    }
    static public Controller get(){
        return me;
    }
    
    
    public ArrayList<String> getMessages () {
        
        return recivedMessages;
    }
    public void clearMessages(){
        recivedMessages = new ArrayList<>();
    }
    public void sendMessages(String message) {
        client.write.sendMessages(message); 
    }
    public void addMessage(String m){
        recivedMessages.add(m);
    }
    
    public void connect(String userName, String ip,int port){
        client = new ChatClient(userName, ip, port);
        error = client.getError();
        this.userName=userName;
        
    }
    public boolean connectionStatus(boolean status){
        return status;
    }
    public void setClientUserName(String userName){
        
    }
    public String getUserName(){
       //System.out.print("Username:"+userName);
       return userName; 
    } 
    public String getError(){
        return error;
    }
}
