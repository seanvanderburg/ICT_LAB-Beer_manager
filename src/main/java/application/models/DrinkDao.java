package application.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		List<Drink> drinks = getSession().createCriteria(Drink.class).list();
		return drinks;
	}

	public Drink getById(long id) {
		Drink drink = (Drink) getSession().get(Drink.class, id);

		//Drink drink = (Drink) getSession().createCriteria(Drink.class).add(Restrictions.eq("id", id)).uniqueResult();
		return drink;
	}

	public Drink getByName(String drinkName) {
		Drink drink = (Drink) getSession().createCriteria(Drink.class).add(Restrictions.eq("drinkName", drinkName)).uniqueResult();
		return drink;
	}

} 