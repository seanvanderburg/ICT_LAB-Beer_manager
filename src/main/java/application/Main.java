package application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Bottle;

public class Main {
	public static void main(String[] args) {
		Transactions transaction = new Transactions();
		transaction.addBottle();
	}
}
