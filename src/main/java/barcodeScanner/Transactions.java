package barcodeScanner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Validator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import application.entities.Bottle;
import application.entities.BottleType;
import application.entities.Crate;
import application.entities.Drink;

/**
 * Adds scanned bottle to the database, if related Drink or bottleType tables
 * are not present, they will be generated too.
 * 
 * @param dateScanned
 * @param drink
 * @param bottleType
 */
public class Transactions {

	public static void addBottle(String dateScanned, String drink,
			String bottleType){

		Session session = (Session) HibernateUtil.createSessionFactory()
				.getCurrentSession();

		session.beginTransaction();

		Criteria criteria = session.createCriteria(Drink.class);
		Drink relatedDrink = (Drink) criteria.add(
				Restrictions.eq("drinkName", drink)).uniqueResult();

		Criteria criteriaB = session.createCriteria(BottleType.class);
		BottleType relatedBottleType = (BottleType) criteriaB.add(
				Restrictions.eq("type", bottleType)).uniqueResult();

		Criteria criteriaC = session.createCriteria(Crate.class);
		Crate existingCrate = (Crate) criteriaC.add(
				Restrictions.between("freeSpaces", 1, 24)).uniqueResult();

		if (relatedDrink == null) {
			Date date = new Date();
			
			relatedDrink = new Drink("Unspecified", drink, date, false);

			System.out.println(relatedDrink);
			session.save(relatedDrink);
		}

		if (relatedBottleType == null) {
			relatedBottleType = new BottleType();
			relatedBottleType.setType(bottleType);
			session.save(relatedBottleType);
		}

		Bottle bottle = new Bottle();
		bottle.setDateScanned(dateScanned);
		bottle.setDrink(relatedDrink);
		bottle.setBottleType(relatedBottleType);

		if (existingCrate == null || existingCrate.getFreeSpaces() == 0) {

			Crate newCrate = new Crate();
			newCrate.setFreeSpaces(24);
			int freespaces = newCrate.getFreeSpaces();
			bottle.setCrate(newCrate);
			newCrate.setFreeSpaces(freespaces - 1);
			session.save(bottle);
			session.save(newCrate);
			session.getTransaction().commit();

		} else {

			int freespaces = existingCrate.getFreeSpaces();
			bottle.setCrate(existingCrate);
			existingCrate.setFreeSpaces(freespaces - 1);
			session.save(bottle);
			session.save(existingCrate);
			session.getTransaction().commit();

		}

	}
}
