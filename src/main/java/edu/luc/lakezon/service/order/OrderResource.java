package edu.luc.lakezon.service.order;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import edu.luc.lakezon.service.representation.order.OrderRepresentation;
import edu.luc.lakezon.service.representation.order.OrderRequest;
import edu.luc.lakezon.service.workflow.order.OrderActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/customer/{customerId}/order")
public class OrderResource implements OrderService {

	@GET
	@Produces({"application/xml" , "application/json"})
	public Set<OrderRepresentation> getOrders(@PathParam("customerId") String customerId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrders(customerId);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{orderId}")
	@Override
	public OrderRepresentation getOrder(@PathParam("customerId") String customerId,
			@PathParam("orderId") String orderId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(customerId, orderId);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createOrder(orderRequest);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{orderId}")
	@Override
	public OrderRepresentation updateOrder(@PathParam("orderId") String orderId, 
			OrderRequest orderRequest) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.updateOrder(orderId, orderRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{orderId}")
	@Override
	public Response deleteOrder(@PathParam("orderId") String orderId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.deleteOrder(orderId);
	}

}
