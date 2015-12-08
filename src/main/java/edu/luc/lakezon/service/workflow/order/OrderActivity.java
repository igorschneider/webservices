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
	
	public Set<OrderRepresentation> getCustomerOrders(String customerId) {
		
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
			
			Link self = new Link("self", "order/customer/" + customerId + 
					"/order/" + order.getOrderId());
			Link viewOrderDetails = new Link("viewOrderDetails", "order/customer/" + customerId + 
					"/order/" + order.getOrderId() + "/orderdetail");

			if (order.getStatus().equals(edu.luc.lakezon.business.order.Status.PROCESSING)) {

				Link cancelOrder = new Link("cancelOrder", "order/customer/" + customerId + 
						"/order/" + order.getOrderId());
				
				orderRepresentation.setLinks(self, viewOrderDetails, cancelOrder);
			} else {
				orderRepresentation.setLinks(self, viewOrderDetails);
			}
			

			orderRepresentations.add(orderRepresentation);
		}
		
		return orderRepresentations;
	}
	
	public Set<OrderRepresentation> getProductOwnerOrders(String productOwnerId) {
		
		Set<Order> orders = null;
		Set<OrderRepresentation> orderRepresentations = 
				new HashSet<OrderRepresentation>();
		
		orders = orderDAO.getAll();
		
		Iterator<Order> it = orders.iterator(); 
		
		while (it.hasNext()) {
			Order order = (Order)it.next();
			
			Iterator<OrderDetail> it2 = order.getOrderDetailList().iterator();
			
			while (it2.hasNext()) {
				
				OrderDetail orderDetail = (OrderDetail)it2.next();
				
				if (orderDetail.getProduct().getProductOwner().getProductOwnerId() == 
						Integer.parseInt(productOwnerId)) {
					
					OrderRepresentation orderRepresentation = 
							new OrderRepresentation();
					
					orderRepresentation.setStatus(order.getStatus());
					orderRepresentation.setOrderDate(order.getOrderDate());

					Link self = new Link("self", "order/customer/" + order.getCustomer().getCustomerId() + 
							"/order/" + order.getOrderId());
					Link shipOrder = new Link("shipOrder", "order/customer/" + order.getCustomer().getCustomerId() + 
							"/order/" + order.getOrderId());
					
					orderRepresentation.setLinks(self, shipOrder);

					orderRepresentations.add(orderRepresentation);
				}
				
			}
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
		
		Link self = new Link("self", "order/customer/" + customerId + 
				"/order/" + orderId);
		Link viewOrderDetails = new Link("viewOrderDetails", "order/customer/" + customerId + 
				"/order/" + orderId + "/orderdetail");
		
		if (order.getStatus() == edu.luc.lakezon.business.order.Status.CART) {
			Link clearCart = new Link("clearCart", "order/customer/" + customerId + 
					"/order/" + orderId);
			Link checkout = new Link("checkout", "payment/token");
			Link pay = new Link("pay", "payment/transaction");
			Link placeOrder = new Link("placeOrder", "order/customer/" + customerId + 
					"/order/" + orderId);

			orderRepresentation.setLinks(self, viewOrderDetails, clearCart, checkout, pay, placeOrder);
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
		
		Link self = new Link("self", "order/customer/" + customerId + 
				"/order/" + orderId);
		Link viewOrderDetails = new Link("viewOrderDetails", "order/customer/" + customerId + 
				"/order/" + orderId + "/orderdetail");
		Link clearCart = new Link("clearCart", "order/customer/" + customerId + 
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
		Order order = orderDAO.getById(Integer.parseInt(orderId));

		order.setStatus(orderRequest.getStatus());

		orderDAO.save(order);

		OrderRepresentation orderRepresentation = 
				new OrderRepresentation();

		orderRepresentation.setStatus(order.getStatus());
		orderRepresentation.setOrderDate(order.getOrderDate());
		
		Link self = new Link("self", "order/customer/" + order.getCustomer().getCustomerId() + 
				"/order/" + orderId);
		Link viewOrderDetails = new Link("viewOrderDetails", "order/customer/" + 
				order.getCustomer().getCustomerId() + 
				"/order/" + orderId + "/orderdetail");

		orderRepresentation.setLinks(self, viewOrderDetails);;

		return orderRepresentation;
	}

	public Response deleteOrder(String orderId) {
		Order order = orderDAO.getById(Integer.parseInt(orderId));

		if (order.getStatus().equals(edu.luc.lakezon.business.order.Status.CART)) {

			Iterator<OrderDetail> it = order.getOrderDetailList().iterator();
			
			order.setOrderDetailList(new HashSet<OrderDetail>(0));
			
			while (it.hasNext()) {
				orderDetailDAO.delete((OrderDetail)it.next());
			}

			return Response.status(Status.OK).build();

		} else if (order.getStatus().equals(edu.luc.lakezon.business.order.Status.PROCESSING)) {

			order.setStatus(edu.luc.lakezon.business.order.Status.CANCELED);
			orderDAO.update(order);
			return Response.status(Status.OK).build();

		} else {

			return Response.status(Status.METHOD_NOT_ALLOWED).build();
			
		}
		
		
	}
	
}
