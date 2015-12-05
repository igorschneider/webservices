package edu.luc.lakezon.service.representation.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import edu.luc.lakezon.service.representation.BaseRepresentation;

@XmlRootElement(name = "OrderDetail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderDetailRepresentation extends BaseRepresentation {

	private Integer orderId;
	private Integer productId;
	private Integer quantity;

	public OrderDetailRepresentation() {}

	// Getters and Setters

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
