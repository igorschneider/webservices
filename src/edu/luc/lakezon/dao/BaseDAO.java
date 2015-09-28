package edu.luc.lakezon.dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.luc.lakezon.customer.Customer;

public abstract class BaseDAO<T> {

	protected SessionFactory sessionFactory;
	protected Session session;
	protected Query query;

	public BaseDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	@Override
	public void finalize() throws Throwable {
		session.close();
		sessionFactory.close();
		
		super.finalize();
	}

	public void save(T t) {
		session.beginTransaction();

		session.save(t);
		
		session.getTransaction().commit();
	}

	public void update(T t) {
		session.beginTransaction();

		session.update(t);
		
		session.getTransaction().commit();
	}

	public void delete(T t) {
		session.beginTransaction();

		session.delete(t);
		
		session.getTransaction().commit();
	}

	public T getById(Integer id, String table, String field) {
		T t = null;
		
		session.beginTransaction();

		query = session.createQuery("from " + table + " where " + field + " = :" + field);
		query.setParameter(field, id);
		
		try {
			Iterator<Customer> i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				t = (T) i.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		session.getTransaction().commit();

		return t;
	}
}
