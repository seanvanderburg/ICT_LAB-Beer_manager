package application.swingGUI;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import application.entities.Bottle;
import application.entities.Drink;
import application.entities.Neighbourhood;

public class Transactions {


	public static void addBottle(String capacity, String width, String height,
			String dateScanned, String drink) {

		Session session = (Session) HibernateUtil.getSessionFactory()
				.getCurrentSession();
		
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Drink.class);
		Drink relatedDrink = (Drink) criteria.add(Restrictions.eq("drinkName", drink))
		                             .uniqueResult();
		Bottle bottle = new Bottle();
		bottle.setCapacity(capacity);
		bottle.setWidth(width);
		bottle.setHeight(height);
		bottle.setDateScanned(dateScanned);
		bottle.setDrink(relatedDrink);
		session.save(bottle);
		session.getTransaction().commit();
		System.out.println("Bottle added");
	}

	public void addNeighbourhood() {
		// check if bottle is present in db, if the bottle data is found toggle
		// warning
		Session session = (Session) HibernateUtil.getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();
		// List result = HibernateUtil.getSessionFactory().getCurrentSession()
		// .createQuery("from Bottle where name = ? OR id = ?")
		// .setString(0, UserInterface.getUsernameInput())
		// .setString(1, Front.getPasswInput()).list();

		// if (result.isEmpty() || result == null) {
		// } else {
		Neighbourhood n = new Neighbourhood();
		session.save(n);
		session.getTransaction().commit();
		System.out.println("Added neighbourhood");
		// }
	}

	public static void addDrink(String drinkname) {

		Session session = (Session) HibernateUtil.getSessionFactory()
				.getCurrentSession();

		session.beginTransaction();

		Drink d = new Drink();
		d.setDrinkName(drinkname);
		session.save(d);
		session.getTransaction().commit();
		System.out.println("Done");
		// }
	}
}
