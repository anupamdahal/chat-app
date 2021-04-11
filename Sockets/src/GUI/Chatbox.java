package GUI;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.*;

class Chatbox extends JFrame {

    boolean typing;
    boolean errorPrinted = false;
    public Chatbox() {
        chatboxGUI();
    }

    private void chatboxGUI() {
        
        JPanel panel;
        JTextField textField;
        JTextArea textArea;
        JLabel typingLabel;
        
        //custom colors
        Color lightBlue=new Color(121,202,224);
    	Color turquoise=new Color(0,83,98);
    	Color darkBlue=new Color(70,130,180);
        Color lightGrey=new Color(227,244,244);

        Timer timer;
        Timer newMessageLoop;
        Font font1;
        
        //frame properties
        font1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 35);
        setTitle("Chat Box");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(screenSize.width-1000,screenSize.height-200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //panel
        panel = new JPanel();
        panel.setBackground(darkBlue);
        panel.setLayout(new GridLayout(0, 1));
        add(panel, BorderLayout.SOUTH);

        //label for thinking/typing
        typingLabel = new JLabel();
        typingLabel.setForeground(Color.WHITE);
        typingLabel.setFont(font1);
        panel.add(typingLabel);

        //timer for thinking/typing label
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                //if user isn't typing, he is thinking
                if (!typing) {
                    typingLabel.setText("Thinking...");
                }
            }
        });

        // Set initial delay of 2000 ms
        // That means, actionPerformed() is executed 2500ms
        // after the start() is called
        timer.setInitialDelay(2000);
        
        //jtextField for user input    
        textField = new JTextField();
        textField.setBackground(lightGrey);
        textField.setFont(font1);
        panel.add(textField);

        //textArea for displaying chat
        textArea = new JTextArea();
        textArea.setBackground(lightBlue);
        textArea.setFont(font1);
        //make it non-editable
        textArea.setEditable(false);       
                
        newMessageLoop = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               for(String newMessage:Controller.get().getMessages()){
                   
                    showLabel(newMessage, textArea, textField, typingLabel);
               }
               Controller.get().clearMessages();
                //set to == false to make it clear in the picture
               
            }
        });
        newMessageLoop.start();
       
        // Add a KeyListener
        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {

                // Key pressed means, the user is typing
                typingLabel.setText("You are typing...");

                // When key is pressed, stop the timer
                // so that the user is not thinking, he is typing
                timer.stop();

                // He is typing, the key is pressed
                typing = true;

                // If he presses enter, add text to chat textArea
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    String typed_message=textField.getText();
                    showLabel(typed_message, textArea, textField, typingLabel);
                    Controller.get().sendMessages(typed_message);
                }
            }

            public void keyReleased(KeyEvent ke) {

                // When the user isn't typing..
                typing = false;

                // If the timer is not running, i.e.
                // when the user is not thinking..
                if (!timer.isRunning()) // He released a key, start the timer,
                // the timer is started after 2500ms, it sees
                // whether the user is still in the keyReleased state
                // which means, he is thinking
                {
                    timer.start();
                }
            }
        });

        JScrollPane js = new JScrollPane(textArea);
        add(js);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent we) {
                // Get the focus when window is opened
                textField.requestFocus();
            }
        });

    }

    private void showLabel(String text, JTextArea textArea, JTextField textField, JLabel typingLabel) {
        // If text is empty return
        if (text.trim().isEmpty()) {
            return;
        }

        // Otherwise, append text with a new line
        textArea.append(text + "\n");

        // Set textField and label text to empty string
        textField.setText("");
        typingLabel.setText("");
    }

}
