package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class Menu extends JFrame
{
JPanel panel;
JTextField jtxtfield;
JTextArea jtxtarea;
JLabel label1;
boolean typing;
Timer timer;
Font font1;
JButton button;
JLabel headerLabel;
JLabel statusLabel;
  public Menu()
  {
      menuGUI();
  }
  
  private void menuGUI()
  {
      
//      // Set frame properties
//  	  font1= new Font("Century Gothic", Font.LAYOUT_LEFT_TO_RIGHT, 40);
//      setTitle("Menu");        
//      
//      setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//      // Create a JPanel and set layout
//      jpanel=new JPanel();
//
//     
////      label1=new JLabel();
////      label1.setFont(font1);
////      jpanel.add(label1);
////      
//      
//     
//      jtxtfield=new JTextField();
//      jtxtfield.setFont(font1);
//      jtxtfield.setBounds(100,100,100,100);
//      jpanel.add(jtxtfield);
//      //jtxtfield.setBackground(Color);
//      
//      
//      
//    
//      
//  
//      jpanel.setBackground(Color.BLACK);
//      jpanel.setPreferredSize(new Dimension(70,500));
//      add(jpanel);
//      setSize(500,500);
//      setLocationRelativeTo(null);
//      setVisible(true);

	  
      setSize(400,400);
      setLayout(new GridLayout(3, 1));
      
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      panel = new JPanel();
      panel.setLayout(new FlowLayout());

      add(headerLabel);
      add(panel);
      add(statusLabel);
      setVisible(true);  
   
      headerLabel.setText("Enter IP Address"); 

      //JLabel  namelabel= new JLabel("", JLabel.RIGHT);
     
      final JTextField userText = new JTextField(10);
           

      JButton loginButton = new JButton("OK");
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {  
        	 Chatbox chatbox=new Chatbox();
        	 chatbox.setVisible(true);
        	 setVisible(false);
                 
         }
      }); 
      
      panel.add(userText);
      
      panel.add(loginButton);
      setLocationRelativeTo(null);
      setVisible(true);  
  }
  
  
  
 
}