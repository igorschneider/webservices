package edu.luc.lakezon.product;


import static org.junit.Assert.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.product.ProductOwner;

public class ProductOwnerTest {

	@Test
	public void testSave() {
		
		ProductOwner productOwner = new ProductOwner();
		productOwner.setName("Larry");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(productOwner);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		assertTrue(true);
	}

}
