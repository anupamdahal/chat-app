package GUI;

//Usually you will require both swing and awt packages
//even if you are working with just swings.
/*import javax.swing.*;
import java.awt.*;
public class Chatbox {
 public static void main(String args[]) {

     //Creating the Frame
     JFrame frame = new JFrame("Chat Frame");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400, 400);

     //Creating the MenuBar and adding components
     JMenuBar mb = new JMenuBar();
     JMenu m1 = new JMenu("FILE");
     JMenu m2 = new JMenu("Help");
     mb.add(m1);
     mb.add(m2);
     JMenuItem m11 = new JMenuItem("Open");
     JMenuItem m22 = new JMenuItem("Save as");
     m1.add(m11);
     m1.add(m22);

     //Creating the panel at bottom and adding components
     JPanel panel = new JPanel(); // the panel is not visible in output
     JLabel label = new JLabel("Enter Text");
     JTextField tf = new JTextField(10); // accepts upto 10 characters
     JButton send = new JButton("Send");
     JButton reset = new JButton("Reset");
     panel.add(label); // Components Added using Flow Layout
     panel.add(tf);
     panel.add(send);
     panel.add(reset);

     // Text Area at the Center
     JTextArea ta = new JTextArea();

     //Adding Components to the frame.
     frame.getContentPane().add(BorderLayout.SOUTH, panel);
     frame.getContentPane().add(BorderLayout.NORTH, mb);
     frame.getContentPane().add(BorderLayout.CENTER, ta);
     frame.setVisible(true);
 }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class Chatbox extends JFrame
{
JPanel jpanel;
JTextField jtxtfield;
JTextArea jtxtarea;
JLabel label1;
boolean typing;
Timer timer;
Font font1;
    public Chatbox()
    {
        chatboxGUI();
    }
    
    private void chatboxGUI()
    {
    
        // Set frame properties
    	font1= new Font("Century Gothic", Font.LAYOUT_LEFT_TO_RIGHT, 40);
        setTitle("Chat Box");        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Create a JPanel and set layout
        jpanel=new JPanel();
        jpanel.setBackground(Color.LIGHT_GRAY);
        jpanel.setLayout(new GridLayout(0,1));
        label1=new JLabel();
        label1.setFont(font1);
        jpanel.add(label1);
        
        // Create a timer that executes every 1 millisecond
        timer=new Timer(1,new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                // If the user isn't typing, he is thinking
                if(!typing)
                	label1.setText("Thinking...");
            }
        });
        
        // Set initial delay of 2000 ms
        // That means, actionPerformed() is executed 2500ms
        // after the start() is called
        timer.setInitialDelay(2000);
        
        // Create JTextField, add it.
        
       
        jtxtfield=new JTextField();
        jpanel.add(jtxtfield);
        jtxtfield.setBackground(Color.PINK);
        jtxtfield.setFont(font1);
        
        
        // Add panel to the south,
        add(jpanel,BorderLayout.SOUTH);
        
        
        // Add a KeyListener
        jtxtfield.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke)
            {
            
                // Key pressed means, the user is typing
            	
            	label1.setText("You are typing...");
                
                // When key is pressed, stop the timer
                // so that the user is not thinking, he is typing
                timer.stop();
                
                // He is typing, the key is pressed
                typing=true;
                
                // If he presses enter, add text to chat textarea
                if(ke.getKeyCode()==KeyEvent.VK_ENTER) showLabel(jtxtfield.getText());
            }
            
            public void keyReleased(KeyEvent ke)
            {
            
                // When the user isn't typing..
                typing=false;
                
                // If the timer is not running, i.e.
                // when the user is not thinking..
                if(!timer.isRunning())
                
                // He released a key, start the timer,
                // the timer is started after 2500ms, it sees
                // whether the user is still in the keyReleased state
                // which means, he is thinking
                timer.start();
            }
        });
        
        // Create a textarea
        jtxtarea=new JTextArea();
        jtxtarea.setBackground(Color.CYAN);
        jtxtarea.setFont(font1);   
        // Make it non-editable
        jtxtarea.setEditable(false);
        
        // Set some margin, for the text
        //ta.setMargin(new Insets(0,0,0,0));
        
        // Set a scrollpane
        JScrollPane js=new JScrollPane(jtxtarea);
        add(js);
        
        addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent we)
            {
                // Get the focus when window is opened
            	jtxtfield.requestFocus();
            }
        });
        
        setSize(800,1000);
       
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void showLabel(String text)
    {
        // If text is empty return
        if(text.trim().isEmpty()) return;
        
        // Otherwise, append text with a new line
        jtxtarea.append(text+"\n");
        
        // Set textfield and label text to empty string
        jtxtfield.setText("");
        label1.setText("");
    }
    
   
}