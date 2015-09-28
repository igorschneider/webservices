package edu.luc.lakezon.dao.customer;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.luc.lakezon.customer.Customer;

public class CustomerDAO {

	private SessionFactory sessionFactory;
	private Session session;
	private Query query;

	public CustomerDAO() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	@Override
	public void finalize() throws Throwable {
		session.close();
		sessionFactory.close();
		
		super.finalize();
	}
	
	public void save(Customer customer) {
		session.beginTransaction();

		session.save(customer);
		
		session.getTransaction().commit();
	}
	
	public void update(Customer customer) {
		session.beginTransaction();

		session.save(customer);
		
		session.getTransaction().commit();
	}
	
	public void delete(Customer customer) {
		session.beginTransaction();

		session.delete(customer);
		
		session.getTransaction().commit();
	}
	
	public Customer getById(Integer id) {
		Customer customer = null;
		
		session.beginTransaction();

		query = session.createQuery("from Customer where customerId = :customerID");
		query.setParameter("customerID", id);
		
		try {
			Iterator<Customer> i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				customer = (Customer) i.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		session.getTransaction().commit();

		return customer;
	}
	
}
