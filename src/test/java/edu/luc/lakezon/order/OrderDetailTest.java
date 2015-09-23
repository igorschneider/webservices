package edu.luc.lakezon.order;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.order.Order;
import edu.luc.lakezon.product.Product;
import edu.luc.lakezon.product.ProductOwner;


public class OrderDetailTest {
	
	
	@Test
	public void testSave() {
			
		
		Product productTest = new Product();
		
		ProductOwner productOwnerTest = new ProductOwner();
		productOwnerTest.setName("DynkSA");

		productTest.setName("Amendoin");
		productTest.setDescription("Amendoin da alegria");
		productTest.setQuantity(10);
		productTest.setImg("Image4");
		productTest.setProductOwner(productOwnerTest);
		
		Order orderTest = new Order();
		Calendar rightNow = Calendar.getInstance();
		orderTest.setOrderDate(rightNow);
//		orderTest.setCustomer(customerTest);
//		(orderTest.getListOrderDetail()).add(orderDetailTest);
		orderTest.setStatus(Status.PROCESSING);
		OrderDetail orderDetailTest = new OrderDetail(orderTest,productTest,3);
		orderTest.addListOrderDetail(orderDetailTest);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		session.save(orderDetailTest);

		
			
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
			
		assertTrue(true);
	}
}
