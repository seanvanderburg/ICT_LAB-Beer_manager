package application.models;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import application.entities.Drink;

@Repository
@Transactional
public class DrinkDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Drink drink) {
		getSession().save(drink);
	}

	public void delete(Drink drink) {
		getSession().delete(drink);
	}

	public List<Drink> getAllDrinks() {
		Session session = getSession(); 
		List<Drink> drinks = session.createCriteria(Drink.class).list();
		return drinks;
	}

	public Drink getById(long id) {
		Session session = sessionFactory.openSession();
		return (Drink) session.load(Drink.class, id);
	}

	public Drink getByName(String drinkName) {
		Session session = sessionFactory.openSession();
		Drink drink = (Drink) session.createCriteria(Drink.class).add(Restrictions.eq("drinkName", drinkName)).uniqueResult();
		return drink;
	}

} 