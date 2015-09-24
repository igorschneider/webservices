package edu.luc.lakezon.order;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.luc.lakezon.product.Product;

@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderid")
	private Order order;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid")
	private Product product;
	
	@Column(name = "quantity")
	private int quantity;
	
	OrderDetail(Order ord,Product prod,int quant){
		this.order = ord;
		this.product = prod;
		this.quantity = quant;
	}
	
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

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}

/*
 public class OrderDetail {
	
	@EmbeddedId
	private OrderProductId orderProductId;
	
	@Column(name = "quantity")
	private int quantity;
	
	OrderDetail(Order ord,Product prod,int quant){
		this.orderProductId = new OrderProductId(ord,prod);
		this.quantity = quant;
	}
	
	public Order getOrder() {
		return orderProductId.getOrder();
	}
	public void setOrder(Order order) {
		this.orderProductId.setOrder(order);
	}
	public Product getProduct() {
		return orderProductId.getProduct();
	}
	public void setProduct(Product product) {
		this.orderProductId.setProduct(product);
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
  
  
  */
