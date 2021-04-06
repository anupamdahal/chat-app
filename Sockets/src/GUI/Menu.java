package GUI;

/**
 * 
 MaskFormatter mf = new MaskFormatter("(###)-###-####");
 mf.setPlaceholderCharacter(' ');
 phoneNumberInput = new javax.swing.JFormattedTextField(mf);
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class Menu extends JFrame
{

  public Menu()
  {
      menuGUI();
  }
  
  private void menuGUI()
  {	

	  JPanel panel;
	  JTextField textField;
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
      
      //textfield
      textField = new JTextField(10);           
      ipAddress= textField.getText();
      //button
      JButton loginButton = new JButton("OK");
      
      //when user clicks button
      loginButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
        	 
        	 Chatbox chatbox=new Chatbox();
        	 chatbox.setVisible(true);
        	 setVisible(false);
                 
         }
      }); 
      
      //add textfield and button to panel
      panel.add(textField);      
      panel.add(loginButton);
      
      //add label and panel to frame
      add(headerLabel);
      add(panel);
      
      
  }
  
  
  
 
}