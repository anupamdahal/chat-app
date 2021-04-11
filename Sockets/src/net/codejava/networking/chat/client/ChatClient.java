package net.codejava.networking.chat.client;
import java.net.*;
import java.io.*;
import Controller.Controller;
/**
 * This is the chat client program.
 * Type 'bye' to terminate the program.
 *
 * @author www.codejava.net
 */
public class ChatClient {
	
        private String hostname;
	private int port;
	private String userName;
        static private ChatClient client;
        public WriteThread write;
        
        private String error="";


        private boolean connected;
	public ChatClient(String userName, String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
                client = this;
                client.userName = userName;
                execute();
	}

	public void execute() {
		try {
                    
			Socket socket = new Socket(hostname, port);
                        Controller.get().connectionStatus(true);
			System.out.println("Connected to the chat server");

			new ReadThread(socket, this).start();
			write = new WriteThread(socket, this);
                        write.setUserName(userName);
                        write.start(); 
                        error = "";
		} catch (UnknownHostException ex) {
                        error="Server not found: " + ex.getMessage();                        
			System.out.println("Server not found: " + ex.getMessage());
                        
		} catch (IOException ex) {
                        //Controller.get().connectionStatus(false);
                        error="I/O Error: " + ex.getMessage();
			System.out.println("I/O Error: " + ex.getMessage());
                        
		}
                

	}
        public String getUserName(){
            return userName;
        }
        public boolean getConnectionStatus(){            
            return connected;
            
        }
        //get error added
       
        public String getError(){
            return error;
        }

	
    
        
}