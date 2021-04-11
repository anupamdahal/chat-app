package GUI;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;
import net.codejava.networking.chat.client.ChatClient;
import net.codejava.networking.chat.server.ChatServer;

class WelcomeMenu extends JFrame {

    private String userName = "";
    private String ipAddress;
    private Font font1;
    private JPanel ipPanel, userNamePanel, buttonPanel;
    private JTextField ipField, usernameField;
    private JButton button, okButton;
    private JLabel headerLabel, connectLabel, usernameLabel, messageLabel;

    public WelcomeMenu() {
        menuGUI();
    }

    private void menuGUI() {
        
        //custom colors
        Color lightBlue=new Color(162, 220, 223);
    	Color turquoise=new Color(103,196,200);
    	Color darkBlue=new Color(60,177,188);
    	Color lightGrey=new Color(227,244,244);

        //frame properties   
        font1 = new Font("Arial",Font.BOLD, 15);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(screenSize.width-1000,screenSize.height-400);
        setLocationRelativeTo(null);
        setTitle("Welcome!");
        setLayout(new GridLayout(0, 1));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //panels
        ipPanel = new JPanel();
        ipPanel.setLayout(new GridBagLayout());
        ipPanel.setBackground(darkBlue);
        
        userNamePanel = new JPanel();
        userNamePanel.setLayout(new GridBagLayout());
        userNamePanel.setBackground(turquoise);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(lightBlue);

        //labels
        usernameLabel= new JLabel("Enter your username: ");
        usernameLabel.setFont(font1);
        usernameLabel.setForeground(Color.WHITE);
        
        headerLabel = new JLabel("Enter IP Address: ");
        headerLabel.setFont(font1);
        headerLabel.setForeground(Color.WHITE);
        
        //username textfield
        usernameField=new JTextField(12);     
                
        //button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(font1);
        loginButton.setBackground(Color.WHITE);
        
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

        //when user clicks button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userName=usernameField.getText();
                ipAddress = ipField.getText();
                int port = 8080;
                System.out.println(ipAddress);
                Controller.get().connect(userName, ipAddress, port);    
                Controller.get().sendMessages(userName);

                Chatbox chatbox = new Chatbox();
                chatbox.setVisible(true);
                setVisible(false);

            }
        });

        //add textfield and button to panel
        userNamePanel.add(usernameLabel);
        userNamePanel.add(usernameField);
        ipPanel.add(headerLabel);
        ipPanel.add(ipField);
        buttonPanel.add(loginButton);
        add(ipPanel); 
        add(userNamePanel); 
        add(buttonPanel);
       

    }
    
    /**private void userPanel(){
        
        userNamePanel=new JPanel();
        userNamePanel.setLayout(new FlowLayout());
        //label
        connectLabel = new JLabel("You have successfully connected to the chat server!", JLabel.CENTER);
        usernameLabel= new JLabel("Enter your username", JLabel.CENTER);
        //username textfield
        usernameField=new JTextField(10);
        userName=usernameField.getText();
        Controller.get().setClientUserName(userName);
        
        JButton startButton = new JButton("Start Chatting!");
        //when user clicks button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                Chatbox chatbox = new Chatbox();
                chatbox.setVisible(true);
                setVisible(false);
            }
        });
        userNamePanel.add(connectLabel);
        userNamePanel.add(usernameLabel);
        userNamePanel.add(usernameField);
        userNamePanel.add(startButton);
        //add label and panel to frame
        //add(headerLabel);
        add(userNamePanel);
        
    }**/
    private void connectionErrorMessage(){
        //JFrame frame=new JFrame();
        //JOptionPane.showMessageDialog(frame,"Could not connect to server. Try again!");
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //frame.setVisible(true);
    }

}
