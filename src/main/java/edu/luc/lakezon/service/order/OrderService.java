package edu.luc.lakezon.service.order;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.order.OrderRepresentation;
import edu.luc.lakezon.service.representation.order.OrderRequest;

@WebService
public interface OrderService {

	public Set<OrderRepresentation> getCustomerOrders(String customerId);
	public Set<OrderRepresentation> getProductOwnerOrders(String productOwnerId);
	public OrderRepresentation getOrder(String customerId, String orderId);
	public OrderRepresentation addProductToCart(String customerId, String orderId, String productId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
	public OrderRepresentation updateOrder(String orderId, OrderRequest orderRequest);
	public Response deleteOrder(String orderId);
	
}
