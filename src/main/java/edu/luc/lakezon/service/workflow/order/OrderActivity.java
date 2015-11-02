package edu.luc.lakezon.service.workflow.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.dao.order.OrderDAO;
import edu.luc.lakezon.service.representation.order.OrderRepresentation;
import edu.luc.lakezon.service.representation.order.OrderRequest;

public class OrderActivity {

	private OrderDAO orderDAO = new OrderDAO();
	private CustomerDAO customerDAO = new CustomerDAO();
	
	public Set<OrderRepresentation> getOrders(String customerId) {
		
		Set<Order> orders = null;
		Set<OrderRepresentation> orderRepresentations = 
				new HashSet<OrderRepresentation>();
		
		orders = orderDAO.getAllById(Integer.parseInt(customerId));
		
		System.out.println("OrderActivity - customerId: " + customerId);
		
		Iterator<Order> it = orders.iterator(); 
		
		while (it.hasNext()) {
			Order order = (Order)it.next();
			OrderRepresentation orderRepresentation = 
					new OrderRepresentation();
			
			orderRepresentation.setOrderId(order.getOrderId());
			orderRepresentation.setStatus(order.getStatus());
			orderRepresentation.setOrderDate(order.getOrderDate());
			orderRepresentation.setCustomerId(Integer.parseInt(customerId));
			
			orderRepresentations.add(orderRepresentation);
		}
		
		System.out.println("OrderActivity - Finish");

		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(String customerId, String orderId) {
		Order order = orderDAO.getById(Integer.parseInt(orderId));
		
		OrderRepresentation orderRepresentation = 
				new OrderRepresentation();

		orderRepresentation.setOrderId(order.getOrderId());
		orderRepresentation.setStatus(order.getStatus());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setCustomerId(Integer.parseInt(orderId));
		
		return orderRepresentation;
	}
	
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		Customer customer = customerDAO.getById(orderRequest.getCustomerId());
		
		Order order = new Order();
		
		order.setStatus(orderRequest.getStatus());
		order.setOrderDate(orderRequest.getOrderDate());
		order.setCustomer(customer);
		
		orderDAO.save(order);
		
		OrderRepresentation orderRepresentation = 
				new OrderRepresentation();

		orderRepresentation.setOrderId(order.getOrderId());
		orderRepresentation.setStatus(order.getStatus());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setCustomerId(order.getCustomer().getCustomerId());
		
		return orderRepresentation;
	}
	
	public OrderRepresentation updateOrder(String orderId, 
			OrderRequest orderRequest) {
		Customer customer = customerDAO.getById(orderRequest.getCustomerId());

		Order order = orderDAO.getById(Integer.parseInt(orderId));

		order.setStatus(orderRequest.getStatus());
		order.setOrderDate(orderRequest.getOrderDate());
		order.setCustomer(customer);

		orderDAO.save(order);

		OrderRepresentation orderRepresentation = 
				new OrderRepresentation();

		orderRepresentation.setOrderId(order.getOrderId());
		orderRepresentation.setStatus(order.getStatus());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setCustomerId(order.getCustomer().getCustomerId());
		
		return orderRepresentation;
	}

	public Response deleteOrder(String orderId) {
		Order order = orderDAO.getById(Integer.parseInt(orderId));

		orderDAO.delete(order);
		
		return Response.status(Status.OK).build();
	}
	
}
