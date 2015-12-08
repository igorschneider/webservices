package edu.luc.lakezon.service.customer;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;
import edu.luc.lakezon.service.representation.customer.CustomerRequest;

@WebService
public interface CustomerService {

	public Set<CustomerRepresentation> getCustomers();
	public CustomerRepresentation getCustomer(String customerId);
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest);
	public CustomerRepresentation updateCustomer(String customerId, CustomerRequest customerRequest);
	public Response deleteCustomer(String customerId);
	public Response authenticateCustomer(CustomerRequest customerRequest);
	
}
