package edu.luc.lakezon.product;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import edu.luc.lakezon.customer.Customer;

public class ReviewTest {

	private Review review = new Review();
	
	@Test
	public void testGetterSetterId() {
		Integer idExpected = 5;
		review.setReviewId(idExpected);
		
		Integer idActual = 0;
		idActual = review.getReviewId();
		
		assertTrue(idActual == idExpected);
	}

	@Test
	public void testGetterSetterRating() {
		Integer ratingExpected = 5;
		review.setRating(ratingExpected);
		
		Integer ratingActual = 0;
		ratingActual = review.getRating();
		
		assertTrue(ratingActual == ratingExpected);
	}

	@Test
	public void testGetterSetterDescription() {
		String descriptionExpected = "Review description";
		review.setDescription(descriptionExpected);
		
		String descriptionActual = "";
		descriptionActual = review.getDescription();
		
		assertTrue(descriptionActual == descriptionExpected);
	}
	
	@Test
	public void testGetterSetterDate() {
		Calendar dateExpected = Calendar.getInstance();
		review.setReviewDate(dateExpected);
		
		Calendar dateActual;
		dateActual = review.getReviewDate();
		
		assertTrue(dateActual == dateExpected);
	}

	@Test
	public void testGetterSetterCustomer() {
		Customer customerExpected = new Customer();
		review.setCustomer(customerExpected);

		Customer customerActual;
		customerActual = review.getCustomer();

		assertTrue(customerActual == customerExpected);
	}

	@Test
	public void testGetterSetterProduct() {
		Product productExpected = new Product();
		review.setProduct(productExpected);

		Product productActual;
		productActual = review.getProduct();

		assertTrue(productActual == productExpected);
	}

}
