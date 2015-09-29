package edu.luc.lakezon.product;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.factory.TestFactory;

public class ProductOwnerTest {

	private ProductOwner productOwner = TestFactory.initProductOwner();
	private ProductOwner productOwnerB;
	private ProductOwnerDAO productOwnerDAO;
	private String newName = "Lakezon Warehouse";

	@Test
	public void testGetterSetterId() {
		Integer idExpected = 5;
		productOwner.setProductOwnerId(idExpected);

		Integer idActual = 0;
		idActual = productOwner.getProductOwnerId();

		assertTrue(idActual == idExpected);
	}

	@Test
	public void testGetterSetterName() {
		String nameExpected = "Company A";
		productOwner.setName(nameExpected);

		String nameActual = "";
		nameActual = productOwner.getName();

		assertTrue(nameActual == nameExpected);
	}

	@Test
	public void testGetterSetterProductsList() {
		Set<Product> productsListExpected = new HashSet<Product>(0);
		productOwner.setProductsList(productsListExpected);

		Set<Product> productsListActual;
		productsListActual = productOwner.getProductsList();

		assertTrue(productsListActual == productsListExpected);
	}

	@Test
	public void testCRUD() {

		productOwnerDAO = new ProductOwnerDAO();

		// TESTING CREATE
		productOwnerDAO.save(productOwner);

		// Assert the id is set
		assertTrue("ID is set", productOwner.getProductOwnerId() != 0);

		// Search for the product owner
		productOwnerB = productOwnerDAO.getById(productOwner.getProductOwnerId());

		// Assert that the product owner was correctly saved
		assertTrue("Name added is different from the name returned",
				(productOwnerB.getName()).equals(productOwner.getName()));

		// TESTING UPDATE

		// Change the product owner name
		productOwner.setName(newName);

		// Update the database
		productOwnerDAO.update(productOwner);

		// Assert that the product owner was correctly updated
		assertTrue("Address was no updated correctly",
				(productOwnerDAO.getById(productOwner.getProductOwnerId()).getName().equals(newName)));

		// TESTING DELETE
		productOwnerDAO.delete(productOwner);

		// Assert that the product owner was correctly deleted
		assertTrue("Delete query did not delete",
				productOwnerDAO.getById(productOwner.getProductOwnerId()) == null);	
	}

}
