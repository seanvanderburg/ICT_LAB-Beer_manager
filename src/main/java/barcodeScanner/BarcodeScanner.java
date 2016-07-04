package barcodeScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reads Barcode scanner input as keyboard input
 * Exports barcode name to txtfile for Lejos NXJ applications to control the physical sorting of bottles
 * @throws IOException
 */
public class BarcodeScanner {

	private static String codeName;
	private static String bottleType;
	private static String scanDate;
	
	public static void scanCode() throws IOException {
		while (true) {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("Barcode scan ready \n");

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();

			codeName = br.readLine();
			scanDate = dateFormat.format(date);
			bottleType = "beer";


			System.out.println(codeName + "\n");
			Transactions.addBottle(scanDate, codeName, bottleType);
		}
	}
}
