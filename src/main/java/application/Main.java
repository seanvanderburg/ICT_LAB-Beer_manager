package application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Bottle;

public class Main {
	public static void main(String[] args) {
		   SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
	        Session session = sessionFactory.openSession();  
	        session.beginTransaction();  
	          
	        Bottle bottle = new Bottle();
	        bottle.setname("Heineken pils");  
	        session.save(bottle);  
	        session.getTransaction().commit();  
	          
	        session.close();    
	}
}
