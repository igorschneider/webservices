package edu.luc.lakezon.dao.product;

import edu.luc.lakezon.dao.BaseDAO;
import edu.luc.lakezon.product.Review;

public class ReviewDAO extends BaseDAO<Review> {
	public Review getById(Integer id) {
		return super.getById(id, "Review", "reviewId");
	}
}