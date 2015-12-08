package edu.luc.lakezon.dao.product;

import java.util.Set;

import edu.luc.lakezon.business.product.Review;
import edu.luc.lakezon.dao.BaseDAO;

public class ReviewDAO extends BaseDAO<Review> {

	public Review getById(Integer id) {
		return super.getById(id, "Review", "reviewId");
	}
	
	public Set<Review> getAllByProductId(Integer productId) {
		return super.getAllById(productId, "Review", "productId");
	}

	public Set<Review> getAllByCustomerId(Integer customerId) {
		return super.getAllById(customerId, "Review", "customerId");
	}

}
