package application.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import application.entities.Drink;

/**
 * Handles Drink Entity CRUD operations using Hibernate session
 * 
 * @author Sean
 *
 */
@Repository
@Transactional
public class DrinkDao {

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
	 * @param drink from Controller
	 */
	public void save(Drink drink) {
		getSession().save(drink);
	}
	
	/**
	 * 
	 * @param drink from Controller
	 */
	public void delete(Drink drink) {
		getSession().delete(drink);
	}

	/**
	 * 
	 * @return list of drinks
	 */
	public List<Drink> getAllDrinks() {
		List<Drink> drinks = getSession().createCriteria(Drink.class).list();
		for (Drink drink : drinks) {
			Hibernate.initialize(drink.getBottles());
		}
		return drinks;
	}

	/**
	 * 
	 * @param id from controller
	 * @return drink that matches id
	 */
	public Drink getById(long id) {
		Drink drink = (Drink) getSession().get(Drink.class, id);
		if (drink != null) {
			Hibernate.initialize(drink.getBottles());
		}
		return drink;
	}

	/**
	 * @param drinkName from controller
	 * @return drink that matches name
	 */
	public Drink getByName(String drinkName) {
		Drink drink = (Drink) getSession().createCriteria(Drink.class)
				.add(Restrictions.eq("drinkName", drinkName)).uniqueResult();
		return drink;
	}
}