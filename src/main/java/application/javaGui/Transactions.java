package application.javaGui;
import java.util.List;

import org.hibernate.Session;

import application.entities.Bottle;
import application.entities.Drink;
import application.entities.Neighbourhood;

public class Transactions {
	public static void addBottle(String capacity, String width, String height, String dateScanned) {
		//check if bottle is present in db, if the bottle data is found toggle warning
		Session session = (Session) HibernateUtil.getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
//		List result = HibernateUtil.getSessionFactory().getCurrentSession()
//				.createQuery("from Bottle where name = ? OR id = ?")
//				.setString(0, UserInterface.getUsernameInput())
//				.setString(1, Front.getPasswInput()).list();
		
//		if (result.isEmpty() || result == null) {
//		} else {
			Bottle bottle = new Bottle();
			System.out.println(capacity);
			bottle.setCapacity(capacity);
			bottle.setWidth(width);
			bottle.setHeight(height);
			bottle.setDateScanned(dateScanned);
		    session.save(bottle);  
		    session.getTransaction().commit();  
		    System.out.println("Done");
//		}
	}
	
	public void addNeighbourhood() {
		//check if bottle is present in db, if the bottle data is found toggle warning
		Session session = (Session) HibernateUtil.getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
//		List result = HibernateUtil.getSessionFactory().getCurrentSession()
//				.createQuery("from Bottle where name = ? OR id = ?")
//				.setString(0, UserInterface.getUsernameInput())
//				.setString(1, Front.getPasswInput()).list();
		
//		if (result.isEmpty() || result == null) {
//		} else {
		    Neighbourhood n = new Neighbourhood();
		    session.save(n);  
		    session.getTransaction().commit();  
		    System.out.println("Added neighbourhood");
//		}
	}
	
	public void addDrink() {
		//check if bottle is present in db, if the bottle data is found toggle warning
		Session session = (Session) HibernateUtil.getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
//		List result = HibernateUtil.getSessionFactory().getCurrentSession()
//				.createQuery("from Bottle where name = ? OR id = ?")
//				.setString(0, UserInterface.getUsernameInput())
//				.setString(1, Front.getPasswInput()).list();
		
//		if (result.isEmpty() || result == null) {
//		} else {
		    Drink d = new Drink();
		    session.save(d);  
		    session.getTransaction().commit();  
		    System.out.println("Done");
//		}
	}
}
