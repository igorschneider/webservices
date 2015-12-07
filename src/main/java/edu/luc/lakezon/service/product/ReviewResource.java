package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.product.ReviewRepresentation;
import edu.luc.lakezon.service.representation.product.ReviewRequest;
import edu.luc.lakezon.service.workflow.product.ReviewActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/review")
public class ReviewResource implements ReviewService{

	@GET
	@Produces({"application/xml" , "application/json"})
	public Set<ReviewRepresentation> getReviews() {
		System.out.println("GET METHOD Request for all reviews .............");
		ReviewActivity revActivity = new ReviewActivity();
		return revActivity.getReviews();	
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("{reviewId}")
	@Override
	public ReviewRepresentation getReview(@PathParam("reviewId") String id) {
		System.out.println("GET METHOD Request String ............." + id);
		ReviewActivity revActivity = new ReviewActivity();
		return revActivity.getReview(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public ReviewRepresentation createReview(ReviewRequest reviewRequest) {
		ReviewActivity revActivity = new ReviewActivity();
		return revActivity.createReview(reviewRequest);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{reviewId}")
	@Override
	public ReviewRepresentation updateReview(@PathParam("reviewId") String reviewId, ReviewRequest reviewRequest) {
		ReviewActivity revActivity = new ReviewActivity();
		return revActivity.updateReview(reviewId,reviewRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{reviewId}")
	@Override
	public Response deleteReview(@PathParam("orderId") String reviewId) {
		ReviewActivity revActivity = new ReviewActivity();
		return revActivity.deleteReview(reviewId);
	}

}
