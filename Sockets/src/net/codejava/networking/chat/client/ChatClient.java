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
        
	public ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
                client = this;
                execute();
	}

	public void execute() {
		try {
			Socket socket = new Socket(hostname, port);

			System.out.println("Connected to the chat server");

			new ReadThread(socket, this).start();
			write = new WriteThread(socket, this);
                        write.start();
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O Error: " + ex.getMessage());
		}

	}

	void setUserName(String userName) {
		this.userName = userName;
	}

	String getUserName() {
		return this.userName;
	}


	public static void main(String[] args) {
		//if (args.length < 2) return;
                System.out.println("LALALAL");
		String hostname = "192.168.1.16";
		int port = 8080;

		client = new ChatClient(hostname, port);
		client.execute();
	}
    
        
}