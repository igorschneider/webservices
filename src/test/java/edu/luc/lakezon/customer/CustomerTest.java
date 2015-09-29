package edu.luc.lakezon.customer;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.factory.*;

public class CustomerTest {

	private Customer customer = new Customer();
	private CustomerDAO customerDAO;
	private Customer custT = TestFactory.initCustomer();
	private Customer custC;
	private String newName = "Anthony";

	@Test
	public void testGetterSetterId() {
		Integer idExpected = 5;
		customer.setCustomerId(idExpected);

		Integer idActual = 0;
		idActual = customer.getCustomerId();

		assertTrue(idActual == idExpected);
	}

	@Test
	public void testGetterSetterName() {
		String nameExpected = "Customer A";
		customer.setName(nameExpected);

		String nameActual = "";
		nameActual = customer.getName();

		assertTrue(nameActual == nameExpected);
	}

	@Test
	public void testGetterSetterGender() {
		String genderExpected = "M";
		customer.setGender(genderExpected);

		String genderActual = "";
		genderActual = customer.getGender();

		assertTrue(genderActual == genderExpected);
	}

	@Test
	public void testGetterSetterBirthdate() {
		Calendar birthdateExpected = Calendar.getInstance();
		customer.setBirthdate(birthdateExpected);

		Calendar birthdateActual;
		birthdateActual = customer.getBirthdate();

		assertTrue(birthdateActual == birthdateExpected);
	}

	@Test
	public void testGetterSetterAddress() {
		Address addressExpected = new Address();
		customer.setAddress(addressExpected);

		Address addressActual;
		addressActual = customer.getAddress();

		assertTrue(addressActual == addressExpected);
	}

	@Test
	public void testGetterSetterPassword() {
		String passwordExpected = "***";
		customer.setPassword(passwordExpected);

		String passwordActual = "";
		passwordActual = customer.getPassword();

		assertTrue(passwordActual == passwordExpected);
	}

	@Test
	public void testGetterSetterOrdersList() {
		Set<Order> ordersListExpected = new HashSet<Order>(0);
		customer.setOrdersList(ordersListExpected);

		Set<Order> ordersListActual;
		ordersListActual = customer.getOrdersList();

		assertTrue(ordersListActual == ordersListExpected);
	}

	@Test
	public void testCRUD() {

		customerDAO = new CustomerDAO();

		// TESTING CREATE
		customerDAO.save(custT);

		// Assert the id is set
		assertTrue("ID is set", custT.getCustomerId() != 0);

		// Search for the customer
		custC = customerDAO.getById(custT.getCustomerId());

		// Assert that the customer was correctly saved
		assertTrue("Name added is different from the name returned",
				(custC.getName()).equals(custT.getName()));

		// TESTING UPDATE

		// Change the customer name
		custT.setName(newName);

		// Update the object
		customerDAO.update(custT);

		//Search for the updated customer
		custC = customerDAO.getById(custT.getCustomerId());

		// Assert that the customer was correctly updated
		assertTrue("Customer was no updated correctly",
				(custC.getName()).equals(newName));

		// TESTING DELETE
		customerDAO.delete(custT);

		//Search for the deleted customer
		custC = customerDAO.getById(custT.getCustomerId());

		// Assert that the customer was correctly deleted
		assertTrue("Delete query did not delete", custC == null);
	}

}
