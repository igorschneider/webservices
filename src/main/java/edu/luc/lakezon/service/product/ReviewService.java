package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;


import edu.luc.lakezon.service.representation.product.ReviewRepresentation;
import edu.luc.lakezon.service.representation.product.ReviewRequest;

@WebService
public interface ReviewService {

	public Set<ReviewRepresentation> getReviews(String productId);
	public ReviewRepresentation getReview(String productId, String reviewId);
	public ReviewRepresentation createReview(ReviewRequest reviewRequest);
	public ReviewRepresentation updateReview(String reviewId, ReviewRequest reviewRequest);
	public Response deleteReview(String reviewId);
	
}