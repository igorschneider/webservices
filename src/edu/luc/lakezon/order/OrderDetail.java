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
public class OrderDetail {
	
	@EmbeddedId
	private OrderProductId orderProductId;
	
	@Column(name = "quantity")
	private int quantity;
	
	OrderDetail(Order ord,Product prod,int quant){
		orderProductId = new OrderProductId(ord,prod);
		quantity = quant;
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


