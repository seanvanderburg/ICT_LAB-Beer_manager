package barcodeScanner;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class BarcodeMain {
	public static void main(String[] args) {
		try {
			BarcodeScanner.scanCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

