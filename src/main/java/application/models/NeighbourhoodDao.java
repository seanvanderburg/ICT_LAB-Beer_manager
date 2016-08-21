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
import application.entities.Neighbourhood;

@Repository
@Transactional
public class NeighbourhoodDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Neighbourhood neighbourhood) {
		getSession().save(neighbourhood);
	}

	public void delete(Neighbourhood neighbourhood) {
		getSession().delete(neighbourhood);
	}
	
	public Neighbourhood getById(long id) {
		Neighbourhood neighbourhood = (Neighbourhood) getSession().get(Neighbourhood.class, id);
		return neighbourhood;
	}

	public List<Neighbourhood> getAllNeighbourhoods() {
		List<Neighbourhood> neighbourhoods = getSession().createCriteria(Neighbourhood.class).list();
		return neighbourhoods;
	}

} 