package edu.luc.lakezon.order;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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
	private Order orderTest = TestFactory.initOrder();
	private Order ordC;
	private CustomerDAO customerDAO = new CustomerDAO();
	private Product prodT = TestFactory.initProduct();
	private Customer custT= TestFactory.initCustomer();
	private Calendar rightNow = Calendar.getInstance();
	private Status newStatus = Status.CANCELED;

	@Test
	public void testGetterSetterId() {
		Integer idExpected = 500;
		orderTest.setOrderId(idExpected);
		
		Integer idActual = 0;
		idActual = orderTest.getOrderId();
		
		assertTrue(idActual == idExpected);
	}
	
	@Test
	public void testGetterSetterOrderDate() {
		Calendar dateExpected = Calendar.getInstance();
		orderTest.setOrderDate(dateExpected);

		Calendar dateActual;
		dateActual = orderTest.getOrderDate();

		assertTrue(dateActual == dateExpected);
	}
	
	@Test
	public void testGetterSetterStatus() {
		Status statusExpected = Status.PROCESSING;
		orderTest.setStatus(statusExpected);

		Status statusActual;
		statusActual = orderTest.getStatus();

		assertTrue(statusActual == statusExpected);
	}
	
	@Test
	public void testGetterSetterCustomer() {
		Customer customerExpected = new Customer();
		orderTest.setCustomer(customerExpected);

		Customer customerActual;
		customerActual = orderTest.getCustomer();

		assertTrue(customerActual == customerExpected);
	}
	
	@Test
	public void testGetterSetterOrderDetailList() {
		Set<OrderDetail> orderDetailListExpected = new HashSet<OrderDetail>(0);
		orderTest.setOrderDetailList(orderDetailListExpected);
		
		Set<OrderDetail> orderDetailListActual;
		orderDetailListActual = orderTest.getOrderDetailList();
		
		assertTrue(orderDetailListActual == orderDetailListExpected);
	}
	

	
	@Test
	public void testCRUD() {
		
		
		// TESTING CREATE
		customerDAO.save(custT);
		ordT.setCustomer(custT);
		ordT.setOrderDate(rightNow);
		ordT.setStatus(Status.PROCESSING);
		orderDAO.save(ordT);
		ProductOwnerDAO productOwnerDAO = new ProductOwnerDAO();
		productOwnerDAO.save(prodT.getProductOwner());
		productDAO.save(prodT);
//		OrderDetail ordDT = new OrderDetail(ordT,prodT,55);
		OrderDetail ordDT = new OrderDetail();
		ordDT.setOrder(ordT);
		ordDT.setProduct(prodT);
		ordDT.setQuantity(55);

		(ordT.getOrderDetailList()).add(ordDT);
		orderDAO.save(ordT);

		// Assert the id is set
		assertTrue("ID is set", ordT.getOrderId() != 0);
		
		// Search for the order
		ordC = orderDAO.getById(ordT.getOrderId());
	
		// TESTING UPDATE
		// Change the date
		Calendar newDate = Calendar.getInstance();
		ordT.setOrderDate(newDate);
		
		// Update the object
		orderDAO.update(ordT);
		
		//Search for the updated order
		ordC = orderDAO.getById(ordT.getOrderId());
		
		// Assert that the order was correctly updated
		assertTrue("Order was no updated correctly", (ordC.getOrderDate()).equals(newDate));
		
		// TESTING DELETE
		orderDAO.delete(ordT);

		//Search for the updated order
		ordC = orderDAO.getById(ordT.getOrderId());
		
		// Assert that the order was correctly deleted
		assertTrue("Delete query did not delete", ordC == null);
	}	

}
