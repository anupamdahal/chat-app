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

	public ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public int execute() {
		try {
			Socket socket = new Socket(hostname, port);

			System.out.println("Connected to the chat server");

			new ReadThread(socket, this).start();
			new WriteThread(socket, this).start();
                         return 0;
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
                        return 1;
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
                        return 2;
		}

	}

	public void setUserName(String userName) {
		this.userName = userName; 
	}

	public String getUserName() {
		return this.userName; 
	}


	public static void main(String[] args) {
        System.out.println("LALA");
		String hostname = "192.168.1.16";
		int port = 8080;

		ChatClient client = new ChatClient(hostname, port);
		client.execute();
	}
        public static void run(String hName,int p){
            
		ChatClient client = new ChatClient(hName, p);
		client.execute();
        }
}