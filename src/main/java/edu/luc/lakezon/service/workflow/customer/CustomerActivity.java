package edu.luc.lakezon.service.workflow.customer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.dao.customer.CustomerDAO;
import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;

public class CustomerActivity {

	private static CustomerDAO customerDAO = new CustomerDAO();
	
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
	
}
