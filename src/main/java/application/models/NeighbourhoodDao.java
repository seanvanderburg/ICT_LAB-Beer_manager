package application.models;

import java.util.List;

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
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(Neighbourhood neig) {
    getSession().save(neig);
    return;
  }
  
  public void delete(Neighbourhood neig) {
    getSession().delete(neig);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Neighbourhood> getAll() {
    return getSession().createQuery("from Neighbourhood").list();
  }
  

  public Neighbourhood getById(long id) {
    return (Neighbourhood) getSession().load(Neighbourhood.class, id);
  }

  public void update(Neighbourhood neig) {
    getSession().update(neig);
    return;
  }

} // class UserDao
