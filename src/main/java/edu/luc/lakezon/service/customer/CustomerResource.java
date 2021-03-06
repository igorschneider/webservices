package edu.luc.lakezon.service.customer;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;
import edu.luc.lakezon.service.representation.customer.CustomerRequest;
import edu.luc.lakezon.service.workflow.customer.CustomerActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/customer")
public class CustomerResource implements CustomerService {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	@Override
	public Set<CustomerRepresentation> getCustomers() {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomers();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerId}")
	@Override
	public CustomerRepresentation getCustomer(@PathParam("customerId") String customerId) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomer(customerId);
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	@Override
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.createCustomer(customerRequest);
	}

	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerId}")
	@Override
	public CustomerRepresentation updateCustomer(@PathParam("customerId") String customerId,
			CustomerRequest customerRequest) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.updateCustomer(customerId, customerRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerId}")
	@Override
	public Response deleteCustomer(@PathParam("customerId") String customerId) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.deleteCustomer(customerId);
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/authentication")
	@Override
	public Response authenticateCustomer(CustomerRequest customerRequest) {
		try {
			CustomerActivity customerActivity = new CustomerActivity();
			return customerActivity.authenticateCustomer(customerRequest);
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

}
