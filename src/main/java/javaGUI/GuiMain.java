package javaGUI;

import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import application.models.Bottle;

public class GuiMain {
	public static void main(String[] args) {				
		 SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		            UserInterface gui = new UserInterface();
		        }
		    });
		
	}
}
