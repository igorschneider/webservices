package edu.luc.lakezon.product;

public class Product {

	private String name;
	private ProductOwner productOwner;
	private String description;
	private Integer quantity;
	private String img;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductOwner getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(ProductOwner productOwner) {
		this.productOwner = productOwner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
