package application.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import application.entities.Neighbourhood;

/**
 * Handles Neighbourhood Entity CRUD operations using Hibernate session
 * @author Sean
 *
 */
@Repository
@Transactional
public class NeighbourhoodDao {

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
	 * @param neighbourhood to be saved
	 */
	public void save(Neighbourhood neighbourhood) {
		getSession().save(neighbourhood);
	}

	/**
	 * 
	 * @param neighbourhood to be deleted
	 */
	public void delete(Neighbourhood neighbourhood) {
		getSession().delete(neighbourhood);
	}
	
	/**
	 * 
	 * @param id from controller
	 * @return neighbourhood that matches id
	 */
	public Neighbourhood getById(long id) {
		Neighbourhood neighbourhood = (Neighbourhood) getSession().get(Neighbourhood.class, id);
		return neighbourhood;
	}

	/**
	 * 
	 * @return list of neighbourhoods
	 */
	public List<Neighbourhood> getAllNeighbourhoods() {
		List<Neighbourhood> neighbourhoods = getSession().createCriteria(Neighbourhood.class).list();
		return neighbourhoods;
	}

} 