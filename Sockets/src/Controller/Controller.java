/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Controller {
    static private Controller me = new Controller();
    
    private ArrayList<String> recivedMessages;
    
    
    private Controller(){
        recivedMessages = new ArrayList<>();
    }
    static public Controller get(){
        return me;
    }
    
    
    public ArrayList<String> getMessages () {
        ArrayList<String> temp = recivedMessages;
        recivedMessages.clear();
        return temp;
    }
    public void sendMessages(){
        
    }
    public void addMessage(String m){
        recivedMessages.add(m);
    }
}
