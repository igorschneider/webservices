package edu.luc.lakezon.dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class BaseDAO<T> {

	protected static SessionFactory sessionFactory;
	protected static Session session;
	protected Query query;

	public BaseDAO() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		}
	}

	@Override
	public void finalize() throws Throwable {
		if (sessionFactory != null) {
			session.close();
			sessionFactory.close();
		}

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
			@SuppressWarnings("unchecked")
			Iterator<T> i = (Iterator<T>) query.list().iterator();
			if (i != null && i.hasNext()) {
				t = (T) i.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		session.getTransaction().commit();

		return t;
	}

	public T getById(Integer id1, Integer id2,String table, String field1, String field2) {
		T t = null;

		session.beginTransaction();

		query = session.createQuery("from " + table + " where " + field1 + " = :" + field1 +" AND "+ field2 + " = :" + field2);
		query.setParameter(field1, id1);
		query.setParameter(field2, id2);

		try {
			@SuppressWarnings("unchecked")
			Iterator<T> i = (Iterator<T>) query.list().iterator();
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
