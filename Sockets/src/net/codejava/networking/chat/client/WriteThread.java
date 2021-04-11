package net.codejava.networking.chat.client;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This thread is responsible for reading user's input and send it to the
 * server. It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {

    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;

    private String text = "";
    private boolean sendMessage = false;
    private String userName="";
    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);           
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        

       
    }
    public void setUserName(String name){
        userName = name; 
    }
    public void sendMessages(String message) {
        text = message;
        sendMessage = true;
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        writer.println(sb.toString());
    }
    
    public void closeSocket(){
         try {
            socket.close();
        } catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
