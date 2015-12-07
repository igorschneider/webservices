package edu.luc.lakezon.service.workflow.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.Link;
import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.business.order.OrderDetail;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.dao.order.OrderDAO;
import edu.luc.lakezon.dao.order.OrderDetailDAO;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.service.representation.order.OrderRepresentation;
import edu.luc.lakezon.service.representation.order.OrderRequest;

public class OrderActivity {

	private OrderDAO orderDAO = new OrderDAO();
	private CustomerDAO customerDAO = new CustomerDAO();
	private ProductDAO productDAO = new ProductDAO();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	
	public Set<OrderRepresentation> getOrders(String customerId) {
		
		Set<Order> orders = null;
		Set<OrderRepresentation> orderRepresentations = 
				new HashSet<OrderRepresentation>();
		
		orders = orderDAO.getAllById(Integer.parseInt(customerId));
		
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
		
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(String customerId, String orderId) {
		Order order = orderDAO.getById(Integer.parseInt(orderId));
		
		OrderRepresentation orderRepresentation = 
				new OrderRepresentation();

		orderRepresentation.setOrderId(order.getOrderId());
		orderRepresentation.setStatus(order.getStatus());
		orderRepresentation.setOrderDate(order.getOrderDate());
		orderRepresentation.setCustomerId(Integer.parseInt(customerId));
		
		Link self = new Link("self", "customer/" + customerId + 
				"/order/" + orderId);
		Link viewOrderDetails = new Link("viewOrderDetails", "customer/" + customerId + 
				"/order/" + orderId + "/orderdetails");
		
		if (order.getStatus() == edu.luc.lakezon.business.order.Status.CART) {
			Link clearCart = new Link("clearCart", "customer/" + customerId + 
					"/order/" + orderId);

			orderRepresentation.setLinks(self, viewOrderDetails, clearCart);
		} else {
			orderRepresentation.setLinks(self, viewOrderDetails);
		}

		return orderRepresentation;
	}
	
	public OrderRepresentation addProductToCart(String customerId, String orderId, 
			String productId) {
		Order order = orderDAO.getById(Integer.parseInt(orderId));
		Product product = productDAO.getById(Integer.parseInt(productId));
		
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrder(order);
		orderDetail.setProduct(product);
		orderDetail.setQuantity(1);
		
		orderDetailDAO.save(orderDetail);
		
		OrderRepresentation orderRepresentation = 
				new OrderRepresentation();

		orderRepresentation.setStatus(order.getStatus());
		
		Link self = new Link("self", "customer/" + customerId + 
				"/order/" + orderId);
		Link viewOrderDetails = new Link("viewOrderDetails", "customer/" + customerId + 
				"/order/" + orderId + "/orderdetails");
		Link clearCart = new Link("clearCart", "customer/" + customerId + 
				"/order/" + orderId);

		orderRepresentation.setLinks(self, viewOrderDetails, clearCart);;

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
