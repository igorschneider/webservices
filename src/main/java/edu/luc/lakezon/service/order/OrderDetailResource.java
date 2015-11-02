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

import edu.luc.lakezon.service.representation.order.OrderDetailRepresentation;
import edu.luc.lakezon.service.representation.order.OrderDetailRequest;
import edu.luc.lakezon.service.workflow.order.OrderDetailActivity;

@Path("/customer/{customerId}/order/{orderId}/orderdetail")
public class OrderDetailResource implements OrderDetailService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Override
	public Set<OrderDetailRepresentation> getOrderDetails(@PathParam("orderId") String orderId) {
		OrderDetailActivity orderDetailActivity = new OrderDetailActivity();
		return orderDetailActivity.getOrderDetails(orderId);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productId}")
	@Override
	public OrderDetailRepresentation getOrderDetail(@PathParam("orderId") String orderId, 
			@PathParam("productId") String productId) {
		OrderDetailActivity orderDetailActivity = new OrderDetailActivity();
		return orderDetailActivity.getOrderDetail(orderId, productId);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public OrderDetailRepresentation createOrderDetail(@PathParam("orderId") String orderId, 
			OrderDetailRequest orderDetailRequest) {
		OrderDetailActivity orderDetailActivity = new OrderDetailActivity();
		return orderDetailActivity.createOrderDetail(orderId, orderDetailRequest);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{productId}")
	@Override
	public OrderDetailRepresentation updateOrderDetail(@PathParam("orderId") String orderId, 
			@PathParam("productId") String productId,
			OrderDetailRequest orderDetailRequest) {
		OrderDetailActivity orderDetailActivity = new OrderDetailActivity();
		return orderDetailActivity.updateOrderDetail(orderId, productId, 
				orderDetailRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{productId}")
	@Override
	public Response deleteOrderDetail(@PathParam("orderId") String orderId, 
			@PathParam("productId") String productId) {
		OrderDetailActivity orderDetailActivity = new OrderDetailActivity();
		return orderDetailActivity.deleteOrderDetail(orderId, productId);
	}

}
