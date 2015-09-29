package edu.luc.lakezon.order;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.business.order.OrderDetail;
import edu.luc.lakezon.business.order.Status;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.dao.order.OrderDAO;
import edu.luc.lakezon.dao.order.OrderDetailDAO;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.factory.TestFactory;

public class OrderDetailTest {

	OrderDetail orderDetailTest = TestFactory.initOrderDetail();
	private Customer custT= TestFactory.initCustomer();
	private Product prodT = TestFactory.initProduct();
	private Calendar rightNow = Calendar.getInstance();
	private Order ordT = new Order();
	private OrderDetail orderDetail = new OrderDetail();
	private OrderDetailDAO orderDetailDAO;
	private OrderDAO orderDAO;
	private ProductDAO productDAO;
	private CustomerDAO customerDAO;

	@Test
	public void testGetterSetterId() {
		Order orderN = TestFactory.initOrder();
		Product productN = TestFactory.initProduct();
		Integer orderIdExpected = 5;
		Integer productIdExpected = 6;
		orderN.setOrderId(orderIdExpected);
		productN.setProductId(productIdExpected);

		orderDetail.setOrder(orderN);
		orderDetail.setProduct(productN);

		Integer orderIdActual = 0;
		Integer productIdActual = 0;
		orderIdActual = orderDetail.getOrder().getOrderId();
		productIdActual = orderDetail.getProduct().getProductId();

		assertTrue((orderIdActual == orderIdExpected)&&(productIdActual == productIdExpected));
	}

	@Test
	public void testGetterSetterQuantity() {
		Integer quantExpected = 5;
		orderDetail.setQuantity(quantExpected);

		Integer quantActual = 0;
		quantActual = orderDetail.getQuantity();

		assertTrue(quantActual == quantExpected);
	}

	@Test
	public void testCRUD() {

		orderDetailDAO = new OrderDetailDAO();
		orderDAO = new OrderDAO();
		productDAO = new ProductDAO();
		customerDAO = new CustomerDAO();

		customerDAO.save(custT);
		ordT.setCustomer(custT);
		ordT.setOrderDate(rightNow);
		ordT.setStatus(Status.PROCESSING);
		orderDAO.save(ordT);
		ProductOwnerDAO productOwnerDAO = new ProductOwnerDAO();
		productOwnerDAO.save(prodT.getProductOwner());
		productDAO.save(prodT);

		// TESTING CREATE
		OrderDetail ordDT = new OrderDetail();
		ordDT.setOrder(ordT);
		ordDT.setProduct(prodT);
		ordDT.setQuantity(55);
		orderDetailDAO.save(ordDT);

		// Assert the id is set
		assertTrue("ID is set",
				(ordDT.getOrder().getOrderId() != 0)&&(ordDT.getProduct().getProductId() != 0));

		// Search for the orderDetail
		orderDetailDAO.getById(ordDT.getOrder().getOrderId(),ordDT.getProduct().getProductId());

		// TESTING UPDATE

		// Change the Quantity
		ordDT.setQuantity(5);

		// Update the database
		orderDetailDAO.update(ordDT);

		// Assert that the quantity was correctly updated
		assertTrue("Quantity was no updated correctly",
				(orderDetailDAO.getById(ordDT.getOrder().getOrderId(),ordDT.getProduct().getProductId()).getQuantity() == 5));

		// TESTING DELETE
		orderDetailDAO.delete(ordDT);

		// Assert that the orderDetail was correctly deleted
		assertTrue("Delete query did not delete",
				orderDetailDAO.getById(ordDT.getOrder().getOrderId(),ordDT.getProduct().getProductId()) == null);
	}

}
