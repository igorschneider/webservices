package edu.luc.lakezon.product;
import java.util.Calendar;

import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.product.Product;

public class Review {

	private int rating;
	private String description;
	private Customer customer;
	private Product product;
	private Calendar reviewDate;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Calendar getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Calendar reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
	
}
