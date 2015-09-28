package edu.luc.lakezon.customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.factory.*;

public class CustomerTest {
	private CustomerDAO customerDAO = new CustomerDAO();
	private Customer custT= TestFactory.initCustomer();
	private Customer custC;
	private String newName="Anthony";
	
	@Test
	public void testCRUD() {
		
		// TESTING CREATE
		customerDAO.save(custT);

		// Assert the id is set
		assertTrue("ID is set", custT.getCustomerId() != 0);
		
		// Search for the customer
		custC = customerDAO.getById(custT.getCustomerId());

		// Assert that the customer was correctly saved
		assertTrue("Name added is different from the name returned", (custC.getName()).equals(custT.getName()));
		
		// TESTING UPDATE
		
		// Change the customer name
		custT.setName(newName);
		
		// Update the object
		customerDAO.update(custT);
		
		//Search for the updated customer
		custC = customerDAO.getById(custT.getCustomerId());
		
		// Assert that the customer was correctly updated
		assertTrue("Customer was no updated correctly", (custC.getName()).equals(newName));
		
		// TESTING DELETE
		customerDAO.delete(custT);

		//Search for the updated customer
		custC = customerDAO.getById(custT.getCustomerId());
		
		// Assert that the customer was correctly deleted
		assertTrue("Delete query did not delete", custC == null);
	}	
}
