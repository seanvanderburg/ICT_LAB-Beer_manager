package application;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Bottle;

public class Main {
	public static void main(String[] args) {
		//Transactions transaction = new Transactions();
		//transaction.addBottle();
				
		 SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		            UserInterface gui = new UserInterface();
		        }
		    });
		
	}
}
