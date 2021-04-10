package GUI;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.*;

class Chatbox extends JFrame {

    boolean typing;

    public Chatbox() {
        chatboxGUI();
    }

    private void chatboxGUI() {
        JPanel panel;
        JTextField textField;
        JTextArea textArea;
        JLabel typingLabel;

        Timer timer;
        Timer newMessageLoop;
        Font font1;
        //frame properties
        font1 = new Font("Century Gothic", Font.LAYOUT_LEFT_TO_RIGHT, 40);
        setTitle("Chat Box");
        setSize(800, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create a panel and set layout
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridLayout(0, 1));
        add(panel, BorderLayout.SOUTH);

        //create label for thinking/typing
        typingLabel = new JLabel();
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
        textField.setBackground(Color.PINK);
        textField.setFont(font1);
        panel.add(textField);

        //textArea for displaying chat
        textArea = new JTextArea();
        textArea.setBackground(Color.CYAN);
        textArea.setFont(font1);
        //make it non-editable
        textArea.setEditable(false);
        
        
        
        newMessageLoop = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               for(String newMessage:Controller.get().getMessages()){
                   
                    showLabel(newMessage, textArea, textField, typingLabel);
               }
               Controller.get().clearMessages();
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

        // Set some margin, for the text
        //ta.setMargin(new Insets(0,0,0,0));
        // Set a scrollpane
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
