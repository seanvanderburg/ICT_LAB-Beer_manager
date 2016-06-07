package application.swingGUI;

import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class GuiMain {
	public static void main(String[] args) {				
		 SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		            UserInterface gui = new UserInterface();
		        }
		    });
		
	}
}
