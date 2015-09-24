package edu.luc.lakezon.product;


import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import edu.luc.lakezon.product.ProductOwner;

public class ProductOwnerTest {

	@Test
	public void testGetterSetter() {
		
		// Create a ProductOwner object
		ProductOwner productOwner = new ProductOwner();

		// Set the id
		Integer idExpected = 5;
		productOwner.setProductOwnerId(idExpected);
		
		// Get the id
		Integer idActual = 0;
		idActual = productOwner.getProductOwnerId();
		
		// Assert the id is set and get correctly
		assertTrue(idActual == idExpected);

		// Set the name
		String nameExpected = "Company A";
		productOwner.setName(nameExpected);
		
		// Get the name
		String nameActual = "";
		nameActual = productOwner.getName();
		
		// Assert the name is set and get correctly
		assertTrue(nameActual == nameExpected);
	}
	
	@Test
	public void testCRUD() {
		
		// Create a ProductOwner object
		ProductOwner productOwner = new ProductOwner();
		productOwner.setName("Company A");
		
		// Begin the transaction
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Create the query to search for the product owner
		Query query = session.createQuery("from ProductOwner where name = :company");
		query.setParameter("company", productOwner.getName());

		// Assert Company A is not in the database
		assertTrue(query.list().isEmpty());
		
		// Insert the object into the table
		session.save(productOwner);
		
		// Assert the id is set
		assertTrue(productOwner.getProductOwnerId() != 0);
		
		// Assert Company A is in the database
		assertFalse(query.list().isEmpty());
		
		// Change the product owner name
		productOwner.setName("Company B");

		// Update the object
		session.update(productOwner);
		
		// Assert Company A is not in the database
		assertTrue(query.list().isEmpty());
		
		// Change the query to search for the new name
		query.setParameter("company", productOwner.getName());

		// Assert Company B is in the database
		assertFalse(query.list().isEmpty());
		
		// Delete the object
		session.delete(productOwner);
		
		// Assert Company B is not in the database
		assertTrue(query.list().isEmpty());
		
		// Commit the transaction
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
