package edu.luc.lakezon.service.workflow.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.Link;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.business.order.OrderDetail;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.dao.order.OrderDAO;
import edu.luc.lakezon.dao.order.OrderDetailDAO;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.service.representation.order.OrderDetailRepresentation;
import edu.luc.lakezon.service.representation.order.OrderDetailRequest;

public class OrderDetailActivity {

	private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	private OrderDAO orderDAO = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();

	public Set<OrderDetailRepresentation> getOrderDetails(String customerId, String orderId) {
		
		Set<OrderDetail> orderDetails = null;
		Set<OrderDetailRepresentation> orderDetailRepresentations = 
				new HashSet<OrderDetailRepresentation>();
		
		orderDetails = orderDetailDAO.getAllById(Integer.parseInt(orderId));
		
		Iterator<OrderDetail> it = orderDetails.iterator(); 
		
		while (it.hasNext()) {
			OrderDetail orderDetail = (OrderDetail)it.next();
			OrderDetailRepresentation orderDetailRepresentation = 
					new OrderDetailRepresentation();
			
			orderDetailRepresentation.setOrderId(orderDetail.getOrder().getOrderId());
			orderDetailRepresentation.setProductId(orderDetail.getProduct().getProductId());
			orderDetailRepresentation.setQuantity(orderDetail.getQuantity());
			orderDetailRepresentation.setName(orderDetail.getProduct().getName());
			orderDetailRepresentation.setDescription(orderDetail.getProduct().getDescription());
			orderDetailRepresentation.setImg(orderDetail.getProduct().getImg());
			orderDetailRepresentation.setPrice(orderDetail.getProduct().getPrice());
			
			Link updateOrderDetail = new Link("updateOrderDetail", "order/customer/" + customerId + 
					"/order/" + orderId + "/orderdetail/" + 
					orderDetail.getProduct().getProductId());

			Link removeOrderDetail = new Link("removeOrderDetail", "order/customer/" + customerId + 
					"/order/" + orderId + "/orderdetail/" + 
					orderDetail.getProduct().getProductId());

			orderDetailRepresentation.setLinks(updateOrderDetail, removeOrderDetail);

			orderDetailRepresentations.add(orderDetailRepresentation);
		}
		
		return orderDetailRepresentations;
	}
	
	public OrderDetailRepresentation getOrderDetail(String orderId, String productId) {
		OrderDetail orderDetail = orderDetailDAO.getById(
				Integer.parseInt(orderId), Integer.parseInt(productId));
		
		OrderDetailRepresentation orderDetailRepresentation = 
				new OrderDetailRepresentation();

		orderDetailRepresentation.setOrderId(orderDetail.getOrder().getOrderId());
		orderDetailRepresentation.setProductId(orderDetail.getProduct().getProductId());
		orderDetailRepresentation.setQuantity(orderDetail.getQuantity());
		
		return orderDetailRepresentation;
	}
	
	public OrderDetailRepresentation createOrderDetail(String orderId, 
			OrderDetailRequest orderDetailRequest) {
		Order order = orderDAO.getById(Integer.parseInt(orderId));
		Product product = productDAO.getById(orderDetailRequest.getProductId());
		
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrder(order);
		orderDetail.setProduct(product);
		orderDetail.setQuantity(orderDetailRequest.getQuantity());
		
		orderDetailDAO.save(orderDetail);
		
		OrderDetailRepresentation orderDetailRepresentation = 
				new OrderDetailRepresentation();

		orderDetailRepresentation.setOrderId(orderDetail.getOrder().getOrderId());
		orderDetailRepresentation.setProductId(orderDetail.getProduct().getProductId());
		orderDetailRepresentation.setQuantity(orderDetail.getQuantity());
		
		return orderDetailRepresentation;
	}
	
	public OrderDetailRepresentation updateOrderDetail(String orderId, String productId,
			OrderDetailRequest orderDetailRequest) {
		OrderDetail orderDetail = orderDetailDAO.getById(Integer.parseInt(orderId),
				Integer.parseInt(productId));
		
		orderDetail.setQuantity(orderDetailRequest.getQuantity());

		orderDetailDAO.save(orderDetail);
		
		OrderDetailRepresentation orderDetailRepresentation = 
				new OrderDetailRepresentation();

		orderDetailRepresentation.setOrderId(orderDetail.getOrder().getOrderId());
		orderDetailRepresentation.setProductId(orderDetail.getProduct().getProductId());
		orderDetailRepresentation.setQuantity(orderDetail.getQuantity());
		
		return orderDetailRepresentation;
	}

	public Response deleteOrderDetail(String orderId, String productId) {
		OrderDetail orderDetail = orderDetailDAO.getById(Integer.parseInt(orderId),
				Integer.parseInt(productId));

		orderDetailDAO.delete(orderDetail);
		
		return Response.status(Status.OK).build();
	}
	
}
