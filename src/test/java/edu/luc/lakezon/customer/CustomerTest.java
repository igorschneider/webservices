
package edu.luc.lakezon.customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import edu.luc.lakezon.factory.*;

public class CustomerTest {

	
	
	@Test
	public void testSave() {
		Customer custT= new Customer();
		custT= TestFactory.initCustomer();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(custT);

		// Assert the id is set
		assertTrue(custT.getCustomerId() != 0);
		
		// Create the query to search for the customer
		Query query = session.createQuery("from Customer where customerid = :customerID");
		query.setParameter("customerID", custT.getCustomerId());
		
		// Assert that the customer was correctly saved
		try {
			Iterator<Customer> i;
			i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				Customer c = (Customer) i.next();
				System.out.println((c.getName()).equals(custT.getName()));
				assertTrue((c.getName()).equals(custT.getName()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	
	@Test
	public void testUpdate() {
		
				
		Customer custT= new Customer();
		custT= TestFactory.initCustomer();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println(custT.getName());
		
		System.out.println("id" + custT.getCustomerId());
		
		// Create the query to search for the customer
		Query query = session.createQuery("from Customer where customerid = :customerID");
		query.setParameter("customerID", custT.getCustomerId());
		
		System.out.println(query.list().size());
		
		// Change the product owner name
		//custT.setName("Jerry");
		//custT.setBirthdate(calendar);

	
		// Update the object
		//session.update(custT);
		
		
		/*
		// Create the query to search for the customer
		query = session.createQuery("from customer where name = :customerName AND birthdate = :birthDate");
		query.setParameter("customerName", "Jerry");
		query.setParameter("birthDate", calendar);
		
		
		try {
			Iterator<Customer> i;
			i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				Customer c = (Customer) i.next();
				assertTrue((c.getName()).equals("Jerry"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
	
	}
	
	
	
	@Test
	public void testDelete() {
		
	}
	
	
	
	
	
}
