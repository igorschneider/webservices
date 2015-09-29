package edu.luc.lakezon.dao.product;

import edu.luc.lakezon.business.product.Review;
import edu.luc.lakezon.dao.BaseDAO;

public class ReviewDAO extends BaseDAO<Review> {

	public Review getById(Integer id) {
		return super.getById(id, "Review", "reviewId");
	}

}
