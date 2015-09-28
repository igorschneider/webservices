package edu.luc.lakezon.customer;

import org.junit.Test;

import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.dao.customer.AddressDAO;
import edu.luc.lakezon.factory.TestFactory;

import static org.junit.Assert.*;

public class AddressTest {

	private Address address = new Address();
	Address addressTest = TestFactory.initAddress();
	private AddressDAO addressDAO = new AddressDAO();
	
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
	public void testCRUD() {
		
	//CREATING ADDRESS
	addressDAO.save(addressTest);
	
	// Assert the id is set
			assertTrue("ID is set", addressTest.getAddressId() != 0);
			
			// Search for the address
			 addressDAO.getById(addressTest.getAddressId());

			// TESTING UPDATE
			
			// Change the address
			addressTest.setAddressline1("NEW ADDRESS LINE");
			addressTest.setCountry("BRAZIL");
			
			// Update the db
			addressDAO.update(addressTest);
						
			// Assert that the customer was correctly updated
		     assertTrue("Address was no updated correctly", (addressDAO.getById(addressTest.getAddressId()).getCountry().equals("BRAZIL")));
			
			// TESTING DELETE
			addressDAO.delete(addressTest);
			
			// Assert that the customer was correctly deleted
			assertTrue("Delete query did not delete", addressDAO.getById(addressTest.getAddressId()) == null);	
	}
}
