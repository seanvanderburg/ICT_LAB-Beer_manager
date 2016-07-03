package application.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		return;
	}

	public void delete(Neighbourhood neighbourhood) {
		getSession().delete(neighbourhood);
		return;
	}

	public List<Neighbourhood> getAllNeighs() {
		Session session = sessionFactory.openSession(); 
		List<Neighbourhood> neighs = session.createCriteria(Neighbourhood.class).list();
		return neighs;
	}

} 