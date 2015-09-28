package edu.luc.lakezon.order;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.customer.Address;
import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.dao.order.OrderDAO;
import edu.luc.lakezon.dao.order.OrderDetailDAO;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.factory.TestFactory;
import edu.luc.lakezon.order.Order;
import edu.luc.lakezon.product.Product;
import edu.luc.lakezon.product.ProductOwner;

public class OrderTest {
	private OrderDAO orderDAO = new OrderDAO();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	private ProductDAO productDAO = new ProductDAO();
	private Order ordT = new Order();
	private CustomerDAO customerDAO = new CustomerDAO();
	private Product prodT = TestFactory.initProduct();
	private Customer custT= TestFactory.initCustomer();
	private Calendar rightNow = Calendar.getInstance();
//	private OrderDetail ordDT = new OrderDetail(ordT,prodT,3);

//	
//	@Test
//	public void testSave() {
//		
//		Address addressTest = new Address();
//		addressTest.setAddressline1("Rua tal");
//		addressTest.setAddressline2("Numero tal");
//		addressTest.setCity("Chicagouo");
//		addressTest.setCountry("USA");
//		addressTest.setState("Illinois");
//		addressTest.setZipcode(666666);
//		
//		Customer customerTest = new Customer();
//		customerTest.setAddress(addressTest);
//		customerTest.setBirthdate(rightNow);
//		customerTest.setGender("M");
//		customerTest.setName("Robertson");
//		customerTest.setPassword("mamamiaaaaa");
//		
////		ProductOwner productOwnerTest = new ProductOwner();
////		productOwnerTest.setName("Amazon");
////
////		Product productTest= new Product();
////		productTest.setName("Product1");
////		productTest.setDescription("Description1");
////		productTest.setQuantity(10);
////		productTest.setImg("Image1");
////		productTest.setProductOwner(productOwnerTest);
//		
//		Order orderTest = new Order();
//		orderTest.setCustomer(customerTest);
//		orderTest.setOrderDate(rightNow);
//
////		(orderTest.getListOrderDetail()).add(orderDetailTest);
//		orderTest.setStatus(Status.PROCESSING);
////		OrderDetail orderDetailTest = new OrderDetail(orderTest,productTest,3);
////		orderTest.addListOrderDetail(orderDetailTest);
//		
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//
//		session.save(orderTest);
//
//		
//			
//		session.getTransaction().commit();
//		session.close();
//		sessionFactory.close();
//			
//		assertTrue(true);
//	}
//	

	
	@Test
	public void testCRUD() {
		
		
		// TESTING CREATE
//		(ordT.getOrderDetailList()).add(ordDT);
		customerDAO.save(custT);
//		Customer custtt = new Customer();
//		custtt = custT;
		ordT.setCustomer(custT);
		ordT.setOrderDate(rightNow);
		ordT.setStatus(Status.PROCESSING);
		orderDAO.save(ordT);
		ProductOwnerDAO productOwnerDAO = new ProductOwnerDAO();
		productOwnerDAO.save(prodT.getProductOwner());
		productDAO.save(prodT);
		OrderDetail ordDT = new OrderDetail(ordT,prodT,55);
		orderDetailDAO.save(ordDT);
		(ordT.getOrderDetailList()).add(ordDT);
		orderDAO.save(ordT);
//
//		// Assert the id is set
//		assertTrue("ID is set", ordT.getOrderId() != 0);
//		
//		// Search for the order
//		ordC = orderDAO.getById(ordT.getOrderId());
//
//		// Assert that the order was correctly saved
//		assertTrue("Name added is different from the name returned", (ordC.getName()).equals(ordT.getName()));
//		
//		// TESTING UPDATE
//		
//		// Change the order name
//		ordT.setName(newName);
//		
//		// Update the object
//		orderDAO.update(ordT);
//		
//		//Search for the updated order
//		ordC = orderDAO.getById(ordT.getOrderId());
//		
//		// Assert that the order was correctly updated
//		assertTrue("Order was no updated correctly", (ordC.getName()).equals(newName));
//		
//		// TESTING DELETE
//		orderDAO.delete(ordT);
//
//		//Search for the updated order
//		ordC = orderDAO.getById(ordT.getOrderId());
//		
//		// Assert that the order was correctly deleted
//		assertTrue("Delete query did not delete", ordC == null);
	}	

}
