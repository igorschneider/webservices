package edu.luc.lakezon.service.order;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.order.OrderRepresentation;
import edu.luc.lakezon.service.representation.order.OrderRequest;

@WebService
public interface OrderService {

	public Set<OrderRepresentation> getOrders(String customerId);
	public OrderRepresentation getOrder(String customerId, String orderId);
	public OrderRepresentation addProductToCart(String productId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
	public OrderRepresentation updateOrder(String orderId, OrderRequest orderRequest);
	public Response deleteOrder(String orderId);
	
}
