package edu.luc.lakezon.business.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "productowner")
@XmlRootElement
public class ProductOwner implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "productownerid_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
	@Column(name = "productownerid")
	private int productOwnerId;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productOwner")
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
