package application.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import application.entities.Bottle;
import application.entities.Drink;

/**
 * Handles Bottle Entity CRUD operations using Hibernate session
 * @author Sean
 *
 */
@Repository
@Transactional
public class BottleDao {

	/**
	 * get session
	 */
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @param bottle from controller
	 */
	public void save(Bottle bottle) {

		Drink drink = bottle.getDrink();
		if (drink != null) {
			String drinkName = drink.getDrinkName();
			bottle.setDrink((Drink) getSession().createCriteria(Drink.class)
					.add(Restrictions.eq("drinkName", drinkName))
					.uniqueResult());
		}
		getSession().save(bottle);
	}

	/**
	 * 
	 * @param id from controller
	 * @return bottle based on id
	 */
	public Bottle getById(long id) {
		Bottle bottle = (Bottle) getSession().get(Bottle.class, id);
		return bottle;
	}

	/**
	 * 
	 * @return list of bottles
	 */
	public List<Bottle> getAllBottles() {
		List<Bottle> bottles = getSession().createCriteria(Bottle.class).list();
		return bottles;
	}

}