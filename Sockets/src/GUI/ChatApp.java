package GUI;

import javax.swing.SwingUtilities;

public class ChatApp {

	 public static void main(String args[])
	    {
		 	
	        SwingUtilities.invokeLater(new Runnable(){
	            public void run()
	            {
	                new WelcomeMenu();
	            }
	        });
	    }

}
