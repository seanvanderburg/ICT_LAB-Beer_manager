package application.swingGUI;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class GuiMain {
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				UserInterface gui = new UserInterface();
//			}
//		});
		try {
			BarcodeScanner.scanCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

