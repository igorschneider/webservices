package edu.luc.lakezon.business.product;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.product.Product;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "reviewid_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
	@Column(name = "reviewid")
	private Integer reviewId;
	
	@Column(name = "rating")
	private Integer rating;

	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@Column(name = "reviewdate")
	private Calendar reviewDate;

	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
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
