package edu.luc.lakezon.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class BaseDAO<T> {

	protected static SessionFactory sessionFactory;
	protected static Session session;
	protected Query query;

	public BaseDAO() {
		prepareSession();
	}

//	@Override
//	public void finalize() throws Throwable {
//		if (sessionFactory != null) {
//			session.close();
//			sessionFactory.close();
//		}
//
//		super.finalize();
//	}
	
	private void prepareSession() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
		}
		else if (!(session.isOpen())) {
			session = sessionFactory.openSession();
		}
	}

	public void save(T t) {
		prepareSession();
		
		session.beginTransaction();

		session.save(t);

		session.getTransaction().commit();
	}

	public void update(T t) {
		prepareSession();
		
		session.beginTransaction();

		session.update(t);

		session.getTransaction().commit();
	}

	public void delete(T t) {
		prepareSession();
		
		session.beginTransaction();

		session.delete(t);

		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public Set<T> getAll(String table) {		
		prepareSession();
		
		Set<T> setT = null;
		
		session.beginTransaction();

		query = session.createQuery("from " + table);

		try {
			setT = new HashSet<T>(query.list());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		session.getTransaction().commit();
		
		return setT;
	}
	
	@SuppressWarnings("unchecked")
	public Set<T> getAllById(Integer id, String table, String field) {		
		prepareSession();
		
		Set<T> setT = null;
		
		session.beginTransaction();

		query = session.createQuery("from " + table + " where " + field + " = :" + field);
		query.setParameter(field, id);

		try {
			setT = new HashSet<T>(query.list());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		session.getTransaction().commit();
		
		return setT;
	}
	
	public T getById(Integer id, String table, String field) {
		prepareSession();
		
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
		prepareSession();
		
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
