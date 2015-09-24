package edu.luc.lakezon.customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Iterator;

public class CustomerTest {

	Calendar rightNow = Calendar.getInstance();
	
	private boolean isSameDay(Calendar cal1, Calendar cal2) {
		if (cal1 == null || cal2 == null)
			return false;
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
	}
	
	
	@Test
	public void testSave() {

		Address addressTest = new Address();
		addressTest.setAddressline1("N SHERIDAN AVE");
		addressTest.setAddressline2("APT 1324");
		addressTest.setCity("Chicago");
		addressTest.setCountry("US");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);
		Customer customerTest = new Customer();
		customerTest.setAddress(addressTest);
		customerTest.setBirthdate(rightNow);
		customerTest.setGender("M");
		customerTest.setName("Joseph Smith");
		customerTest.setPassword("4588");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(customerTest);

		// Create the query to search for the customer
		Query query = session.createQuery("from Customer where name = 'joseph'");
		// Assert Company A is not in the database
		try {
			Iterator<Customer> i;
			i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				Customer c = (Customer) i.next();
				assertTrue((c.getName()).equals("joseph") && isSameDay(c.getBirthdate(), rightNow));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
		
}
