package edu.luc.lakezon.product;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class ProductTest {

	@Test
	public void test() {

		ProductOwner productOwner = new ProductOwner();
		productOwner.setName("Amazon");

		Product product= new Product();
		product.setName("Product1");
		product.setDescription("Description1");
		product.setQuantity(10);
		product.setImg("Image1");
		product.setProductOwner(productOwner);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(product);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		assertTrue(true);
	}

}
