package edu.luc.lakezon.service.order;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.order.OrderDetailRepresentation;
import edu.luc.lakezon.service.representation.order.OrderDetailRequest;

@WebService
public interface OrderDetailService {

	public Set<OrderDetailRepresentation> getOrderDetails(String customerId, String orderId);
	public OrderDetailRepresentation getOrderDetail(String orderId, String productId);
	public OrderDetailRepresentation createOrderDetail(String orderId, OrderDetailRequest orderDetailRequest);
	public OrderDetailRepresentation updateOrderDetail(String orderId, String productId, OrderDetailRequest orderDetailRequest);
	public Response deleteOrderDetail(String orderId, String productId);

}
