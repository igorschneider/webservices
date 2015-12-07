package edu.luc.lakezon.service.representation.order;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.luc.lakezon.business.order.Status;
import edu.luc.lakezon.service.representation.BaseRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class OrderRepresentation extends BaseRepresentation {

	private Integer orderId;
	private Status status;
	private Calendar orderDate;
	private Integer customerId;

	public OrderRepresentation() {}

	// Getters and Setters

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
