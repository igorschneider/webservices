package edu.luc.lakezon.service.customer;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;
import edu.luc.lakezon.service.representation.customer.CustomerRequest;
import edu.luc.lakezon.service.workflow.customer.CustomerActivity;

@Path("/customer/")
public class CustomerResource implements CustomerService {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Override
	public Set<CustomerRepresentation> getCustomers() {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomers();
	}

	@Override
	public CustomerRepresentation getCustomer(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerRepresentation createCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateCustomer(CustomerRequest customerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
