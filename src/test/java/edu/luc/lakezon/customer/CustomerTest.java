package edu.luc.lakezon.customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import edu.luc.lakezon.factory.*;

public class CustomerTest {
	private Customer custT= TestFactory.initCustomer();
	private String newName="Anthony";
	
	@Test
	public void testCRUD() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// TESTING CREATE
		session.save(custT);

		// Assert the id is set
		assertTrue("ID is set", custT.getCustomerId() != 0);
		
		// Create the query to search for the customer
		Query query = session.createQuery("from Customer where customerId = :customerID");
		query.setParameter("customerID", custT.getCustomerId());
		
		// Assert that the customer was correctly saved
		try {
			Iterator<Customer> i;
			i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				Customer c = (Customer) i.next();
				assertTrue("Name added is different from the name returned",(c.getName()).equals(custT.getName()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// TESTING UPDATE
		
		// Create the query to search for the customer
		query = session.createQuery("from Customer where customerId = :customerID");
		query.setParameter("customerID", custT.getCustomerId());
				
		// Change the customer name
		custT.setName(newName);
		
		// Update the object
		session.update(custT);
		
		//Create the query to search for the updated customer
		query = session.createQuery("from Customer where customerId = :customerID");
		query.setParameter("customerID", custT.getCustomerId());
		
		assertFalse(query.list().isEmpty());
		
		// Assert that the customer was correctly updated
				try {
					Iterator<Customer> i;
					i = (Iterator<Customer>) query.list().iterator();
					if (i != null && i.hasNext()) {
						Customer c = (Customer) i.next();
						assertTrue("Customer was no updated correctly",(c.getName()).equals(newName));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		
		// TESTING DELETE
		session.delete(custT);
		assertTrue("Delete query did not delete", query.list().isEmpty());
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
		
	}	
}
