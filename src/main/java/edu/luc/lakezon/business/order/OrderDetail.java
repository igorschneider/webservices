package edu.luc.lakezon.business.order;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.luc.lakezon.business.product.Product;

@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;

	@Column(name = "quantity")
	private Integer quantity;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order ord) {
		this.order = ord;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product prod) {
		this.product = prod;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
