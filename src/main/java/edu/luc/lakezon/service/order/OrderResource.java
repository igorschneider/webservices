package edu.luc.lakezon.service.order;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import edu.luc.lakezon.service.representation.order.OrderRepresentation;
import edu.luc.lakezon.service.representation.order.OrderRequest;
import edu.luc.lakezon.service.workflow.order.OrderActivity;

@Path("/order")
public class OrderResource implements OrderService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/customer/{customerId}/order")
	@Override
	public Set<OrderRepresentation> getCustomerOrders(@PathParam("customerId") String customerId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getCustomerOrders(customerId);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/order")
	@Override
	public Set<OrderRepresentation> getProductOwnerOrders(
			@QueryParam("productOwnerId") String productOwnerId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getProductOwnerOrders(productOwnerId);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/customer/{customerId}/order/{orderId}")
	@Override
	public OrderRepresentation getOrder(@PathParam("customerId") String customerId,
			@PathParam("orderId") String orderId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(customerId, orderId);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/customer/{customerId}/order/{orderId}/product/{productId}")
	@Override
	public OrderRepresentation addProductToCart(@PathParam("customerId") String customerId,
			@PathParam("orderId") String orderId, @PathParam("productId") String productId) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.addProductToCart(customerId, orderId, productId);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/customer/{customerId}/order")
	@Override
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createOrder(orderRequest);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/customer/{customerId}/order/{orderId}")
	@Override
	public OrderRepresentation updateOrder(@PathParam("orderId") String orderId, 
			OrderRequest orderRequest) {
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.updateOrder(orderId, orderRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@CrossOriginResourceSharing(allowAllOrigins = true)
	@Path("/customer/{customerId}/order/{orderId}")
	@Override
	public Response deleteOrder(@PathParam("orderId") String orderId) {
		try {
			OrderActivity orderActivity = new OrderActivity();
			return orderActivity.deleteOrder(orderId);
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

}
