package application.javaGui;

import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import application.entities.Bottle;

public class GuiMain {
	public static void main(String[] args) {				
		 SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		            UserInterface gui = new UserInterface();
		        }
		    });
		
	}
}
