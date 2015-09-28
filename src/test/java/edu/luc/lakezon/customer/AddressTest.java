package edu.luc.lakezon.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

	private Address address = new Address();
	
	@Test
	public void testGetterSetterId() {
		Integer idExpected = 5;
		address.setAddressId(idExpected);
		
		Integer idActual = 0;
		idActual = address.getAddressId();
		
		assertTrue(idActual == idExpected);
	}
	
	@Test
	public void testGetterSetterLine1() {
		String line1Expected = "1234 N Some Ave";
		address.setAddressline1(line1Expected);
		
		String line1Actual = "";
		line1Actual = address.getAddressline1();
		
		assertTrue(line1Actual == line1Expected);
	}
	
	@Test
	public void testGetterSetterLine2() {
		String line2Expected = "Apt 1001";
		address.setAddressline2(line2Expected);
		
		String line2Actual = "";
		line2Actual = address.getAddressline2();
		
		assertTrue(line2Actual == line2Expected);
	}

	@Test
	public void testGetterSetterZipcode() {
		Integer zipcodeExpected = 60606;
		address.setZipcode(zipcodeExpected);
		
		Integer zipcodeActual = 0;
		zipcodeActual = address.getZipcode();
		
		assertTrue(zipcodeActual == zipcodeExpected);
	}
	
	@Test
	public void testGetterSetterCity() {
		String cityExpected = "Chicago";
		address.setCity(cityExpected);
		
		String cityActual = "";
		cityActual = address.getCity();
		
		assertTrue(cityActual == cityExpected);
	}
	
	@Test
	public void testGetterSetterState() {
		String stateExpected = "IL";
		address.setState(stateExpected);
		
		String stateActual = "";
		stateActual = address.getState();
		
		assertTrue(stateActual == stateExpected);
	}
	
	@Test
	public void testGetterSetterCountry() {
		String countryExpected = "USA";
		address.setCountry(countryExpected);
		
		String countryActual = "";
		countryActual = address.getCountry();
		
		assertTrue(countryActual == countryExpected);
	}
	
	@Test
	public void testSave() {
		
		Address addressTest = new Address();
		addressTest.setAddressline1("Rua tal");
		addressTest.setAddressline2("Numero tal");
		addressTest.setCity("Chicagouo");
		addressTest.setCountry("USA");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(addressTest);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		assertTrue(true);
	}
}
