package edu.luc.lakezon.customer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Calendar;

public class CustomerTest {


	@Test
	public void testSave() {
		
		Address addressTest = new Address();
		addressTest.setAddressline1("Rua tal");
		addressTest.setAddressline2("Numero tal");
		addressTest.setCity("Chicagouo");
		addressTest.setCountry("USA");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);
		
		Customer customerTest = new Customer();
		customerTest.setAddress(addressTest);
		Calendar rightNow = Calendar.getInstance();
		customerTest.setBirthdate(rightNow);
		customerTest.setGender("M");
		customerTest.setName("Robertson");
		customerTest.setPassword("mamamiaaaaa");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(customerTest);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		assertTrue(true);
	
}
	
	
	
}
