package edu.luc.lakezon.service.workflow.customer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;
import edu.luc.lakezon.service.representation.customer.CustomerRequest;

public class CustomerActivity {

	private CustomerDAO customerDAO = new CustomerDAO();
	
	public Set<CustomerRepresentation> getCustomers() {
		
		Set<Customer> customers = null;
		Set<CustomerRepresentation> customerRepresentations = 
				new HashSet<CustomerRepresentation>();
		
		customers = customerDAO.getAll();
		
		Iterator<Customer> it = customers.iterator(); 
		
		while (it.hasNext()) {
			Customer customer = (Customer)it.next();
			CustomerRepresentation customerRepresentation = 
					new CustomerRepresentation();
			
			customerRepresentation.setCustomerId(customer.getCustomerId());
			customerRepresentation.setName(customer.getName());
			customerRepresentation.setGender(customer.getGender());
			customerRepresentation.setBirthdate(customer.getBirthdate());
			customerRepresentation.setPassword(customer.getPassword());
			
			customerRepresentations.add(customerRepresentation);
		}
		
		return customerRepresentations;
	}
	
	public CustomerRepresentation getCustomer(String customerId) {
		Customer customer = customerDAO.getById(Integer.parseInt(customerId));
		
		CustomerRepresentation customerRepresentation = 
				new CustomerRepresentation();

		customerRepresentation.setCustomerId(customer.getCustomerId());
		customerRepresentation.setName(customer.getName());
		customerRepresentation.setGender(customer.getGender());
		customerRepresentation.setBirthdate(customer.getBirthdate());
		customerRepresentation.setPassword(customer.getPassword());
		
		return customerRepresentation;
	}
	
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		
		customer.setName(customerRequest.getName());
		customer.setGender(customerRequest.getGender());
		customer.setBirthdate(customerRequest.getBirthdate());
		customer.setPassword(customerRequest.getPassword());
		
		customerDAO.save(customer);
		
		CustomerRepresentation customerRepresentation = 
				new CustomerRepresentation();

		customerRepresentation.setCustomerId(customer.getCustomerId());
		customerRepresentation.setName(customer.getName());
		customerRepresentation.setGender(customer.getGender());
		customerRepresentation.setBirthdate(customer.getBirthdate());
		customerRepresentation.setPassword(customer.getPassword());
		
		return customerRepresentation;
	}
	
	public CustomerRepresentation updateCustomer(String customerId, 
			CustomerRequest customerRequest) {
		Customer customer = customerDAO.getById(Integer.parseInt(customerId));

		customer.setName(customerRequest.getName());
		customer.setGender(customerRequest.getGender());
		customer.setBirthdate(customerRequest.getBirthdate());
		customer.setPassword(customerRequest.getPassword());

		customerDAO.save(customer);

		CustomerRepresentation customerRepresentation = 
				new CustomerRepresentation();

		customerRepresentation.setCustomerId(customer.getCustomerId());
		customerRepresentation.setName(customer.getName());
		customerRepresentation.setGender(customer.getGender());
		customerRepresentation.setBirthdate(customer.getBirthdate());
		customerRepresentation.setPassword(customer.getPassword());
		
		return customerRepresentation;
	}

	public Response deleteCustomer(String customerId) {
		Customer customer = customerDAO.getById(Integer.parseInt(customerId));

		customerDAO.delete(customer);
		
		return Response.status(Status.OK).build();
	}
	
	public Response authenticateCustomer(CustomerRequest customerRequest) {

		Set<Customer> customers = customerDAO.getAllByString(customerRequest.getName());

		Iterator<Customer> it = customers.iterator();
		
		System.out.println("Request Password: " + customerRequest.getPassword());

		while (it.hasNext()) {

			Customer customer = (Customer)it.next();
			
			System.out.println("DB Password: " + customer.getPassword());
			
			if (customer.getPassword().equals(customerRequest.getPassword())) {
				return Response.status(Status.OK).build();
			}

		}
		
		return Response.status(Status.UNAUTHORIZED).build();
		
	}
	
}
