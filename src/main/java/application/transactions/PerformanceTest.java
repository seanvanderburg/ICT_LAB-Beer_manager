package application.transactions;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.query.dsl.QueryBuilder;

import application.entities.Bottle;
import application.entities.Drink;

public class PerformanceTest {
	public static void runtest() {
		for (int i = 0; i < 100; i++) {

			Session session = (Session) HibernateUtil.createSessionFactory()
					.getCurrentSession();

			session.beginTransaction();
			Criteria criteria = session.createCriteria(Drink.class);

			Drink drink = (Drink) criteria.add(
					Restrictions.eq("drinkName", "Testbier")).uniqueResult();

			Bottle bottle = new Bottle();
			bottle.setDateScanned("2017-21-8");
			bottle.setDrink(drink);
			session.save(bottle);

			session.getTransaction().commit();

		}

	}

}
