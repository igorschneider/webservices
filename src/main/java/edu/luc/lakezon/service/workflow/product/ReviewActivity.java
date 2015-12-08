package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.business.product.Review;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.dao.product.ReviewDAO;
import edu.luc.lakezon.service.representation.product.ReviewRepresentation;
import edu.luc.lakezon.service.representation.product.ReviewRequest;

public class ReviewActivity {
	

	private ReviewDAO reviewDAO = new ReviewDAO();
	private CustomerDAO customerDAO = new CustomerDAO();
	private ProductDAO productDAO = new ProductDAO();
	
	public Set<ReviewRepresentation> getReviews(String productId, String customerId) {
		
		Set<Review> reviews = null;
		Set<ReviewRepresentation> reviewRepresentations = new HashSet<ReviewRepresentation>();

		if (!(productId.equals(""))) {
			reviews = reviewDAO.getAllByProductId(Integer.parseInt(productId));
		} else {
			reviews = reviewDAO.getAllByCustomerId(Integer.parseInt(customerId));
		}
		
		Iterator<Review> it = reviews.iterator();
		while(it.hasNext()) {
			Review re = (Review)it.next();
			ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
			reviewRepresentation.setReviewId(re.getReviewId());
			reviewRepresentation.setCustomerId(re.getCustomer().getCustomerId());
			reviewRepresentation.setDescription(re.getDescription());
			reviewRepresentation.setProductId(re.getProduct().getProductId());
			reviewRepresentation.setRating(re.getRating());
			reviewRepresentation.setReviewDate(re.getReviewDate());
			
			reviewRepresentations.add(reviewRepresentation);
        }

		return reviewRepresentations;

	}

	public ReviewRepresentation getReview(String reviewId) {
		Review review = reviewDAO.getById(Integer.parseInt(reviewId));
		
		ReviewRepresentation reviewRepresentation = 
				new ReviewRepresentation();

		reviewRepresentation.setReviewId(review.getReviewId());
		reviewRepresentation.setDescription(review.getDescription());
		reviewRepresentation.setProductId(review.getProduct().getProductId());
		reviewRepresentation.setRating(review.getRating());
		reviewRepresentation.setReviewDate(review.getReviewDate());
		reviewRepresentation.setCustomerId(review.getCustomer().getCustomerId());
		
		
		return reviewRepresentation;
	}
	
	public ReviewRepresentation createReview(ReviewRequest reviewRequest) {
		
		Review review = new Review();
		Customer co = customerDAO.getById(reviewRequest.getCustomerId());
		Product prod = productDAO.getById(reviewRequest.getProductId());
		
		review.setCustomer(co);
		review.setProduct(prod);
		review.setRating(reviewRequest.getRating());
		review.setDescription(reviewRequest.getDescription());
		review.setReviewDate(reviewRequest.getReviewDate());
		
		
		reviewDAO.save(review);
		
		ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
		
		reviewRepresentation.setReviewId(review.getReviewId());
		reviewRepresentation.setCustomerId(review.getCustomer().getCustomerId());
		reviewRepresentation.setProductId(review.getProduct().getProductId());
		reviewRepresentation.setDescription(review.getDescription());
		reviewRepresentation.setRating(review.getRating());
		reviewRepresentation.setReviewDate(review.getReviewDate());
		
		return reviewRepresentation;
	}
	
	
	public ReviewRepresentation updateReview(String reviewId, ReviewRequest reviewRequest) {
		
		Review review = reviewDAO.getById(Integer.parseInt(reviewId));
		
		review.setRating(reviewRequest.getRating());
		review.setDescription(reviewRequest.getDescription());
		review.setReviewDate(reviewRequest.getReviewDate());

		reviewDAO.save(review);
		
		ReviewRepresentation reviewRepresentation = new ReviewRepresentation();

		reviewRepresentation.setReviewId(review.getReviewId());
		reviewRepresentation.setCustomerId(review.getCustomer().getCustomerId());
		reviewRepresentation.setProductId(review.getProduct().getProductId());
		reviewRepresentation.setDescription(review.getDescription());
		reviewRepresentation.setRating(review.getRating());
		reviewRepresentation.setReviewDate(review.getReviewDate());
		
		return reviewRepresentation;
	}
	
	public Response deleteReview(String reviewId) {
		Review re = reviewDAO.getById(Integer.parseInt(reviewId));

		reviewDAO.delete(re);
		
		return Response.status(Status.OK).build();
	}

}
