package edu.luc.lakezon.service.representation.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ProductOwner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductOwnerRepresentation {

	private int productOwnerId;
	private String name;

	
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
	
}
