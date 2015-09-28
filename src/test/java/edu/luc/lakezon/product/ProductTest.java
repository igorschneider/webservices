package edu.luc.lakezon.product;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class ProductTest {

	@Test
	public void test() {


		ProductOwner productOwner = new ProductOwner();
		productOwner.setName("Amazon11333");

		Product product= new Product();
		product.setName("Product1133");
		product.setDescription("Description11");
		product.setQuantity(10);
		product.setImg("Image11");
		product.setProductOwner(productOwner);
		
		Product product2= new Product();
		product2.setName("Product2133");
		product2.setDescription("Description21");
		product2.setQuantity(12);
		product2.setImg("Image21");
		product2.setProductOwner(productOwner);

		(productOwner.getProductsList()).add(product);
		(productOwner.getProductsList()).add(product2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(productOwner);
		

		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
		assertTrue(true);
	}
//	
//	
//	@Test
//	public void testCRUD() {
//		
//		// Create a ProductOwner object
//		ProductOwner productOwner = new ProductOwner();
//		productOwner.setName("CRUD PRODUCT");
//		
//		// Create product
//		Product product= new Product();
//		product.setName("ProductCRUD");
//		product.setDescription("DescriptionCRUD");
//		product.setQuantity(11);
//		product.setImg("ImageCRUD");
//		product.setProductOwner(productOwner);
//		
//		// Begin the transaction
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		// Create the query to search for the product
//		Query query = session.createQuery("from Product where name = :product");
//		query.setParameter("product", product.getName());
//
//		// Assert product is not in the database
//		assertTrue(query.list().isEmpty());
//		
//		// Insert the object into the table
//		session.save(product);
//		
//		// Assert the id is set
//		assertTrue(product.getProductId() != 0);
//		
//		// Assert product is in the database
//		assertFalse(query.list().isEmpty());
//		
//		// Change the product name
//		product.setName("Product CRUD CHANGE");
//
//		// Update the object
//		session.update(product);
//		
//		// Assert Product is not in the database
//		assertTrue(query.list().isEmpty());
//		
//		// Change the query to search for the new name
//		query.setParameter("product", product.getName());
//
//		// Assert new product  is in the database
//		assertFalse(query.list().isEmpty());
//		
////		// Delete the object
////		session.delete(product);
//		
//		// Assert new product is not in the database
////		assertTrue(query.list().isEmpty());
//		
//		// Commit the transaction
//		session.getTransaction().commit();
//		session.close();
//		sessionFactory.close();
//	}
//

}
