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

        //getting the user name
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter your name: ");
        String userName = "";
        try {
            userName = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(WriteThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        //set the username on the client side
        client.setUserName(userName);
        //print it
        writer.println(userName);


       
    }

    public void sendMessages(String message) {
        text = message;
        sendMessage = true;
        writer.println(text);
    }
    
    public void closeSocket(){
         try {
            socket.close();
        } catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
