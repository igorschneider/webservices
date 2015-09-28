package edu.luc.lakezon.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

}
