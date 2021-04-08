/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sam;

import sockets.Settings;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sam
 */
public class Message {
    private final String timeStamp;
    private final String user;
    private final String message;
   /**
    *  
    * This will also set the timestamp to whenever the object is created
    * @param user the name of the user who made the message
    * @param message the string of the message
    */
    public Message(String user, String message) {
            SimpleDateFormat t = new SimpleDateFormat();
            t.applyPattern(Settings.shortDateFormat);
            timeStamp = t.format(new Date());
            
            this.user = user;
            this.message = message;
    }
    
    public String getUser(){
        return user;
    }
    public String getMessage(){
        return message;
    }
    public String getTimeStamp(){
        return timeStamp;
    }
    /**
     * 
     * @return 
     */
    public String getString(){
        StringBuilder sb = new StringBuilder();
        sb
                .append(user)
                .append(" ")
                .append(timeStamp)
                .append("\t")
                .append(message)
                
                ;
        
        return "";
    }
}
