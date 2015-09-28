package edu.luc.lakezon.product;


import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.product.ProductOwner;

public class ProductOwnerTest {

	ProductOwner productOwner = new ProductOwner();
	
	@Test
	public void testGetterSetterId() {
		Integer idExpected = 5;
		productOwner.setProductOwnerId(idExpected);
		
		Integer idActual = 0;
		idActual = productOwner.getProductOwnerId();
		
		assertTrue(idActual == idExpected);
	}
	
	@Test
	public void testGetterSetterName() {
		String nameExpected = "Company A";
		productOwner.setName(nameExpected);
		
		String nameActual = "";
		nameActual = productOwner.getName();
		
		assertTrue(nameActual == nameExpected);
	}
	
	@Test
	public void testGetterSetterProductsList() {
		Set<Product> productsListExpected = new HashSet<Product>(0);
		productOwner.setProductsList(productsListExpected);
		
		Set<Product> productsListActual;
		productsListActual = productOwner.getProductsList();
		
		assertTrue(productsListActual == productsListExpected);
	}
	
	@Test
	public void testCRUD() {
		
	/*	//CREATING ADDRESS
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
	*/}
}
