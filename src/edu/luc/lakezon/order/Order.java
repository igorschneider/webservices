package edu.luc.lakezon.order;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.product.Product;

@Entity
@Table(name = "order_table")
public class Order {
		
	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "orderid_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
	@Column(name = "orderid")
	private Integer orderId;
	
	@Column(name = "status")
	private Status status;
	
	@Column(name = "orderdate")
	private Calendar orderDate;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Customer customer;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Set<OrderDetail> orderDetailList = new HashSet<OrderDetail>(0);
	
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Set<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(Set<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}


}
