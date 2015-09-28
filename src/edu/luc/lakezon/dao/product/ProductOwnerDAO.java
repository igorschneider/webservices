package edu.luc.lakezon.dao.product;

import edu.luc.lakezon.dao.BaseDAO;
import edu.luc.lakezon.product.ProductOwner;

public class ProductOwnerDAO extends BaseDAO<ProductOwner> {
	public ProductOwner getById(Integer id) {
		return super.getById(id, "ProductOwner", "productOwnerId");
	}
}