package application.models;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
} 