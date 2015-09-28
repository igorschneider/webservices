package edu.luc.lakezon.dao.product;

import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.dao.BaseDAO;

public class ProductDAO extends BaseDAO<Product> {
	public Product getById(Integer id) {
		return super.getById(id, "Product", "productId");
	}
}