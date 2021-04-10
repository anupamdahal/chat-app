package net.codejava.networking.chat.client;
import java.net.*;
import java.io.*;

/**
 * This is the chat client program.
 * Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class ChatClient {
	
        private String hostname;
	private int port;
	private String userName;
        static private ChatClient client;
        public WriteThread write;
        
	public ChatClient(String userName,String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
                client = this;
                client.userName = userName;
                execute();
	}

	public void execute() {
		try {
			Socket socket = new Socket(hostname, port);

			System.out.println("Connected to the chat server");

			new ReadThread(socket, this).start();
			write = new WriteThread(socket, this);
                        write.setUserName(userName);
                        write.start(); 
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
		}

	}
        public String getUserName(){
            return userName;
        }

	
    
        
}