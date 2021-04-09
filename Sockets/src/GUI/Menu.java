package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;
import net.codejava.networking.chat.client.ChatClient;
import net.codejava.networking.chat.server.ChatServer;

class Menu extends JFrame
{
  private String userName = "";
  
  
  
  public Menu()
  {
      menuGUI();
  }
  
  private void menuGUI()
  {	

	  JPanel panel;
	  JTextField ipField;
	  JButton button;
	  JLabel headerLabel;
	  String ipAddress;
	  
	  //frame properties
	  setLocationRelativeTo(null);
      setVisible(true);  
      setSize(400,400);
      setTitle("Menu");
      setLayout(new GridLayout(3, 1));
      setVisible(true); 
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      //panel
      panel = new JPanel();
      panel.setLayout(new FlowLayout());
      
      //label
      headerLabel = new JLabel("Enter IP Address", JLabel.CENTER);      
      
      //ipField
      MaskFormatter mf; 
      try {
  		mf = new MaskFormatter("###.###.###.###"); 
  		mf.setPlaceholderCharacter('0');
  		ipField = new javax.swing.JFormattedTextField(mf);
  	} catch (Exception e1) {  
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  		 ipField = new JTextField(10);         
  	}
       
       
      ipAddress= ipField.getText();
      //button
      JButton loginButton = new JButton("OK");
      
     
      //when user clicks button
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
        	 
        	 int port = 8080;
                 
                 ChatClient.run("localhost",port);   
        	 Chatbox chatbox=new Chatbox();
        	 chatbox.setVisible(true);
        	 setVisible(false);
                 
         }
      }); 
      
      JButton hostButton = new JButton("Host");
      hostButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
        	 
        	 int port = 8080;
                 
        	 Chatbox chatbox=new Chatbox();
        	 chatbox.setVisible(true);
        	 setVisible(false);
                 ChatServer.run(port);  
                 //ChatClient.run("localhost",port);
                 
         }
      }); 
      
      
      //add textfield and button to panel
      panel.add(ipField);      
      panel.add(loginButton);
      panel.add(hostButton);
      //add label and panel to frame
      add(headerLabel);
      add(panel);
      
      
  }
  
  
  
 
}