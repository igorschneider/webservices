package edu.luc.lakezon.order;
import java.util.Calendar;

import edu.luc.lakezon.customer.Customer;

public class Order {
	
	private Status status;
	private Calendar orderDate;
	private Customer customer;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
