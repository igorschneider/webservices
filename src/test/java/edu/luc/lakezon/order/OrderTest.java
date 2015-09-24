package edu.luc.lakezon.order;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.customer.Address;
import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.order.Order;
import edu.luc.lakezon.product.Product;
import edu.luc.lakezon.product.ProductOwner;

public class OrderTest {
	
	@Test
	public void testSave() {
		
		Address addressTest = new Address();
		addressTest.setAddressline1("Rua tal");
		addressTest.setAddressline2("Numero tal");
		addressTest.setCity("Chicagouo");
		addressTest.setCountry("USA");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);
		
		Customer customerTest = new Customer();
		customerTest.setAddress(addressTest);
		Calendar rightNow = Calendar.getInstance();
		customerTest.setBirthdate(rightNow);
		customerTest.setGender("M");
		customerTest.setName("Robertson");
		customerTest.setPassword("mamamiaaaaa");
		
//		ProductOwner productOwnerTest = new ProductOwner();
//		productOwnerTest.setName("Amazon");
//
//		Product productTest= new Product();
//		productTest.setName("Product1");
//		productTest.setDescription("Description1");
//		productTest.setQuantity(10);
//		productTest.setImg("Image1");
//		productTest.setProductOwner(productOwnerTest);
		
		Order orderTest = new Order();
		orderTest.setCustomer(customerTest);
		orderTest.setOrderDate(rightNow);

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
