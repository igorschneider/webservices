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

	private Integer productOwnerId;
	private String name;
	private String password;

	public ProductOwnerRepresentation() {}

	// Getters and Setters

	public Integer getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(Integer productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
