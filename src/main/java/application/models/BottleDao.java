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

@Repository
@Transactional
public class BottleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Bottle bottle) {
		Drink drink = bottle.getDrink();
		String drinkName = drink.getDrinkName();
		bottle.setDrink((Drink) getSession().createCriteria(Drink.class).add(Restrictions.eq("drinkName", drinkName)).uniqueResult());
		getSession().save(bottle);
	}
	
	public Bottle getById(String bottleId) {
		Session session = sessionFactory.openSession();
		Bottle bottle = (Bottle) session.createCriteria(Bottle.class).add(Restrictions.eq("bottleId", bottleId)).uniqueResult();
		return bottle;
	}
	
	public List<Bottle> getAllBottles() {
		Session session = sessionFactory.openSession(); 
		List<Bottle> bottles = session.createCriteria(Bottle.class).list();
		return bottles;
	}
	

} 