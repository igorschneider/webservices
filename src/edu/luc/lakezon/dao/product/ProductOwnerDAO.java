package edu.luc.lakezon.dao.product;

import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.BaseDAO;

public class ProductOwnerDAO extends BaseDAO<ProductOwner> {
	public ProductOwner getById(Integer id) {
		return super.getById(id, "ProductOwner", "productOwnerId");
	}
}