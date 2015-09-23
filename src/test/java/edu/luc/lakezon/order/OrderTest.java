package edu.luc.lakezon.order;

import static org.junit.Assert.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.order.Order;
import edu.luc.lakezon.product.Product;
import edu.luc.lakezon.product.ProductOwner;

public class OrderTest {
	
	@Test
	public void testSave() {
			
		Order orderTest = new Order();
//		Customer customerTest = new Customer();
		Product productTest = new Product();
		
		ProductOwner productOwnerTest = new ProductOwner();
		productOwnerTest.setName("DynkSA");

		productTest.setName("Amendoin");
		productTest.setDescription("Amendoin da alegria");
		productTest.setQuantity(10);
		productTest.setImg("Image4");
		productTest.setProductOwner(productOwnerTest);
		

		orderTest.setOrderDate(null);
//		orderTest.setCustomer(customerTest);
		
//		(orderTest.getListOrderDetail()).add(orderDetailTest);
		orderTest.setStatus(Status.PROCESSING);
//		OrderDetail orderDetailTest = new OrderDetail(orderTest,productTest,3);
//		orderTest.addListOrderDetail(orderDetailTest);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		session.save(orderTest);

		
			
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
			
		assertTrue(true);
	}

}
