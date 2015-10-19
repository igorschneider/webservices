package edu.luc.lakezon.service.representation.product;


import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import edu.luc.lakezon.business.product.Product;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductOwnerRequest {
	
	private String name;
	private Set<Product> productsList = new HashSet<Product>(0);
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
