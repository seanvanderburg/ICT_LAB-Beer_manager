package application.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import application.entities.Drink;

@Repository
@Transactional
public class DrinkDao {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void save(Drink drink) {
		getSession().save(drink);
		return;
	}

	public void delete(Drink drink) {
		getSession().delete(drink);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<Drink> getAll() {
		return getSession().createCriteria(Drink.class).list();
	}

	public Drink getById(long id) {
		return (Drink) getSession().load(Drink.class, id);
	}

	public Drink getByName(String drinkName) {
		return (Drink) getSession().load(Drink.class, drinkName);
	}

	public void update(Drink drink) {
		getSession().update(drink);
		return;
	}

} // class UserDao
