package edu.luc.lakezon.service.customer;

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

import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;
import edu.luc.lakezon.service.representation.customer.CustomerRequest;
import edu.luc.lakezon.service.workflow.customer.CustomerActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/customer")
public class CustomerResource implements CustomerService {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	public Set<CustomerRepresentation> getCustomers() {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomers();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{customerId}")
	@Override
	public CustomerRepresentation getCustomer(@PathParam("customerId") String customerId) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomer(customerId);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.createCustomer(customerRequest);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{customerId}")
	@Override
	public CustomerRepresentation updateCustomer(@PathParam("customerId") String customerId,
			CustomerRequest customerRequest) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.updateCustomer(customerId, customerRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{customerId}")
	@Override
	public Response deleteCustomer(@PathParam("customerId") String customerId) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.deleteCustomer(customerId);
	}

}
