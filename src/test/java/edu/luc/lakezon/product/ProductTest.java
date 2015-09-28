package edu.luc.lakezon.product;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.factory.TestFactory;

public class ProductTest {

	Product product = new Product();
	Product productTest = TestFactory.initProduct();

	@Test
	public void testGetterSetterId() {
		Integer idExpected = 5;
		product.setProductId(idExpected);

		Integer idActual = 0;
		idActual = product.getProductId();

		assertTrue(idActual == idExpected);
	}

	@Test
	public void testGetterSetterName() {
		String nameExpected = "Product 1";
		product.setName(nameExpected);

		String nameActual = "";
		nameActual = product.getName();

		assertTrue(nameActual == nameExpected);
	}

	@Test
	public void testGetterSetterDescription() {
		String descriptionExpected = "Description 1";
		product.setDescription(descriptionExpected);

		String descriptionActual = "";
		descriptionActual = product.getDescription();

		assertTrue(descriptionActual == descriptionExpected);
	}

	@Test
	public void testGetterSetterQuantity() {
		Integer quantityExpected = 5;
		product.setQuantity(quantityExpected);

		Integer quantityActual = 0;
		quantityActual = product.getQuantity();

		assertTrue(quantityActual == quantityExpected);
	}

	@Test
	public void testGetterSetterImage() {
		String imageExpected = "Image URL";
		product.setImg(imageExpected);

		String imageActual = "";
		imageActual = product.getImg();

		assertTrue(imageActual == imageExpected);
	}
	
	@Test
	public void testGetterSetterPrice() {
		Double priceExpected = 5.55;
		product.setPrice(priceExpected);

		Double priceActual = 0.00;
		priceActual = product.getPrice();

		assertTrue(priceActual == priceExpected);
	}

	@Test
	public void testGetterSetterProductOwner() {
		ProductOwner productOwnerExpected = new ProductOwner();
		product.setProductOwner(productOwnerExpected);

		ProductOwner productOwnerActual;
		productOwnerActual = product.getProductOwner();

		assertTrue(productOwnerActual == productOwnerExpected);
	}

	@Test
	public void testCRUD() {

		ProductDAO productDAO = new ProductDAO();
		ProductOwnerDAO productOwnerDAO = new ProductOwnerDAO();
		productOwnerDAO.save(productTest.getProductOwner());
		// CREATING ADDRESS
		productDAO.save(productTest);

		// Assert the id is set
		assertTrue("ID is set", productTest.getProductId() != 0);

		// Search for the address
		productDAO.getById(productTest.getProductId());

		// TESTING UPDATE

		// Change the address
		productTest.setQuantity(455);

		// Update the db
		productDAO.update(productTest);

		// Assert that the customer was correctly updated
		assertTrue("Product was no updated correctly",
				(productDAO.getById(productTest.getProductId()).getQuantity() == 455));

		// TESTING DELETE
		productDAO.delete(productTest);

		// Assert that the customer was correctly deleted
		assertTrue("Delete query did not delete", productDAO.getById(productTest.getProductId()) == null);
	}

}
