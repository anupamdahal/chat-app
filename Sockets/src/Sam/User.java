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
public class User {
    
    private final String name;
    //I assume this will turn into its own type at some point. the string is a place holder
    private String ipAddress;
    /**
     * This makes a new user!
     * @param name the screen name of the user 
     * @param ipAddress what the IP address is
     */
    public User( String name,String ipAddress){
        this.name = name;
        this.ipAddress = ipAddress;
    }
    
    public String getName(){
        return name;
    }
}
