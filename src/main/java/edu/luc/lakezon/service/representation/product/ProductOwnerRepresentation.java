package edu.luc.lakezon.service.representation.product;

import java.util.HashSet;
import java.util.Set;

import edu.luc.lakezon.business.product.Product;

public class ProductOwnerRepresentation {

	private int productOwnerId;
	private String name;
	private Set<Product> productsList = new HashSet<Product>(0);
	
	// GETTERS AND SETTERS
	public int getProductOwnerId() {
		return productOwnerId;
	}
	public void setProductOwnerId(int productOwnerId) {
		this.productOwnerId = productOwnerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getProductsList() {
		return productsList;
	}
	public void setProductsList(Set<Product> productsList) {
		this.productsList = productsList;
	}
	
}
