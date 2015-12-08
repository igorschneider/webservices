package edu.luc.lakezon.dao.product;

import java.util.Set;

import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.BaseDAO;

public class ProductOwnerDAO extends BaseDAO<ProductOwner> {

	public ProductOwner getById(Integer id) {
		return super.getById(id, "ProductOwner", "productOwnerId");
	}
	
	public Set<ProductOwner> getAll() {
		return super.getAll("ProductOwner");
	}

	public Set<ProductOwner> getAllByString(String search) {
		return super.getAllByString(search, "ProductOwner", "name");
	}

}
