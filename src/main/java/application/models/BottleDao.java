package application.models;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import application.entities.Bottle;

@Repository
@Transactional
public class BottleDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(Bottle bottle) {
    getSession().save(bottle);
    return;
  }
  
  public void delete(Bottle bottle) {
    getSession().delete(bottle);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Bottle> getAll() {
    return getSession().createQuery("from Bottle").list();
  }
  
  public Bottle getById(long id) {
    return (Bottle) getSession().load(Bottle.class, id);
  }

  public void update(Bottle bottle) {
    getSession().update(bottle);
    return;
  }

} // class UserDao
