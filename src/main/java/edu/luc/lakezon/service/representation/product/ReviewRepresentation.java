package edu.luc.lakezon.service.representation.product;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.luc.lakezon.service.representation.BaseRepresentation;

@XmlRootElement(name = "Review")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ReviewRepresentation extends BaseRepresentation {

	private Integer reviewId;
	private Integer productId;
	private Integer customerId;
	private Integer rating;
	private String description;
	private Calendar reviewDate;

	public ReviewRepresentation() {}

	// Getters and Setters

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Calendar reviewDate) {
		this.reviewDate = reviewDate;
	}

}
