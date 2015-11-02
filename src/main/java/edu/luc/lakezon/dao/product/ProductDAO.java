package edu.luc.lakezon.dao.product;

import java.util.Set;

import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.dao.BaseDAO;

public class ProductDAO extends BaseDAO<Product> {

	public Product getById(Integer id) {
		return super.getById(id, "Product", "productId");
	}
	
	public Set<Product> getAll() {
		return super.getAll("Product");
	}
}
