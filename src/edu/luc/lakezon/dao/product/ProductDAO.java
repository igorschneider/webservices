package edu.luc.lakezon.dao.product;

import edu.luc.lakezon.dao.BaseDAO;
import edu.luc.lakezon.product.Product;

public class ProductDAO extends BaseDAO<Product> {
	public Product getById(Integer id) {
		return super.getById(id, "Product", "productId");
	}
}