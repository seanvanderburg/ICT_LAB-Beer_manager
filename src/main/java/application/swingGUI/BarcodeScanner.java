package application.swingGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BarcodeScanner {

	public static String codeName;
	public static String scanWidth;
	public static String scanHeight;
	public static String scanCapacity;
	public static String scanDate;

	public static void scanCode() throws IOException {
		while(true){
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Barcode scan ready \n");
	        codeName = br.readLine();	        
	        
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        Date date = new Date();
	        
	        scanWidth = "10cm";
	        scanHeight = "30cm";
	        scanCapacity = "33cl";
	        scanDate = dateFormat.format(date);
	        System.out.println(codeName + "\n");
	        Transactions.addBottle(scanCapacity, scanWidth, scanHeight, scanDate, codeName);
		}
	}
}
