package javaGUI;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();    
    

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
