package edu.luc.lakezon.service.representation.order;

import java.util.Calendar;

import edu.luc.lakezon.business.order.Status;

public class OrderRepresentation {

	private Integer orderId;
	private Status status;
	private Calendar orderDate;
	private Integer customerId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}
