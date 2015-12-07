package edu.luc.lakezon.service.representation.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.luc.lakezon.service.representation.BaseRepresentation;

@XmlRootElement(name = "ProductOwner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ProductOwnerRepresentation extends BaseRepresentation {

	private int productOwnerId;
	private String name;

	public ProductOwnerRepresentation() {}

	// Getters and Setters

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
